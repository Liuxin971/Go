package com.sx.ybj.service.note.note;

import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.ShareData;


import java.util.List;

public interface NoteService {
    /**
     * 创建笔记
     * @param notebook
     * @return
     */
   Notebook createNote(Notebook notebook);//创建笔记

    /**
     * 修改笔记
     * @param notebook
     * @return
     */
   Notebook updateNote(Notebook notebook);//修改笔记

    /**
     * 删除笔记
     * @param notebookId
     * @return
     */
     Integer deleteNote(int notebookId); //删除笔记

    /**
     * 获得最新笔记
     * @return
     */
     List<ShareData> getNewNote(int userId);
    /**
     * 得到分享的笔记
     */
     Notebook getOneShareNote(int notebookId);
    /**
     *  增加访问量
     * @param notebookId
     * @return
     */
    Integer addNotebookAccess(int notebookId);

    /**
     *   依据笔记本id查询笔记
     * @param notebookId
     * @return
     */
    Notebook getNotebook(int notebookId);



}
