package com.example.demo.object;

import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import javax.validation.constraints.NotNull;
import java.io.Serializable;
import java.util.Date;

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

    /**
     * 注解中的属性名才是真的的参数名称
     */
    @JSONField(name = "name")
    private String name;

    private Integer age;

    @NotNull
    private Integer id;

    private String username;

    /**
     * 是否被序列化
     * 下述为是否被序反列化
     *fastjson
     * @JSONField(deserialize = 布尔类型)
     */
    @JSONField(serialize = false)
    private String password;

    /**
     * jackson
     */
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Integer role;

    private String redisKey;

    /**
     * jackson
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * fastjson
     * */
    @JSONField(format = "yyyy-mm-dd hh:mm:ss")
    private Date updateTime;

    public User(Integer id, String username, Integer role) {
        this.id = id;
        this.username = username;
        this.role = role;
    }

    public User() {
    }
}
