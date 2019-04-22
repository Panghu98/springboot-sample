package com.example.demo.task;

import org.springframework.scheduling.annotation.Async;
import org.springframework.scheduling.annotation.AsyncResult;
import org.springframework.stereotype.Component;

import java.util.concurrent.Future;

/**
* @Description:    the comment of java class 
* @Author:         panghu
* @CreateTime:     19-4-22 下午5:02
 @Async 注解可以用于标记方法也可以用于表记类,关闭这个注解的话这个类就变成同步的
*/
//@Async
@Component
public class AsyncTask {

    public void task1() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(1000);
        long end = System.currentTimeMillis();
        System.out.println("任务1耗时"+(end-begin));
    }

    public void task2() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(2000);
        long end = System.currentTimeMillis();
        System.out.println("任务2耗时"+(end-begin));
    }

    public void task3() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时"+(end-begin));
    }

    public Future<String> task4() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000L);
        long end = System.currentTimeMillis();
        System.out.println("任务4耗时"+(end-begin));
        return new AsyncResult<>("任务4");
    }

    public Future<String> task5() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("任务5耗时"+(end-begin));
        return new AsyncResult<>("任务5");
    }

    public Future<String> task6() throws InterruptedException {
        long begin = System.currentTimeMillis();
        Thread.sleep(3000);
        long end = System.currentTimeMillis();
        System.out.println("任务3耗时"+(end-begin));
        return new AsyncResult<>("任务6");
    }



}
