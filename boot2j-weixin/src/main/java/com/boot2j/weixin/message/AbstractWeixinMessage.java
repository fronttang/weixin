/**
 * 
 */
package com.boot2j.weixin.message;

import java.util.Date;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.boot2j.weixin.constant.MessageType;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public abstract class AbstractWeixinMessage implements WeixinMessage {
	
	private static Logger logger = LoggerFactory.getLogger(AbstractWeixinMessage.class);
	
	protected void before(MessageContext context)
	{
		
	}
	
	protected void after(MessageContext context)
	{
		
	}
	
	@Override
	public OutMessage invoke(MessageContext context) {

		before(context);
		OutMessage oms = doMessage(context);
		after(context);
		return oms;
	}
	
	protected abstract OutMessage doMessage(MessageContext context);
	
	/**
	 * 显示文本消息
	 */
	protected OutMessage textMessage(InMessage msg, String content)
	{
		OutMessage oms = new OutMessage();
		// 设置发送信息
		oms.setContent(content);
		oms.setCreateTime(new Date().getTime());
		oms.setToUserName(msg.getFromUserName());
		oms.setFromUserName(msg.getToUserName());
		oms.setMsgType(MessageType.TEXT.getType());
		return oms;
	}
	
	protected OutMessage musicMessage(InMessage msg)
	{
		OutMessage oms = new OutMessage();
		return oms;
	}
	
	protected OutMessage locationMessage(InMessage msg)
	{
		return null;
	}
	
	/**
	 * 显示图文消息
	 */
	protected OutMessage newsMessage(InMessage msg, List<Articles> argList)
	{
		OutMessage oms = new OutMessage();
		oms.setCreateTime(new Date().getTime());
		oms.setToUserName(msg.getFromUserName());
		oms.setFromUserName(msg.getToUserName());
		oms.setMsgType(MessageType.NEWS.getType());
		oms.setArticles(argList);
		oms.setArticleCount(argList.size());
		return oms;
	}
	
	protected OutMessage linkMessage(InMessage msg, OutMessage oms)
	{
		return null;
	}
	
	protected OutMessage eventMessage(InMessage msg)
	{
		return null;
	}
	
	protected OutMessage imageMessage(InMessage msg, String imgPath)
	{
		return null;
	}
	
}
