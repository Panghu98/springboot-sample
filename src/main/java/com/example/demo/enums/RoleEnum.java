package com.example.demo.enums;

import lombok.Getter;

/**
 * @author dgh
 * @date 19-1-18 下午7:33
 */
@Getter
public enum RoleEnum {
    /***/
    USER(1),
    ADMIN(2),
    SUPER_ADMIN(3);

    Integer value;

    RoleEnum(Integer value) {
        this.value = value;
    }
}
