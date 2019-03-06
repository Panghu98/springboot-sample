package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.redis.RedisModelMap;
import com.example.demo.redis.RedisUtil;
import com.example.demo.redis.StateParameter;
import com.example.demo.object.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author panghu
 * @Title: RedisTestController
 * @ProjectName demo
 * @Description: TODO
 * @date 19-3-5 上午11:59
 */
@Slf4j
@Controller
@Transactional(rollbackFor = Exception.class)
@RequestMapping("/redis")
public class RedisTestController{

    @Autowired
    RedisUtil redisUtil;

    /**
     * @auther: zhangyingqi
     * @date: 17:26 2018/8/28
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 测试redis存储&读取
     */
    @RequestMapping(value="/test")
    @ResponseBody
    public ModelMap test(){
        RedisModelMap redisModelMap = new RedisModelMap();
        try {
            redisUtil.set("redisTemplate","这是一条测试数据", 2);
            String value = redisUtil.get("redisTemplate", 2).toString();
            log.info("redisValue="+value);
            log.info("读取redis成功");
            return redisModelMap.getModelMap(StateParameter.SUCCESS, value, "操作成功");
            //TODO  添加相关的数据库操作
        } catch (Exception e) {
            e.printStackTrace();
            return redisModelMap.getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

    @RequestMapping(value="/setUser")
    @ResponseBody
    public ModelMap setUser(){
        RedisModelMap redisModelMap = new RedisModelMap();
        try {
            User user = new User();
            user.setName("隔壁老王");
            user.setAge(28);
            user.setId(6666);
            redisUtil.set("user",user, 2);
            User res = (User)redisUtil.get("user",2);
            log.info("res="+ JSON.toJSONString(res));
            log.info("读取redis成功");
            return redisModelMap.getModelMap(StateParameter.SUCCESS, res, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return redisModelMap.getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

}
