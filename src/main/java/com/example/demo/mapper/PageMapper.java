package com.example.demo.mapper;

import com.example.demo.object.GoodsType;
import com.example.demo.object.Page;
import java.util.List;

public interface PageMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(Page record);

    Page selectByPrimaryKey(Integer id);

    List<Page> selectAll();

    int updateByPrimaryKey(Page record);

    List<GoodsType> getList();
}