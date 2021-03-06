/**
 * 
 */
package com.boot2j.weixin.message.abstracts;

import com.boot2j.weixin.message.AbstractWeixinMessage;
import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public abstract class AbstractTextWeixinMessage extends AbstractWeixinMessage {

	@Override
	protected OutMessage doMessage(MessageContext context) {
		
		InMessage ims = context.getInMessage();
		
		OutMessage oms = textMessage(ims, getContent(context));
		
		return oms;
	}
	
	protected abstract String getContent(MessageContext context);

}
