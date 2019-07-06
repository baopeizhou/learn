package org.bob.learn.client.util;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.io.IOException;

/**
 * Jackson工具类
 */
@Slf4j
public final class JacksonUtils {

    private final static ObjectMapper OBJECT_MAPPER = SpringContextUtils.getBean(ObjectMapper.class);

    private final static String EXCEPTION_OBJECT_TO_STRING_DESC = "Jackson 对象转字符串异常:{}";

    private final static String EXCEPTION_STRING_TO_OBJECT_DESC = "Jackson 字符串转对象异常:{}";

    private JacksonUtils() throws IllegalAccessException {
        throw new IllegalAccessException("禁止访问JacksonUtils私有构造方法");
    }

    /**
     *  Object To Json
     * @param t
     * @param <T>
     * @return
     */
    public static <T> String toJson(T t) {
        String s = null;
        if (t != null) {
            try{
                s = OBJECT_MAPPER.writeValueAsString(t);
            } catch (JsonProcessingException e) {
                log.error(EXCEPTION_OBJECT_TO_STRING_DESC,e.toString());
                s = null;
            }
        }
        return s;
    }

    /**
     * Json To Bean
     * @param s
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fromJson(String s, Class<T> clazz){
        T t = null;
        if (StringUtils.isNoneBlank(s)) {
            try {
                t = OBJECT_MAPPER.readValue(s, clazz);
            }catch (IOException e) {
                log.error(EXCEPTION_STRING_TO_OBJECT_DESC,e.toString());
            }
        }
        return  t;
    }

}
