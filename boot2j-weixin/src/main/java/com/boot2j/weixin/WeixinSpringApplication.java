/**
 * 
 */
package com.boot2j.weixin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@WeixinApplication
public class WeixinSpringApplication {

	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(WeixinSpringApplication.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}
}
