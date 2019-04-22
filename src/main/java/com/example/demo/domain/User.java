package com.example.demo.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.Date;

/**
 * @author panghu
 * @title: User
 * @projectName json
 * @date 19-4-22 下午2:35
 */
@Data
@AllArgsConstructor
public class User {

    private String username;

    @JsonIgnore
    private String password;

    @JsonProperty(value = "phoneNumber")
    private String phone;

    @JsonInclude(JsonInclude.Include.NON_NULL)
    private String email;

    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    public User(String username, String password, String phone, Date createTime) {
        this.username = username;
        this.password = password;
        this.phone = phone;
        this.createTime = createTime;
    }
}
