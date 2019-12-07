package com.sx.ybj.service.nb;


import com.sx.ybj.pojo.Categorize;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.ShareData;
import com.sx.ybj.utils.YbjResult;

import java.util.List;

/**
 * @program: ybj
 * @description: 笔记本事务
 * @author: lwx
 * @create: 2019-05-17 19:15
 */
public interface NoteBookService {
    /**
     * 创建笔记本
     * @param userId
     * @param categorizerName
     * @return
     */
   YbjResult createBook(int userId, String categorizerName);//创建笔记本


//   List<Categorize> searchNoteBook(int userId);

    /**
     * 查询笔记本
     * @param userId
     * @return
     */
    List<Categorize> searchNoteBook(int userId);//查询笔记本

    /**
     *更新笔记本
     * @param categorize
     * @return
     */
    Categorize updateCatelog(Categorize categorize);//更新笔记本

    /**
     *根据笔记本ID查询笔记本下的笔记
     * @param categorizeId
     * @return
     */
   List<ShareData> getNotesByNoteBookId(int categorizeId);//查询笔记本下的笔记

    /**
     *删除笔记本
     * @param categorizeId
     * @return
     */
   YbjResult deleteNotebook(int categorizeId);//删除笔记本



}