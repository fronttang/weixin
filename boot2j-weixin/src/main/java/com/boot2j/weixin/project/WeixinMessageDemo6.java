/**
 * 
 */
package com.boot2j.weixin.project;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.Articles;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.WeixinMessage;
import com.boot2j.weixin.message.abstracts.AbstractNewsWeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Component
@com.boot2j.weixin.annotation.WeixinMessage(value = "6", type = MessageType.TEXT)
public class WeixinMessageDemo6 extends AbstractNewsWeixinMessage implements WeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("Java枚举类型浅析");
		articles.setDescription("Java 中的枚举类型采用关键字enum 来定义，从jdk1.5才有的新类型，所有的枚举类型都是继承自Enum 类型。要了解枚举类型，建议大家先打开jdk 中的Enum类简单读一下，这个类里面定义了很多protected 方法，比如构造函数，如果要使用这些方法我们可以把枚举类型定义到当前类中。每个枚举类型，都有自己的名字和顺序，当我们输出一个枚举类型的时候，会输入枚举类型的name ，具体可以参考下面的例子。");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221WcPIzLlXldu9sY6A3W5Tl7s9ialluNR9lic7t6JAX7MJ5bRE0cDZ3cia9AwLMnR7rzXITbicz1eYH2FA/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=201326680&idx=1&sn=7572f4eff396e33ce525785fc2e62c08#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
