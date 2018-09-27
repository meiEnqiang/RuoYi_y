package com.ruoyi.common.redis;

import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ValueOperations;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

/**
 * @author MeiEnQiang
 * @date 2018/9/21/0021
 */
public abstract class AbstractCacheValueDao<T> {
    @Resource
    private RedisTemplate<String, T> cacheRedisTemplate;

    public void setCacheRedisTemplate(RedisTemplate<String, T> cacheRedisTemplate) {
        this.cacheRedisTemplate = cacheRedisTemplate;
    }

    private ValueOperations<String, T> createValueOperation() {
        return cacheRedisTemplate.opsForValue();
    }

    protected abstract String getKey(String key);

    public T get(String key) {
        return createValueOperation().get(getKey(key));
    }

    public void setRehinkByOffSetHour(String key, T value, long hour) {
        createValueOperation().set(getKey(key), value, hour, TimeUnit.HOURS);
    }
}
