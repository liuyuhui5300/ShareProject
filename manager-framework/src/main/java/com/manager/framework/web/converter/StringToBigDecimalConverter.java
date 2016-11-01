package com.manager.framework.web.converter;

import java.math.BigDecimal;

import org.springframework.core.convert.converter.Converter;

/**
 * 类描述:                  <br>
 * 创建时间: 2016年3月23日 下午4:37:09 <br>
 * 
 * @author 仲李
 * @version 
 */
public class StringToBigDecimalConverter implements Converter<String, BigDecimal> {

	@Override
	public BigDecimal convert(String source) {
		return new BigDecimal(source);
	}

}
