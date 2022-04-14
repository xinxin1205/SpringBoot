package com.bdqn.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.PrintWriter;

@CrossOrigin("*")
@Component
public class LoginFilter implements HandlerInterceptor {

    @Autowired
    RedisUtil u;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //如果有session 则证明可登录
        String Login = request.getParameter("Login");
        System.err.println(Login);
        if (Login != null) {
            Object o = u.get(Login);
            if (o != null) {
                return true;
            }
        }
        //给前台一个响应
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        PrintWriter out = response.getWriter();
        out.print("nologin");
        out.flush();
        out.close();
        return false;
        /*改为return true则不会被拦截 */
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("请求中ing...");
        HandlerInterceptor.super.postHandle(request, response, handler, modelAndView);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("before...");
        HandlerInterceptor.super.afterCompletion(request, response, handler, ex);
    }
}
