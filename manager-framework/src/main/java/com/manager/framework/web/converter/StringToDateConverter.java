package com.manager.framework.web.converter;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.manager.framework.utils.format.DateFormat;

/**
 * 
 * <br>创建日期：2016年11月2日
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class StringToDateConverter implements Converter<String, Date> {

	@Override
	public Date convert(String source) {
		if (StringUtils.isBlank(source))
			return null;
		int length = source.length();
		switch (length) {
		case 10:
			return DateFormat.parseDate(source);
		case 19:
			return DateFormat.parseDefaultDate(source);
		default:
			throw new RuntimeException("Unsupport Date Format: " + source);
		}
	}

}
