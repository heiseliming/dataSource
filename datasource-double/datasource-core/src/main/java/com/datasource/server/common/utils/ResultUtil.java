package com.datasource.server.common.utils;

import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;

/**
 * @author ahuxh
 */
@Slf4j
public class ResultUtil {

	/**
	 * 设置返回数据
	 * @param data
	 * @return
	 */
	public static Result setData(Object data) {
		log.debug("响应数据：{}", JSONObject.toJSON(data));
		return new Result(data);
	}

	/**
	 * setData:设置响应码和响应信息；
	 * @param code
	 * @param message
	 * @return
	 * Result
	 */
	public static Result setData(String message, int code) {
		log.debug("响应码：{} 响应信息：{}", code, message);
		return new Result(message, code);
	}

	/**
	 * 设置返回数据
	 * @param data
	 * @return
	 */
	public static Result setData(ResultEnum data) {
		log.debug("响应数据：{}:{}", data.getCode(), data.getMessage());
		return new Result(data.getMessage(),data.getCode());
	}

	public static Result success() {
		return success(null);
	}

	/**
	 * 成功
	 */
	public static Result success(Object data){
		return new Result("请求成功",200,data);
	}

	/**
	 * 成功
	 */
	public static Result success(Integer total, Object data){
		return new Result("请求成功",200, total, data);
	}

	/**
	 * 失败
	 */
	public static Result fail(String message){
		return new Result("请求失败", 400,message);
	}

}
