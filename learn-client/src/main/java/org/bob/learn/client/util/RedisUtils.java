package org.bob.learn.client.util;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.connection.DataType;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * Redis工具类
 */
@Slf4j
public final class RedisUtils {

    private static StringRedisTemplate redisTemplate;

    /**
     * 私有构造器
     * 禁止通过反射构造类实例
     * @throws IllegalAccessException 非法访问异常
     */
    private RedisUtils() throws IllegalAccessException {
        throw new IllegalAccessException("禁止访问RedisUtils私有构造方法");
    }

    /**
     * Redis底层对象
     */
    @Component
    final static class Redis {
        Redis(@Autowired StringRedisTemplate redisTemplate){
            RedisUtils.redisTemplate = redisTemplate;
        }
    }

    /**
     * 获取Redis模板
     * @return Redis模板
     */
    public static RedisTemplate getRedisTemplate() {
        return redisTemplate;
    }

    /************************************ key 相关的工具方法 ********************************************/
    /**
     * @see RedisTemplate#hasKey(Object)
     */
    public static boolean exists(String key){
        Boolean hasKey = redisTemplate.hasKey(key);
        return hasKey!=null?hasKey:false;
    }

    /**
     * @see RedisTemplate#getExpire(Object)
     */
    public static long ttl(String key){
        Long timeToLive = redisTemplate.getExpire(key);
        return timeToLive!=null?timeToLive:0L;
    }

    /**
     * @see RedisTemplate#getExpire(Object, TimeUnit)
     */
    public static long ttl(String key,TimeUnit timeUnit){
        Long timeToLive = redisTemplate.getExpire(key,timeUnit);
        return timeToLive!=null?timeToLive:0L;
    }

    /**
     * @see RedisTemplate#keys(Object)
     */
    public static Set<String> keys(String pattern){
        return redisTemplate.keys(pattern);
    }

    /**
     * @see RedisTemplate#expire(Object, long, TimeUnit)
     */
    public static boolean expire(String key, long timeout, TimeUnit timeUnit){
       Boolean expire =  redisTemplate.expire(key,timeout,timeUnit);
       return expire!=null?expire:false;
    }

    /**
     * @see RedisTemplate#expireAt(Object, Date)
     */
    public static boolean expireAt(String key, Date date){
        Boolean expireAt =  redisTemplate.expireAt(key,date);
        return expireAt!=null?expireAt:false;
    }

    /**
     * @see RedisTemplate#type(Object)
     */
    public static DataType type(String key){
        return redisTemplate.type(key);
    }

    /**
     * @see RedisTemplate#delete(Object)
     */
    public static boolean del(String key){
        Boolean delete = redisTemplate.delete(key);
        return delete!=null?delete:false;
    }


   /****************************** value操作工具方法 ******************************************************/

    /**
     * @see org.springframework.data.redis.core.ValueOperations#set(Object, Object)
     */
   public static void set(String key, String value){
       redisTemplate.opsForValue().set(key, value);
   }

    /**
     * @see RedisUtils#set(String, String, long, TimeUnit)
     */
    public static void set(String key, String value, long timeout){
        set(key,value,timeout,TimeUnit.SECONDS);
    }

    /**
     * @see org.springframework.data.redis.core.ValueOperations#set(Object, Object, long, TimeUnit)
     */
   public static void set(String key, String value, long timeout, TimeUnit timeUnit){

    }

    /**
     * @see org.springframework.data.redis.core.ValueOperations#setIfPresent(Object, Object)
     */
    public static void setex(String key, String value){
        redisTemplate.opsForValue().setIfPresent(key, value);
    }

    /**
     * @see RedisUtils#setex(String, String, long, TimeUnit)
     */
    public static void setex(String key, String value, long timeout){
        setex(key, value,timeout,TimeUnit.SECONDS);
    }

    /**
     * @see org.springframework.data.redis.core.ValueOperations#setIfPresent(Object, Object, long, TimeUnit)
     */
    public static void setex(String key, String value, long timeout, TimeUnit timeUnit){
        redisTemplate.opsForValue().setIfPresent(key, value,timeout,timeUnit);
    }

    /**
     * @see org.springframework.data.redis.core.ValueOperations#setIfAbsent(Object, Object)
     */
    public static void setnx(String key, String value){
        redisTemplate.opsForValue().set(key, value);
    }

    /**
     * @see RedisUtils#setnx(String, String, long, TimeUnit)
     */
    public static void setnx(String key, String value, long timeout){
        setnx(key, value,timeout,TimeUnit.SECONDS);
    }

    /**
     * @see org.springframework.data.redis.core.ValueOperations#setIfAbsent(Object, Object, long, TimeUnit)
     */
    public static void setnx(String key, String value, long timeout, TimeUnit timeUnit){
        redisTemplate.opsForValue().setIfAbsent(key, value,timeout,timeUnit);
    }

    /**
     * @see org.springframework.data.redis.core.ValueOperations#get(Object)
     */
    public static String get(String key){
        return o2s(redisTemplate.opsForValue().get(key));
    }

    /***************************** set 操作工具方法 ****************************************/

