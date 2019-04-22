package com.example.demo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.annotation.EnableScheduling;

/**
 * @EnableAsync  开启异步任务
 * @EnableScheduling  开启定时任务
 * @author panghu
 */
@EnableConfigurationProperties
@EnableCaching
@EnableScheduling
@EnableAsync
@MapperScan("com.example.demo.mapper")
@SpringBootApplication(scanBasePackages = "com.example")
public class DemoApplication {

    public static void main(String[] args) {

        SpringApplication.run(DemoApplication.class, args);
    }

}

