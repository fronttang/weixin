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
public enum MessageType {

	TEXT("text"), 
	LOCATION("location"), 
	IMAGE("image"), 
	LINK("link"), 
	EVENT("event"), 
	NEWS("news"), 
	MUSIC("music"), 
	VOICE("voice"), 
	VIDEO("video"),
	SHORTVIDEO("shortvideo");

	String type;

	MessageType(String type) {
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
