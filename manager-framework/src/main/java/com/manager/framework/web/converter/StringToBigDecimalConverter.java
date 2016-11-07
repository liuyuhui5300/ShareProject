package com.manager.framework.web.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * <br>创建日期：2016年11月2日
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class StringToBigDecimalConverter implements Converter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String source) {
		return new BigDecimal(source);
	}

}
