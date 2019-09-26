/**
 * 
 */
package com.boot2j.weixin.constant;

/**
 * 微信消息类型
 * 
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public enum MessageEventType {

	CLICK("CLICK"), 
	SUBSCRIBE("subscribe"), 
	UNSUBSCRIBE("unsubscribe"), 
	SCAN("SCAN"), 
	LOCATION("LOCATION"), 
	MASSSENDJOBFINISH("MASSSENDJOBFINISH"), // 事件推送群发结果
	TEMPLATESENDJOBFINISH("TEMPLATESENDJOBFINISH"), // 模板消息发送结果
	VIEW("VIEW");

	String type;

	MessageEventType(String type) {
		this.type = type;
	}

	/**
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
	 * @param type
	 *            the type to set
	 */
	public void setType(String type) {
		this.type = type;
	}

}
