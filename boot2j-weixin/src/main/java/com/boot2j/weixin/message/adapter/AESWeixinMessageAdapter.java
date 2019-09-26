/**
 * 
 */
package com.boot2j.weixin.message.adapter;

import org.springframework.util.StringUtils;

import com.boot2j.weixin.aes.WXBizMsgCrypt;
import com.boot2j.weixin.constant.EncodingType;
import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.handler.MessageHandler;
import com.boot2j.weixin.utils.XStreamFactory;
import com.thoughtworks.xstream.XStream;

/**
 * 微信消息AES加解密
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class AESWeixinMessageAdapter extends AbstractEncryptWeixinMessageAdapter {
	
	/**
	 * @param handler
	 */
	public AESWeixinMessageAdapter(MessageHandler handler) {
		super(handler);
	}

	/**
	 * 如果消息是加密的，则需要解密
	 * @param context
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	@Override
	protected InMessage decodeMessage(InMessage msg ,MessageContext context) throws Exception {
		// 消息体验证和解密
		if (checkEncodeType(msg.getEncrypt_type())) {
			
			String token = weixinProperties.getToken();
			
			String msg_signature = msg.getMsg_signature();
			String encrypt_type = msg.getEncrypt_type();
			String timestamp = msg.getTimestamp();
			String nonce = msg.getNonce();
			String encrypt = msg.getEncrypt();
			
			String encodingAesKey = weixinProperties.getEncodingAesKey();
			String appid = weixinProperties.getAppid();
			
			WXBizMsgCrypt crypt = new WXBizMsgCrypt(token, encodingAesKey, appid);
			String xml = crypt.decryptMsgW(msg_signature, timestamp, nonce, encrypt);
			if (!StringUtils.isEmpty(xml)) {
				
				XStream xstream = XStreamFactory.init(true);
				xstream.alias("xml", InMessage.class);
				msg = (InMessage) xstream.fromXML(xml);
				
				msg.setEncrypt_type(encrypt_type);
				msg.setTimestamp(timestamp);
				msg.setNonce(nonce);
				msg.setToken(token);
				msg.setAppid(appid);
				msg.setEncrypt(encrypt);
				msg.setEncodingAesKey(encodingAesKey);
			}
		}
		return msg;
	}

	@Override
	protected String encodeMessage(String msg, MessageContext context) throws Exception {
		InMessage ims = context.getInMessage();
		if (checkEncodeType(ims.getEncrypt_type())) {
			// 对消息进行加密
			WXBizMsgCrypt crypt = new WXBizMsgCrypt(ims.getToken(), ims.getEncodingAesKey(), ims.getAppid());
			msg = crypt.encryptMsg(msg, ims.getTimestamp(), ims.getNonce());
		}
		return msg;
	}


	@Override
	protected boolean checkEncodeType(String encodeType) {
		return EncodingType.AES.getType().equalsIgnoreCase(encodeType);
	}
}
