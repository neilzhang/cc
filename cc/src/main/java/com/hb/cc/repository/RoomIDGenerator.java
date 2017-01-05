package com.hb.cc.repository;

import java.util.concurrent.atomic.AtomicInteger;

public class RoomIDGenerator {
	private static AtomicInteger seed = new AtomicInteger(100000);

	private RoomIDGenerator() {

	}

	public static String get() {
		return String.valueOf(seed.getAndIncrement());
	}

}
