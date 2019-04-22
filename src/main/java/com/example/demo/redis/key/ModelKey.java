package com.example.demo.redis.key;

/**
 * @author panghu
 * @title: ModelKey
 * @projectName demo
 * @date 19-4-22 上午10:18
 */

public class ModelKey extends BasePrefix {

    public ModelKey(int expireSeconds, String prefix) {
        super(expireSeconds, prefix);
    }

    public ModelKey(){
        super(-1,"test");
    }
}
