package com.sx.ybj.service.note.active;


import com.sx.ybj.pojo.Activity;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.utils.YbjResult;

import java.util.List;

/**
 * @program: ybj
 * @description: 活动事物
 * @author: lwx
 * @create: 2019-05-24 19:35
 */
public interface ActiveService {
    /**
     * 查看活动主题
     * @return
     */
    List<Activity> getActivity();//查看活动主题

    /**
     * 查看活动
     * @param activityId
     * @return
     */
    List<Notebook> getActivityById(int activityId);//查看活动

    /**
     * 参加活动
     * @param notebookId
     * @param activity_id
     * @return
     */
    YbjResult joinActivity(int notebookId,int activity_id);//参加活动


}