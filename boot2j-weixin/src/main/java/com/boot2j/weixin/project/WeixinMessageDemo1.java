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
@com.boot2j.weixin.annotation.WeixinMessage(value = "1", type = MessageType.TEXT)
public class WeixinMessageDemo1 extends AbstractNewsWeixinMessage implements
		WeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("成功的求職簡歷 這6個信息一定要有");
		articles.setDescription("6秒鐘就可以決定一個人對你第一印象的好與壞。如何在這麼短的時間之內，引起一位與你素昧平生的人的注意？求職簡歷的撰寫也是一樣，它不僅是求職第一步，更是在眾多競爭者中扮演敲門磚的角色。一份好的簡歷將讓你獲得面試的機會，甚至雀屏中選。");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221WaIlxOZJKFh0xTkdTZ1icU38KqSslhEib6ia3dzTCQuh73dAHZuGCBpjWabEeXwTMUtKjdPLQdXAHrA/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=2450065847&idx=3&sn=7b3afe03816fb70a91cb66d39adef83c#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
