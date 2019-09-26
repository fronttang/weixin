/**
 * 
 */
package com.boot2j.server;


/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public interface Server {

	void setConfig(ServerConfig config);
	
	void start();
	
	void stop();
}
