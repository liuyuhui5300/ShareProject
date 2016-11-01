package com.manager.framework.web.converter;

import org.apache.commons.lang3.StringUtils;
import org.springframework.core.convert.converter.Converter;

/**
 * 类描述: <br>
 * 创建时间: 2016年3月23日 下午4:16:16 <br>
 * 
 * @author 仲李
 * @version
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
