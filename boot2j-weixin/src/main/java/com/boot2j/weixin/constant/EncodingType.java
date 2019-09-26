/**
 * 
 */
package com.boot2j.weixin.constant;

/**
 * 消息加密方式
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public enum EncodingType {

	PIW("piw"),//明文（不加密）
	AES("aes");// AES加密
	
	private String type;
	
	EncodingType(String type){
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
}
