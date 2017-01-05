package com.hb.cc.consumer.topic;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

import org.springframework.stereotype.Component;

/**
 * 
 * @author liang
 * @description 闃熷垪娑堟伅鐩戝惉鍣�
 * 
 */
@Component
public class TopicReceiver1 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			System.out.println("QueueReceiver1鎺ユ敹鍒版秷鎭�" + ((TextMessage) message).getText());
		} catch (JMSException e) {
			e.printStackTrace();
		}
	}
}
