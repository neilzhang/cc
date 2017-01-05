package com.hb.cc.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.hb.cc.domain.ChatRoom;

public interface ChatRoomRepository extends JpaRepository<ChatRoom, String> {

	public ChatRoom findByName(String name);

}
