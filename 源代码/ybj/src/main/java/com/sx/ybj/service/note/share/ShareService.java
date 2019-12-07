package com.sx.ybj.service.note.share;

import com.sx.ybj.pojo.Collect;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.ShareData;
import com.sx.ybj.utils.YbjResult;

import java.util.List;

/**
 * @program: ybj
 * @description: 查询共享笔记
 * @author: lwx
 * @create: 2019-05-18 10:36
 */

public interface ShareService {
    /**
     * 查询共享笔记
     * @return
     */
    List<ShareData> getShareNote();//查询共享笔记

    /**
     * 收藏笔记
     * @param collect
     * @return
     */
    YbjResult collectNote(Collect collect);//收藏笔记

    /**
     * 查询收藏笔记
     * @return
     */
    YbjResult findCollectionNote(int userId);//查询收藏笔记

    /**
     *删除共享笔记
     * @param collectId
     * @return
     */
    YbjResult delCollectionNote(int collectId);

    /**
     * 接收热点消息
     * @return
     */
    List<Notebook> getHotNote();



}