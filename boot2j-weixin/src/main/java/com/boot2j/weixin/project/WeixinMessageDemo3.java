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
@com.boot2j.weixin.annotation.WeixinMessage(value = "3", type = MessageType.TEXT)
public class WeixinMessageDemo3 extends AbstractNewsWeixinMessage implements WeixinMessage {

	@Override
	protected List<Articles> getArticles(MessageContext context) {
		List<Articles> articlesList = new ArrayList<Articles>();
		Articles articles = new Articles();
		articles.setTitle("Linux之父Linus说：并行计算基本上就是浪费大家的时间");
		articles.setDescription("硬件的性能无法永远提升，当前的趋势实际上趋于降低功耗。那么推广并行技术这个灵丹妙药又有什么好处呢？我们已经知道适当的乱序CPU是必要的，因为人们需要合理的性能，并且乱序执行已被证明比顺序执行效率更高。 ");
		articles.setPicUrl("http://mmbiz.qpic.cn/mmbiz/bFA85Vd221XA3edJ4UpymoQOyprDppFyzWoLyCZFtKhV5vgwWJWU3dSorcTO1eicR1O6qM6nHWPPUH29kKfGzuw/640?tp=webp&wxfrom=5");
		articles.setUrl("https://mp.weixin.qq.com/s?__biz=MjM5MDkxODU2NQ==&mid=202555034&idx=1&sn=3d90be4e8bb59ebe8d277074563a1554#rd");
		articlesList.add(articles);
		return articlesList;
	}

}
