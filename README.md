# 项目说明 
## 在jwt的Filter中配置了preFlighted请求的跨域问题
## redis整合使用的是redisTemplate
#### 相关的json框架介绍
![相关的json介绍](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/png1.png)
#### bean的格式
* 未给email赋值
![bean的格式](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/png3.png)
#### 返回给前台的json
![返回给前台的json](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/json.png)
### springboot整合定时任务和异步任务处理
* 使用springboot框架的话推荐使用第三种
* 如果是使用spring的话推荐使用第二种
![定时任务](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/定时任务.png)  
### 定时任务的配置
* cron也是linux上面的一个定时任务命令  相关的语法可以在网上进行搜索
![定时任务的配置](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/定时任务配置.png)  
* 定时执行和延迟执行的区别:
    * 延迟执行(fixedDelay)是指任完成后的在一定的延迟时间之后执行
    * 定时执行(fixedRate)是这一次任务的开始到上一次任务的开始为执行时间
    * fixedDelayString 可以通过在配置文件里面添加相关的依赖 这样就可以通过配置文件来修改这个时间(常用)
![异步任务](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/异步任务.png)
### 搜索框架ElasticSearch
    * solr和ElasticSearch都是基于Apache的框架Lucene
![ElasticSearch](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/ElasticSearch2.png)
* 纯Java开发,springboot使用,5.6版本
    * es升级4->5v版本,改动大,但是5过后的版本改动都不大
![ElasticSearch](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/ElasticSearch.png)
* elasticsearch5.6.x的简单测试
    * 步骤一 https://www.elastic.co/guide/en/elasticsearch/reference/5.6/index.html
    * 步骤二 使用postman工具
    * 基础语法  可以到步骤一的网址去查看相关的语法
        * 查看集群状态
        GET localhost:9200/_cat/health?v
        ![集群状态](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/集群状态.png)
        * 查看索引
        GET localhost:9200/_cat/indices?v
        * 创建索引   customer指的是索引的名称
        PUT localhost:9200/customer?pretty
        * 删除索引 
        DELETE localhost:9200/customer?pretty
        * 添加内容
        PUT localhost:9200/customer/external/2?pretty
        * 查看内容
        GET localhost:9200/customer/external/2?pretty
### springboot整合elasticsearch
![](https://github.com/Panghu98/springboot-sample/blob/master/src/main/resources/static/%E6%95%B4%E5%90%88elasticsearch.png)

        
