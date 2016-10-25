package com.manager.bean;

import org.apache.commons.lang3.SerializationException;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;

/**  
* <pre>
* 类描述： 
* 创建人：仲李  
* 联系方式：oathleo@gmail.com  18516152819
* 创建时间：2015年3月25日 上午9:33:00 
* @version 
*  </pre>
*/
public class MsgpackRedisSerializer<V> {
  
    private final JavaType      javaType;

    private ObjectMapper        objectMapper    = new ObjectMapper();

    static boolean isEmpty(byte[] data) {
        return (data == null || data.length == 0);
    }
    
    public MsgpackRedisSerializer(Class<V> type) {
        this.javaType = TypeFactory.defaultInstance().constructType(type);
    }
 
    public byte[] serialize(V t) throws SerializationException {
        try {
            return objectMapper.writeValueAsBytes(t);
        } catch (JsonProcessingException ex) {
            throw new SerializationException("Could not write msgpack: " + ex.getMessage(), ex);
        }
    }
 
    public V deserialize(byte[] bytes) throws SerializationException {
        if (isEmpty(bytes)) {
            return null;
        }
        try {
            return (V) this.objectMapper.readValue(bytes, 0, bytes.length, javaType);
        } catch (Exception ex) {
            throw new SerializationException("Could not read msgpack: " + ex.getMessage(), ex);
        }
    }

}
