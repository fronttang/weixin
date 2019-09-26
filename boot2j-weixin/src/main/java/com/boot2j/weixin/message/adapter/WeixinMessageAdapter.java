/**
 * 
 */
package com.boot2j.weixin.message.adapter;

import javax.servlet.ServletInputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import com.boot2j.weixin.config.WeixinProperties;
import com.boot2j.weixin.message.Articles;
import com.boot2j.weixin.message.InMessage;
import com.boot2j.weixin.message.MessageContext;
import com.boot2j.weixin.message.OutMessage;
import com.boot2j.weixin.message.handler.MessageHandler;
import com.boot2j.weixin.utils.Tools;
import com.boot2j.weixin.utils.XStreamFactory;
import com.thoughtworks.xstream.XStream;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public abstract class WeixinMessageAdapter implements MessageAdapter {

	private static Logger logger = LoggerFactory.getLogger(WeixinMessageAdapter.class);

	@Autowired
	protected WeixinProperties weixinProperties;
	
	private MessageHandler messageHandler;

	public WeixinMessageAdapter(MessageHandler handler) {
		this.messageHandler = handler;
	}

	/**
	 * @param request
	 * @param response
	 * @return
	 * @throws Exception
	 */
	@Override
	public String adapter(HttpServletRequest request, HttpServletResponse response) {
		try
		{
			XStream xstream = XStreamFactory.init(true);
			
			MessageContext context = new MessageContext(request, response);
	
			OutMessage oms = new OutMessage();
			
			ServletInputStream in = request.getInputStream();
			// 转换微信post过来的xml内容
			xstream.alias("xml", InMessage.class);
			// xs = XstreamUtils.XStreamConver(xs);
			String xmlMsg = Tools.inputStream2String(in);
			logger.debug(String.format("inMessage:%s", xmlMsg));
			
			InMessage msg = new InMessage();
			
			if (!StringUtils.isEmpty(xmlMsg)) {
				
				msg = (InMessage) xstream.fromXML(xmlMsg);
				
				msg.setEncrypt_type(request.getParameter("encrypt_type"));
				msg.setMsg_signature(request.getParameter("msg_signature"));
				msg.setTimestamp(request.getParameter("timestamp"));
				msg.setNonce(request.getParameter("nonce"));
				
				msg = decodeMessage(msg ,context);
				
				context.setInMessage(msg);
				
				oms = messageHandler.invoke(context);
			}
			return returnData(oms, context);
		}
		catch(Exception e)
		{
			logger.error("", e);
		}
		return "success";
	}

	/**
	 * 如果消息是加密的，则需要解密
	 * @param context
	 * @param msg
	 * @return
	 * @throws Exception
	 */
	protected abstract InMessage decodeMessage(InMessage msg, MessageContext context) throws Exception ;

	/**
	 * 生成返回数据
	 * @param work
	 */
	private String returnData(OutMessage oms, MessageContext context) throws Exception {
		if (oms != null)
		{
			XStream xstream = XStreamFactory.init(true);
			xstream.alias("xml", OutMessage.class);
			xstream.alias("item", Articles.class);
			String msg = xstream.toXML(oms);
			msg = encodeMessage(msg, context);
			//logger.debug(String.format("outMessage:%s", msg));
			return msg;
		}
		return "success";
	}
	
	/**
	 * 返回加密消息
	 * @param msg
	 * @param context
	 * @return
	 * @throws Exception
	 */
	protected abstract String encodeMessage(String msg, MessageContext context) throws Exception;

}
