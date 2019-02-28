package com.example.demo.service;

import com.example.demo.object.GoodsType;

import java.util.List;

/**
 * @author panghu
 * @Title: PageService
 * @ProjectName demo
 * @Description: TODO
 * @date 19-2-27 下午9:21
 */
public interface PageService {

    List<GoodsType> getList(int pageNum, int pageSize) throws Exception;

}
