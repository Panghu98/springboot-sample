package com.example.demo.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.UUID;

/**
 * @author panghu
 * @Title: ModelMap
 * @ProjectName demo
 * @Description: TODO
 * @date 19-3-5 下午1:21
 */
public class RedisModelMap {

    protected final String success = StateParameter.SUCCESS;
    protected final String  fail = StateParameter.FAULT;

    protected final Logger logger = LoggerFactory.getLogger(this.getClass());

    public org.springframework.ui.ModelMap getModelMap(String status, Object data, String msg){
        org.springframework.ui.ModelMap modelMap=new org.springframework.ui.ModelMap();
        modelMap.put("status", status);
        modelMap.put("data", data);
        modelMap.put("msg", msg);
        return modelMap;

    }

    public String getUuid(){
        String uuid = UUID.randomUUID().toString(); //获取UUID并转化为String对象
        uuid = uuid.replace("-", "");
        return uuid;
    }


}
