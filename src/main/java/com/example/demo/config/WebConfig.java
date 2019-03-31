package com.example.demo.config;

import com.example.demo.interceptor.AuthorityInterceptor;
import com.example.demo.service.UserService;
import com.example.demo.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @author dgh
 * @date 19-1-19 下午8:11
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Bean
    public UserService userService() {
        return new UserServiceImpl();
    }

    @Autowired
    private AuthorityInterceptor authorityInterceptor;

    /**
     * 在这个方法当中配置拦截器需要拦截的页面
     */
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(authorityInterceptor).addPathPatterns("/**")
                .excludePathPatterns("/login", "/autoconfig", "/getCheckCode", "/getGoodsTypeList");
    }

}
