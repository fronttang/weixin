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
@com.boot2j.weixin.annotation.WeixinMessage(value = "4", type = MessageType.TEXT)
public class WeixinMessageDemo4 extends AbstractNewsWeixinMessage implements WeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("21副GIF动图让你了解各种数学概念");
		articles.setDescription("“让我们面对它;总的来说数学是不容易的，但当你征服了问题，并达到新的理解高度，这就是它给你的回报。”");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221VicIRs9kmjZicdIXngOmnEA2Yl5q2NNRdpsHicgogrVEeUK8kCwmXkhtNtje8BZ0Bhz2rwZ8SJIPgMg/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=202582177&idx=1&sn=34ceb494344b23b1442c568f10f49a0f#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
