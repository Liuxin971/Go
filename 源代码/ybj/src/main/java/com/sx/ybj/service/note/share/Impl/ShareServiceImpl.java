package com.sx.ybj.service.note.share.Impl;

import com.sx.ybj.mapper.CollectMapper;
import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.pojo.*;
import com.sx.ybj.service.note.share.ShareService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * @program: ybj
 * @description: 共享笔记
 * @author: lwx
 * @create: 2019-05-18 10:43
 */
@Service
public class ShareServiceImpl implements ShareService {
    @Autowired
    NotebookMapper notebookMapper;
    @Autowired
    CollectMapper collectMapper;
    @Override
    public List<ShareData> getShareNote() {

            NotebookExample notebookExample=new NotebookExample();
            NotebookExample.Criteria criteria=notebookExample.createCriteria();
            criteria.andNotebookSharingEqualTo(1).andNotebookStateEqualTo(1);
            List<Notebook> notebooks= notebookMapper.selectByExample(notebookExample);//查询到笔记
            //根据笔记id，查询是否被用户收藏,并且标记
           List<ShareData> shareData=new ArrayList<>();
           for (Notebook notebook:notebooks){
               ShareData shareData1=new ShareData();
               shareData1.setNotebook(notebook);
               shareData1.setState(sc(Util.getCurrentUser().getUserId(),notebook.getNotebookId()));
               shareData.add(shareData1);
           }
           return  shareData;


    }

    //查询笔记是否被收藏
    public  int  sc(int userId,int notebookId){
        try {
            CollectExample collectExample=new CollectExample();
            CollectExample.Criteria criteria=collectExample.createCriteria();
            //userId、notebookId
            criteria.andUserIdEqualTo(userId).andNotebookIdEqualTo(notebookId);
            Collect collect1=collectMapper.selectByExample(collectExample).get(0);
            if (!collect1.getUserId().toString().isEmpty()){
                return 1;
            }

        } catch (Exception e) {
        }

        return  0;
    }







    @Override
    public YbjResult delCollectionNote(int collectId) {
        try {
           return YbjResult.ok(collectMapper.deleteByPrimaryKey(collectId));
        } catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }
    }

    @Override
    public YbjResult findCollectionNote(int userId) {
        try {
            CollectExample collectExample=new CollectExample();
            CollectExample.Criteria criteria=collectExample.createCriteria();
            criteria.andUserIdEqualTo(userId);
            List<Collect> collects=collectMapper.selectByExample(collectExample);
            List<Collect> collects1=new ArrayList<>();
            for (Collect collect:collects){
                Notebook notebook=notebookMapper.selectByPrimaryKey(collect.getNotebookId());
                if (notebook.getNotebookState()==1){
                    collects1.add(collect);
                }


            }
            //by用户ID查询收藏的笔记ID
            return YbjResult.ok(collects1);
        } catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }
    }

    @Override
    public List<Notebook> getHotNote() {
        NotebookExample notebookExample=new NotebookExample();
        NotebookExample.Criteria criteria=notebookExample.createCriteria();
        criteria.andNotebookAccessGreaterThanOrEqualTo(99).andNotebookSharingEqualTo(1).andNotebookStateEqualTo(1);
        return  notebookMapper.selectByExample(notebookExample);
    }

    @Override
    public YbjResult collectNote(Collect collect) {

        try {
            CollectExample collectExample=new CollectExample();
            CollectExample.Criteria criteria=collectExample.createCriteria();
            criteria.andUserIdEqualTo(collect.getUserId()).andNotebookIdEqualTo(collect.getNotebookId());
            Collect collect1=collectMapper.selectByExample(collectExample).get(0);
            System.out.println(collect1.getUserId().toString().isEmpty());
            if (!collect1.getUserId().toString().isEmpty()){
                return YbjResult.build(0, "笔记已经存在");
            }
        } catch (Exception e) {
        }

        try {

           collectMapper.insert(collect);
           return YbjResult.ok();
        } catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }
    }
}