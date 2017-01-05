package com.hb.cc.consumer.comet4j.dto;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.Date;

public class TalkDTO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = -1235880146845451006L;
	private final String transtime;
	private String type;
	private String id;
	private String name;
	private String text;

	public TalkDTO(String id, String name, String text) {
		this.type = "talk";
		this.id = id;
		this.name = name;
		this.text = text;
		Date d = new Date(System.currentTimeMillis());
		SimpleDateFormat f = new SimpleDateFormat("HH:mm");
		this.transtime = f.format(d);
	}

	public String getType() {
		return this.type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getText() {
		return this.text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
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
