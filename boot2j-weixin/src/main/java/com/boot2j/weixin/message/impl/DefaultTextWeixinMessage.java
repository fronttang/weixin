/**
 * 
 */
package com.boot2j.weixin.message.impl;

import java.util.ArrayList;
import java.util.List;

import com.boot2j.weixin.annotation.WeixinMessage;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.Articles;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.TextWeixinMessage;
import com.boot2j.weixin.message.abstracts.AbstractNewsWeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@WeixinMessage(type = MessageType.TEXT)
public class DefaultTextWeixinMessage extends AbstractNewsWeixinMessage implements TextWeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("5種入門編程語言 幫你敲開就業之門");
		articles.setDescription("選填科系對未來的職場生涯發展影響甚巨，掌握專業技能更是決定未來收入高低的關鍵。美國許多研究與調查皆發現，計算機科學（又稱：資訊科學）相關學位畢業的學生不僅在起薪方面比其他科系來得高，到職場生涯中期的年薪上漲幅度，也比一般專業高。此外，他們還被列為最受僱主歡迎的學位之一");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221WaIlxOZJKFh0xTkdTZ1icU3PJ8XdMgzemosXs8TTZw69BcB5NQPxA56WvA9vV4MicllNwqY4b545jA/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=2450065847&idx=1&sn=dcf8af9974bad211308a6229269edb29#rd");
		articlesList.add(articles);
		return articlesList;
	}

//	@Override
//	protected String getContent(MessageContext context) {
//		
//		return "您好，我正在成长过程中，这项功能正在完善当中，请先咨询其他问题,谢谢\r\n";
//	}

}
