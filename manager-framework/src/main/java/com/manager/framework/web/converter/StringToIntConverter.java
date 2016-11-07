package com.manager.framework.web.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * <br>创建日期：2016年11月2日
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class StringToIntConverter implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		return new Integer(source);
	}

	

}
