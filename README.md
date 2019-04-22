# 项目说明
## 在jwt的Filter中配置了preFlighted请求的跨域问题
## redis整合使用的是redisTemplate
#### 相关的json框架介绍
![相关的json介绍](/home/panghu/IdeaProjects/json/src/main/resources/static/png1.png)
####bean的格式
* 未给email赋值
![bean的格式](/home/panghu/IdeaProjects/json/src/main/resources/static/png3.png)
####返回给前台的json
![返回给前台的json](/home/panghu/IdeaProjects/springboot-sample/src/main/resources/static/json.png)
###springboot整合定时任务和异步任务处理
* 使用springboot框架的话推荐使用第三种
* 如果是使用spring的话推荐使用第二种
![定时任务](/home/panghu/IdeaProjects/springboot-sample/src/main/resources/static/定时任务.png)  
###定时任务的配置
* cron也是linux上面的一个定时任务命令  相关的语法可以在网上进行搜索
![定时任务的配置](/home/panghu/IdeaProjects/springboot-sample/src/main/resources/static/定时任务配置.png)  
* 定时执行和延迟执行的区别:
    * 延迟执行(fixedDelay)是指任完成后的在一定的延迟时间之后执行
    * 定时执行(fixedRate)是这一次任务的开始到上一次任务的开始为执行时间
    * fixedDelayString 可以通过在配置文件里面添加相关的依赖 这样就可以通过配置文件来修改这个时间(常用)
![异步任务](/home/panghu/IdeaProjects/springboot-sample/src/main/resources/static/异步任务.png)
