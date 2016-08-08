package com.school.util;

/**
 * @Description 字符串判空工具类
 * @Author <wuyiliang 757210697@qq.com>
 * @Date 2015年9月3日 上午10:40:20
 * @CopyRight 2015 TopView Inc
 * @version V1.0
 */
public class NotEmptyString {

	/**
	 * 至少有一个参数不为空则返回true
	 * 
	 * @param values
	 * @return
	 */
	public static boolean isAtLeastOneNotEmpty(String[] values) {
		for(int i = 0; i < values.length; i++) {
			if(values[i] != null && !"".equals(values[i])) {
				return true;
			}
		}
		return false;
	}
	
	/**
	 * 当所有参数都不为空才返回true
	 * @param values
	 * @return
	 */
	public static boolean isNotEmpty(String[] values) {
		for(String value : values) {
			if(null == value || "".equals(value))
				return false;
		}
		return true;
	}
	
	/**
	 * 当所有对象都不为空才返回true
	 * @param objects
	 * @return
	 */
	public static boolean isNotNull(Object... objects) {
		for(Object value : objects) {
			if(null == value)
				return false;
		}
		return true;
	}
	
	/**
	 * 参数不为空则返回true
	 * @param value
	 * @return
	 */
	public static boolean isNotNullString(String value) {
		if(null == value || "".equals(value)) {
			return false;
		} else {
			return true;
		}
	}
}
