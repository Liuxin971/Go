package com.sx.ybj.service.nb.Impl;
import com.sx.ybj.mapper.CategorizeMapper;
import com.sx.ybj.mapper.CollectMapper;
import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.pojo.*;
import com.sx.ybj.service.nb.NoteBookService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * @program: ybj
 * @description: 笔记本事务
 * @author: lwx
 * @create: 2019-05-17 19:19
 */
@Service
//@CacheConfig(cacheNames="category")
public class NoteBookServiceImpl implements NoteBookService {
    @Autowired
    CategorizeMapper categorizeMapper;
    @Autowired
    NotebookMapper notebookMapper;
   @Autowired
   CollectMapper collectMapper;


    @Override
    public YbjResult deleteNotebook(int categorizeId) {
        try {

            NotebookExample notebookExample=new NotebookExample();
            NotebookExample.Criteria criteria=notebookExample.createCriteria();
            criteria.andCategorizeIdEqualTo(categorizeId).andNotebookStateEqualTo(1);
            List<Notebook> notebooks=notebookMapper.selectByExample(notebookExample);
            if (!notebooks.isEmpty()){
                return YbjResult.build(0,"no","笔记本下面有笔记,删除失败 ");
            }
            Categorize categorize=categorizeMapper.selectByPrimaryKey(categorizeId);
            if (categorize.getCategorizeName().equals("默认笔记")){
                return YbjResult.build(0,"no","不能删除默认笔记");
            }

           //判断回收站是否有笔记,没有的话失败
            NotebookExample notebookExample1=new NotebookExample();
            NotebookExample.Criteria criteria2=notebookExample1.createCriteria();
            criteria2.andCategorizeIdEqualTo(categorizeId).andNotebookStateEqualTo(0);
            List<Notebook> notebooks3=notebookMapper.selectByExample(notebookExample1);
            if (notebooks3.isEmpty()){
                categorizeMapper.deleteByPrimaryKey(categorizeId);
              return YbjResult.build(1,"彻底删除成功");
            }

            categorize.setCategorizeState(0);
            return  YbjResult.ok(  categorizeMapper.updateByPrimaryKeySelective(categorize));
        } catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }
    }
    //查询笔记自己的笔记本是否被自己收藏
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
    public  List<ShareData>  getNotesByNoteBookId(int categorizeId) {

            //根据ID查询未收藏笔记
            NotebookExample notebookExample=new NotebookExample();
            NotebookExample.Criteria criteria=notebookExample.createCriteria();
            //状态、笔记本id、用户id
            List<ShareData> shareDatas=new ArrayList<>();
            criteria.andCategorizeIdEqualTo(categorizeId).andNotebookStateEqualTo(1).andUserIdEqualTo(Util.getCurrentUser().getUserId());
            List<Notebook> notebooks=notebookMapper.selectByExample(notebookExample);
            //设置状态
            for (Notebook notebook:notebooks){
                ShareData shareData=new ShareData();
                shareData.setNotebook(notebook);
                shareData.setState(sc(notebook.getUserId(),notebook.getNotebookId(),categorizeId));
                shareDatas.add(shareData);
            }

        //   查询笔记本下收藏的笔记
            CollectExample collectExample=new CollectExample();
            CollectExample.Criteria criteria1=collectExample.createCriteria();
            criteria1.andUserIdEqualTo(Util.getCurrentUser().getUserId()).andCategorizeIdEqualTo(categorizeId);
            List<Collect> collects=collectMapper.selectByExample(collectExample);

            for (Collect collect:collects){//添加到
                ShareData shareData=new ShareData();
                Notebook notebook=notebookMapper.selectByPrimaryKey(collect.getNotebookId());
                if (notebook.getUserId()!=Util.getCurrentUser().getUserId()&&notebook.getNotebookState()!=0)  //如果不是收藏自己的就添加，防止重复
                {
                    shareData.setNotebook(notebook);
                    shareData.setState(1);
                    shareDatas.add(shareData);
                }


            }

           return shareDatas;


    }
    @Override
//    @CacheEvict(allEntries=true)
    public Categorize updateCatelog(Categorize categorize) {

            CategorizeExample categorizeExample = new CategorizeExample();
            CategorizeExample.Criteria criteria = categorizeExample.createCriteria();
            criteria.andCategorizeIdEqualTo(categorize.getCategorizeId());
            categorizeMapper.updateByExampleSelective(categorize,categorizeExample);
            return  categorizeMapper.selectByPrimaryKey(categorize.getCategorizeId());

    }

//    @Override
//    public List<Categorize> searchNoteBook(int userId) {
//        try {
//            CategorizeExample categorizeExample=new CategorizeExample();
//            CategorizeExample.Criteria criteria=categorizeExample.createCriteria();
//            criteria.andUserIdEqualTo(userId);
//            return YbjResult.ok(categorizeMapper.selectByExample(categorizeExample));
//        } catch (Exception e) {
//            return YbjResult.build(500, "异常", ExceptionUtil.getStackTrace(e));
//        }
//
//
//    }


    @Override
//    @Cacheable(key="'category '+#userId")
    public List<Categorize> searchNoteBook(int userId) {
        CategorizeExample categorizeExample=new CategorizeExample();
            CategorizeExample.Criteria criteria=categorizeExample.createCriteria();
            criteria.andUserIdEqualTo(userId).andCategorizeStateEqualTo(1);
            return categorizeMapper.selectByExample(categorizeExample);
    }

    @Override
    public YbjResult createBook(int userId, String categorizeName) {

        try {
            //判断用户名是否重复
            CategorizeExample categorizeExample=new CategorizeExample();
            CategorizeExample.Criteria criteria=categorizeExample.createCriteria();
            criteria.andCategorizeNameEqualTo(categorizeName).andUserIdEqualTo(userId);
            if (!categorizeMapper.selectByExample(categorizeExample).isEmpty()){
                return YbjResult.build(0,"笔记本名字重复");
            }

            //创建笔记本
            Categorize categorize = new Categorize();
            categorize.setCategorizeName(categorizeName);
            categorize.setUserId(userId);
            categorize.setCategorizeState(1);
            categorizeMapper.insert(categorize);






            return YbjResult.ok(categorize);
        } catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }


    }
}