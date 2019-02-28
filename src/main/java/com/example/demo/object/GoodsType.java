package com.example.demo.object;

import lombok.Data;

import java.util.Date;

/**
 * @author panghu
 * @Title: GoodsType
 * @ProjectName demo
 * @Description: TODO
 * @date 19-2-27 下午9:23
 */
@Data
public class GoodsType {

    private int id;

    private Date createTime;

    private Date updateTime;

    private String typeName;

}
