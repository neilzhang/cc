package com.hb.cc.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity(name = "CHAT_ROOM")
public class ChatRoom implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -45283877579983591L;

	@Id
	@Column(name = "ID")
	private String id;

	@Column(name = "NAME")
	private String name;

	@Column(name = "DESCRIPTION")
	private String description;

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
