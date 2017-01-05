package com.hb.cc.controller;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.cc.producer.topic.TopicSender;

/**
 * 
 * @author liang
 * @description controller娴嬭瘯
 */
@Controller
@RequestMapping("/activemq")
public class ActivemqController {

	@Resource
	TopicSender topicSender;

	/**
	 * 鍙戦�娑堟伅鍒颁富棰� Topic涓婚 锛氭斁鍏ヤ竴涓秷鎭紝鎵�湁璁㈤槄鑰呴兘浼氭敹鍒� 杩欎釜鏄富棰樼洰鐨勫湴鏄竴瀵瑰鐨�
	 * 
	 * @param message
	 * @return String
	 */
	@ResponseBody
	@RequestMapping("topicSender")
	public String topicSender(@RequestParam("message") String message) {
		String opt = "";
		try {
			topicSender.send("test.topic", message);
			opt = "suc";
		} catch (Exception e) {
			opt = e.getCause().toString();
		}
		return opt;
	}

}
