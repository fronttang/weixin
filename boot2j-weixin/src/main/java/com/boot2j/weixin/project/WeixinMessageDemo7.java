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
@com.boot2j.weixin.annotation.WeixinMessage(value = "7", type = MessageType.TEXT)
public class WeixinMessageDemo7 extends AbstractNewsWeixinMessage implements WeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("慢慢的，它們就沒有了，就像從未存在過");
		articles.setDescription("幾年以前，我曾經嘲笑過某科技界大佬。當時他說：也許90后、95後會慢慢不知道谷歌是什麼網站。");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221XclVFArrSo9sEK1IEia4umJZbu5kQGR6mcIU7WDIZaUd7UtBpWANX7DT3WCzicd2bgdJqKlX8dOtoA/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=201477553&idx=1&sn=bc5a64835d41c0201ab1ae7908a81e83#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
