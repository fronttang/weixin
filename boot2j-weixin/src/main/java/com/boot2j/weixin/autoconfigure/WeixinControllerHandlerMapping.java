/**
 * 
 */
package com.boot2j.weixin.autoconfigure;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.servlet.mvc.method.annotation.RequestMappingHandlerMapping;

import com.boot2j.weixin.web.BasicWeixinController;

/**
 * 微信消息映射
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class WeixinControllerHandlerMapping extends RequestMappingHandlerMapping {

	private static Logger logger = LoggerFactory.getLogger(WeixinControllerHandlerMapping.class);
	
	private BasicWeixinController controller;
	
	public WeixinControllerHandlerMapping(BasicWeixinController controller) {
		this.controller = controller;
	}
	
	@Override
	public void afterPropertiesSet() {
		super.afterPropertiesSet();
		detectHandlerMethods(controller);
	}
	
	@Override
	protected boolean isHandler(Class<?> beanType) {
		return false;
	}

}
