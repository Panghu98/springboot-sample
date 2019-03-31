package com.example.demo.service.impl;

import com.example.demo.mapper.UserMapper;
import com.example.demo.object.JwtUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

/**
 * @author panghu
 */
@Service
public class JwtUserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        if (userMapper.selectByUsername(username) == null) {
            throw new UsernameNotFoundException(String.format("No user found with username '%s'.", username));
        } else {
            String password = userMapper.selectByUsername(username).getPassword();
            return new JwtUser(username, password);
        }

    }
}
