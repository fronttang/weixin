/**
 * 
 */
package com.boot2j.weixin.message.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.boot2j.weixin.annotation.WeixinMessage;
import com.boot2j.weixin.annotation.WeixinMessageHandler;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.EventWeixinMessage;
import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@WeixinMessageHandler(type = MessageType.EVENT)
public class EventWeixinMessageHandler extends AbstractMessageMapping implements MessageHandler  {

	private static final Map<String, EventWeixinMessage> MESSAGE_MAP = new ConcurrentHashMap<String, EventWeixinMessage>(256);

	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, EventWeixinMessage> messageBeans = this.applicationContext.getBeansOfType(EventWeixinMessage.class);
		messageBeans.forEach((name, bean) -> {
			WeixinMessage weixinMessage = this.applicationContext.findAnnotationOnBean(name, WeixinMessage.class);
			if(weixinMessage != null && weixinMessage.event() != null) {
				MESSAGE_MAP.put(weixinMessage.event().getType(), bean);
			}
		});
	}

	@Override
	public EventWeixinMessage getWeixinMessage(String name) {
		return MESSAGE_MAP.get(name);
	}

	@Override
	public OutMessage invoke(MessageContext context) {
		
		InMessage ims = context.getInMessage();
		String event = ims.getEvent();
		
		EventWeixinMessage weixinMessage = getWeixinMessage(event);
		if(weixinMessage != null) {
			return weixinMessage.invoke(context);
		}
		return null;
	}

}
