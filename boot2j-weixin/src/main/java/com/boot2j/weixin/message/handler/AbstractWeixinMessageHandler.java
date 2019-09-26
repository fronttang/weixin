/**
 * 
 */
package com.boot2j.weixin.message.handler;

import com.boot2j.weixin.message.WeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public abstract class AbstractWeixinMessageHandler implements MessageHandler {

	protected WeixinMessage message;
	
	public AbstractWeixinMessageHandler(WeixinMessage message){
		this.message = message;
	}
}
