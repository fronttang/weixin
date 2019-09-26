/**
 * 
 */
package com.boot2j.weixin.message.event;

import org.springframework.stereotype.Component;

import com.boot2j.weixin.annotation.WeixinMessage;
import com.boot2j.weixin.constant.MessageEventType;
import com.boot2j.weixin.constant.MessageType;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
@Component
@WeixinMessage(type = MessageType.EVENT, event = MessageEventType.CLICK)
public class ClickWeixinMessage extends AbstractEventWeixinMessage {

}
