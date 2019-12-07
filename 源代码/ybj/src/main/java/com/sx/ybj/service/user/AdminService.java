package com.sx.ybj.service.user;

import com.sx.ybj.pojo.Feedback;
import com.sx.ybj.pojo.User;


import java.util.List;

/**
 * @program: ybj
 * @description: 管理员事物
 * @author: lwx
 * @create: 2019-05-31 10:14
 */
public interface AdminService {
    /**
     * 用户权限管理
     * @param user
     * @return
     */
    Integer  userControl(User user);

    /**
     * 得到反馈信息
     * @return
     */
    List<Feedback> getFeedBack();

    /**
     * 回复用户反馈
     * @param feedback
     * @return
     */
    Integer replyFeedback(Feedback feedback);

    /**
     * 得到所有用户信息
     * @return
     */
   List<User> getAllUser();
}