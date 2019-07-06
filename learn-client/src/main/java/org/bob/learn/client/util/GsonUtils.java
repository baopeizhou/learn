package org.bob.learn.client.util;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import lombok.extern.slf4j.Slf4j;

/**
 * Gson工具类
 */
@Slf4j
public final class GsonUtils {

    private static final Gson GSON;

    static{
        GSON = new GsonBuilder()
                .setDateFormat("yyyy-MM-dd HH:mm:ss")
                .create();
    }

    private GsonUtils() throws IllegalAccessException {
        throw new IllegalAccessException("非法访问GsonUtils私有构造函数");
    }

    /**
     * 获取Gson解析器
     * @return Gson
     */
    public static Gson gson(){
        return GSON;
    }

    /**
     * 对象转换为json
     * @param object 对象
     * @return json
     */
    public static String toJson(Object object) {
        return GSON.toJson(object);
    }

    /**
     * json转换为对象
     * @param json json
     * @param clazz 对象的类型实例
     * @param <T> 对象类型
     * @return 对象
     */
    public static<T> T fromJson(String json,Class<T> clazz) {
           return GSON.fromJson(json,clazz);
    }


}