    /**
     * @see org.springframework.data.redis.core.SetOperations#add(Object, Object[])
     */
    public static long sadd(String key, String...value){
      Long addNum = redisTemplate.opsForSet() .add(key,value);
      return addNum!=null?addNum:0L;
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#remove(Object, Object...)
     */
    public static long srem(String key, Object... value){
        Long removeNum = redisTemplate.opsForSet().remove(key,value);
        return removeNum!=null?removeNum:0L;
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#isMember(Object, Object)
     */
    public static boolean sismember(String key, Object value){
        Boolean isMember = redisTemplate.opsForSet().isMember(key,value);
        return isMember!=null?isMember:false;
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#members(Object)
     */
    public static Set<String> smembers(String key){
        return redisTemplate.opsForSet().members(key);
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#members(Object)
     */
    public static long scard(String key){
        Long size = redisTemplate.opsForSet().size(key);
        return size!=null? size :0;
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#union(Object, Object)
     */
    public static Set<String> sunion(String key, String otherKey){
        return redisTemplate.opsForSet().union(key, otherKey);
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#union(Object, Collection)
     */
    public static Set<String> sunion(String key, Collection<String> otherKeys){
        return redisTemplate.opsForSet().union(key,otherKeys);
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#unionAndStore(Object, Object, Object)
     */
    public static long sunionstore(String key, String otherKey, String destKey){
        Long unionNum = redisTemplate.opsForSet().unionAndStore(key, otherKey, destKey);
        return unionNum!=null?unionNum:0L;
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#unionAndStore(Object, Collection, Object)
     */
    public static long sunionstore(String key, Collection<String> otherKeys, String destKey){
        Long unionNum = redisTemplate.opsForSet().unionAndStore(key,otherKeys,destKey);
        return unionNum!=null?unionNum:0L;
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#difference(Object, Object)
     */
    public static Set<String> sdiff(String key, String otherKey){
        return redisTemplate.opsForSet().difference(key, otherKey);
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#difference(Object, Collection)
     */
    public static Set<String> sdiff(String key, Collection<String> otherKeys){
        return redisTemplate.opsForSet().difference(key,otherKeys);
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#intersect(Object, Object)
     */
    public static Set<String> sinter(String key, String otherKey){
        return redisTemplate.opsForSet().intersect(key,otherKey);
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#intersect(Object, Collection)
     */
    public static Set<String> sinter(String key, Collection<String> otherKeys){
        return redisTemplate.opsForSet().intersect(key,otherKeys);
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#intersect(Object, Object)
     */
    public static long sinterstore(String key, String otherKey,String destKey){
        Long interNum = redisTemplate.opsForSet().intersectAndStore(key,otherKey,destKey);
        return interNum!=null?interNum:0L;
    }

    /**
     * @see org.springframework.data.redis.core.SetOperations#intersect(Object, Collection)
     */
    public static long sinterstore(String key, Collection<String> otherKeys, String destKey){
        Long interNum = redisTemplate.opsForSet().intersectAndStore(key,otherKeys,destKey);
        return interNum!=null?interNum:0L;
    }

    /***********************************哈希表操作*************************************/
    /**
     * @see org.springframework.data.redis.core.HashOperations#hasKey(Object, Object)
     */
    public static boolean hexists(String key,String hashKey)  {
        Boolean hasKey = redisTemplate.opsForHash().hasKey(key,hashKey);
        return hasKey!=null?hasKey:false;
    }


    /**
     * @see org.springframework.data.redis.core.HashOperations#put(Object, Object, Object)
     */
    public static void hset(String key, String hashKey,String hashValue) {
        redisTemplate.opsForHash().put(key,hashKey,hashValue);
    }

    /**
     * @see org.springframework.data.redis.core.HashOperations#putIfAbsent(Object, Object, Object)
     */
    public static void hsetnx(String key, String hashKey,String hashValue) {
        redisTemplate.opsForHash().putIfAbsent(key,hashKey,hashValue);
    }

    /**
     * @see org.springframework.data.redis.core.HashOperations#putAll(Object, Map)
     */
    public static void hmset(String key, Map<String,String> hashMap) {
        redisTemplate.opsForHash().putAll(key,hashMap);
    }



    /**
     * @see org.springframework.data.redis.core.HashOperations#get(Object, Object)
     */
    public static String hget(String key, String hashKey) {
        return o2s(redisTemplate.opsForHash().get(key,hashKey));
    }

    /**
     * 注意：不同Collection实现中排序和去重特性
     * @see org.springframework.data.redis.core.HashOperations#get(Object, Object)
     */
    public static List<String> hmget(String key, Collection<Object> hashKeys) {
        List<Object> hashValues = redisTemplate.opsForHash().multiGet(key, hashKeys);
        return ((CollectionUtils.isNotEmpty(hashValues))? hashValues.stream().map(RedisUtils::o2s).collect(Collectors.toList()):null);
    }

    /**
     * 对象转String
     * @param value 值对象
     * @return 值String类型对象
     */
    private static String o2s(Object value){
        return (null==value)?null:value.toString();
    }

}
