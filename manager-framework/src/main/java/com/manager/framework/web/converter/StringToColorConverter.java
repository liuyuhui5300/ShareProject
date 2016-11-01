package com.manager.framework.web.converter;

import java.awt.Color;

import org.springframework.core.convert.converter.Converter;

/**
 * 类描述: <br>
 * 创建时间: 2016年3月23日 下午4:40:28 <br>
 * 
 * @author 仲李
 * @version
 */
public class StringToColorConverter implements Converter<String, Color> {

	// 0x0000FF BLUE
	@Override
	public Color convert(String source) {
		source = source.substring(4);
		return new Color(Integer.parseInt(source, 16));
	}

}
