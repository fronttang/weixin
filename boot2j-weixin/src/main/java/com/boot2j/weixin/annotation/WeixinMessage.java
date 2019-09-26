/**
 * 
 */
package com.boot2j.weixin.annotation;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.core.annotation.AliasFor;

import com.boot2j.weixin.constant.MessageEventType;
import com.boot2j.weixin.constant.MessageType;

/**
 * 定义类为微信消息
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
//@Component
public @interface WeixinMessage {
	
	/**
	 * 微信消息名称
	 */
	@AliasFor("value")
	String name() default "";
	
	/**
	 * 微信消息类型
	 */
	MessageType type() default MessageType.TEXT;
	
	/**
	 * eventType
	 * @return
	 */
	MessageEventType event() default MessageEventType.CLICK;

	/**
	 * 微信消息名称
	 */
	@AliasFor("name")
	String value() default "";
}
