package com.example.demo.controller;

import com.example.demo.object.User;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.web.bind.annotation.*;

/**
 * @author panghu
 * @Title: TestController
 * @ProjectName demo
 * @Description: TODO
 * @date 19-3-3 下午3:32
 */
@RestController
@RequestMapping("/test")
public class RedisController {
    private String testString = "testString";

    @Autowired
    private RedisTemplate<Object, Object> redisTemplate;
    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @PostMapping("/add")
    public String add(@RequestParam("key")String userKey) {
        //1,添加一个Value为String
        //for test
        /* 测试  stringRedisTemplate.opsForValue().set(testString, "测试存储字符串类型");*/
        //2,添加一个Value为对象
        User user = new User();
        user.setId(1);
        user.setUsername("张三");
        user.setPassword("1111");
        user.setRedisKey(userKey);
        redisTemplate.opsForValue().set(user.getRedisKey(), user);
        return "成功";
    }

    @GetMapping("/getString")
    public String findString() {
        String s = stringRedisTemplate.opsForValue().get(testString);
        return s;
    }

    @GetMapping("/delete")
    public String deleteByKey(@Param("key")String userKey) {
        //1,删除string类型
        stringRedisTemplate.delete(testString);
        //2,删除user对象
        redisTemplate.delete(userKey);
        return "删除成功";
    }
}