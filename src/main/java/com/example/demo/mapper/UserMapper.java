package com.example.demo.mapper;


import com.example.demo.object.User;

/**
 * @author dgh
 * @date 19-1-18 下午5:21
 */
public interface UserMapper {
    /**通过用户名查询用户信息
     * @param username
     * @return
     */
    User selectByUsername(String username);


}
