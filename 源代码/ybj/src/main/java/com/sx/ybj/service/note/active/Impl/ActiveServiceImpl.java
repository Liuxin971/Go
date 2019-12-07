package com.sx.ybj.service.note.active.Impl;

import com.sx.ybj.mapper.ActivityMapper;
import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.pojo.Activity;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.NotebookExample;
import com.sx.ybj.service.note.active.ActiveService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


/**
 * @program: ybj
 * @description: 活动事物
 * @author: lwx
 * @create: 2019-05-24 19:40
 */
@Service
public class ActiveServiceImpl implements ActiveService {
   @Autowired
    ActivityMapper activityMapper;
   @Autowired
   NotebookMapper notebookMapper;

    @Override
    public YbjResult joinActivity(int notebookId,int activity_id) {
        try {
            Notebook notebook=new Notebook();
            notebook.setNotebookActivityNote(activity_id);
            NotebookExample notebookExample=new NotebookExample();
            NotebookExample.Criteria criteria=notebookExample.createCriteria();
            criteria.andNotebookIdEqualTo(notebookId);
            notebookMapper.updateByExampleSelective(notebook,notebookExample);
            return YbjResult.ok();
        } catch (Exception e) {
            return YbjResult.build(500, "异常", ExceptionUtil.getStackTrace(e));

        }
    }

    @Override
    public List<Notebook> getActivityById(int activityId) {
            NotebookExample notebookExample=new NotebookExample();
        NotebookExample.Criteria criteria=notebookExample.createCriteria();
        criteria.andNotebookActivityNoteEqualTo(activityId);
        return  notebookMapper.selectByExample(notebookExample);
//            Activity activities=activityMapper.selectByPrimaryKey(activityId);
//            return notebookMapper.selectByPrimaryKey(activities.getNotebookId());

    }

    @Override
    public List<Activity> getActivity() {
        System.out.println(activityMapper.selectByExample(null).get(0).getActivityContent());
                   return activityMapper.selectByExample(null);

    }
}