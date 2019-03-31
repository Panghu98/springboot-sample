package com.example.demo.controller;

import com.example.demo.service.impl.LoginServiceImpl;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author panghu
 * @Title: AnonController
 * @ProjectName oil-supply-chain
 * @Description: TODO
 * @date 19-3-11 下午2:52
 */
@RequestMapping(value = "/test")
@Api(description = "用户登录接口")
@RestController
public class AnonController {

    @Autowired
    private LoginServiceImpl loginService;

    @Autowired
    public AnonController(LoginServiceImpl loginService) {
        this.loginService = loginService;
    }

    @ApiOperation(value = "用户登录接口",tags = "login")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名",required = true),
            @ApiImplicitParam(name = "password",value = "密码",required = true)
    })
    @PostMapping("/login12")
    public Map login(String username,String password) {
        return loginService.login(username, password);
    }

}
