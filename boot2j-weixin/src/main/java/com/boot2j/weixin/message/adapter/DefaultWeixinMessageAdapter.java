/**
 * 
 */
package com.boot2j.weixin.message.adapter;

import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.handler.MessageHandler;

/**
 * 默认消息适配器，不加解密
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class DefaultWeixinMessageAdapter extends WeixinMessageAdapter {

	/**
	 * @param handler
	 */
	public DefaultWeixinMessageAdapter(MessageHandler handler) {
		super(handler);
	}

	@Override
	protected InMessage decodeMessage(InMessage msg ,MessageContext context) throws Exception {
		return msg;
	}

	@Override
	protected String encodeMessage(String msg, MessageContext context) throws Exception {
		return msg;
	}
	
}
