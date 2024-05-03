package com.example.redistest.redis.utils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
/**
 * @ClassName RedisUtils
 * @Description
 * @Author Lizhou
 * @Date 2020-10-22 10:10:10
 **/
@Slf4j
@Component
public class RedisUtils {
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;
    /**
     * 根据key读取数据
     */
    public Object get(final String key) {
        if (StringUtils.isEmpty(key)) {
            return null;
        }
        try {
            return redisTemplate.opsForValue().get(key);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 写入数据
     */
    public boolean set(final String key, Object value) {
        if (StringUtils.isEmpty(key)) {
            return false;
        }
        try {
            redisTemplate.opsForValue().set(key, value);
            log.info("存入redis成功，key：{}，value：{}", key, value);
            return true;
        } catch (Exception e) {
            log.error("存入redis失败，key：{}，value：{}", key, value);
            e.printStackTrace();
        }
        return false;
    }
}