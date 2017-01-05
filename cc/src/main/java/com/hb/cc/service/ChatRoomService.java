package com.hb.cc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hb.cc.domain.ChatRoom;
import com.hb.cc.repository.ChatRoomRepository;
import com.hb.cc.repository.RoomIDGenerator;

@Service
public class ChatRoomService {

	@Autowired
	private ChatRoomRepository chatRoomRepository;

	public ChatRoom getChatRoom(String name) {
		return chatRoomRepository.findByName(name);
	}

	public boolean checkNameExist(String name) {
		return chatRoomRepository.findByName(name) != null;
	}

	public String createChatRoom(String name, String description) {
		ChatRoom chatRoom = new ChatRoom();
		chatRoom.setId(RoomIDGenerator.get());
		chatRoom.setName(name);
		chatRoom.setDescription(description);
		ChatRoom save = chatRoomRepository.save(chatRoom);
		return save.getId();
	}

	public boolean checkIDExist(String roomId) {
		return chatRoomRepository.findOne(roomId) != null;
	}

}
