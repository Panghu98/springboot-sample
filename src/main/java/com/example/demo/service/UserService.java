package com.example.demo.service;

import com.example.demo.object.User;
import com.example.demo.vo.ResultVO;

import javax.servlet.http.HttpServletResponse;

/**
 * @author dgh
 * @date 19-1-18 下午3:14
 */
public interface UserService {
//    /**
//     * 用户登录
//     * @param username
//     * @param password
//     * @param response
//     * @return
//     */
//    ResultVO loginUser(String username, String password, HttpServletResponse response);

    /**
     * demo
     *
     * @return
     */
    User getCurrentUser();

    User selectByEmpNum();
}
