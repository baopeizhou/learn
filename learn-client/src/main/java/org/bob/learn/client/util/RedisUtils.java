package org.bob.learn.client.util;

import lombok.extern.slf4j.Slf4j;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;

import java.util.Date;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Redis工具类
 */
@Slf4j
public final class RedisUtils {

    private static RedisTemplate<String,Object> redisTemplate = SpringContextUtils.getBean(RedisTemplate.class);

    /**
     * 私有构造器
     * 禁止通过反射构造类实例
     * @throws IllegalAccessException 非法访问异常
     */
    private RedisUtils() throws IllegalAccessException {
        throw new IllegalAccessException("禁止访问RedisUtils私有构造方法");
    }

    public static RedisTemplate<String, Object> getRedisTemplate() {
        return redisTemplate;
    }

    /************************************ key 相关的工具方法 ********************************************/
    /**
     * 判断key是否存在
     * @param key
     * @return
     */
    public static boolean exists(String key){

        return redisTemplate.hasKey(key);
    }

    /**
     * 获取符合指定模式的key
     * @param pattern
     * @return
     */
    public static Set<String> keys(String pattern){
        return redisTemplate.keys(pattern);
    }

    /**
     * 设置key的过期时间
     * @param key
     * @param timeout
     * @param timeUnit
     * @return
     */
    public static Boolean expire(String key,long timeout,TimeUnit timeUnit){
       return redisTemplate.expire(key,timeout,timeUnit);
    }

    /**
     * 设置key的过期时间
     * @param key
     * @param date
     * @return
     */
    public static Boolean expireAt(String key, Date date){
        return redisTemplate.expireAt(key,date);
    }

    /**
     * 获取key对应value的类型
     * @param key
     * @return
     */
    public static DataType type(String key){
        return redisTemplate.type(key);
    }


   /****************************** value操作工具方法 ******************************************************/


   public static void set(String key,Object value){
       redisTemplate.opsForValue().set(key, value);
   }

    public static void set(String key, Object value, long timeout, TimeUnit timeUnit){
        redisTemplate.opsForValue().set(key, value,timeout,timeUnit);
    }


    public static String get(String key){
        Object value= redisTemplate.opsForValue().get(key);
        return null!=value?(String)(value):null;
    }

    public static <T> T get(String key, Class<T> clazz){
        Object value= redisTemplate.opsForValue().get(key);
        return null!=value?(T)value:null;
    }

    /***************************** set 操作工具方法 ****************************************/

    /**
     * 向集合添加元素
     * @param key     集合对应的key
     * @param value   待添加的元素
     * @return        实际添加数量
     */
    public static Long sAdd(String key, Object...value){
      return redisTemplate.opsForSet().add(key,value);
    }

    /**
     * 从集合删除元素
     * @param key     集合对应的key
     * @param value   待删除的元素
     * @return        实际删除数量
     */
    public static Long sRem(String key, Object... value){
        return redisTemplate.opsForSet().remove(key,value);
    }


    /**
     * 判断某一元素是否在集合中
     * @param key    集合对应的key
     * @param value  集合对应的值
     * @return       结果标识
     */
    public static Boolean sIsMember(String key,Object value){
        return redisTemplate.opsForSet().isMember(key,value);
    }


    /**
     * 获取某一集合的所有原色
     * @param key     集合对应的key
     * @param clazz   集合元素的类型
     * @param <T>
     * @return
     */
    public static <T> Set<T> sMembers(String key, Class<T> clazz){
        return (Set<T>)redisTemplate.opsForSet().members(key);
    }


}
