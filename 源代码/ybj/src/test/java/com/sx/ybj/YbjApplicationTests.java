package com.sx.ybj;

import com.sx.ybj.mapper.NotebookMapper;
import com.sx.ybj.pojo.Notebook;
import com.sx.ybj.service.nb.ElasticsearchNote;
import org.junit.Test;

import org.junit.runner.RunWith;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.test.context.junit4.SpringRunner;

import javax.mail.internet.MimeMessage;
import java.awt.*;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest

public class YbjApplicationTests {
    @Autowired
    ElasticsearchNote elasticsearchNote;
    @Autowired
    NotebookMapper notebookMapper;

    @Autowired
    JavaMailSenderImpl javaMailSender;
    @Autowired
    StringRedisTemplate stringRedisTemplate;

//    @Test
//    public  void jsoup(){
//        URL url=new URL("");
//
//    }





    @Test
    public void context() {
        SimpleMailMessage mailMessage = new SimpleMailMessage();
        //有建设中
        mailMessage.setSubject("springboot");
        mailMessage.setText("spring来自服务器");
        mailMessage.setTo("1402981929@qq.com");
        mailMessage.setFrom("1747613113@qq.com");
        javaMailSender.send(mailMessage);
    }

    @Test
    public void redis() {

        stringRedisTemplate.opsForValue().append("code", "123");
    }

    @Test
    public void TestTime() {

        Date date1 = new Date();
        Date date2 = notebookMapper.selectByExample(null).get(0).getNotebookModfiy();
        long day = (date2.getTime() - date1.getTime() + 1000000) / (60 * 60 * 24 * 1000);
        System.out.println("相隔" + day);
    }

    @Test
    public  void TestTime2(){
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd HH-mm-ss");
        List<Notebook> notebooks=notebookMapper.selectByExample(null);
        List<Notebook> notebooks1=new ArrayList<>();
        notebooks.stream().sorted((n1,n2)->(n1.getNotebookModfiy().getTime()>n2.getNotebookModfiy().getTime()?-1:1)).forEach(notebook ->notebooks1.add(notebook));
        System.out.println("****");
        notebooks1.stream().forEach(notebook -> System.out.println(simpleDateFormat.format(notebook.getNotebookModfiy())));
    }


    @Test
    public  void  download() throws Exception{
        Notebook notebook = notebookMapper.selectByPrimaryKey(40);
        String nbName =+ System.currentTimeMillis()+ notebook.getNotebookTitle() ;
        String content=notebook.getNotebookContent();
        File file = new File("D:\\cctv\\"+nbName);
        file.createNewFile();
        try (FileWriter fr = new FileWriter(file)) {
            // 以字符流的形式把数据写入到文件中
            char[] cs = content.toCharArray();
            fr.write(cs);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }



    }

    @Test
    public  void  get1() throws  Exception{
        String content=notebookMapper.selectByPrimaryKey(227).getNotebookContent();
        String  conten1 =content.replaceAll("\\&[a-zA-Z]{1,10};", "").replaceAll("<[^>]*>", "").replaceAll("[(/>)<]", "");
        System.out.println(conten1);



    }





    @Test
    public void get() throws Exception {
        String html = null;
        FileReader fr = new FileReader("F:\\IDE\\hha.md");
        char[] cbconf = new char[1024];
        while (fr.read(cbconf) != -1) {
            html = new String(cbconf);
        }
        PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);
        html = pdp.markdownToHtml(html);
        System.out.println(html);
    }



//
//    @Test
//    public  void  compliterContext() throws Exception{
//        //定义一个复杂的邮件消息
//        MimeMessage mailMessage=javaMailSender.createMimeMessage();
//        MimeMessageHelper helper=new MimeMessageHelper(mailMessage,true);
//        //邮件设置
//        helper.setSubject("springboot");
//        helper.setText("<b style='color:red'>来自 服务器<b>",true);
//        helper.setTo("1293437197@qq.com");
//        helper.setFrom("1747613113@qq.com");
//        //上传文件
//        helper.addAttachment("1.jpg",new File("C:\\Users\\刘\\Pictures\\QQ浏览器截图\\1.jpg"));
//        javaMailSender.send(mailMessage);
//    }


    @Test
    public void test() {
//       book book=new book();
//       book.setId(2);
//       book.setAuthor("吴承恩");
//       book.setBookName("西游记");
//       repos.index(book);

        elasticsearchNote.index(notebookMapper.selectByExample(null).get(0));
        for (Notebook notebook : elasticsearchNote.findByNotebookContentLikeAndNotebookSharingEqualsAndNotebookStateEquals("j", 1,1)) {
            System.out.println(notebook.toString());
        }
    }

}
