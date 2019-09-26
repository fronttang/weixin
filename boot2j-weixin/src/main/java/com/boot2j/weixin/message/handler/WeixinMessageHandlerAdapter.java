/**
 * 
 */
package com.boot2j.weixin.message.handler;

import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;
import com.boot2j.weixin.message.WeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class WeixinMessageHandlerAdapter implements MessageHandler {
	
	private MessageMapping handlerMapping;

	public WeixinMessageHandlerAdapter(MessageMapping handlerMapping) {
		this.handlerMapping = handlerMapping;
		
	}

	@Override
	public OutMessage invoke(MessageContext context) {
		
		InMessage ims = context.getInMessage();
		String msgType = ims.getMsgType();
		
		WeixinMessage handler = handlerMapping.getWeixinMessage(msgType);
		
		return handler.invoke(context);
	}

}
