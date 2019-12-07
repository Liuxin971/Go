package com.sx.ybj.controller;


import com.sx.ybj.mapper.UserMapper;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.User;
import com.sx.ybj.service.note.note.NoteService;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


import java.text.SimpleDateFormat;
import java.util.Date;


/**
 * @program: ybj
 * @description: 页面跳转
 * @author: lwx
 * @create: 2019-05-11 22:39
 */
@Controller
public class ShowMain {

   @Autowired
    UserMapper  userMapper;
    @Autowired
    NoteService noteService;
//
//    @RequestMapping("/getOneShareNotes/{notebookId}")
//    public String getOneShareNote(@PathVariable("notebookId") int notebookId, Model model) {
//
//        try {
//            Notebook notebook=noteService.getOneShareNote(notebookId);
//            model.addAttribute("content", notebook.getNotebookContent());
//            User user=userMapper.selectByPrimaryKey(notebook.getUserId());
//            model.addAttribute("ed",user.getUserNickname());
//            model.addAttribute("img",user.getUserPicture());
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
//        Date date=new Date();
//        String date1=simpleDateFormat.format(date);
//        model.addAttribute("date",date1);
//        return "home";
//    }


    @RequestMapping("/getOneShareNotes/{notebookId}")
    public  String  getShare(Model model,@PathVariable("notebookId") int notebookId){
        try {
            model.addAttribute("id",notebookId);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "getOneShareNotes";
    }



    @RequestMapping("/mng")
    public  String  get1(){
        return "后台";
    }

    @RequestMapping("/alogin")
    public  String  get0(){
        return "alogin";
    }




    @RequestMapping("/feedback")
    public  String  get2(){
        return "反馈信息";
    }

@RequestMapping("/user")
public  String  get3(){
        return "用户管理";
        }


        }