package com.manager.framework.web.converter;

import java.awt.Color;

import org.springframework.core.convert.converter.Converter;

/**
 * 
 * <br>创建日期：2016年11月2日
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class StringToColorConverter implements Converter<String, Color> {

	// 0x0000FF BLUE
	@Override
	public Color convert(String source) {
		source = source.substring(4);
		return new Color(Integer.parseInt(source, 16));
	}

}
