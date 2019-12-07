package com.sx.ybj.service.note.recycle;

import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.utils.YbjResult;

import java.util.List;

public interface RecycleBinService {

    /**
     * 查看回收站笔记
     * @param userId
     * @return
     */
    List<Notebook> getBin(int userId); //查看回收站笔记

    /**
     * 恢复笔记
     * @param notebookId
     * @return
     */
    YbjResult recoverNote(int notebookId);//恢复笔记

    /**
     * 彻底单个删除
     * @param notebookId
     * @return
     */
    YbjResult cDeleteNotebook(int notebookId);//彻底删除






    /**
     *  恢复全部笔记
     * @return
     */
    Integer   recoverAllNote();

    /**
     *   删除全部笔记
     * @return
     */
    Integer  binDelNote();



}
