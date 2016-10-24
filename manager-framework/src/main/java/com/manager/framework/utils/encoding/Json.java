/* @(#)
 *
 * Project:manager-framework
 *
 * Modify Information:
 * =============================================================================
 *   Author         Date           Description
 *   ------------ ---------- ---------------------------------------------------
 *   LIUYUHUI      2016年10月24日        first release
 *
 *
 */
package com.manager.framework.utils.encoding;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * <br>创建日期：2016年10月24日
 * <br><b>Copyright 2016 SHITOU All Rights Reserved</b>
 * @author LIUYUHUI
 * @since 1.0
 * @version 1.0
 */
public class Json {

	public static final Logger LOG = LoggerFactory.getLogger(Json.class);

    public static final ObjectMapper writeMapper = new ObjectMapper();

    public static final ObjectMapper readMapper = new ObjectMapper();

    static {
        writeMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        writeMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        writeMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);

        readMapper.setSerializationInclusion(JsonInclude.Include.NON_NULL);
        readMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        readMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
    }

    public static String ToJson(Object value) {
        try {
            return writeMapper.writeValueAsString(value);
        } catch (Exception e) {
            LOG.error("ToJosn error,Object:{}", value, e);
        }
        return "";
    }

    public static byte[] ToJsonAsBytes(Object value) {
        try {
            return writeMapper.writeValueAsBytes(value);
        } catch (Exception e) {
            LOG.error("ToJsonAsBytes error,Object:{}", value, e);
            return null;
        }
    }

    public static <T> T ToObject(String content, Class<T> valueType) {
        try {
            return readMapper.readValue(content, valueType);
        } catch (Exception e) {
            LOG.error("ToObject error,content:{}", content, e);
            return null;
        }
    }
}
