package com.hb.cc.controller;

import org.comet4j.core.CometContext;
import org.comet4j.core.CometEngine;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.hb.cc.consumer.comet4j.listener.JoinListener;
import com.hb.cc.consumer.comet4j.listener.LeftListener;
import com.hb.cc.domain.ChatRoom;
import com.hb.cc.dto.ResultDto;
import com.hb.cc.dto.ResultDtoFactory;
import com.hb.cc.service.ChatRoomService;

@Controller
@RequestMapping("/chatroom")
public class ChatRoomController {

	@Autowired
	private ChatRoomService chatRoomService;

	public void fetchLimitedChatRooms() {

	}

	public void searchChatRoom() {

	}

	@RequestMapping("create")
	@ResponseBody
	public ResultDto<String> createChatRoom(String name, String decription) {
		String roomId = null;
		if (chatRoomService.checkNameExist(name)) {
			return ResultDtoFactory.toNack("chat room already exists");
		} else if ((roomId = chatRoomService.createChatRoom(name, decription)) != null) {
			CometContext cc = CometContext.getInstance();
			CometEngine engine = cc.getEngine();
			cc.registChannel(roomId);

			engine.addConnectListener(new JoinListener());
			engine.addDropListener(new LeftListener());
			return ResultDtoFactory.toAck("success", roomId);
		} else {
			return ResultDtoFactory.toNack("fail");
		}
	}

	@RequestMapping("join")
	@ResponseBody
	public ResultDto<String> joinChatRoom(String roomId, String clientId) {
		if (!chatRoomService.checkIDExist(roomId)) {
			return ResultDtoFactory.toNack("chat room not exists");
		} else {
			return ResultDtoFactory.toAck("success");
		}
	}

	@RequestMapping("getRoom")
	@ResponseBody
	public ResultDto<ChatRoom> getChatRoom(String name) {
		return ResultDtoFactory.toAck("success", chatRoomService.getChatRoom(name));
	}
}
