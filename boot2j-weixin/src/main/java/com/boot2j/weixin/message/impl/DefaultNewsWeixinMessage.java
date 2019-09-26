/**
 * 
 */
package com.boot2j.weixin.message.impl;

import com.boot2j.weixin.annotation.WeixinMessage;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.AbstractWeixinMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.NewsWeixinMessage;
import com.boot2j.weixin.message.OutMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@WeixinMessage(type = MessageType.NEWS)
public class DefaultNewsWeixinMessage extends AbstractWeixinMessage implements NewsWeixinMessage {

	@Override
	protected OutMessage doMessage(MessageContext context) {
		return null;
	}

}
