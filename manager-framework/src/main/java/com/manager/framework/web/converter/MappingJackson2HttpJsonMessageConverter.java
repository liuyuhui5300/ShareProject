package com.manager.framework.web.converter;

import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpOutputMessage;
import org.springframework.http.MediaType;
import org.springframework.http.converter.AbstractHttpMessageConverter;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.http.converter.HttpMessageNotWritableException;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.context.WebApplicationContext;

import com.manager.framework.utils.encoding.Json;

/**
 * 类描述: 加密并json化 response </br>
 * 创建时间: 2015年12月3日 下午2:31:34 </br>
 * 
 * @author 李恒
 * @version
 */
public class MappingJackson2HttpJsonMessageConverter /*extends AbstractHttpMessageConverter<Object>*/ {
    /*public static final Logger LOG = LoggerFactory.getLogger(MappingJackson2HttpJsonMessageConverter.class);

    private static final String DATA = "data";
    // 是否开启密文
    private boolean isSafe = false;
    // 是否开启密文
    private String aesKey = null;

    private static String IS_SAFE_KEY = "${data.is.safe}";

    private static String AES_KEY = "${aes.key}";

    // 自定义媒体类型
    public MappingJackson2HttpJsonMessageConverter() {
        super(new MediaType("application", "json", Charset.forName("UTF-8")));
        WebApplicationContext webApplicationContext = ContextLoader.getCurrentWebApplicationContext();
        PropertyContext propertyContext = webApplicationContext.getBean("propertyContext", PropertyContext.class);
        if (propertyContext != null && aesKey == null) {
            String isSafe = propertyContext.getPropertiesValue(IS_SAFE_KEY);
            if (isSafe != null) {
                this.isSafe = Boolean.parseBoolean(isSafe);
            }
            this.aesKey = propertyContext.getPropertiesValue(AES_KEY);
            LOG.debug("isSafe:{},aesKey:{}", isSafe, aesKey);

        }
    }

    @Override
    protected boolean supports(Class<?> clazz) {
        return true;
    }

    @Override
    protected Object readInternal(Class<?> clazz, HttpInputMessage inputMessage) throws IOException, HttpMessageNotReadableException {
        return null;
    }

    @Override
    protected void writeInternal(Object d, HttpOutputMessage outputMessage) throws IOException, HttpMessageNotWritableException {
        BasicRes r = new BasicRes();
        String json = Json.ToJson(d);
        LOG.debug("reponse :{}", json);
        if (isSafe) {
            try {
                json = AESPlus.encrypt(json, aesKey);
                r.setData(json);
            } catch (Exception e) {
                LOG.error("加密数据失败，json={},key={}", json, aesKey, e);
                throw new RuntimeException("加密数据失败");
            }
        } else {
            r.setData(d);
        }
        byte[] jsonBytes = Json.ToJsonAsBytes(r);

        OutputStream out = outputMessage.getBody();
        out.write(jsonBytes, 0, jsonBytes.length);
        out.close();
    }*/

}
