package com.sx.ybj.controller.user;


import com.sx.ybj.mapper.FeedbackMapper;
import com.sx.ybj.pojo.Feedback;

import com.sx.ybj.service.note.note.FeedbackImpl;
import com.sx.ybj.service.user.UserInfoService;
import com.sx.ybj.service.user.UserService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.YbjResult;
import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import com.sx.ybj.pojo.User;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * @program: ybj
 * @description: 用户信息
 * @author: lwx
 * @create: 2019-05-16 18:58
 */
@RestController
@RequestMapping("/user")
public class UserInfoController {

    @Autowired
    UserService userService;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    FeedbackMapper feedbackMapper;
    @Autowired
    FeedbackImpl feedbackImpl;
    @PostMapping("/reg")
 public YbjResult reg(User user,String Code){
        return  userService.reg(user,Code);
 }

   @GetMapping("/getUserInfo")
    public YbjResult getUser(){

       try {
           return  YbjResult.ok(userService.getUserInfo());
       } catch (Exception e) {
          return  YbjResult.build(0,"获取用户信息失败", ExceptionUtil.getStackTrace(e));
       }
   }
 @GetMapping("/getCode")
    public YbjResult getCode(String email){
        return userService.sendCode(email);
 }
 @GetMapping("/updatePwdWL")
    public  YbjResult updatePwdWL(String password, String userEmail, String code, HttpServletRequest request){
     try {
         int i= userService.updatePwdWL(password,userEmail,code,request);
         if (i==0)
             return YbjResult.build(0,"重置密码失败");
         return YbjResult.ok(i);
     } catch (Exception e) {
        return YbjResult.build(0,"重置密码失败",ExceptionUtil.getStackTrace(e));
     }

 }

    @GetMapping("/addFeedback")
    public  YbjResult addFeedback(Feedback feedback){
        try {
            int i=userService.addFeedBack(feedback);
            if (i==0)
                return YbjResult.build(0,"反馈失败");
            return  YbjResult.ok();
        } catch (Exception e) {
          return  YbjResult.build(0,"异常",ExceptionUtil.getStackTrace(e));
        }
    }

@GetMapping("/updatePwd")
    public  YbjResult updatePwd(String password){
    try {
        return YbjResult.ok(userService.updatePwd(password));
    } catch (Exception e) {
       return  YbjResult.build(0,"重置密码失败",ExceptionUtil.getStackTrace(e));
    }
}

    @GetMapping("/updateUser")
    public  YbjResult updateUser(User user){
        try {
            return YbjResult.ok(userService.updateUser(user));
        } catch (Exception e) {
            return  YbjResult.build(0,"修改失败",ExceptionUtil.getStackTrace(e));
        }
    }


    @GetMapping("/getFeedBack")
    public  YbjResult getFeedBack(){
        try {
            return YbjResult.ok(userService.getFeedBack());
        } catch (Exception e) {
            return  YbjResult.build(0,"异常",ExceptionUtil.getStackTrace(e));
        }
    }







    @GetMapping("/userLogin")
    public  YbjResult userLogin(HttpServletRequest request, HttpServletResponse response,String username,String password){
            return  userService.login(request,response,username,password);
    }

    @GetMapping("/getUserByToken")
    public YbjResult getUserByToken(HttpServletRequest request, HttpServletResponse response){

        try {
            return  YbjResult.ok(userService.getUserByToken(request,response));
        } catch (Exception e) {
            return  YbjResult.build(0,"异常",ExceptionUtil.getStackTrace(e));
        }

    }

    @GetMapping("/checkInfo")
    public YbjResult checkInfo(String value,String type) throws  Exception{

        return  userInfoService.checkInfo(value,type);

    }


}