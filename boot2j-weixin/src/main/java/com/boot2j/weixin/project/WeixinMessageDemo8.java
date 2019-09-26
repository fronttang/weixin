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
@com.boot2j.weixin.annotation.WeixinMessage(value = "8", type = MessageType.TEXT)
public class WeixinMessageDemo8 extends AbstractNewsWeixinMessage implements WeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("除了《程序员》，还有多少IT杂志值得程序员们阅读");
		articles.setDescription("先来谈谈《程序员》杂志，我刚接触程序员杂志，是在大二，那时，我刚转系到计算机系，一来认识的人少，二来我校的机算机课程与我所期待的大相径庭，我对程序的那股子热情，可真是万千抑郁无处可泄啊。");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221X5lly5picCKzylD403cFh8HGbDXkh5FK4AUQD6tUwlcYljrW67UJI9q7ewQbhNK34RTRqPMdEL41A/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=201588874&idx=1&sn=11cbce9dc3b1899de2c4cc7d7c1a10ae#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
