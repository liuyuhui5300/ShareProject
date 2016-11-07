package com.manager.framework.web.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 
 * <br>创建日期：2016年11月2日
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class StringToBooleanConverter implements Converter<String, Boolean> {

	@Override
	public Boolean convert(String source) {
		if (StringUtils.isBlank(source))
			return Boolean.FALSE;
		if ("T".equals(source)) {
			return Boolean.TRUE;
		} else {
			return Boolean.FALSE;
		}

	}

}
