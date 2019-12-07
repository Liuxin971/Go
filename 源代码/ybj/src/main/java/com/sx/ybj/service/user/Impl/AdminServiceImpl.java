package com.sx.ybj.service.user.Impl;

import com.sx.ybj.mapper.FeedbackMapper;
import com.sx.ybj.mapper.UserMapper;
import com.sx.ybj.pojo.Feedback;
import com.sx.ybj.pojo.FeedbackExample;
import com.sx.ybj.pojo.User;
import com.sx.ybj.service.user.AdminService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

/**
 * @program: ybj
 * @description: 管理员
 * @author: lwx
 * @create: 2019-05-31 10:16
 */
@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    UserMapper userMapper;
@Autowired
    FeedbackMapper feedbackMapper;

    @Override
    public Integer replyFeedback(Feedback feedback) {
            feedback.setFeedbackAdmin(1);
            feedback.setFeedbackCreate(new Date());
            return feedbackMapper.insert(feedback);



    }

    @Override
    public List<Feedback> getFeedBack() {
        FeedbackExample feedbackExample=new FeedbackExample();
        FeedbackExample.Criteria criteria=feedbackExample.createCriteria();
        criteria.andFeedbackAdminEqualTo(0);
        return feedbackMapper.selectByExample(feedbackExample);
    }

    @Override
    public List<User> getAllUser() {
          return userMapper.selectByExample(null);
    }

    @Override
    public Integer userControl(User user) {
           User user1=userMapper.selectByPrimaryKey(user.getUserId());
           if (user1.isEnabled()){
               user1.setEnabled("0");
           }else {
               user1.setEnabled("1");
           }
           return userMapper.updateByPrimaryKeySelective(user1);




    }
}