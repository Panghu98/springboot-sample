package com.example.demo.interceptor;

import com.example.demo.annotation.RoleRequired;
import com.example.demo.enums.LoginEnum;
import com.example.demo.object.User;
import com.example.demo.service.UserService;
import com.example.demo.utils.ResultVoUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import com.alibaba.fastjson.JSON;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author dgh
 * @date 19-1-19 下午7:54
 */
@Service
@Slf4j
public class AuthorityInterceptor implements HandlerInterceptor {

    @Autowired
    private UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        response.setCharacterEncoding("UTF-8");
        response.setContentType(MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE);
        String json = JSON.toJSONString(ResultVoUtil.error(LoginEnum.AUTHENTICATION_ERROR));
        User user = userService.getCurrentUser();
        log.info(String.valueOf(user));
        if (user == null) {
            log.info("未登录");
            return true;
        }
        log.info("Security 执行权限验证--------");
        if (handler instanceof HandlerMethod) {
            System.out.println("--------------------------");
            HandlerMethod handlerMethod = (HandlerMethod) handler;
            RoleRequired roleRequired = handlerMethod.getMethodAnnotation(RoleRequired.class);
            if (roleRequired == null) {
                log.info("不需要角色权限验证");
                return true;
            }
            Integer requireValue = roleRequired.value().getValue();
            Integer userValue = user.getRole();
            log.info("requireValue:{},userValue:{}", requireValue, userValue);
            if (userValue >= requireValue) {
                return true;
            } else {
                json = JSON.toJSONString(ResultVoUtil.error(LoginEnum.HAVE_NO_PERMISSIONS));
                log.error("............权限不足...........");
            }
        }
        response.getWriter().append(json);
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
