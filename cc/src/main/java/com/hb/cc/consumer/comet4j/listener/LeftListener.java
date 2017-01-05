package com.hb.cc.consumer.comet4j.listener;

import org.comet4j.core.CometConnection;
import org.comet4j.core.CometEngine;
import org.comet4j.core.event.DropEvent;
import org.comet4j.core.listener.DropListener;

import com.hb.cc.consumer.comet4j.AppStore;
import com.hb.cc.consumer.comet4j.dto.LeftDTO;

public class LeftListener extends DropListener {
	public boolean handleEvent(DropEvent anEvent) {
		CometConnection conn = anEvent.getConn();
		if (conn != null) {
			String userName = AppStore.getInstance().get(conn.getId());
			LeftDTO dto = new LeftDTO(conn.getId(), userName);
			AppStore.getInstance().getMap().remove(conn.getId());
			((CometEngine) anEvent.getTarget()).sendToAll("talker", dto);
		}
		return true;
	}
}