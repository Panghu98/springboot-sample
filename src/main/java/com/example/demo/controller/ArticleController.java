package com.example.demo.controller;

import com.example.demo.domain.Article;
import com.example.demo.repository.ArticleRepository;
import org.elasticsearch.index.query.QueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author panghu
 * @title: ArticleController
 * @projectName demo
 * @date 19-4-24 下午7:49
 */
@RestController
@RequestMapping("/test/elasticsearch")
public class ArticleController {

    @Autowired
    private ArticleRepository articleRepository;

    @GetMapping("/save")
    public Object save(){
        Article article = new Article();
        article.setId(2L);
        article.setContent("this is the content");
        article.setTitle("hello elasticsearch");
        article.setSummary("hello,this is a test for a search engine");
        articleRepository.save(article);

        return "OK";
    }

//    @GetMapping
//    public Object search(Long id){
//        Article article = articleRepository.search(id);
//    }

     @GetMapping("/search")
    public Object search(Long id){
         /**
          * 可以构造更加复杂的搜索方法
          */
         QueryBuilder queryBuilder = QueryBuilders.matchQuery("id",id);

         return articleRepository.search(queryBuilder);
     }

}
