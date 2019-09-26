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
@com.boot2j.weixin.annotation.WeixinMessage(value = "5", type = MessageType.TEXT)
public class WeixinMessageDemo5 extends AbstractNewsWeixinMessage implements WeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("历史上最有名的电脑密码是什么？");
		articles.setDescription("CSDN 600万注册用户密码被盗，其中最诗意密码泄露！密码是：ppnn13%dkstFeb.1st。看不懂？中文解析：娉娉袅袅十三余，豆蔻梢头二月初。碉堡了有木有——我们的密码都弱爆了啊！摔！！");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221XP53tIu8Xt1CxILxiae5XWOHRPIpZqDtGR7AfkW4F7FLdxqOBBcia1Uyc0Iq8mqHgws3qibnbL8icaLw/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=201378252&idx=1&sn=8a82b2eadfe020e2e66a8fbba6977c2a#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
