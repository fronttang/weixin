/**
 * 
 */
package com.boot2j.weixin.message.handler;

import com.boot2j.weixin.annotation.WeixinMessageHandler;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;
import com.boot2j.weixin.message.ShortvideoWeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@WeixinMessageHandler(type = MessageType.SHORTVIDEO)
public class ShortvideoWeixinMessageHandler extends AbstractWeixinMessageHandler {

	/**
	 * @param message
	 */
	public ShortvideoWeixinMessageHandler(ShortvideoWeixinMessage message) {
		super(message);
	}

	@Override
	public OutMessage invoke(MessageContext context) {
		return null;
	}

}
