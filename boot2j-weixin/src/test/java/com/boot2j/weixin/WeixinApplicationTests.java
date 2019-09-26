package com.boot2j.weixin;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;

// @RunWith(SpringRunner.class)
// @SpringBootTest
@WeixinApplication
public class WeixinApplicationTests {

	//@Test
	public void contextLoads() {
	}
	
	public static void main(String[] args) {
		SpringApplication application = new SpringApplication(WeixinApplicationTests.class);
		application.setBannerMode(Banner.Mode.OFF);
		application.run(args);
	}

}
