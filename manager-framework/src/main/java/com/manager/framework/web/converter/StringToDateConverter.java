package com.manager.framework.web.converter;

import java.util.Date;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

import com.manager.framework.utils.format.DateFormat;

/**
 * 类描述: <br>
 * 创建时间: 2016年3月23日 下午4:01:14 <br>
 * 
 * @author 仲李
 * @version
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
