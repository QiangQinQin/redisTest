package com.example.redistest.redis.test;
import com.example.redistest.redis.Entity.UserInfo;
import com.example.redistest.redis.utils.RedisUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.Date;
@SpringBootTest
class RedisTestApplicationTests {
    @Autowired
    private RedisUtils redisUtil;
    @Test
    void contextLoads() {
        UserInfo userInfo = new UserInfo();
        userInfo.setId(1949);
        userInfo.setName("中国");
        userInfo.setCreateTime(new Date());
        // 放入redis
        redisUtil.set("user", userInfo);
        // 从redis中获取
        System.out.println("获取到数据：" + redisUtil.get("user"));
    }
}