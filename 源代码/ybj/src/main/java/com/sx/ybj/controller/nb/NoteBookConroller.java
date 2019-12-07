package com.sx.ybj.controller.nb;

import com.sx.ybj.pojo.Categorize;
import com.sx.ybj.service.nb.NoteBookService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * @program: ybj
 * @description: 笔记本事物
 * @author: lwx
 * @create: 2019-05-17 19:37
 */
@RestController
@RequestMapping("/user")
public class NoteBookConroller {

    @Autowired
    NoteBookService noteBookService;

    @GetMapping("/createBook")
    public YbjResult createBook( String categorizeName) {
          return noteBookService.createBook(Util.getCurrentUser().getUserId(), categorizeName);
//          return noteBookService.createBook(userId, categorizeName);
    }

    @GetMapping("/getAllBook")
    public YbjResult searchNoteBook() {

        try {
        return YbjResult.ok(noteBookService.searchNoteBook(Util.getCurrentUser().getUserId()));
          //  return YbjResult.ok(noteBookService.searchNoteBook(userId));
        } catch (Exception e) {
            return YbjResult.build(0, "异常", ExceptionUtil.getStackTrace(e));
        }
    }

    @GetMapping("/updateBook")
    public YbjResult updateCatelog(Categorize categorize) {
        try {
            return YbjResult.ok(noteBookService.updateCatelog(categorize));
        } catch (Exception e) {
          return  YbjResult.build(0,"更新失败",ExceptionUtil.getStackTrace(e));
        }
    }

    @GetMapping(value = "/getNote/{categorizeId}")
    public YbjResult searchNotesByNoteBookId(@PathVariable("categorizeId") int categorizeId) {
        try {
            return YbjResult.ok(noteBookService.getNotesByNoteBookId(categorizeId));
        } catch (Exception e) {
            return  YbjResult.build(0,"更新失败",ExceptionUtil.getStackTrace(e));
        }
    }

    @GetMapping(value = "/delBook/{categorizeId}")
    public YbjResult deleteNotebook(@PathVariable("categorizeId")int categorizeId) {
        return noteBookService.deleteNotebook(categorizeId);
    }
}