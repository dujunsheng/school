package com.school.util;

import java.util.Calendar;
import java.util.Date;

/**
 *  获取时间
* @author  作者  chenbowei E-mail:bowei_chan@163.com
* @date 创建时间：Aug 12, 2016 10:42:34 PM 
* @version 1.0
 */
public class DateUtil {
    
    /*
     * 获取几天前的日期
     */
    public static Date getLasetestDate(int offset) {
	Calendar c = Calendar.getInstance();
	c.add(Calendar.DATE, -offset);
	return c.getTime();
    }
}
