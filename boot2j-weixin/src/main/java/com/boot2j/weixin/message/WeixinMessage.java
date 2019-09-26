/**
 * 
 */
package com.boot2j.weixin.message;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public interface WeixinMessage {

	OutMessage invoke(MessageContext context);
}
