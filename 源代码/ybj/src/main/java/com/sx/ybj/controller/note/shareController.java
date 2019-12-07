package com.sx.ybj.controller.note;

import com.sx.ybj.pojo.Collect;
import com.sx.ybj.service.note.share.ShareService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ybj
 * @description: 共享笔记
 * @author: lwx
 * @create: 2019-05-18 10:48
 */
@RequestMapping("/user")
@RestController
public class shareController {
    @Autowired
    ShareService shareService;

    @GetMapping("/getShareNote")
    public YbjResult searchShareNote(){
        try {
            return  YbjResult.ok(shareService.getShareNote());
        } catch (Exception e) {
          return YbjResult.build(0,"查询共享笔记失败", ExceptionUtil.getStackTrace(e));
        }
    }

    @GetMapping("/CollectionShareNote")
    public YbjResult collectNote(Collect collect){
        collect.setUserId(Util.getCurrentUser().getUserId());
        return  shareService.collectNote(collect);
    }
    @GetMapping("/getCollectionNote")
    public YbjResult findCollectionNote(){
        return  shareService.findCollectionNote(Util.getCurrentUser().getUserId());
    }
    @GetMapping("/delCollectionNote")
    public YbjResult delCollectionNote(int collectId){
        return  shareService.delCollectionNote(collectId);
    }
    @GetMapping("/getHotNote")
    public YbjResult getNote(){
        try {
            return  YbjResult.ok(shareService.getHotNote());
        } catch (Exception e) {
           return  YbjResult.build(0,"获取信息失败",ExceptionUtil.getStackTrace(e));
        }
    }


}