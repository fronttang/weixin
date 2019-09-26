/**
 * 
 */
package com.boot2j.weixin.message.adapter;

import com.boot2j.weixin.message.handler.MessageHandler;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public abstract class AbstractEncryptWeixinMessageAdapter extends WeixinMessageAdapter {

	/**
	 * @param handler
	 */
	public AbstractEncryptWeixinMessageAdapter(MessageHandler handler) {
		super(handler);
	}

	protected abstract boolean checkEncodeType(String encodeType);

}
