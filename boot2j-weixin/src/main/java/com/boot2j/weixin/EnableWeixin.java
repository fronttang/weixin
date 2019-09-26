package com.boot2j.weixin;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;

import com.boot2j.weixin.autoconfigure.WeixinConfigurationImportSelector;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */ 
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@ComponentScan(basePackages = { "com.boot2j.weixin" })
@Import(WeixinConfigurationImportSelector.class)
public @interface EnableWeixin {

}
