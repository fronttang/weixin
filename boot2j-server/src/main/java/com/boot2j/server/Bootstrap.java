/**
 * 
 */
package com.boot2j.server;

import com.boot2j.server.nio.NioServer;


/**
 * 服务器启动与关闭
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class Bootstrap {
	
	private static ServerConfig config;
	
	private static Server server;

	/**
	 * 服务开启
	 */
	public static void start() {
		// 先进行一些初始化工作
		init();
		
		server.setConfig(config);
		server.start();
	}
	
	/**
	 * 服务关闭
	 */
	public static void stop() {
		server.stop();
	}
	
	/**
	 * 初始化
	 */
	private static void init() {
		// 这里可以进行配置文件的读取
		config = new ServerConfig();
	}
	
	public static void main(String[] args) {
		server = new NioServer();
		if(args != null && args.length > 0) {
			String commend = args[0];
			if("start".equalsIgnoreCase(commend)) {
				start();
			} else if("stop".equalsIgnoreCase(commend)) {
				stop();
			} else {
				start();
			}
		} else {
			start();
		}
	}
}
