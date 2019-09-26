/**
 * 
 */
package com.boot2j.server;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class ServerConfig {

	// 主机名
	private String host = "localhost";

	// 名字
	private String name = "http server";

	// 服务器端口
	private int port = 8080;

	/**
	 * @return the port
	 */
	public int getPort() {
		return port;
	}

	/**
	 * @param port
	 *            the port to set
	 */
	public void setPort(int port) {
		this.port = port;
	}

	/**
	 * @return the host
	 */
	public String getHost() {
		return host;
	}

	/**
	 * @param host
	 *            the host to set
	 */
	public void setHost(String host) {
		this.host = host;
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @param name
	 *            the name to set
	 */
	public void setName(String name) {
		this.name = name;
	}

}
