package com.sx.ybj.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

@Configuration
public class MvcConfig extends WebMvcConfigurerAdapter {
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
//        registry.addViewController("/index").setViewName("index");

    }
     @Bean
    public LoginHandlerInterceptor LoginHandlerInterceptor(){
        return new LoginHandlerInterceptor();
    }


    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor( LoginHandlerInterceptor()).addPathPatterns("/**")
                .excludePathPatterns("/user/userLogin","/user/login","/user/getUserByToken","/admin/getFeedBack","/**");
    }


}
