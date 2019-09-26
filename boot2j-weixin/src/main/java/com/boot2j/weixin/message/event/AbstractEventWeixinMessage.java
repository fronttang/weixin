/**
 * 
 */
package com.boot2j.weixin.message.event;

import com.boot2j.weixin.message.EventWeixinMessage;
import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;
import com.boot2j.weixin.message.WeixinMessage;
import com.boot2j.weixin.message.handler.AbstractMessageMapping;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class AbstractEventWeixinMessage extends AbstractMessageMapping implements EventWeixinMessage {
	

	@Override
	public OutMessage invoke(MessageContext context) {
		
		InMessage ims = context.getInMessage();
		String eventKey = ims.getEventKey();
		WeixinMessage message = getWeixinMessage(eventKey);
		if(message != null) {
			return message.invoke(context);
		} else {
			return null;
		}
	}

}
