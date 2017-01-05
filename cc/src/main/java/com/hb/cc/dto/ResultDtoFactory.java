package com.hb.cc.dto;

/**
 * Class Name: ResultDtoFactory Description: TODO
 * 
 * @author SC
 *
 */
public final class ResultDtoFactory {

	private ResultDtoFactory() {

	};

	public static <T> ResultDto<T> toAck(String msg) {
		return toAck(msg, null);
	}

	public static <T> ResultDto<T> toAck(String msg, T data) {
		ResultDto<T> dto = new ResultDto<T>();
		dto.setCode(ResultCode.ACK);
		dto.setMessage(msg);
		dto.setData(data);
		return dto;
	}

	public static <T> ResultDto<T> toNack(String msg) {
		return toNack(msg, null);
	}

	public static <T> ResultDto<T> toNack(String msg, T data) {
		ResultDto<T> dto = new ResultDto<T>();
		dto.setCode(ResultCode.NACK);
		dto.setMessage(msg);
		dto.setData(data);
		return dto;
	}

}
