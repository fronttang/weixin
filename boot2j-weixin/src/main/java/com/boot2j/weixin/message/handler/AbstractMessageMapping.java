/**
 * 
 */
package com.boot2j.weixin.message.handler;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.util.StringUtils;

import com.boot2j.weixin.message.AbstractWeixinMessage;
import com.boot2j.weixin.message.WeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public abstract class AbstractMessageMapping implements MessageMapping {
	
	protected ApplicationContext applicationContext;
	
	protected static final Map<String, WeixinMessage> MESSAGE_MAP = new ConcurrentHashMap<String, WeixinMessage>(256);

	@Override
	public void setApplicationContext(ApplicationContext applicationContext)
			throws BeansException {
		this.applicationContext = applicationContext;
	}
	
	@Override
	public void afterPropertiesSet() throws Exception {
		Map<String, WeixinMessage> messageBeans = this.applicationContext.getBeansOfType(WeixinMessage.class);
		messageBeans.forEach((name, bean) -> {
			com.boot2j.weixin.annotation.WeixinMessage weixinMessage = this.applicationContext.findAnnotationOnBean(name, com.boot2j.weixin.annotation.WeixinMessage.class);
			if(supports(weixinMessage)) {
				MESSAGE_MAP.put(weixinMessage.value(), bean);
			}
		});
	}
	
	protected boolean supports(com.boot2j.weixin.annotation.WeixinMessage message) {
		return (message != null && !StringUtils.isEmpty(message.value()));
	}
	
	@Override
	public WeixinMessage getWeixinMessage(String name) {
		return MESSAGE_MAP.get(name);
	}

}
