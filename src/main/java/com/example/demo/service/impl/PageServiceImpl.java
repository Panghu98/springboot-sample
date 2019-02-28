package com.example.demo.service.impl;

import com.example.demo.mapper.PageMapper;
import com.example.demo.object.GoodsType;
import com.example.demo.service.PageService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author panghu
 * @Title: PageServiceImpl
 * @ProjectName demo
 * @Description: TODO
 * @date 19-2-27 下午9:35
 */
@Service
@Transactional(rollbackFor = { RuntimeException.class, Exception.class })
public class PageServiceImpl implements PageService {

    @Autowired
    private PageMapper pageMapper;

    public List<GoodsType> getList(int pageNum, int pageSize) throws Exception {
        //使用分页插件,核心代码就这一行
        PageHelper.startPage(pageNum, pageSize);
        // 获取
        List<GoodsType> typeList = pageMapper.getList();
        return typeList;
    }
}
