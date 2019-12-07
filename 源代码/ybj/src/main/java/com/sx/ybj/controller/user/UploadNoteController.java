package com.sx.ybj.controller.user;

import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.YbjResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.io.*;

/**
 * @program: ybj
 * @description:
 * @author: lwx
 * @create: 2019-06-14 12:41
 */
@RestController
@RequestMapping("/user")
public class UploadNoteController {
    @Autowired
    NotebookMapper notebookMapper;

    @RequestMapping("/saveContent")
    @ResponseBody
    public YbjResult downloadFile(int notebookId) throws Exception{
        Notebook notebook = notebookMapper.selectByPrimaryKey(notebookId);
        String nbName =System.currentTimeMillis()+ notebook.getNotebookTitle()+".md" ;//获得文件名称
        String url=notebook.getNotebookUrl();//获得文件路径
        String content=notebook.getNotebookContent();//获得内容
        //删除原先的笔记
        if (url!=null){
            File file=new File(url);
            file.delete();
        }
        url="/usr/local/tmp2/upload/";//定义路径
        File file = new File(url+nbName);
        file.createNewFile(); //创建文件
        try (FileWriter fr = new FileWriter(file)) {
            // 以字符流的形式把数据写入到文件中
            char[] cs = content.toCharArray();
            fr.write(cs);  //写入文件
            //添加url
            notebook.setNotebookUrl(url+nbName);
            notebookMapper.updateByPrimaryKeySelective(notebook);
         return YbjResult.ok();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            return YbjResult.build(0,"保存失败", ExceptionUtil.getStackTrace(e));
        }

    }

}