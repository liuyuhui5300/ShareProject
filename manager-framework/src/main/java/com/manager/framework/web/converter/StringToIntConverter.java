package com.manager.framework.web.converter;

import org.springframework.core.convert.converter.Converter;

/**
 * 类描述: <br>
 * 创建时间: 2016年3月23日 下午4:30:18 <br>
 * 
 * @author 仲李
 * @version
 */
public class StringToIntConverter implements Converter<String, Integer> {

	@Override
	public Integer convert(String source) {
		return new Integer(source);
	}

	

}
