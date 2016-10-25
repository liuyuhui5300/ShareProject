package com.manager.bean;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * 
 * <br>创建日期：2016年10月25日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
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
