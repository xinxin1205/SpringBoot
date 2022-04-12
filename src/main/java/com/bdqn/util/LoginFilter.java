package com.bdqn.util;

import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.xml.ws.handler.Handler;

public class LoginFilter implements HandlerInterceptor {


    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        System.out.println("after...");

        //如果有session 则证明可登录
        HttpSession httpSession=request.getSession();
        if (httpSession.getAttribute("login")!=null){
            System.out.println("拦截器判断进入session");
//            httpSession.setAttribute("无权限","请先登录");
//            response.sendRedirect("/");
        }
        return true;
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
