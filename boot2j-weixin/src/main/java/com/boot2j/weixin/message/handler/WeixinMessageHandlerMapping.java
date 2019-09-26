/**
 * 
 */
package com.boot2j.weixin.message.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import com.boot2j.weixin.annotation.WeixinMessageHandler;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class WeixinMessageHandlerMapping extends AbstractMessageMapping {

	private static final Map<String, MessageHandler> MESSAGE_HANDLER_MAP = new ConcurrentHashMap<String, MessageHandler>(256);

	/**
	 * @see org.springframework.beans.factory.InitializingBean#afterPropertiesSet()
	 */
	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, MessageHandler> handlerBeans = this.applicationContext.getBeansOfType(MessageHandler.class);
		handlerBeans.forEach((name, handle) -> {
			WeixinMessageHandler handler = this.applicationContext.findAnnotationOnBean(name, WeixinMessageHandler.class);
			if(handler != null && handler.type() != null) {
				MESSAGE_HANDLER_MAP.put(handler.type().getType(), handle);
			}
		});

	}

	@Override
	public MessageHandler getWeixinMessage(String name) {
		return MESSAGE_HANDLER_MAP.get(name);
	}
}
