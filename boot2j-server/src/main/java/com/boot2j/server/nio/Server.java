/**
 * 
 */
package com.boot2j.server.nio;

import java.io.IOException;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.concurrent.atomic.AtomicInteger;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class Server extends Thread {

	private static Logger logger = LoggerFactory.getLogger(Server.class);

	private ServerSocketChannel serverSock;

	private Processor[] processor;

	private AtomicInteger pollerRotater = new AtomicInteger(0);
	
	private int processorThreadCount = Math.min(2,Runtime.getRuntime().availableProcessors());

	public Server(ServerSocketChannel serverSock) throws IOException {
		this.serverSock = serverSock;

		// 开启处理线程
		processor = new Processor[processorThreadCount];
		for (int i = 0; i < processor.length; i++) {
			processor[i] = new Processor();
			Thread thread = new Thread(processor[i], "processor" + i);
			thread.setDaemon(true);
			thread.start();
		}
	}

	public Processor getProcessor() {
		int idx = Math.abs(pollerRotater.incrementAndGet()) % processor.length;
		return processor[idx];
	}

	@Override
	public void run() {
		while (true) {
			try {

				// 等待链接
				SocketChannel socket = serverSock.accept();
				logger.info("接收到请求");
				// 设置为非阻塞
				socket.configureBlocking(false);
				getProcessor().registerChannel(socket);

			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
}
