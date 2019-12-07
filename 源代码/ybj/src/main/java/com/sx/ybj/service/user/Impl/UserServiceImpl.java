package com.sx.ybj.service.user.Impl;

import com.sx.ybj.mapper.*;

import com.sx.ybj.pojo.*;
import com.sx.ybj.service.nb.NoteBookService;
import com.sx.ybj.service.user.UserInfoService;
import com.sx.ybj.service.user.UserService;
import com.sx.ybj.utils.*;
//import org.apache.catalina.servlet4preview.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequest;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.DigestUtils;
import javax.servlet.http.HttpServletResponse;
import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * @program: ybj
 * @description: 用户信息
 * @author: lwx
 * @create: 2019-05-16 19:04
 */
@Service
@Transactional
public class UserServiceImpl implements UserService{

@Autowired
      UserMapper userMapper;
@Autowired
    Roles_userMapper roles_userMapper;
@Autowired
    NoteBookService noteBookService;
@Autowired
    JavaMailSenderImpl javaMailSender;
@Autowired
    StringRedisTemplate stringRedisTemplate;
@Autowired
    FeedbackMapper feedbackMapper;
    @Autowired
    UserInfoService userInfoService;
    @Autowired
    RolesMapper_1 rolesMapper;

    @Override
    public YbjResult sendCode(String email) {
        try {
            SimpleMailMessage mailMessage=new SimpleMailMessage();
            //邮件
            String code=generateWord();
            //加入缓存
            stringRedisTemplate.opsForValue().set("code_"+email,code,100, TimeUnit.SECONDS);
            mailMessage.setSubject("springboot");
            mailMessage.setText(code);
            mailMessage.setTo(email);
            mailMessage.setFrom("1747613113@qq.com");
            javaMailSender.send(mailMessage);
            return YbjResult.ok();
        } catch (MailException e) {
           return  YbjResult.build(0,"发送失败");
        }
    }

    public String generateWord(){
        String[] beforeShuffle=new String[]{
                "0","1","2","3","4","5","6","7","8","9"
        };
        List list= Arrays.asList(beforeShuffle);// //将数组转成List
        Collections.shuffle(list);
        StringBuffer sb=new StringBuffer();
        for (int i=0;i<list.size();i++){
            sb.append(list.get(i));
        }
        String afterShuffele=sb.toString();
        String result=afterShuffele.substring(5,9);
        return  result;
    }

    @Override
    public User getUserInfo() {
           User user=userMapper.selectByPrimaryKey(Util.getCurrentUser().getUserId());
           user.setPassword("");
        return user;
    }

    @Override
    public Integer addFeedBack(Feedback feedback) {
        feedback.setFeedbackAdmin(0);
        feedback.setFeedbackCreate(new Date());
        feedback.setUserId(Util.getCurrentUser().getUserId());
        return feedbackMapper.insert(feedback);
    }

    @Override
    public YbjResult getUserByToken(String token) {

            // TODO Auto-generated method stub
            String json=stringRedisTemplate.opsForValue().get("USER_TOKEN_KEY" + ":" + token);
            //判断是否有查询到
            if(StringUtils.isBlank(json))
                return YbjResult.build(400, "用户session已经过期");
            User u=JsonUtils.jsonToPojo(json,User.class);
//            stringRedisTemplate.opsForValue().set("USER_TOKEN_KEY" + ":" + token,json,1000);
            return YbjResult.ok(u);

    }

