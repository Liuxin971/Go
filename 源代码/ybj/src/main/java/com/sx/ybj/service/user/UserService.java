package com.sx.ybj.service.user;
import com.sx.ybj.pojo.Feedback;
import  com.sx.ybj.pojo.User;
import com.sx.ybj.utils.YbjResult;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;


/**
 * @program: ybj
 * @description: 用户信息
 * @author: lwx
 * @create: 2019-05-16 19:04
 */
public interface UserService {
   YbjResult reg(User user,String Code);//用户注册
   User getUserInfo();//获取用户信息

   /**
    * 重置密码
    * @param password
    * @return
    */
   Integer updatePwd(String password);

   /**
    * 未登录状态下重置密码
    * @param password
    * @param userEmail
    * @param code
    * @param request
    * @return
    */
   Integer updatePwdWL(String password, String userEmail, String code, HttpServletRequest request);

   /**
    * 发送验证码
    * @param email
    * @return
    */

   YbjResult sendCode(String email);

   /**
    *  反馈信息给管理员
    * @param feedback
    * @return
    */
   Integer   addFeedBack(Feedback feedback);

   /**
    * 得到反馈
    * @return
    */
   List<Feedback> getFeedBack();

   /**
    *   登录
    * @param request
    * @param response
    * @param username
    * @param password
    * @return
    */
   YbjResult login(HttpServletRequest request, HttpServletResponse response,String username, String password);

   /**
    * 获得用户信息
    * @param request
    * @param response
    * @return
    */
   User getUserByToken(HttpServletRequest request, HttpServletResponse response);
   YbjResult getUserByToken(String token);

   /**
    * 修改用户
    * @param user
    * @return
    */
   User updateUser(User user);

}