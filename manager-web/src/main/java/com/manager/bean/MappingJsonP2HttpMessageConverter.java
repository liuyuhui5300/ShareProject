package com.manager.bean;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * 
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class MappingJsonP2HttpMessageConverter extends MappingJackson2HttpMessageConverter {

//	@Override
//	protected void writePrefix(JsonGenerator generator, Object object) throws IOException {
//		generator.writeRaw("callback(");
//	}
//
//	@Override
//	protected void writeSuffix(JsonGenerator generator, Object object) throws IOException {
//		generator.writeRaw(");");
//	}
}
