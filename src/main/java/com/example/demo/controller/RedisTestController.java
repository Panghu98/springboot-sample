package com.example.demo.controller;

import com.alibaba.fastjson.JSON;
import com.example.demo.redis.RedisModelMap;
import com.example.demo.redis.RedisUtil;
import com.example.demo.redis.StateParameter;
import com.example.demo.object.User;
import com.example.demo.redis.key.ModelKey;
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
public class RedisTestController {

    @Autowired
    RedisUtil redisUtil;


    /**
     * @auther: zhangyingqi
     * @date: 17:26 2018/8/28
     * @param: []
     * @return: org.springframework.ui.ModelMap
     * @Description: 测试redis存储&读取
     */
    @RequestMapping(value = "/test")
    @ResponseBody
    public ModelMap test(String key) {
        RedisModelMap redisModelMap = new RedisModelMap();
        try {
            String value = redisUtil.get(key).toString();
            log.info("redisValue=" + value);
            log.info("读取redis成功");
            return redisModelMap.getModelMap(StateParameter.SUCCESS, value, "操作成功");
            //TODO  添加相关的数据库操作
        } catch (Exception e) {
            log.error(e.getMessage());
            return redisModelMap.getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

    @RequestMapping(value = "/set")
    @ResponseBody
    public void set(String key,String value,long time) {
        redisUtil.set(key, value,new ModelKey());
        log.info("插入成功");
    }


    @RequestMapping(value = "/setUser")
    @ResponseBody
    public ModelMap setUser() {
        RedisModelMap redisModelMap = new RedisModelMap();
        try {
            User user = new User();
            user
                    .setName("隔壁的泰山");
            user.setAge(28);
            user.setId(6666);
            redisUtil.set("2016", user, new ModelKey());
            User res = (User) redisUtil.get("2016");
            log.info("res=" + JSON.toJSONString(res));
            log.info("读取redis成功");
            return redisModelMap.getModelMap(StateParameter.SUCCESS, res, "操作成功");
        } catch (Exception e) {
            e.printStackTrace();
            return redisModelMap.getModelMap(StateParameter.FAULT, null, "操作失败");
        }
    }

}
