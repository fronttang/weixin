/**
 * 
 */
package com.boot2j.weixin.message.abstracts;

import java.util.List;

import com.boot2j.weixin.message.AbstractWeixinMessage;
import com.boot2j.weixin.message.Articles;
import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public abstract class AbstractNewsWeixinMessage extends AbstractWeixinMessage {

	@Override
	protected OutMessage doMessage(MessageContext context) {
		
		InMessage ims = context.getInMessage();
		
		OutMessage oms = newsMessage(ims, getArticles(context));
		
		return oms;
	}
	
	protected abstract List<Articles> getArticles(MessageContext context);
	

}
