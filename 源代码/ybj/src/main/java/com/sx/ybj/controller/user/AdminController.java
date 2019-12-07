package com.sx.ybj.controller.user;

import com.sx.ybj.mapper.FeedbackMapper;
import com.sx.ybj.pojo.Feedback;
import com.sx.ybj.pojo.User;
import com.sx.ybj.service.note.note.FeedbackImpl;
import com.sx.ybj.service.user.AdminService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @program: ybj
 * @description: admin
 * @author: lwx
 * @create: 2019-05-31 10:28
 */
@RestController
@RequestMapping("/admin")
public class AdminController {
    @Autowired
    AdminService adminService;
    @Autowired
    FeedbackMapper feedbackMapper;
    @Autowired
    FeedbackImpl feedbackImpl;
    @GetMapping("/userControl")
    public YbjResult userController(User user){
        try {
            return YbjResult.ok(adminService.userControl(user));
        } catch (Exception e) {
            return  YbjResult.build(0,"更新用户状态失败", ExceptionUtil.getStackTrace(e));
        }

    }
    @GetMapping("/getFeedBack")
    public YbjResult getFeedBack(){
        try {
            return YbjResult.ok(adminService.getFeedBack());
        } catch (Exception e) {
          return  YbjResult.build(0,"获取信息失败", ExceptionUtil.getStackTrace(e));
        }
    }
    @GetMapping("/replyFeedback")
    public  YbjResult replyFeedback(Feedback feedback){

        try {
            return  YbjResult.ok(adminService.replyFeedback(feedback));
        } catch (Exception e) {
            return   YbjResult.build(0,"反馈失败",ExceptionUtil.getStackTrace(e));
        }

    }

    @GetMapping("/getAllUser")
    public  YbjResult getAllUser(){

        try {
            return  YbjResult.ok(adminService.getAllUser());
        } catch (Exception e) {
            return   YbjResult.build(0,"获取信息失败失败",ExceptionUtil.getStackTrace(e));
        }

    }


    @GetMapping("/searchFeedback")
    public YbjResult serarchFeedback(String content){
        try {
            List<Feedback> feedbacks=feedbackMapper.selectByExample(null);
            for (Feedback feedback:feedbacks){
                feedbackImpl.index(feedback);
            }
            return YbjResult.ok(feedbackImpl.findByFeedbackContentLikeAndFeedbackAdminEquals(content,0));
        } catch (Exception e) {
            return YbjResult.build(0,"失败",ExceptionUtil.getStackTrace(e));
        }
    }


}