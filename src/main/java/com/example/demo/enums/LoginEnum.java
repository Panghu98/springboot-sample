package com.example.demo.enums;

import lombok.Data;
import lombok.Getter;

/**
 * @author dgh
 * @date 19-1-18 下午2:26
 */
@Getter
public enum LoginEnum {

    /***/
    USERNAME_EMPTY(1,"用户名为空"),
    USER_NOT_EXIT(2,"用户名不存在"),
    USER_LOGIN_ERROR(3,"密码错误"),
    TOKEN_NON_ERROR(4, "token信息必传"),
    TOKEN_ERROR(5, "token验证失败"),
    HAVE_NO_PERMISSIONS(101,"权限不足"),
    AUTHENTICATION_ERROR(201,"用户认证失败，请重新登录");

    Integer code;
    String message;

    LoginEnum(Integer code, String message) {
        this.code = code;
        this.message = message;
    }
}
