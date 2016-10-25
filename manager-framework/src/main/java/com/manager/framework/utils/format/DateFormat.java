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

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.apache.commons.lang3.StringUtils;

/**
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class DateFormat {

	public static final String DateFormatPattern = "yyyy-MM-dd";

	public static final String DefaultDateFormatPattern = "yyyy-MM-dd HH:mm:ss";

	public static final String DateFormatPatternStyle1 = "yyyyMMddHHmmss";

	public static final String DateFormatPatternStyle2 = "yyyyMMddHHmmssSSS";

	private DateFormat() {

	}

	public static final Date parseDate(String str) {
		if (StringUtils.isBlank(str))
			return null;
		try {
			return new SimpleDateFormat(DateFormatPattern).parse(str);
		} catch (ParseException e) {
		}
		return null;
	}

	public static final Date parseDefaultDate(String str) {
		if (StringUtils.isBlank(str))
			return null;
		try {
			return new SimpleDateFormat(DefaultDateFormatPattern).parse(str);
		} catch (ParseException e) {
		}
		return null;
	}

	public static final Date parseDateStyle1(String str) {
		if (StringUtils.isBlank(str))
			return null;
		try {
			return new SimpleDateFormat(DateFormatPatternStyle1).parse(str);
		} catch (ParseException e) {
		}
		return null;
	}

	/**
	 * 
	 * @since 1.0 
	 * @param date
	 * @param format
	 * @return
	 * <br><b>作者： @author LIUYUHUI</b>
	 * <br>创建时间：2016年10月25日 上午10:14:57
	 */
	public static String dateToString(Date date, String format) {
		SimpleDateFormat sdf = new SimpleDateFormat(format);
		String dateStr = sdf.format(date);
		return dateStr;
	}
}
