package com.bdqn.config;

import com.bdqn.util.LoginFilter;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

//装配拦截器组件 定义拦截器规则
//加入到springboot中
@Configuration
public class SpringConfig implements WebMvcConfigurer {

    //怎样把springmvc 这个对象当成组件注入到拦截器中
    public LoginFilter getmvc() {
        return new LoginFilter();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        InterceptorRegistration registration = registry.addInterceptor(getmvc());
        //所有的路径都拦截，但是要排除login
        registration.addPathPatterns("/*");//添加选择要拦截的路径
        registration.excludePathPatterns("/Login");//排除要拦截的唯一路径
    }

}
