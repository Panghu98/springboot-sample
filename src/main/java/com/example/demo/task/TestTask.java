package com.example.demo.task;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.Date;

/**
 * @author panghu
 * @title: Testtask
 * @projectName demo
 * @description 定时任务类
 * @date 19-4-22 下午3:35
 */
//@Component
public class TestTask {

    /**
     * 默认单位是毫秒
     */
    @Scheduled(fixedRate = 2000)
    public void sum(){
        System.out.println("当前时间为"+new Date());
    }

}
