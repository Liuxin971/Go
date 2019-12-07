package com.sx.ybj.service.note.note.Impl;

import com.sx.ybj.mapper.CategorizeMapper;
import com.sx.ybj.mapper.CollectMapper;
import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.pojo.*;
import com.sx.ybj.service.note.note.NoteService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class NoteServiceImpl implements NoteService {
    @Autowired
    NotebookMapper notebookMapper;
@Autowired
    CategorizeMapper categorizeMapper;
@Autowired
    CollectMapper collectMapper;
    @Override
    public List<ShareData> getNewNote(int userId) {
       Date date1=new Date();
        NotebookExample notebookExample=new NotebookExample();
        NotebookExample.Criteria criteria= notebookExample.createCriteria();
        //用户名、笔记状态
        criteria.andUserIdEqualTo(userId).andNotebookStateEqualTo(1);
        List<Notebook> notebooks= notebookMapper.selectByExample(notebookExample);
        List<Notebook> notebooks1=new ArrayList<>();
        for (Notebook notebook:notebooks){
            long day=(date1.getTime()-notebook.getNotebookModfiy().getTime()+1000000)/(60*60*24*1000);//找出最近十天的笔记
            if (day<=10)
                notebooks1.add(notebook);
        }
        //按照修改时间排序
        List<Notebook> notebooks2=new ArrayList<>();
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        notebooks1.stream().sorted((n1,n2)->(n1.getNotebookModfiy().getTime()>n2.getNotebookModfiy().getTime()?-1:1)).forEach(notebook ->notebooks2.add(notebook));
//        notebooks1.stream().forEach(notebook -> System.out.println(simpleDateFormat.format(notebook.getNotebookModfiy())));
         List<ShareData> shareDatas=new ArrayList<>();
         for (Notebook notebook:notebooks2){
             ShareData shareData=new ShareData();
             shareData.setState(sc(Util.getCurrentUser().getUserId(),notebook.getNotebookId(),notebook.getCategorizeId()));
             shareData.setNotebook(notebook);
             shareDatas.add(shareData);
         }
        return shareDatas;
      }

    //查询笔记自己的笔记是否被自己收藏
    public  int  sc(int userId,int notebookId,int categorizeId){
        try {
            CollectExample collectExample=new CollectExample();
            CollectExample.Criteria criteria=collectExample.createCriteria();
            //userId、notebookId
            criteria.andUserIdEqualTo(userId).andNotebookIdEqualTo(notebookId).andCategorizeIdEqualTo(categorizeId);
            Collect collect1=collectMapper.selectByExample(collectExample).get(0);
            if (!collect1.getUserId().toString().isEmpty()){
                return 1;
            }

        } catch (Exception e) {
        }

        return  0;
    }





    @Override
    public Integer addNotebookAccess(int notebookId) {
        Notebook notebook= notebookMapper.selectByPrimaryKey(notebookId);
        notebook.setNotebookAccess(notebook.getNotebookAccess()+1);
        return   notebookMapper.updateByPrimaryKeySelective(notebook);

    }
    @Override
    public Notebook createNote(Notebook notebook) {
        //如果为空创建默认笔记
          if (notebook.getCategorizeId()==null){
              CategorizeExample categorizeExample=new CategorizeExample();
              CategorizeExample.Criteria criteria=categorizeExample.createCriteria();
              criteria.andUserIdEqualTo(Util.getCurrentUser().getUserId())
                      .andCategorizeNameEqualTo("默认笔记");
              int id=categorizeMapper.selectByExample(categorizeExample).get(0).getCategorizeId();
              notebook.setCategorizeId(id);
          }//创建笔记本
           notebook.setUserId(Util.getCurrentUser().getUserId());
            notebook.setNotebookModfiy(new Date());
            notebook.setNotebookRegdate(new Date());
            notebook.setNotebookState(1);
            notebook.setNotebookSharing(0);
            notebook.setNotebookAccess(0);
            notebook.setNotebookCollect(0);
            notebookMapper.insert(notebook);

           return notebook;

    }

    @Override
    public Notebook getOneShareNote(int notebookId) {
        NotebookExample notebookExample=new NotebookExample();
        NotebookExample.Criteria criteria= notebookExample.createCriteria();
        criteria.andNotebookSharingEqualTo(1).andNotebookIdEqualTo(notebookId).andNotebookStateEqualTo(1);
        return notebookMapper.selectByExample(notebookExample).get(0);
    }

    @Override
    public Notebook getNotebook(int notebookId) {

        Notebook notebook= notebookMapper.selectByPrimaryKey(notebookId);
        if (notebook.getNotebookState()==1){
            return  notebook;
        }
        else {
            return  null;
        }
    }

    @Override
    public Integer deleteNote(int notebookId) {

            Notebook notebook=new Notebook();
            notebook.setNotebookState(0);
            notebook.setNotebookId(notebookId);
         return    notebookMapper.updateByPrimaryKeySelective(notebook);

    }

    @Override
    public Notebook updateNote(Notebook notebook) {
        notebook.setNotebookModfiy(new Date());
        notebookMapper.updateByPrimaryKeySelective(notebook);
        return notebookMapper.selectByPrimaryKey(notebook.getNotebookId());
    }

}