    @Override
    public User getUserByToken(HttpServletRequest request, HttpServletResponse response) {
        try {
            String token=CookieUtils.getCookieValue(request,"token");
            if(StringUtils.isBlank(token)){
                return null;
            }
           YbjResult data=this.getUserByToken(token);
            if(data.getStatus()!=1){
                return null;
            }

            return (User) data.getData();
        }

        catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
            return null;
        }


    }

    @Override
    public YbjResult login(HttpServletRequest request, HttpServletResponse response, String username, String password) {
        try {
            UserExample userExample=new UserExample();
            UserExample.Criteria criteria= userExample.createCriteria();
            criteria.andUsernameEqualTo(username);
            List<User> list = userMapper.selectByExample(userExample);
            if (null == list || list.isEmpty()) {
                return YbjResult.build(0,"用户名不存在");
            }
          //  核对密码
            User user = list.get(0);
            if (!DigestUtils.md5DigestAsHex(password.getBytes()).equals(user.getPassword())) {
                return YbjResult.build(0,"密码错误");
            }



            //登录成功，把用户信息写入redis
            //生成一个用户token
            user.setPassword(null);
            String token = UUID.randomUUID().toString();
//        redis.set("USER_TOKEN_KEY"+ ":" + token, JsonUtils.objectToJson(user));
            stringRedisTemplate.opsForValue().set("USER_TOKEN_KEY"+ ":" + token, JsonUtils.objectToJson(user),3000,TimeUnit.SECONDS);
            //设置session过期时间
//        redis.exprie("USER_TOKEN_KEY" + ":" + token,1000);
            CookieUtils.setCookie(request, response, "token", token);
            return YbjResult.ok(token);
        } catch (Exception e) {
            return YbjResult.build(0,"异常",ExceptionUtil.getStackTrace(e));
        }
    }

    @Override
    public List<Feedback> getFeedBack() {
        FeedbackExample feedbackExample=new FeedbackExample();
        FeedbackExample.Criteria criteria= feedbackExample.createCriteria();
        criteria.andUserIdEqualTo(Util.getCurrentUser().getUserId()).andFeedbackAdminEqualTo(1);
        List<Feedback> feedbacks =feedbackMapper.selectByExample(feedbackExample);
        List<Feedback> feedbacks1=new ArrayList<>();
        Date date1=new Date();
        for (Feedback feedback:feedbacks){
            long day=(date1.getTime()-feedback.getFeedbackCreate().getTime()+1000000)/(60*60*24*1000);
            if (day<=3)
                feedbacks1.add(feedback);

        }
        return feedbacks1;
    }

    @Override
    public Integer updatePwdWL(String password, String userEmail, String code, HttpServletRequest request) {
       String code1= stringRedisTemplate.opsForValue().get("code_"+userEmail);
        if (!code.equals(code1))
            return  0;
        UserExample userExample=new UserExample();
        UserExample.Criteria criteria=userExample.createCriteria();
        criteria.andUserEmailEqualTo(userEmail);
        User user=userMapper.selectByExample(userExample).get(0);
        user.setPassword(DigestUtils.md5DigestAsHex(password.toString().getBytes()));
        return  userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public Integer updatePwd(String password) {
        User user=userMapper.selectByPrimaryKey(Util.getCurrentUser().getUserId());
        user.setPassword(DigestUtils.md5DigestAsHex(password.toString().getBytes()));
         return userMapper.updateByPrimaryKeySelective(user);
    }

    @Override
    public User updateUser(User user) {
        user.setUserRegdate(new Date());
        userMapper.updateByPrimaryKeySelective(user);
        return userMapper.selectByPrimaryKey(Util.getCurrentUser().getUserId());
    }

    @Override
    public YbjResult reg(User user,String Code) {

        try {
            UserExample userExample = new UserExample();
            UserExample.Criteria criteria = userExample.createCriteria();
            criteria.andUsernameEqualTo(user.getUsername());
            List<User> users = userMapper.selectByExample(userExample);
            if (!users.isEmpty()) {
                return YbjResult.build(0, "用户名已存在");
            }
            //验证验证码
            if (!Code.equals(stringRedisTemplate.opsForValue().get("code_"+user.getUserEmail()))){
                return YbjResult.build(0, "验证码错误");
            }


            user.setPassword(DigestUtils.md5DigestAsHex(user.getPassword().getBytes()));  //插入用户,插入之前先对密码进行加密
            user.setUserRegdate(new Date());
            user.setUserNickname("ran");
            user.setUserPicture("http://106.14.145.180:8081/note/uploaded/1560179087701b.jpg");
            user.setEnabled("1");
            userMapper.insert(user);

            //设置默认角色用户角色
           criteria.andUsernameEqualTo(user.getUsername());
           List<User> users1=userMapper.selectByExample(userExample);
           Roles_user roles_user=new Roles_user();
           roles_user.setUid(users1.get(0).getUserId());
           roles_user.setRid(2);
           roles_userMapper.insert(roles_user);
           //插入默认笔记
            noteBookService.createBook(users1.get(0).getUserId(),"默认笔记");
//            //默认收藏文件夹
//            noteBookService.createBook(users1.get(0).getUserId(),"我的文件夹");
           return YbjResult.ok();
        } catch (Exception e) {
          return   YbjResult.build(0, "注册失败", ExceptionUtil.getStackTrace(e));
        }

    }
}