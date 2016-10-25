package com.manager.bean;

import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;

/**
 * <pre>
 * 类描述： 
 * 创建人：仲李  
 * 联系方式：oathleo@gmail.com  18516152819
 * 创建时间：2015年3月11日 下午4:22:13 
 * @version
 * </pre>
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
