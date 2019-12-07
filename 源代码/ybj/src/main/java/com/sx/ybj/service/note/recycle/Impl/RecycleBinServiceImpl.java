package com.sx.ybj.service.note.recycle.Impl;

import com.sx.ybj.mapper.CategorizeMapper;
import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.pojo.Categorize;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.NotebookExample;
import com.sx.ybj.service.note.recycle.RecycleBinService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @program: ybj
 * @description: 回收站
 * @author: lwx
 * @create: 2019-05-18 12:24
 */
@Service
public class RecycleBinServiceImpl implements RecycleBinService {

    @Autowired
    NotebookMapper notebookMapper;
@Autowired
    CategorizeMapper categorizeMapper;
    @Override
    public Integer recoverAllNote() {
        NotebookExample notebookExample=new NotebookExample();
        NotebookExample.Criteria criteria=notebookExample.createCriteria();
        criteria.andNotebookStateEqualTo(0).andUserIdEqualTo(Util.getCurrentUser().getUserId());
       List<Notebook>  notebooks=notebookMapper.selectByExample(notebookExample);
       int i=0;
        for (Notebook notebook:notebooks){
            //恢复全部笔记
            notebook.setNotebookState(1);
            notebookMapper.updateByPrimaryKeySelective(notebook);
            //恢复全部笔记本
            Categorize categorize=categorizeMapper.selectByPrimaryKey(notebook.getCategorizeId());
            categorize.setCategorizeState(1);
            categorizeMapper.updateByPrimaryKeySelective(categorize);

            i++;
       }
        return  i;
    }

    @Override
    public List<Notebook> getBin(int userId) {

            NotebookExample notebookExample=new NotebookExample();
            NotebookExample.Criteria criteria=notebookExample.createCriteria();
            criteria.andUserIdEqualTo(userId).andNotebookStateEqualTo(0);
            return notebookMapper.selectByExample(notebookExample);

    }

    @Override
    public YbjResult recoverNote(int notebookId) {
        try {

            Notebook notebook=notebookMapper.selectByPrimaryKey(notebookId);
            //恢复笔记本
            Categorize categorize=categorizeMapper.selectByPrimaryKey(notebook.getCategorizeId());
            categorize.setCategorizeState(1);
             int i= categorizeMapper.updateByPrimaryKeySelective(categorize);

            //恢复笔记
                  notebook.setNotebookState(1);
            i+=  notebookMapper.updateByPrimaryKeySelective(notebook);
            return YbjResult.ok(i);
        } catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }

    }

    @Override
    public YbjResult cDeleteNotebook(int notebookId) {
        try {
            notebookMapper.deleteByPrimaryKey(notebookId);
            return  YbjResult.ok();
        } catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }
    }


    @Override
    public Integer binDelNote() {
        NotebookExample notebookExample=new NotebookExample();
        NotebookExample.Criteria criteria=notebookExample.createCriteria();
        criteria.andNotebookStateEqualTo(0).andUserIdEqualTo(Util.getCurrentUser().getUserId());
        List<Notebook> notebook1=notebookMapper.selectByExample(notebookExample);
        int i=0;
        for (Notebook notebook:notebook1){
             notebookMapper.deleteByPrimaryKey(notebook.getNotebookId());
//            notebook.setNotebookState(2);
//            notebookMapper.updateByPrimaryKeySelective(notebook);
            i++;
        }
        return i;
    }


}