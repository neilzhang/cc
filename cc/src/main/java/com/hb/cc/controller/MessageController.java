package com.hb.cc.controller;

import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.cc.consumer.comet4j.AppStore;
import com.hb.cc.consumer.comet4j.dto.TalkDTO;

@Controller
@RequestMapping("/message")
public class MessageController {

	@RequestMapping("/say")
	@ResponseBody
	public String say(String message, String clientId, String roomId) {
		final CometEngine engine = CometContext.getInstance().getEngine();
		final AppStore appStore = AppStore.getInstance();
		String name = appStore.get(clientId);
		TalkDTO dto = new TalkDTO(clientId, name, message);
		engine.sendToAll(roomId, dto);
		
		return  String.valueOf(true);
	}

}
