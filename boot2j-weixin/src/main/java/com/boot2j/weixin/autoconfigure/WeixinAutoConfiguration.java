/**
 * 
 */
package com.boot2j.weixin.autoconfigure;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.boot2j.weixin.message.adapter.AESWeixinMessageAdapter;
import com.boot2j.weixin.message.adapter.DefaultWeixinMessageAdapter;
import com.boot2j.weixin.message.adapter.MessageAdapter;
import com.boot2j.weixin.message.handler.MessageHandler;
import com.boot2j.weixin.message.handler.MessageMapping;
import com.boot2j.weixin.message.handler.WeixinMessageHandlerAdapter;
import com.boot2j.weixin.message.handler.WeixinMessageHandlerMapping;
import com.boot2j.weixin.web.BasicWeixinController;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Configuration
@ConditionalOnWebApplication
public class WeixinAutoConfiguration {
	
	@Bean
	public MessageMapping weixinMessageHandlerMapping() {
		return new WeixinMessageHandlerMapping();
	}

	@Bean
	public MessageHandler weixinMessageHandlerAdapter() {
		return new WeixinMessageHandlerAdapter(weixinMessageHandlerMapping());
	}

	@Bean
	@ConditionalOnProperty(prefix = "weixin", name = "encoding-type", havingValue = "piw")
	public MessageAdapter piwWeixinMessageAdapter() {
		return new DefaultWeixinMessageAdapter(weixinMessageHandlerAdapter());
	}
	
	@Bean
	@ConditionalOnProperty(prefix = "weixin", name = "encoding-type", havingValue = "aes")
	public MessageAdapter aesWeixinMessageAdapter() {
		return new AESWeixinMessageAdapter(weixinMessageHandlerAdapter());
	}
	
	@Bean
	@ConditionalOnMissingBean(MessageAdapter.class)
	@ConditionalOnProperty(prefix = "weixin", name = "encoding-type", matchIfMissing = true)
	public MessageAdapter defaultWeixinMessageAdapter() {
		return new DefaultWeixinMessageAdapter(weixinMessageHandlerAdapter());
	}

	@Bean
	public WeixinMessageHandlerMapping messageHandlers() {
		return new WeixinMessageHandlerMapping();
	}

	@Bean
	public BasicWeixinController basicWeixinController() {
		return new BasicWeixinController();
	}

	@Bean
	public WeixinControllerHandlerMapping weixinHandlerMapping() {
		return new WeixinControllerHandlerMapping(basicWeixinController());
	}

}
