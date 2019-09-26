/**
 * 
 */
package com.boot2j.weixin.message;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 消息上下文
 * 
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class MessageContext {

	private HttpServletRequest request;

	private HttpServletResponse response;

	private InMessage inMessage;

	private OutMessage outMessage = new OutMessage();

	public OutMessage getOutMessage() {
		return outMessage;
	}

	public void setOutMessage(OutMessage outMessage) {
		this.outMessage = outMessage;
	}

	public MessageContext(HttpServletRequest request,
			HttpServletResponse response) {
		this.request = request;
		this.response = response;
	}

	public MessageContext(HttpServletRequest request,
			HttpServletResponse response, InMessage inMessage) {
		this.request = request;
		this.response = response;
		this.inMessage = inMessage;
	}

	public HttpServletRequest getRequest() {
		return request;
	}

	public HttpServletResponse getResponse() {
		return response;
	}

	public InMessage getInMessage() {
		return inMessage;
	}

	public void setInMessage(InMessage inMessage) {
		this.inMessage = inMessage;
	}

}
