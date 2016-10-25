package com.manager.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <pre>
 * 类描述： 
 * 创建人：仲李  
 * 联系方式：oathleo@gmail.com  18516152819
 * 创建时间：2015年3月16日 下午7:38:03 
 * @version
 * </pre>
 */
public class JacksonObjectMapper extends ObjectMapper {

	public JacksonObjectMapper() {
		super();
		// // 允许单引号
		// this.configure(JsonParser.Feature.ALLOW_SINGLE_QUOTES, true);
		// // 字段和值都加引号
		// this.configure(JsonParser.Feature.ALLOW_UNQUOTED_FIELD_NAMES, true);
		// // 数字也加引号
		// this.configure(JsonGenerator.Feature.WRITE_NUMBERS_AS_STRINGS, true);
		// this.configure(JsonGenerator.Feature.QUOTE_NON_NUMERIC_NUMBERS,
		// true);

		// 空值不传递
		setSerializationInclusion(JsonInclude.Include.NON_NULL);
	}
}
