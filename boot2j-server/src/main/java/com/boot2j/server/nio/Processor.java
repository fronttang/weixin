/**
 * 
 */
package com.boot2j.server.nio;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.atomic.AtomicLong;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class Processor implements Runnable {

	private static Logger logger = LoggerFactory.getLogger(Processor.class);

	private Selector selector;

	private int BUFFER_SIZE = 1024;

	private AtomicLong wakeupCounter = new AtomicLong(0);

	private final ConcurrentLinkedQueue<SocketChannel> channels = new ConcurrentLinkedQueue<SocketChannel>();

	public Processor() throws IOException {
		selector = Selector.open();
	}

	public Selector getSelector() {
		return this.selector;
	}

	public void registerChannel(SocketChannel channel) {
		channels.offer(channel);
		if (wakeupCounter.incrementAndGet() == 0) {
			selector.wakeup();
		}
	}

	private void register() {
		SocketChannel sc = null;
		while ((sc = channels.poll()) != null) {
			try {

				RegisterChannelThread rct = new RegisterChannelThread(sc);
				rct.setName("RegisterChannelThread");
				rct.setDaemon(true);
				rct.start();

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {

		while (true) {
			try {
				register();

				int keyCount = 0;
				if (wakeupCounter.getAndSet(-1) > 0) {
					keyCount = selector.selectNow();
				} else {
					keyCount = selector.select(1000);
				}
				wakeupCounter.set(0);

				if (keyCount == 0) {
					register();
				}

				Iterator<SelectionKey> iterator = keyCount > 0 ? selector.selectedKeys().iterator() : null;
				while (iterator != null && iterator.hasNext()) {
					SelectionKey sKey = iterator.next();
					iterator.remove();
					try {
						if (sKey.isConnectable()) {
							logger.info("接收到请求" + Thread.currentThread().getName());
						} else if (sKey.isWritable()) {
							// 该key有Write事件
							logger.info("有流写出!" + Thread.currentThread().getName());
							SocketChannel sk = (SocketChannel) sKey.attach(null);
							if (sKey.isValid()) sKey.cancel();
			                if (sKey.channel().isOpen()) {
			                    try {
			                    	sKey.channel().close();
			                    } catch (Exception e) {
			                    	logger.error("", e);
			                    }
			                }
			                try {
			                    if (sk != null) {
			                    	sk.socket().close();
			                    	sk.close();
			                    }
			                } catch (Exception e){
			                	logger.error("", e);
			                }

						} else if (sKey.isReadable()) {
							// 该key有Read事件
							SocketChannel socketChannel = (SocketChannel) sKey.channel();
							String requestHeader = "";
							// 拿出通道中的Http头请求
							try {
								requestHeader = receive(socketChannel);
							} catch (Exception e) {
								logger.error("读取socketChannel出错");
								return;
							}
							// 启动线程处理该请求,if条件判断一下，防止心跳包
							logger.info("该请求的头格式为\r\n" + requestHeader);

							// 把请求hander原样返回
							responseHandler(sKey, requestHeader);
						}
					} catch (Exception e) {
						sKey.cancel();
						e.printStackTrace();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @param sKey
	 * @param requestHeader
	 */
	private void responseHandler(SelectionKey sKey, String requestHeader) {
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
		SocketChannel channel = (SocketChannel) sKey.channel();

		StringBuffer html = new StringBuffer("");
		// 将请求分行
		String[] headers = requestHeader.split("\r\n");
		String first = headers[0];
		logger.info("first:" + first);
		String[] firstLink = headers[0].split(" ", 3);
		// 请求方式
		String method = firstLink[0];
		// URI
		String url = firstLink[1];
		// 版本协议
		String protocol = firstLink[2];
		logger.info("method:" + method + " url:" + url + " protocol:" + protocol);

		// 主页
		if ("/".equalsIgnoreCase(url)) {
			html.append("<html><head><title>index</title></head><body>");
			html.append("<input type=\"text\" name=\"username\" class=\"form-control\" placeholder=\"用户名\" required=\"\"></br>");
			html.append("<input type=\"password\" name=\"password\" class=\"form-control\" placeholder=\"密码\" required=\"\">");
			html.append("<script src=\"/static/js/jquery.min.js?v=2.1.4\"></script>");
			html.append("<script src=\"/static/js/bootstrap.min.js?v=3.3.6\"></script>");
			html.append("</body></html>");
		} else {
			html.append("<html><head><title>index</title></head><body><pre>");
			html.append(requestHeader);
			html.append("</pre></body></html>");
		}

		StringBuilder sb = new StringBuilder();
		// 状态行
		sb.append(protocol + " 200 OK\r\n");
		// 响应头
		sb.append("Server: localhost\r\n");
		sb.append("Content-Type: text/html; charset=UTF-8\r\n");
		sb.append("Date: " + new Date() + "\r\n");
		String result = html.toString();
		if (result != null) {
			sb.append("Content-Length: " + result.getBytes().length + "\r\n");
		}

		// 响应内容
		sb.append("\r\n");
		sb.append(result);

		buffer.put(sb.toString().getBytes());
		// 从写模式，切换到读模式
		buffer.flip();
		try {
			logger.info("生成响应\r\n" + sb.toString());
			channel.register(selector, SelectionKey.OP_WRITE);
			channel.write(buffer);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private String receive(SocketChannel socketChannel) throws Exception {
		// 声明一个1024大小的缓冲区
		ByteBuffer buffer = ByteBuffer.allocate(BUFFER_SIZE);
		byte[] bytes = null;
		int size = 0;
		// 定义一个字节数组输出流
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		// 将socketChannel中的数据写入到buffer中，此时的buffer为写模式，size为写了多少个字节
		while ((size = socketChannel.read(buffer)) > 0) {
			// 将写模式改为读模式
			// The limit is set to the current position and then the position is
			// set to zero.
			// 将limit设置为之前的position，而将position置为0，更多java nio的知识会写成博客的
			buffer.flip();
			bytes = new byte[size];
			// 将Buffer写入到字节数组中
			buffer.get(bytes);
			// 将字节数组写入到字节缓冲流中
			baos.write(bytes);
			// 清空缓冲区
			buffer.clear();
		}
		// 将流转回字节数组
		bytes = baos.toByteArray();
		return new String(bytes);
	}

	private class RegisterChannelThread extends Thread {

		private SocketChannel channel;

		public RegisterChannelThread(SocketChannel channel) {
			this.channel = channel;
		}

		@Override
		public void run() {
			try {
				this.channel.register(selector, SelectionKey.OP_READ, channel);
				if (wakeupCounter.incrementAndGet() == 0) {
					selector.wakeup();
				}
				logger.info("注册");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
