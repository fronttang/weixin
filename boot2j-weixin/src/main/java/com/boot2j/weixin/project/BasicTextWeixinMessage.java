/**
 * 
 */
package com.boot2j.weixin.project;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;
import com.boot2j.weixin.message.TextWeixinMessage;
import com.boot2j.weixin.message.WeixinMessage;
import com.boot2j.weixin.message.handler.AbstractMessageMapping;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Component
@com.boot2j.weixin.annotation.WeixinMessage(type = MessageType.TEXT)
public class BasicTextWeixinMessage extends AbstractMessageMapping implements TextWeixinMessage {

	@Override
	protected boolean supports(com.boot2j.weixin.annotation.WeixinMessage message) {
		return (message != null && !StringUtils.isEmpty(message.value()) && message.type() == MessageType.TEXT);
	}
	
	@Override
	public OutMessage invoke(MessageContext context) {
		
		InMessage ims = context.getInMessage();
		
		String content = ims.getContent();
		
		WeixinMessage message = getWeixinMessage(content);
		if(message != null) {
			return message.invoke(context);
		} else {
			return new SogouWeixinMessage().invoke(context);
		}
	}

}
