package com.datasource.server.common.utils;


import lombok.ToString;

@ToString
public class Result {

	/**
	 * 响应信息
	 */
	private String message = ResultEnum.SUCCESS.getMessage();

	/**
	 * 响应代码
	 */
	private int resCode = ResultEnum.SUCCESS.getCode();

	/**
	 * 响应数据
	 */
	private Object data;

	/**
	 * 总数
	 */
	private Integer total;

	public Result() {
	}

	public Result(Object data) {
		this.data = data;
	}

	public Result(String message, int resCode) {
		this.message = message;
		this.resCode = resCode;
	}

	public Result(String message, int resCode, Object data) {
		this.message = message;
		this.resCode = resCode;
		this.data = data;
	}

	public Result(String message, int resCode, Integer total, Object data) {
		this.message = message;
		this.resCode = resCode;
		this.data = data;
		this.total = total;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public int getResCode() {
		return resCode;
	}

	public void setResCode(int resCode) {
		this.resCode = resCode;
	}

	public Object getData() {
		return data;
	}

	public void setData(Object data) {
		this.data = data;
	}

	public Integer getTotal() {
		return total;
	}

	public void setTotal(Integer total) {
		this.total = total;
	}
}
