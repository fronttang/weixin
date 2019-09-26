/**
 * 
 */
package com.boot2j.weixin.message.adapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public interface MessageAdapter {

	String adapter(HttpServletRequest request, HttpServletResponse response);
}
