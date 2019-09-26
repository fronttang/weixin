/**
 * 
 */
package com.boot2j.weixin.message.handler;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContextAware;

import com.boot2j.weixin.message.WeixinMessage;


/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public interface MessageMapping extends ApplicationContextAware, InitializingBean {

	WeixinMessage getWeixinMessage(String name);
}
