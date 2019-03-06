package com.example.demo.controller;

import com.example.demo.config.RedisConstants;
import com.example.demo.config.RedisModelMap;
import com.example.demo.config.RedisUtil;
import com.example.demo.config.StateParameter;
import com.example.demo.object.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
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
            redisUtil.set("redisTemplate","这是一条测试数据", RedisConstants.datebase2);
            String value = redisUtil.get("redisTemplate", RedisConstants.datebase2).toString();
            log.info("redisValue="+value);
            log.info("读取redis成功");
            return redisModelMap.getModelMap(StateParameter.SUCCESS, value, "操作成功");
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
            redisUtil.set("user",user, RedisConstants.datebase1);
            User res = (User)redisUtil.get("user",RedisConstants.datebase1);
            log.info("res="+res.toString());
            log.info("读取redis成功");
            return redisModelMap.getModelMap(StateParameter.SUCCESS, res, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return redisModelMap.getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

}
