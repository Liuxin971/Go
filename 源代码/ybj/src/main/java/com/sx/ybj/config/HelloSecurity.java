package com.sx.ybj.config;


import com.sx.ybj.service.UserService;
import com.sx.ybj.utils.JsonUtils;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.security.web.authentication.AuthenticationFailureHandler;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.util.DigestUtils;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


@Configuration
@EnableWebSecurity
@Order(-1)
public class HelloSecurity extends WebSecurityConfigurerAdapter {
    @Autowired
    UserService userService;
   @Autowired
   com.sx.ybj.service.user.UserService userServices;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        System.out.println("运行第二个程序");
        http.headers().frameOptions().disable();
        //请求权限配置
        http.authorizeRequests()
        //指定了/login不需要任何认证就可以访问，
        .antMatchers("/alogin","/mng","/user/checkInfo","/user/getOneShareNote/*","/user/login","/user/reg","/user/findShareNote","/user/updatePwdWL","/user/getCode","/home","/getOneShareNotes/*").permitAll()
         .antMatchers("/hello","/admin/*").hasRole("超级管理员")
        //任何请求，登录后方可访问。
        .anyRequest().authenticated()
        //登陆界面参数
//        .and().formLogin().loginPage("/login").permitAll()
                .and().formLogin().loginProcessingUrl("/user/login").permitAll().successHandler(new AuthenticationSuccessHandler() {
            @Override
            public void onAuthenticationSuccess(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Authentication authentication) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
               // out.write("{\"status\":\"1\",\"msg\":\"登录成功\"}");
               if (userServices.getFeedBack().size()>0&&userServices.getFeedBack()!=null)
                   out.write(JsonUtils.objectToJson(YbjResult.ok(userServices.getFeedBack().get(0))));
              else
                   out.write("{\"status\":\"1\",\"msg\":\"登录成功\"}");
                out.flush();
                out.close();
            }
        }).failureHandler(new AuthenticationFailureHandler() {
            @Override
            public void onAuthenticationFailure(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, AuthenticationException e) throws IOException, ServletException {
                httpServletResponse.setContentType("application/json;charset=utf-8");
                PrintWriter out = httpServletResponse.getWriter();
                out.write("{\"status\":\"error\",\"msg\":\"登录失败\"}");
                out.flush();
                out.close();
            }
        })

                //设置注销成功后跳转页面，默认是跳转到登录页面
                .and().logout()
                //权限访问失败界面，关键，如果不定义的话会抛出异常
                .and().exceptionHandling().accessDeniedPage("/").and().cors().and().csrf().disable();


       // http.cors().configurationSource(CorsConfigurationSource());
    }

//    private CorsConfigurationSource CorsConfigurationSource() {
//        CorsConfigurationSource source =   new UrlBasedCorsConfigurationSource();
//        CorsConfiguration corsConfiguration = new CorsConfiguration();
//        corsConfiguration.addAllowedOrigin("http://localhost:8080");	//同源配置，*表示任何请求都视为同源，若需指定ip和端口可以改为如“localhost：8080”，多个以“，”分隔；
//        corsConfiguration.addAllowedHeader("*");//header，允许哪些header，本案中使用的是token，此处可将*替换为token；
//        corsConfiguration.addAllowedMethod("*");	//允许的请求方法，PSOT、GET等
//        ((UrlBasedCorsConfigurationSource) source).registerCorsConfiguration("/**",corsConfiguration); //配置允许跨域访问的url
//        return source;
//    }
    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        System.out.println("不用测试了这里程序运行第一个进入");
        auth.userDetailsService(userService)
                .passwordEncoder(new PasswordEncoder() {
                    @Override
                    public String encode(CharSequence charSequence) {
                        return DigestUtils.md5DigestAsHex(charSequence.toString().getBytes());
                    }

                    @Override
                    public boolean matches(CharSequence charSequence, String s) {
                        System.out.println(s+"....."+(String)charSequence);
                        System.out.println(s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes())));
                        return s.equals(DigestUtils.md5DigestAsHex(charSequence.toString().getBytes()));
                    }
                });
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/static/**","/index.html");
    }

    @Bean
    AccessDeniedHandler getAccessDeniedHandler() {
        return new AuthenticationAccessDeniedHandler();
    }





}
