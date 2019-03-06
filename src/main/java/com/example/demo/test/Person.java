package com.example.demo.test;

import lombok.Data;

/**
 * @author panghu
 * @Title: Person
 * @ProjectName demo
 * @Description: TODO
 * @date 19-3-4 下午2:01
 */
@Data
public class Person {

    private String name;
    private Integer age;

    public Person(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Person{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

}
