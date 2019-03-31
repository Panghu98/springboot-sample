package com.example.demo.controller;

import com.example.demo.service.MailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Random;

/**
 * @author panghu
 * @Title: MailController
 * @ProjectName demo
 * @Description: TODO
 * @date 19-2-18 上午9:34
 */
@RestController
public class MailController {

    @Autowired
    private MailService mailService;

    @GetMapping("/getCheckCode")
    public String getCheckCode(String email) {
        String checkCode = String.valueOf(new Random().nextInt(899999) + 100000);
        String message = "您的注册验证码为：" + checkCode;
        try {
            mailService.sendSimpleMail(email, "注册验证码", message);
        } catch (Exception e) {
            return "邮箱验证发生异常";
        }
        return checkCode;
    }
}
