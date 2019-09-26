/**
 * 
 */
package com.boot2j.weixin.message.handler;

import com.boot2j.weixin.annotation.WeixinMessageHandler;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;
import com.boot2j.weixin.message.TextWeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@WeixinMessageHandler(type = MessageType.TEXT)
public class TextWeixinMessageHandler extends AbstractWeixinMessageHandler {
	
	public TextWeixinMessageHandler(TextWeixinMessage message) {
		super(message);
	}
	
	@Override
	public OutMessage invoke(MessageContext context) {
		// TODO 
		return message.invoke(context);
	}

}
