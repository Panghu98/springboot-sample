package com.example.demo.controller;


import com.example.demo.service.impl.LoginServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author panghu
 */
@RestController
@Slf4j
public class LoginController {

    @Autowired
    private LoginServiceImpl loginService;

    /**
     * 登录接口
     *
     * @param username
     * @param password
     * @return
     */
    @PostMapping("/login")
    public Map login(@RequestParam String username,@RequestParam String password) {
            return loginService.login(username,password);
    }

    @RequestMapping("/test")
    public String test() {
        return "test success";
    }


}
