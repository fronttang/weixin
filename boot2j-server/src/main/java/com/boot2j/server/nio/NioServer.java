/**
 * 
 */
package com.boot2j.server.nio;

import java.net.InetSocketAddress;
import java.nio.channels.ServerSocketChannel;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boot2j.server.Server;
import com.boot2j.server.ServerConfig;

/**
 * nio 服务器实现
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class NioServer implements Server {
	
	private static Logger logger = LoggerFactory.getLogger(NioServer.class);
	
	private ServerConfig config;

	@Override
	public void setConfig(ServerConfig config) {
		this.config = config;
	}

	@Override
	public void start() {

		try {
			// Opens a server-socket channel. 
			ServerSocketChannel ssc = ServerSocketChannel.open();
			// 绑定监听端口
			ssc.socket().bind(new InetSocketAddress(config.getPort()), 100);
			// 设置为阻塞
			ssc.configureBlocking(true);
			
			// 开启服务
			com.boot2j.server.nio.Server server = new com.boot2j.server.nio.Server(ssc);
			server.setName("server");
			server.start();
		}
		catch(Exception e) {
			logger.error("", e);
		}
		
	}
	
	@Override
	public void stop() {
		
	}

}
