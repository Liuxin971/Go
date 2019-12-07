package com.sx.ybj.config;


import com.sx.ybj.service.user.UserService;
import com.sx.ybj.utils.CookieUtils;
import com.sx.ybj.utils.YbjResult;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @program: ybj
 * @description: 用户拦截器
 * @author: lwx
 * @create: 2019-06-03 15:35
 */
public class LoginHandlerInterceptor implements HandlerInterceptor {
   @Autowired
   UserService userService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {


        String token= CookieUtils.getCookieValue(request,"token");
         if(StringUtils.isBlank(token)){
//             response.sendRedirect("http://106.14.145.180:8081/note/login"+"?redirectURL="+request.getRequestURL());
           response.sendRedirect("http://localhost:8081/note/login"+"?redirectURL="+request.getRequestURL());
             return false;
         }
        YbjResult ybjResult=userService.getUserByToken(token);
        System.out.println("开始执行");
        //跳转到首页
        if(ybjResult.getStatus()==0||ybjResult==null){
            response.sendRedirect("http://localhost:8081/note/login"+"?redirectURL="+request.getRequestURL());
            return false;
        }
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, ModelAndView modelAndView) throws Exception {

    }

    @Override
    public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) throws Exception {

    }
}