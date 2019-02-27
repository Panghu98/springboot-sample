package com.example.demo.service;

import java.util.List;

/**
 * @author panghu
 * @Title: BaseService
 * @ProjectName demo
 * @Description: TODO
 * @date 19-2-27 下午7:57
 */
public interface BaseService<T> {

    /**
     * 根据主键删除
     * @param id
     * @return
     */
    int deleteByPrimaryKey(Object id);

    /**
     * 新增一条记录
     * @param entity
     * @return
     */
    int insert(T entity);

    /**
     * 根据主键查询
     * @param id
     * @return
     */
    T selectByPrimaryKey(Object id);

    /**
     * 查询全部记录
     * @return
     */
    List<T> selectAll();

    /**
     * 根据主键修改数据
     * @param entity
     * @return
     */
    int updateByPrimaryKey(T entity);

}
