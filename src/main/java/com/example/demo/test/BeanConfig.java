package com.example.demo.test;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Conditional;
import org.springframework.context.annotation.Configuration;

/**
 * @author panghu
 * @Title: BeanConfig
 * @ProjectName demo
 * @Description: TODO
 * @date 19-3-4 下午2:04
 */

@Configuration
public class BeanConfig {

    /**
     * 只有一个类时，大括号可以省略
     *     如果WindowsCondition的实现方法返回true，则注入这个bean
     * @return
     */
    @Conditional({WindowsCondition.class})
    @Bean(name = "bill")
    public Person person1(){
        return new Person("Bill Gates",62);
    }

    /**
     *     如果LinuxCondition的实现方法返回true，则注入这个bean
     */
    @Conditional({LinuxCondition.class})
    @Bean("linus")
    public Person person2(){
        return new Person("Linus",48);
    }
}
