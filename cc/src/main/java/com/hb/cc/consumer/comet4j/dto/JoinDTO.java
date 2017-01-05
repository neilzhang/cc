package com.hb.cc.consumer.comet4j.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class JoinDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 2587132673740298698L;
	private final String transtime;
	private String type;
	private String id;
	private String name;

	public JoinDTO(String id, String name) {
		this.type = "up";
		this.id = id;
		this.name = name;
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		this.transtime = f.format(d);
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getTranstime() {
		return this.transtime;
	}
}
