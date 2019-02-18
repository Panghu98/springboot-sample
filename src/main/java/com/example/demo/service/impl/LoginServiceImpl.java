package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.utils.JwtTokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * @author dgh
 * @date 19-1-19 下午12:57
 */
@Slf4j
@Service
public class LoginServiceImpl {

    private AuthenticationManager authenticationManager;

    private JwtTokenUtil jwtTokenUtil;

    private UserDetailsService userDetailsService;

    private UserMapper userMapper;

    @Autowired
    public LoginServiceImpl(AuthenticationManager authenticationManager,
                            JwtTokenUtil jwtTokenUtil, UserDetailsService userDetailsService, UserMapper userMapper) {
        this.authenticationManager = authenticationManager;
        this.jwtTokenUtil = jwtTokenUtil;
        this.userDetailsService = userDetailsService;
        this.userMapper = userMapper;
    }

    public Map login(String username, String password) {
        if(userMapper.selectByUsername(username) == null) {
            log.info("用户不存在");
            Map<String,Object> map = new HashMap(10);
            map.put("code", 0);
            map.put("msg", "用户不存在");
            return map;
        }

        log.info("进行验证用户密码..");
        Authentication token1 = new UsernamePasswordAuthenticationToken(username, password);
        Authentication authentication = authenticationManager.authenticate(token1);
        log.info("验证通过..");
        SecurityContextHolder.getContext().setAuthentication(authentication);
        final UserDetails userDetails = userDetailsService.loadUserByUsername(username);
        log.info("加载userDetails:" + userDetails.getUsername());
        final String token = jwtTokenUtil.generateToken(userDetails);
        HashMap<String, String> r = new HashMap<>(10);
        r.put("token", token);

        return r;
    }
}
