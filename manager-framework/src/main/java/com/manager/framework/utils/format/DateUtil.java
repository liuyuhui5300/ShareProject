/* @(#)
 *
 * Project:manager-framework
 *
 * Modify Information:
 * =============================================================================
 *   Author         Date           Description
 *   ------------ ---------- ---------------------------------------------------
 *   LIUYUHUI      2016年10月25日        first release
 *
 *
 */
package com.manager.framework.utils.format;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * <br>
 * 创建日期：2016年10月25日 <br>
 * <b>Copyright 2016 SHITOU All Rights Reserved</b>
 * 
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class DateUtil {

	/**
	 * 默认日期格式：yyyy-MM-dd
	 */
	public static final String DEFAULT_DATE_PATTERN = "yyyy-MM-dd";
	/**
	 * 默认日期格式：yyyy-MM-dd HH:mm
	 */
	public static final String DEFAULT_DATEFORMAT_PATTERN = "yyyy-MM-dd HH:mm";

	/**
	 * 默认时间格式：yyyy-MM-dd HH:mm:ss
	 */
	public static final String DEFAULT_DATETIME_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/**
	 * 默认时间戳格式，到毫秒 yyyy-MM-dd HH:mm:ss SSS
	 */
	public static final String DEFAULT_DATEDETAIL_PATTERN = "yyyy-MM-dd HH:mm:ss SSS";

	public static final String DEFAULT_DATEDETAIL_STR = "yyyy年MM月dd日";

	public static final String DEFAULT_DATEDETAIL_STR_TIME = "yyyy年MM月dd日 HH:mm:ss";

	/**
	 * 1天折算成毫秒数
	 */
	public static final long MILLIS_A_DAY = 24 * 3600 * 1000;

	private static Map<String, Object> parsers = new HashMap<String, Object>();

	private static SimpleDateFormat getDateParser(String pattern) {
		Object parser = parsers.get(pattern);
		if (parser == null) {
			parser = new SimpleDateFormat(pattern);
			parsers.put(pattern, parser);
		}
		return (SimpleDateFormat) parser;
	}

	/**
	 * 取得当前系统日期
	 *
	 * @return
	 */
	public static Date currentDate() {
		return new Date();
	}

	/**
	 * 取得当前系统时间
	 *
	 * @return
	 */
	public static long currentTimeMillis() {
		return System.currentTimeMillis();
	}

	/**
	 * 取得系统当前日期，返回默认日期格式的字符串。
	 *
	 * @param strFormat
	 * @return
	 */
	public static String nowDate(String strFormat) {
		Date date = new Date();
		return getDateParser(strFormat).format(date);
	}

	/**
	 * 取得当前系统时间戳
	 *
	 * @return
	 */
	public static Timestamp currentTimestamp() {
		return new Timestamp(new Date().getTime());
	}

	/**
	 * 将日期字符串转换为Date对象
	 *
	 * @param dateString
	 * @param pattern
	 *            日期格式
	 * @return
	 * @throws Exception
	 */
	public static Date toDate(String dateString, String pattern) throws Exception {
		return getDateParser(pattern).parse(dateString);
	}

	/**
	 * 将日期字符串转换为Date对象，使用默认日期格式
	 *
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static Date toDate(String dateString) throws Exception {
		return getDateParser(DEFAULT_DATE_PATTERN).parse(dateString);
	}

	/**
	 * 将时间字符串转换为Date对象
	 *
	 * @param dateString
	 * @return
	 * @throws Exception
	 */
	public static Date toDateTime(String dateString) throws Exception {
		return getDateParser(DEFAULT_DATETIME_PATTERN).parse(dateString);
	}

	/**
	 * 将Date对象转换为字符串
	 *
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String toDateString(Date date, String pattern) {
		if (date == null)
			return "";
		return getDateParser(pattern).format(date);
	}

	/**
	 * 将Date对象转换为字符串，使用默认日期格式
	 *
	 * @param date
	 * @return
	 */
	public static String toDateString(Date date) {
		return getDateParser(DEFAULT_DATE_PATTERN).format(date);
	}

	/**
	 * 将Date对象转换为时间字符串，使用默认日期格式
	 *
	 * @param date
	 * @return
	 */
	public static String toDateTimeString(Date date) {
		return getDateParser(DEFAULT_DATETIME_PATTERN).format(date);
	}

	/**
	 * 日期相减
	 *
	 * @param date
	 * @param day
	 * @return
	 */
	public static Date diffDate(Date date, int day) {
		Calendar c = Calendar.getInstance();
		c.setTimeInMillis(getMillis(date) - ((long) day) * MILLIS_A_DAY);
		return c.getTime();
	}

	/**
	 * 日期相加
	 *
	 * @param date
	 *            日期
	 * @param day
	 *            天数
	 * @return 返回相加后的日期
	 * @author doumingjun create 2007-04-07
	 */
	public static Date addDate(Date date, int day) {
		Calendar c = Calendar.getInstance();

		c.setTimeInMillis(getMillis(date) + ((long) day) * MILLIS_A_DAY);
		return c.getTime();
	}

	/**
	 * 返回毫秒
	 *
	 * @param date
	 *            日期
	 * @return 返回毫秒
	 * @author doumingjun create 2007-04-07
	 */
	public static long getMillis(Date date) {
		Calendar c = Calendar.getInstance();
		c.setTime(date);
		return c.getTimeInMillis();
	}

	/**
	 * 返回两时间段之间的日期列表
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 * @throws Exception
	 */
	public static List<String> getBetweenDate(String d1, String d2) throws Exception {
		List<Date> list = new ArrayList<Date>();
		List<String> dayList = new ArrayList<String>();
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		GregorianCalendar gc1 = new GregorianCalendar(), gc2 = new GregorianCalendar();
		gc1.setTime(sdf.parse(d1));
		gc2.setTime(sdf.parse(d2));
		do {
			GregorianCalendar gc3 = (GregorianCalendar) gc1.clone();
			list.add(gc3.getTime());
			gc1.add(Calendar.DAY_OF_MONTH, 1);
		} while (!gc1.after(gc2));

		for (Date date : list) {
			Calendar c = Calendar.getInstance();
			c.setTime(date);
			dayList.add(parseDateToStr(c.getTime(), DateUtil.DEFAULT_DATE_PATTERN));
		}
		return dayList;
	}

	/**
	 * 时间转成字符串
	 * 
	 * @param date
	 * @param pattern
	 * @return
	 */
	public static String parseDateToStr(Date date, String pattern) {
		java.text.DateFormat df = new SimpleDateFormat(pattern);
		return df.format(date);
	}

	/**
	 * 时间转成默认字符串
	 * 
	 * @param stringDate
	 * @return
	 * @throws ParseException
	 */
	public static Date parseStrToDate(String stringDate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		Date date = sdf.parse(stringDate);
		return date;
	}

	/**
	 * 日期转日历
	 *
	 * @param date
	 * @return Calendar
	 */
	public static Calendar DateToCalendar(Date date) {
		Calendar startdate = Calendar.getInstance();
		startdate.setTime(date);
		return startdate;
	}

	/**
	 * 日历转日期
	 *
	 * @param calendar
	 * @return Date
	 */
	public static Date CalendarToDate(Calendar calendar) {
		Date date = calendar.getTime();
		return date;
	}

	/**
	 * 计算相差 年、月、日、时、分、秒
	 *
	 * @author yzChen 2014-5-27 11:41:27
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static Map<Integer, Integer> dateCompare(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		return calendarCompare(c1, c2);
	}

	/**
	 * 计算两个时间相差天数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long dateCompareDay(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		long n1 = c1.getTimeInMillis();
		long n2 = c2.getTimeInMillis();
		return Math.abs((n1 - n2) / (1000 * 3600 * 24));
	}

	/**
	 * 计算两时间段之间的小时数
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long dateCompareHour(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		long n1 = c1.getTimeInMillis();
		long n2 = c2.getTimeInMillis();
		return Math.abs((n1 - n2) / (1000 * 3600));
	}

	/**
	 * 计算相差 年、月、日、时、分、秒
	 *
	 * @param c1
	 * @param c2
	 * @return
	 */
	public static Map<Integer, Integer> calendarCompare(Calendar c1, Calendar c2) {
		Map<Integer, Integer> ret = new HashMap<Integer, Integer>();
		int year = c1.get(Calendar.YEAR) - c2.get(Calendar.YEAR);
		int month = c1.get(Calendar.MONTH) - c2.get(Calendar.MONTH);
		int day = c1.get(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH);
		System.out.println(c1.get(Calendar.HOUR_OF_DAY));
		int hour = c1.get(Calendar.HOUR_OF_DAY) - c2.get(Calendar.HOUR_OF_DAY);
		int min = c1.get(Calendar.MINUTE) - c2.get(Calendar.MINUTE);
		int second = c1.get(Calendar.SECOND) - c2.get(Calendar.SECOND);
		if (month < 0 && year > 0) {
			year--;
			month += 12;
		}
		if (day < 0 && month > 0) {
			month--;
			day = c2.getActualMaximum(Calendar.DAY_OF_MONTH) - c2.get(Calendar.DAY_OF_MONTH)
					+ c1.get(Calendar.DAY_OF_MONTH);
		}
		if (hour < 0 && day > 0) {
			day--;
			hour += 24;
		}
		if (min < 0 && hour > 0) {
			hour--;
			min += 60;
		}
		if (second < 0 && min > 0) {
			min--;
			second += 60;
		}
		ret.put(Calendar.YEAR, year);
		ret.put(Calendar.MONTH, month);
		ret.put(Calendar.DATE, day);
		ret.put(Calendar.HOUR, hour);
		ret.put(Calendar.MINUTE, min);
		ret.put(Calendar.SECOND, second);
		return ret;
	}

	/**
	 * 计算两个日期之间相差的天数
	 * 
	 * @param smdate
	 *            较小的时间
	 * @param bdate
	 *            较大的时间
	 * @return 相差天数
	 * @throws ParseException
	 */
	public static int daysBetween(Date smdate, Date bdate) throws ParseException {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		smdate = sdf.parse(sdf.format(smdate));
		bdate = sdf.parse(sdf.format(bdate));
		Calendar cal = Calendar.getInstance();
		cal.setTime(smdate);
		long time1 = cal.getTimeInMillis();
		cal.setTime(bdate);
		long time2 = cal.getTimeInMillis();
		long between_days = (time2 - time1) / (1000 * 3600 * 24);

		return Integer.parseInt(String.valueOf(between_days));
	}

	/**
	 * 计算某天的最早时间
	 * 
	 * @author ruanjiamin
	 */
	public static Date dateStart(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.set(Calendar.MILLISECOND, 0);
		Date startTime = calendar.getTime();
		return startTime;
	}

	/**
	 * 计算某天的最迟时间
	 * 
	 * @author ruanjiamin
	 */
	public static Date dateEnd(Date date) {
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.set(Calendar.HOUR_OF_DAY, 0);
		calendar.set(Calendar.MINUTE, 0);
		calendar.set(Calendar.SECOND, 0);
		calendar.add(Calendar.DAY_OF_MONTH, 1);
		calendar.add(Calendar.SECOND, -1);
		Date endTime = calendar.getTime();
		return endTime;
	}

	/**
	 * 计算两时间段的差值
	 * 
	 * @param d1
	 * @param d2
	 * @return
	 */
	public static long dateDifferential(Date d1, Date d2) {
		Calendar c1 = Calendar.getInstance();
		c1.setTime(d1);
		Calendar c2 = Calendar.getInstance();
		c2.setTime(d2);
		long n1 = c1.getTimeInMillis();
		long n2 = c2.getTimeInMillis();
		return n1 - n2;
	}

	/**
	 * 根据生日判断是否18岁
	 * 
	 * @author ruanjm
	 */
	public static boolean dateYearCalendar(Date birthday) {
		Date date = new Date();
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		calendar.add(Calendar.YEAR, -18);
		Date time = calendar.getTime();

		if (birthday.getTime() > time.getTime())
			return false;
		return true;
	}
}
