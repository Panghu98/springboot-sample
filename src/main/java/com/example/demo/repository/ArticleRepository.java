package com.example.demo.repository;

import com.example.demo.domain.Article;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Component;

/**
 * @author panghu
 * @title: ArticleRepository
 * @projectName demo
 * @date 19-4-24 下午7:36
 * 实际上Component注解和Repository注解效果是一样的
 */
@Component
public interface ArticleRepository extends ElasticsearchRepository<Article,Long> {



}
