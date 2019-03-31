package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.object.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * @author panghu
 * @Title: UserServiceImpl
 * @ProjectName demo
 * @Description: TODO
 * @date 19-1-21 下午5:00
 */
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User getCurrentUser() {
        String anonymousUser = "anonymousUser";
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String name = authentication.getName();
        if (!anonymousUser.equals(name)) {
            return userMapper.selectByUsername(name);
        }
        return null;
    }

    @Override
    public User selectByEmpNum() {
        return null;
    }
}
