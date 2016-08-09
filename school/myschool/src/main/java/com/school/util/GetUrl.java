/**
 * 
 */
package com.school.util;

import javax.servlet.http.HttpServletRequest;

/**
 * @author c116
 * 负责获取当前url
 *
 */
public class GetUrl {

	public static String getUrl(HttpServletRequest req){
		String url = req.getRequestURI() + "?" + req.getQueryString();
		int index = url.lastIndexOf("&pc=");
		if(index != -1){
			url = url.substring(0, index);
		}
		return url;
	} 
}
