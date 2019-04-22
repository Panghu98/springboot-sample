package com.example.demo.controller;

import com.example.demo.domain.User;
import com.example.demo.task.AsyncTask;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;
import java.util.concurrent.Future;

/**
 * @author panghu
 * @title: TestController
 * @projectName demo
 * @date 19-4-22 下午3:22
 */
@RestController
public class TestController {

    @Autowired
    private AsyncTask asyncTask;

    @GetMapping("/testjson")
    public Object testJson(){
        return new User("胖虎","123456","18082244454",new Date());
    }

    @GetMapping("/async_task")
    public Object exeTask() throws InterruptedException {
        long begin = System.currentTimeMillis();
//        asyncTask.task1();
//        asyncTask.task2();
//        asyncTask.task3();

        Future<String> task4 = asyncTask.task4();
        Future<String> task5 = asyncTask.task5();
        Future<String> task6 = asyncTask.task6();

        for (;;){
            if (task4.isDone()&&task5.isDone()&&task6.isDone()) {
                break;
            }
        }

        long end = System.currentTimeMillis();
        System.out.println("执行总耗时"+(end-begin));
        return "OK";
    }
    /**
     * 执行结果
     * 执行总耗时4
     * 任务1耗时1000
     * 任务2耗时2000
     * 任务3耗时3000
     */

}
