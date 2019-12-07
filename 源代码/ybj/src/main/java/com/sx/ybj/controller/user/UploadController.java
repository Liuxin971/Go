package com.sx.ybj.controller.user;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.mapper.UserMapper;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.pojo.User;
import com.sx.ybj.service.note.note.NoteService;
import com.sx.ybj.utils.ExceptionUtil;
import com.sx.ybj.utils.Util;
import com.sx.ybj.utils.YbjResult;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.io.FileInputStream;
import java.net.URLEncoder;


/**
 * @program: ybj
 * @description: 上传图片
 * @author: lwx
 * @create: 2019-06-04 15:37
 */
@Controller
@RequestMapping("/user")
public class UploadController {

    @Autowired
    UserMapper userMapper;
    @Autowired
    NoteService noteService;
    @Autowired
    NotebookMapper notebookMapper;

    @RequestMapping("/uploadPage")
    public String uploadPage() {
        return "uploadPage";
    }


    @RequestMapping("/downloadOnlineLearnMaterials")
    @ResponseBody
    public void downloadFile(HttpServletRequest request, HttpServletResponse response,int notebookId) {
        try {
            Notebook notebook=notebookMapper.selectByPrimaryKey(notebookId);
            String url=notebook.getNotebookUrl();
            if (url != null) { //设置文件路径
                String realPath=url;
                //File file = new File(realPath, fileName); //文件
                File file=new File(realPath);
                if (file.exists()) {
                    response.setContentType("application/force-download");// 设置强制下载不打开
                    response.setHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode( notebook.getNotebookTitle()+".md","UTF-8")  );// 设置文件名
                    byte[] buffer = new byte[1024];
                    FileInputStream fis = null;
                    BufferedInputStream bis = null;
                    try {
                        fis = new FileInputStream(file);
                        bis = new BufferedInputStream(fis);
                        OutputStream os = response.getOutputStream();
                        int i = bis.read(buffer);
                        while (i != -1) {
                            os.write(buffer, 0, i);
                            i = bis.read(buffer);
                        }
                        System.out.println("success");
                    } catch (Exception e) {
                        e.printStackTrace();
                    } finally {
                        if (bis != null) {
                            try {
                                bis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                        if (fis != null) {
                            try {
                                fis.close();
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
//            return YbjResult.ok();
        } catch (Exception e) {
//            return YbjResult.build(0,"上传失败",ExceptionUtil.getStackTrace(e));
            System.out.println(e);
        }

    }


    @PostMapping("/upload")
    @ResponseBody
    public YbjResult upload(HttpServletRequest req, @RequestParam("file") MultipartFile file) {
        try {
            //根据时间来创建文件
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
            String destFileName = "/usr/local/tmp2/upload/images/"+fileName;
            //   4. 第一次运行的时候，这个文件所在的目录往往是不存在的，这里需要创建一下目录
            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            System.out.println(destFileName);
            //将图片放到数据库
            User user = userMapper.selectByPrimaryKey(Util.getCurrentUser().getUserId());
            String path="http://106.14.145.180/images/";
            // String path="http://127.0.0.1:8081/note/uploaded/";
            user.setUserPicture(path + fileName);
            userMapper.updateByPrimaryKeySelective(user);
            //  5. 把浏览器上传的文件复制到希望的位置
            file.transferTo(destFile);
            //6. 把文件名放在model里，以便后续显示用
            //  m.addAttribute("fileName",fileName);
            return YbjResult.ok(path + fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return YbjResult.build(0, "上传失败", e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
            return YbjResult.build(0, "上传失败", e.getMessage());
        }


    }

    @RequestMapping(value = "/upload1", method = RequestMethod.POST)
    public String upload(HttpServletRequest req, @RequestParam("file") MultipartFile file, Model m) {
        try {
            String fileName = System.currentTimeMillis() + file.getOriginalFilename();
//            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;
            String destFileName = "/usr/local/tmp2/upload/images/"+fileName;
            User user = userMapper.selectByPrimaryKey(Util.getCurrentUser().getUserId());
             String path="http://106.14.145.180/images/";
            user.setUserPicture(path + fileName);
            userMapper.updateByPrimaryKeySelective(user);

            File destFile = new File(destFileName);
            destFile.getParentFile().mkdirs();
            file.transferTo(destFile);

            m.addAttribute("fileName", fileName);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        } catch (IOException e) {
            e.printStackTrace();
            return "上传失败," + e.getMessage();
        }

        return "showImage";
    }


//    @RequestMapping(value = "/uploadNote", method = RequestMethod.POST)
    @PostMapping("/uploadNote")
    @ResponseBody
    public YbjResult uploadNote1(HttpServletRequest req, @RequestParam("file") MultipartFile file, Notebook
            notebook) {
        try {
            if (file.isEmpty()) {
                return YbjResult.build(0, "文件不能为空");
            }
            else {
                String html = null;
                String fileName = System.currentTimeMillis() + file.getOriginalFilename();//获取源文件名称
                // String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;//生成下载路径String destFileName="/usr/local/tmp2/upload/"+fileName;
                //生成下载路径
                String destFileName = "/usr/local/tmp2/upload/" + fileName;
                File destFile = new File(destFileName);//生成文件路径
                destFile.getParentFile().mkdirs();
                file.transferTo(destFile);//生成文件

                FileInputStream fileInputStream = new FileInputStream(destFile);//文件输入流
                byte[] all = new byte[(int) destFile.length()];//文件长度
                while (fileInputStream.read(all) != -1) {
                    html = new String(all);
                }
                PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
                html = pdp.markdownToHtml(html);//生成html文件
                notebook.setUserId(Util.getCurrentUser().getUserId());
                String  filename=file.getOriginalFilename();
                String caselsh = filename.substring(0,filename.lastIndexOf("."));//获得文件前醉名称
                notebook.setNotebookTitle(caselsh);
                notebook.setNotebookContent(html);
                notebook.setNotebookUrl(destFileName);
                noteService.createNote(notebook);
                return YbjResult.ok(notebook);

            }

        } catch (IOException e) {
           return YbjResult.build(0, "上传失败", ExceptionUtil.getStackTrace(e));
        }
    }







  //  @RequestMapping(value = "/uploadNote", method = RequestMethod.POST)
//    public String uploadNote(HttpServletRequest req, @RequestParam("file") MultipartFile file, Model m) throws
//            Exception {
//        String html = null;
//        try {
//            html = null;
//            String fileName = System.currentTimeMillis() + file.getOriginalFilename();//获取源文件名称
//
//            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;//生成下载路径
//
//            File destFile = new File(destFileName);//生成文件路径
//            destFile.getParentFile().mkdirs();
//            file.transferTo(destFile);//生成文件
//
//
//            FileInputStream fileInputStream = new FileInputStream(destFile);//文件输入流
//            byte[] all = new byte[(int) destFile.length()];//文件长度
//            while (fileInputStream.read(all) != -1) {
//                html = new String(all);
//            }
//            PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
//            html = pdp.markdownToHtml(html);//生成html文件
//        } catch (IOException e) {
//            e.printStackTrace();
//        } catch (IllegalStateException e) {
//            e.printStackTrace();
//        }
//
//
//        m.addAttribute("md", html);
//        return "home";
//    }



//    @RequestMapping(value = "/uploadNote2", method = RequestMethod.POST)
//    @ResponseBody
//    public YbjResult uploadNotes(HttpServletRequest req, @RequestParam("file") MultipartFile file, Notebook
//            notebook) {
//        try {
//            if (file.isEmpty()) {
//                return YbjResult.build(0, "文件不能为空");
//            }
//            String html = null;
//            String fileName = System.currentTimeMillis() + file.getOriginalFilename();//获取源文件名称
//            String destFileName = req.getServletContext().getRealPath("") + "uploaded" + File.separator + fileName;//生成下载路径String destFileName="/usr/local/tmp2/upload/"+fileName;
//            File destFile = new File(destFileName);//生成文件路径
//            destFile.getParentFile().mkdirs();
//            file.transferTo(destFile);//生成文件
//
//            FileInputStream fileInputStream = new FileInputStream(destFile);//文件输入流
//            byte[] all = new byte[(int) destFile.length()];//文件长度
//            while (fileInputStream.read(all) != -1) {
//                html = new String(all);
//            }
//            PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
//            html = pdp.markdownToHtml(html);//生成html文件
//            notebook.setUserId(Util.getCurrentUser().getUserId());
//            notebook.setNotebookTitle(file.getOriginalFilename());
//            notebook.setNotebookContent(html);
//            notebook.setNotebookUrl(destFileName);
//            noteService.createNote(notebook);
//            return YbjResult.ok(notebook);
//        } catch (IOException e) {
//            return YbjResult.build(0, "上传失败", ExceptionUtil.getStackTrace(e));
//        }
//    }

}