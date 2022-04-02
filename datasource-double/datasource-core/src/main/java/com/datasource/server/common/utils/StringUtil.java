package com.datasource.server.common.utils;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtil {

	private static final Pattern CHINESE_PATTERN = Pattern.compile("[\u4e00-\u9fa5]");

	/**
	 * 
	 * isNotEmpty:判断字符串不能为空
	 * 
	 * @param args 要检查的字符串参数
	 * @return
	 * 		boolean
	 */
	public static boolean isNotEmpty(String args) {
		if (args != null && args != "" && args.trim().length() > 0) {
			return true;
		}
		return false;
	}

	/**
	 * 
	 * isAllNotEmpty:判断所有传入参数都不能为空
	 * @param args 要判断的参数数组
	 * @return 
	 * boolean
	 */
	public static boolean isAllNotEmpty(String... args) {
		boolean check = true;
		if (args != null) {
			for (String arg : args) {
				if (arg == null || arg == "" || arg.trim().length() <= 0) {
					check = false;
					return false;
				}
			}
		}
		return check;
	}

	/**
	 * 
	 * isEmpty:判断字符串为空
	 * @param args 要判断的字符串
	 * @return 
	 * boolean
	 */
	public static boolean isEmpty(String args) {
		if (args != null && args != "" && args.trim().length() > 0) {
			return false;
		}
		return true;
	}


	/**
	 * 判断是否包含中文
	 *
	 * @param value 内容
	 * @return 结果
	 */
	public static boolean containChinese(String value) {
		if (StringUtils.isBlank(value)) {
			return false;
		}
		Matcher matcher = CHINESE_PATTERN.matcher(value);
		return matcher.find();
	}
	 

}
