package com.sx.ybj.controller.note;

import com.sx.ybj.service.note.recycle.RecycleBinService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: ybj
 * @description: 回收站
 * @author: lwx
 * @create: 2019-05-18 12:32
 */
@RestController
@RequestMapping("/user")
public class BinController {
    @Autowired
    RecycleBinService recycleBinService;
    //查找笔记
    @GetMapping("/getBinNote")
    public YbjResult getBin(){
        try {
           return  YbjResult.ok(recycleBinService.getBin(Util.getCurrentUser().getUserId()));
           // return  YbjResult.ok(recycleBinService.getBin(userId));
        } catch (Exception e) {
            return YbjResult.build(0,"获取失败", ExceptionUtil.getStackTrace(e));
        }

    }
    //删除全部笔记
    @GetMapping("/BinDelNote")
    public YbjResult binDelNote() {

        try {
            return YbjResult.ok(recycleBinService.binDelNote());
        } catch (Exception e) {
            return  YbjResult.build(0,"删除笔记失败",ExceptionUtil.getStackTrace(e));
        }
    }




    //回收笔记
    @GetMapping("/recoveryNote")
    public YbjResult recoverNote(int  notebookId){
        return  recycleBinService.recoverNote(notebookId);

    }
//    彻底删除笔记
@GetMapping("/finalDelNote")
    public YbjResult  cDeleteNotebook(int  notebookId){
        return  recycleBinService.cDeleteNotebook(notebookId);

    }
    //回收全部笔记
    @GetMapping("/recoverAllNote")
    public YbjResult recoverAllNote(){
        try {
            return YbjResult.ok(recycleBinService.recoverAllNote());
        } catch (Exception e) {
            return YbjResult.build(0,"恢复失败",ExceptionUtil.getStackTrace(e));
        }
    }



}