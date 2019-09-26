/**
 * 
 */
package com.boot2j.weixin.message.handler;

import com.boot2j.weixin.annotation.WeixinMessageHandler;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.NewsWeixinMessage;
import com.boot2j.weixin.message.OutMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@WeixinMessageHandler(type = MessageType.NEWS)
public class NewsWeixinMessageHandler extends AbstractWeixinMessageHandler {

	/**
	 * @param message
	 */
	public NewsWeixinMessageHandler(NewsWeixinMessage message) {
		super(message);
	}

	@Override
	public OutMessage invoke(MessageContext context) {
		return null;
	}

}
