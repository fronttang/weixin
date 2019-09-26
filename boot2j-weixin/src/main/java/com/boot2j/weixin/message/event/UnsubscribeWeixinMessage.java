/**
 * 
 */
package com.boot2j.weixin.message.event;

import org.springframework.stereotype.Component;

import com.boot2j.weixin.annotation.WeixinMessage;
import com.boot2j.weixin.constant.MessageEventType;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.AbstractWeixinMessage;
import com.boot2j.weixin.message.EventWeixinMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Component
@WeixinMessage(type = MessageType.EVENT, event = MessageEventType.UNSUBSCRIBE)
public class UnsubscribeWeixinMessage extends AbstractWeixinMessage implements EventWeixinMessage {

	@Override
	protected OutMessage doMessage(MessageContext context) {
		return null;
	}

}
