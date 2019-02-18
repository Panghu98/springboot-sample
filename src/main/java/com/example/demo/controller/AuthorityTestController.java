package com.example.demo.controller;

import com.example.demo.annotation.RoleRequired;
import com.example.demo.enums.RoleEnum;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dgh
 * @date 19-1-19 下午8:18
 */
@RestController
public class AuthorityTestController {

    @RoleRequired()
    @GetMapping("/test1")
    public Map login() {
        Map<String, String> map = new HashMap<>(10);
        map.put("msg", "login success");
        return map;
    }

    @RoleRequired(value = RoleEnum.ADMIN)
    @GetMapping("/test2")
    public Map queryAllProduct() {
        Map<String, String> map = new HashMap<>(10);
        map.put("msg", "this is all data");
        return map;
    }
    @RoleRequired(value = RoleEnum.SUPER_ADMIN)
    @GetMapping("/test3")
    public Map show() {
        Map<String, String> map = new HashMap<>(10);
        map.put("msg","展示所有管理员信息");
        return map;
    }

    @GetMapping("/test4")
    public Map<String, String> show2() {
        Map<String, String> map = new HashMap<>(10);
        map.put("msg","错误");
        return map;
    }
}
