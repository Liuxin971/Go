package com.sx.ybj.config;

import org.springframework.boot.autoconfigure.AutoConfigureBefore;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @program: ybj
 * @description: 跨域访问
 * @author: lwx
 * @create: 2019-05-15 08:36
 */
@Configuration
@AutoConfigureBefore(HelloSecurity.class)
public class ORSConfiguration extends WebMvcConfigurerAdapter {
   // @Override
        /**
        *@Description: addMapping：配置可以被跨域的路径，可以任意配置，可以具体到直接请求路径。 
         * allowedMethods：允许所有的请求方法访问该跨域资源服务器，如：POST、GET、PUT、DELETE等。 
         * allowedOrigins：允许所有的请求域名访问我们的跨域资源，可以固定单条或者多条内容，如：”http://www.aaa.com“，只有该域名可以访问我们的跨域资源。 
         * allowedHeaders：允许所有的请求header访问，可以自定义设置任意请求头信息。
        *@Param: [registry]
        *@return: void
        *@Author: your name
        *@date: 2019/5/15
        */
    public void addCorsMappings(CorsRegistry registry) {
        registry.addMapping("/**")
                .allowedMethods("*")
                .allowedOrigins("*")
                .allowedHeaders("*")
               .allowCredentials(true)
                .maxAge(3600);


    }












}
