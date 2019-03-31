package com.example.demo.controller;

import com.example.demo.object.GoodsType;
import com.example.demo.service.PageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author panghu
 * @Title: PageControllrt
 * @ProjectName demo
 * @Description: TODO
 * @date 19-2-27 下午9:43
 */
@RestController
public class PageController {

    @Autowired
    private PageService pageService;

    @PostMapping("/getList")
    public List<GoodsType> getGoodsTypeList(int pageNum, int pageSize) throws Exception {
        // 调用业务逻辑,返回数据
        return pageService.getList(pageNum, pageSize);
    }

}
