/**
 * 
 */
package com.boot2j.weixin.web;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.boot2j.weixin.config.WeixinProperties;
import com.boot2j.weixin.message.adapter.MessageAdapter;
import com.boot2j.weixin.utils.Tools;

import cn.hutool.http.HttpUtil;

/**
 * 微信Controller
 * 
 * @author FrontTang
 * @email fronttang@gmail.com
 * @since 1.0
 */
public class BasicWeixinController {
	
	private static Logger logger = LoggerFactory.getLogger(BasicWeixinController.class);

	@Autowired
	private WeixinProperties weixinProperties;
	
	@Autowired
	private MessageAdapter adapter;
	

	/**
	 * 检验微信signature
	 * 
	 * @param signature
	 * @param timestamp
	 * @param nonce
	 * @param echostr
	 * @return
	 */
	@GetMapping("/weixin")
	@ResponseBody
	public String weixin(String signature, String timestamp, String nonce, String echostr, HttpServletRequest request) {
		if (!StringUtils.isEmpty(signature) && !StringUtils.isEmpty(timestamp) && !StringUtils.isEmpty(nonce)) {
			if (Tools.checkSignature(weixinProperties.getToken(), signature, timestamp, nonce)) {
				return echostr;
			}
		}
		return "is working,IP:" + HttpUtil.getClientIP(request);
	}

	@PostMapping("/weixin")
	@ResponseBody
	public String doWeixin(HttpServletRequest request, HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		response.setContentType("text/xml");
		
		/*logger.info("encrypt_type:" + req.getParameter("encrypt_type"));
		logger.info("msg_signature:" + req.getParameter("msg_signature"));
		logger.info("timestamp:" + req.getParameter("timestamp"));
		logger.info("nonce:" + req.getParameter("nonce"));*/
		
		// 开始执行消息处理器
		return adapter.adapter(request, response);
	}
	
}
