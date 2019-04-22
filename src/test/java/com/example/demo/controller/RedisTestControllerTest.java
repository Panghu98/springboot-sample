package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.object.User;
import com.example.demo.redis.RedisModelMap;
import com.example.demo.redis.RedisUtil;
import com.example.demo.redis.StateParameter;
import com.example.demo.redis.key.ModelKey;
import org.junit.jupiter.api.Test;
import org.springframework.ui.ModelMap;

import static org.junit.jupiter.api.Assertions.*;

/**
 * @author panghu
 * @Title: RedisTestControllerTest
 * @ProjectName demo
 * @Description: TODO
 * @date 19-3-6 下午7:06
 */
class RedisTestControllerTest {

    @Test
    void test1() {
    }

    @Test
    ModelMap setUser() {
        RedisModelMap redisModelMap = new RedisModelMap();
        try {
            RedisUtil redisUtil = new RedisUtil();
            User user = new User();
            user.setName("小张");
            user.setAge(65);
            user.setId(45647854);
            redisUtil.set(String.valueOf(user.getId()), user, new ModelKey());
            User res = (User) redisUtil.get(new ModelKey().getPrefix()+"user");
            return redisModelMap.getModelMap(StateParameter.SUCCESS, res, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return redisModelMap.getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }
}