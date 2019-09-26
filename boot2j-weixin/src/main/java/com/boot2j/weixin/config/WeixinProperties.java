/**
 * 
 */
package com.boot2j.weixin.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import com.boot2j.weixin.constant.EncodingType;

/**
 * 微信有关配置
 * 
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Component
@ConfigurationProperties(prefix = WeixinProperties.PROFIX)
public class WeixinProperties {

	protected static final String PROFIX = "weixin";

	// 微信配置模式 config 配置， db 数据库
	private String model = "config";

	// 验证Token
	private String token = "weixin";

	// 消息加密类型
	private String encodingType = EncodingType.PIW.getType();

	// 加密密钥
	private String encodingAesKey;

	// appid
	private String appid;

	/**
	 * @return the token
	 */
	public String getToken() {
		return token;
	}

	/**
	 * @param token
	 *            the token to set
	 */
	public void setToken(String token) {
		this.token = token;
	}

	/**
	 * @return the encodingType
	 */
	public String getEncodingType() {
		return encodingType;
	}

	/**
	 * @param encodingType
	 *            the encodingType to set
	 */
	public void setEncodingType(String encodingType) {
		this.encodingType = encodingType;
	}

	/**
	 * @return the encodingAesKey
	 */
	public String getEncodingAesKey() {
		return encodingAesKey;
	}

	/**
	 * @param encodingAesKey
	 *            the encodingAesKey to set
	 */
	public void setEncodingAesKey(String encodingAesKey) {
		this.encodingAesKey = encodingAesKey;
	}

	/**
	 * @return the model
	 */
	public String getModel() {
		return model;
	}

	/**
	 * @param model
	 *            the model to set
	 */
	public void setModel(String model) {
		this.model = model;
	}

	/**
	 * @return the appid
	 */
	public String getAppid() {
		return appid;
	}

	/**
	 * @param appid
	 *            the appid to set
	 */
	public void setAppid(String appid) {
		this.appid = appid;
	}

}
