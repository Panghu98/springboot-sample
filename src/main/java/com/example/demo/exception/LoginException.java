package com.example.demo.exception;

import com.example.demo.enums.LoginEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * @author dgh
 * @date 19-1-18 下午2:46
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class LoginException extends RuntimeException {

    private Integer code;

    public LoginException(LoginEnum loginEnum) {
        super(loginEnum.getMessage());
        this.code = loginEnum.getCode();
    }

    public LoginException(Integer code, String message) {
        super(message);
        this.code = code;
    }
}
