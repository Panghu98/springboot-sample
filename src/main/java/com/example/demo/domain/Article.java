package com.example.demo.domain;

import lombok.Data;
import org.springframework.data.elasticsearch.annotations.Document;

import java.io.Serializable;

/**
 * Alt+Insert 调出serialVersionUID 前提是先要继承Serializable这个接口
 * @author panghu
 * @title: Article
 * @projectName demo
 * @date 19-4-24 下午7:10
 * indexName 数据库名  type 表名
 */
@Document(indexName = "db_library",type = "article")
@Data
public class Article implements Serializable {

    private static final long serialVersionUID = -1378742881700847737L;

    private long id;

    private String title;

    private String summary;

    private String content;

    private int pv;


}
