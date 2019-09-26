/**
 * 
 */
package com.boot2j.weixin.message.event;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.boot2j.weixin.annotation.WeixinMessage;
import com.boot2j.weixin.constant.MessageEventType;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.Articles;
import com.boot2j.weixin.message.EventWeixinMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.abstracts.AbstractNewsWeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Component
@WeixinMessage(type = MessageType.EVENT, event = MessageEventType.SUBSCRIBE)
public class SubscribeWeixinMessage extends AbstractNewsWeixinMessage implements EventWeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("Java程序猿增加查看历史推送图文");
		articles.setDescription("为了更多的让广大关注者查看推送历史图文消息记录，Java程序猿增加查看历史图文消息功能。");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221W5xB6onqgx2RwJWolQJxJUtH5F6W779quoJVcCdqiafrJGER4zEWoMG3cq0SZIAHqhHKjw5OQB5yA/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=202426115&idx=1&sn=059fb1c959768dbfabf37e805f6c89a6#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
