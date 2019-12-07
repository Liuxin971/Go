package com.sx.ybj.utils;


import com.sx.ybj.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.security.core.context.SecurityContextHolder;

/**
 * Created by sang on 2017/12/20.
 * 获取用户信息
 */
public class Util {
    public static User getCurrentUser() {
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();//获取用户昵称
        System.out.println(user.toString());
        return user;
    }

}
