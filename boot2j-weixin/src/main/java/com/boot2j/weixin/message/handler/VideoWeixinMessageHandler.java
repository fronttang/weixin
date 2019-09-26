/**
 * 
 */
package com.boot2j.weixin.message.handler;

import com.boot2j.weixin.annotation.WeixinMessageHandler;
import com.boot2j.weixin.constant.MessageType;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;
import com.boot2j.weixin.message.VideoWeixinMessage;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@WeixinMessageHandler(type = MessageType.VIDEO)
public class VideoWeixinMessageHandler extends AbstractWeixinMessageHandler {

	/**
	 * @param message
	 */
	public VideoWeixinMessageHandler(VideoWeixinMessage message) {
		super(message);
	}

	/**
	 * @see com.boot2j.weixin.message.WeixinMessage#invoke(com.boot2j.weixin.message.MessageContext)
	 */
	@Override
	public OutMessage invoke(MessageContext context) {
		return null;
	}

}
