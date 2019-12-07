package com.sx.ybj.controller.note;

import com.sx.ybj.mapper.CollectMapper;
import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.pojo.Collect;
import com.sx.ybj.pojo.CollectExample;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.ShareData;
import com.sx.ybj.service.nb.ElasticsearchNote;
import com.sx.ybj.service.note.note.NoteService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @program: ybj
 * @description:
 * @author: lwx
 * @create: 2019-05-21 23:43
 */
@RestController
@RequestMapping("/user")
public class NoteController {
@Autowired
    NotebookMapper notebookMapper;
    @Autowired
    ElasticsearchNote elasticsearchNote;
    @Autowired
    NoteService noteService;
    @Autowired
    CollectMapper collectMapper;
    @Autowired
    ElasticsearchTemplate elasticsearchTemplate;
    @GetMapping("/getShareNoteByContent")
    public YbjResult test(String content){
        try {
            List<Notebook> notebooks=notebookMapper.selectByExample(null);
            for (Notebook notebook:notebooks){
                String  conten1 = null;
                try {
                    String contents=notebook.getNotebookContent();
                     conten1 = contents.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
                    if (conten1!=null){
                        notebook.setNotebookContent(conten1);
                        elasticsearchNote.index(notebook);
                    }

                } catch (Exception e) {

                }


            }


           List<Notebook> notebooks1= elasticsearchNote.findByNotebookContentLikeAndNotebookSharingEqualsAndNotebookStateEquals(content,1,1);
            List<ShareData> shareData=new ArrayList<>();
            for (Notebook notebook:notebooks1){
                try {
                    Notebook notebook1=notebookMapper.selectByPrimaryKey(notebook.getNotebookId());
                    ShareData shareData1=new ShareData();
                    if (notebook1.getNotebookId()!=null){
                        shareData1.setNotebook(notebook1);
                        shareData1.setState(sc(Util.getCurrentUser().getUserId(),notebook.getNotebookId(),notebook.getCategorizeId()));
                        shareData.add(shareData1);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }

            return  YbjResult.ok(shareData);
        } catch (Exception e) {
            return  YbjResult.build(0,"查询失败", ExceptionUtil.getStackTrace(e));
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

    @GetMapping("/getNewNote")
    public  YbjResult  getNewNote(){


        try {
            return YbjResult.ok(noteService.getNewNote(Util.getCurrentUser().getUserId()));
        } catch (Exception e) {
            return YbjResult.build(0,"获取失败",ExceptionUtil.getStackTrace(e));
        }


    }
@GetMapping("/createNote")
   public  YbjResult createNote(Notebook notebook){
    try {
        return YbjResult.ok(noteService.createNote(notebook));
    } catch (Exception e) {
        return  YbjResult.build(0,"创建失败",ExceptionUtil.getStackTrace(e));
    }
}

    @GetMapping("/addNotebookAccess")
    public YbjResult addNotebookAccess( int notebookId){
        try {
            return  YbjResult.ok(noteService.addNotebookAccess(notebookId));
        } catch (Exception e) {
            return YbjResult.build(0,"访问数量增加失败",ExceptionUtil.getStackTrace(e));
        }
    }

    @GetMapping("/delNote")
    public YbjResult  deleteNote(int notebookId){
        try {
            return YbjResult.ok(noteService.deleteNote(notebookId));
        }catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }
    }

    @GetMapping("/updateNote")
    public YbjResult updateNote(Notebook notebook){
        try {
            notebook.setNotebookModfiy(new Date());
            return YbjResult.ok(noteService.updateNote(notebook));
        }catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }
    }

     @GetMapping("/getOneShareNote/{notebookId}")
    public  YbjResult getOneShareNote(@PathVariable("notebookId") int notebookId){
         try {
             return  YbjResult.ok(noteService.getOneShareNote(notebookId));
         } catch (Exception e) {
             return YbjResult.build(0,"该笔记未被分享",ExceptionUtil.getStackTrace(e));
         }

     }


    @GetMapping("/getNotebookById")
    public  YbjResult getNotebookById(int notebookId){
        try {
            return  YbjResult.ok(noteService.getNotebook(notebookId));
        } catch (Exception e) {
            return YbjResult.build(0,"获取失败",ExceptionUtil.getStackTrace(e));
        }

    }





}