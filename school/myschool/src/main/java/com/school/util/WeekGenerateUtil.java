package com.school.util;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @Title: WeekGenerateUtil.java
 * @Package com.topview.school.util
 * @Description: TODO
 * @author Sherlock-lee
 * @date 2015年4月30日 上午7:12:20
 * @version V1.0
 */
public class WeekGenerateUtil {
	/**
	 * @ClassName: WeekGenerateUtil
	 * @Description: TODO
	 * @author Sherlock-lee
	 * @date 2015年4月30日 上午7:12:20
	 */
	private Date begin = null;
	private Date end = null;
	private int week = 0;

	public Date getBegin() {
		return begin;
	}

	public void setBegin(Date begin) {
		this.begin = begin;
	}

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public int getWeek() {
		return week;
	}

	public void setWeek(int week) {
		this.week = week;
	}

	/**
	 * @throws ParseException
	 * 
	 * @Title: calculate
	 * @Description: TODO
	 * @param @return
	 * @return int
	 * @throws
	 */
	public int calculate(Date now) throws ParseException {

		
		if(now.compareTo(end) > 0){
			return -1;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Calendar c1 = Calendar.getInstance();
		c1.setTime(sdf.parse(sdf.format(begin)));
		int begin_week = c1.get(Calendar.WEEK_OF_YEAR);

		Calendar c2 = Calendar.getInstance();
		c2.setTime(sdf.parse(sdf.format(now)));
		int now_week = c2.get(Calendar.WEEK_OF_YEAR);

		Calendar c3 = Calendar.getInstance();
		c3.set(c1.get(Calendar.YEAR), 12, 31);
		int ee_week = c3.get(Calendar.WEEK_OF_YEAR);

		if (c2.get(Calendar.YEAR) > c1.get(Calendar.YEAR)) {

			return ee_week - begin_week + now_week;
		} else {
			return now_week - begin_week;
		}

	}

}
