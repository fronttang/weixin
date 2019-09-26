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
@com.boot2j.weixin.annotation.WeixinMessage(value = "0", type = MessageType.TEXT)
public class WeixinMessageDemo extends AbstractNewsWeixinMessage implements WeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("2015年找到好工作所需的10項技能");
		articles.setDescription("大學或研究生畢業一定能找到好工作？工學院或信息（計算機）相關學系專業一定受雇主青睞？也許這些「硬」背景在求職時可加點分，但研究顯示，擁有一些「軟技能」（Soft Skills），諸如：團隊協作、溝通技巧與組織分析能力等，在應徵和面試時更能受到企業主的看重。");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221WaIlxOZJKFh0xTkdTZ1icU3h9d2Pd2VvkPicrjKKyVcfx7Q9JibWHxKqibVWq05TEkjFpq8oLadDUCdA/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=2450065847&idx=2&sn=83556ff61704a76290a7c0e3571e430a#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
