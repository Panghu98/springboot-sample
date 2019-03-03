package com.example.demo.object;

import lombok.Data;

import java.io.Serializable;

/**
 * @author panghu
 * @Title: User
 * @ProjectName demo
 * @Description: TODO
 * @date 19-1-21 下午4:44
 */
@Data
public class User implements Serializable {

    private static final long serialVersionUID = -8577252502582508047L;

    private Integer id;

    private String username;

    private String password;

    private Integer role;

    private String redisKey;
}
