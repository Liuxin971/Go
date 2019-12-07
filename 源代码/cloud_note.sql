/*
Navicat MySQL Data Transfer

Source Server         : mylinux
Source Server Version : 50644
Source Host           : 106.14.145.180:3306
Source Database       : cloud_note

Target Server Type    : MYSQL
Target Server Version : 50644
File Encoding         : 65001

Date: 2019-06-27 19:08:40
*/

SET FOREIGN_KEY_CHECKS=0;

-- ----------------------------
-- Table structure for activity
-- ----------------------------
DROP TABLE IF EXISTS `activity`;
CREATE TABLE `activity` (
  `activity_id` int(11) NOT NULL AUTO_INCREMENT,
  `activity_name` varchar(255) NOT NULL COMMENT '活动名称',
  `notebook_id` int(11) NOT NULL COMMENT '笔记本id',
  `activity_time` datetime DEFAULT NULL COMMENT '活动时间',
  `activity_content` longtext COMMENT '活动内容',
  PRIMARY KEY (`activity_id`),
  KEY `noteboook_id` (`notebook_id`),
  CONSTRAINT `activity_ibfk_1` FOREIGN KEY (`notebook_id`) REFERENCES `notebook` (`notebook_id`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of activity
-- ----------------------------

-- ----------------------------
-- Table structure for categorize
-- ----------------------------
DROP TABLE IF EXISTS `categorize`;
CREATE TABLE `categorize` (
  `categorize_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '分类id',
  `categorize_name` char(50) NOT NULL COMMENT '分类名字',
  `user_id` int(11) DEFAULT NULL COMMENT '用户ID',
  `categorize_state` int(255) DEFAULT '1' COMMENT '笔记本状态',
  PRIMARY KEY (`categorize_id`),
  KEY `user_id` (`user_id`),
  CONSTRAINT `categorize_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=190 DEFAULT CHARSET=utf8 COMMENT='分类表';

-- ----------------------------
-- Records of categorize
-- ----------------------------
INSERT INTO `categorize` VALUES ('109', '默认笔记', '16', '1');
INSERT INTO `categorize` VALUES ('110', '默认笔记', '17', '1');
INSERT INTO `categorize` VALUES ('112', '默认笔记', '18', '1');
INSERT INTO `categorize` VALUES ('113', '默认笔记', '19', '1');
INSERT INTO `categorize` VALUES ('115', '默认笔记', '20', '1');
INSERT INTO `categorize` VALUES ('128', '默认笔记', '21', '1');
INSERT INTO `categorize` VALUES ('166', 'html', '16', '1');
INSERT INTO `categorize` VALUES ('168', '默认笔记', '27', '1');
INSERT INTO `categorize` VALUES ('171', '新建笔记本', '20', '1');
INSERT INTO `categorize` VALUES ('175', 'java', '16', '1');
INSERT INTO `categorize` VALUES ('177', '新建笔记本', '18', '1');
INSERT INTO `categorize` VALUES ('178', '新建笔记本(1)', '18', '1');
INSERT INTO `categorize` VALUES ('179', 'ybj', '19', '1');
INSERT INTO `categorize` VALUES ('183', 'YBJ2', '19', '1');
INSERT INTO `categorize` VALUES ('184', '新建笔记本', '16', '1');
INSERT INTO `categorize` VALUES ('185', '新建笔记本', '17', '1');
INSERT INTO `categorize` VALUES ('186', '新建笔记本(1)', '16', '1');
INSERT INTO `categorize` VALUES ('187', '默认笔记', '29', '1');
INSERT INTO `categorize` VALUES ('188', '默认笔记', '30', '1');
INSERT INTO `categorize` VALUES ('189', '新建笔记本', '30', '1');

-- ----------------------------
-- Table structure for collect
-- ----------------------------
DROP TABLE IF EXISTS `collect`;
CREATE TABLE `collect` (
  `collect_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '收藏id',
  `notebook_id` int(11) NOT NULL COMMENT '笔记表id',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `categorize_id` int(11) DEFAULT NULL COMMENT '笔记本id',
  PRIMARY KEY (`collect_id`),
  KEY `notebook_id` (`notebook_id`),
  KEY `user_id` (`user_id`),
  KEY `categorize_id` (`categorize_id`),
  CONSTRAINT `collect_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON UPDATE CASCADE,
  CONSTRAINT `collect_ibfk_2` FOREIGN KEY (`categorize_id`) REFERENCES `categorize` (`categorize_id`),
  CONSTRAINT `notebook_id` FOREIGN KEY (`notebook_id`) REFERENCES `notebook` (`notebook_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=125 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of collect
-- ----------------------------
INSERT INTO `collect` VALUES ('85', '267', '18', '112');
INSERT INTO `collect` VALUES ('89', '270', '20', '115');
INSERT INTO `collect` VALUES ('94', '269', '20', '115');
INSERT INTO `collect` VALUES ('108', '279', '16', '109');
INSERT INTO `collect` VALUES ('118', '267', '19', '113');
INSERT INTO `collect` VALUES ('121', '293', '19', '113');
INSERT INTO `collect` VALUES ('123', '296', '16', '109');
INSERT INTO `collect` VALUES ('124', '280', '16', '109');

-- ----------------------------
-- Table structure for feedback
-- ----------------------------
DROP TABLE IF EXISTS `feedback`;
CREATE TABLE `feedback` (
  `feedback_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '反馈id',
  `feedback_create` date DEFAULT NULL COMMENT '创建反馈时间',
  `feedback_theme` varchar(255) DEFAULT NULL COMMENT '反馈主题',
  `feedback_content` longtext COMMENT '反馈内容',
  `user_id` int(11) DEFAULT NULL COMMENT '用户id',
  `feedback_admin` int(11) DEFAULT '0' COMMENT '管理员给用户的回复 0为用户的反馈1为管理员给用户的回复',
  PRIMARY KEY (`feedback_id`),
  KEY `uid` (`user_id`),
  CONSTRAINT `uid` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=75 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of feedback
-- ----------------------------
INSERT INTO `feedback` VALUES ('65', '2019-06-19', 'test', '反馈测试数据1', '21', '0');
INSERT INTO `feedback` VALUES ('66', '2019-06-19', '这是主题', '这是内容', '21', '1');
INSERT INTO `feedback` VALUES ('67', '2019-06-19', '反馈', '反馈内容', '16', '1');
INSERT INTO `feedback` VALUES ('68', '2019-06-19', '给管理员反馈', '反馈内容', '16', '0');
INSERT INTO `feedback` VALUES ('69', '2019-06-19', '给用户反馈', '反馈内容', '21', '1');
INSERT INTO `feedback` VALUES ('70', '2019-06-20', '', '', '18', '0');
INSERT INTO `feedback` VALUES ('71', '2019-06-20', 'YBJ@@@', 'YBJ2222', '19', '0');
INSERT INTO `feedback` VALUES ('73', '2019-06-20', 'java', 'YBJ2', '19', '1');
INSERT INTO `feedback` VALUES ('74', '2019-06-21', '', '', '21', '1');

-- ----------------------------
-- Table structure for notebook
-- ----------------------------
DROP TABLE IF EXISTS `notebook`;
CREATE TABLE `notebook` (
  `notebook_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '笔记编号',
  `notebook_title` char(50) NOT NULL COMMENT '笔记标题',
  `notebook_content` longtext COMMENT '笔记内容',
  `notebook_abstract` longtext COMMENT '笔记摘要',
  `notebook_regdate` date NOT NULL COMMENT '笔记创建时间',
  `notebook_modfiy` date NOT NULL COMMENT '笔记修改时间',
  `notebook_access` int(11) DEFAULT '0' COMMENT '笔记访问数量',
  `notebook_state` int(11) NOT NULL DEFAULT '1' COMMENT '0表示在回收站  1表示正常  2表示彻底删除',
  `notebook_sharing` int(11) NOT NULL DEFAULT '0' COMMENT '1共享0表示不共享',
  `notebook_activity_note` int(11) DEFAULT '0' COMMENT '活动笔记 id',
  `categorize_id` int(11) NOT NULL COMMENT '笔记本id',
  `user_id` int(11) NOT NULL COMMENT '用户id',
  `notebook_url` varchar(255) DEFAULT NULL COMMENT '上传文件路径',
  `notebook_collect` int(11) DEFAULT '0' COMMENT '0未收藏1收藏',
  PRIMARY KEY (`notebook_id`),
  KEY `user_id` (`user_id`),
  KEY `categorize_id` (`categorize_id`),
  CONSTRAINT `categorize_id` FOREIGN KEY (`categorize_id`) REFERENCES `categorize` (`categorize_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  CONSTRAINT `user_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=305 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of notebook
-- ----------------------------
INSERT INTO `notebook` VALUES ('267', 'YBJ123456', '', null, '2019-06-20', '2019-06-21', '0', '1', '1', null, '179', '19', '/usr/local/tmp2/upload/1561084069476YBJ123456.md', '0');
INSERT INTO `notebook` VALUES ('269', 'jd', '# 一级标题', null, '2019-06-20', '2019-06-20', '0', '1', '0', null, '171', '20', '/usr/local/tmp2/upload/1561042121079jd.md', '0');
INSERT INTO `notebook` VALUES ('270', 'css', '', null, '2019-06-20', '2019-06-20', '0', '1', '0', null, '171', '20', '/usr/local/tmp2/upload/1561013859525css.md', '0');
INSERT INTO `notebook` VALUES ('275', '新建笔记', '111', null, '2019-06-20', '2019-06-20', '0', '0', '0', null, '115', '20', '/usr/local/tmp2/upload/1561012484808新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('276', '新建笔记', '11', null, '2019-06-20', '2019-06-20', '0', '0', '0', null, '115', '20', '/usr/local/tmp2/upload/1561012509019新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('279', 'java', '::: hljs-center\n\n# 云笔记\n\n:::\n\n`\npublic static void \n`\n```java\n\n**package com.sx.ybj.controller.user;\n\nimport org.springframework.stereotype.Controller;\nimport org.springframework.ui.Model;\nimport org.springframework.web.bind.annotation.RequestMapping;\nimport org.springframework.web.bind.annotation.RequestMethod;\nimport org.springframework.web.bind.annotation.RequestParam;\nimport org.springframework.web.multipart.MultipartFile;\n\nimport javax.servlet.http.HttpServletRequest;\nimport java.io.File;\nimport java.io.FileNotFoundException;\nimport java.io.IOException;\n\n/**\n * @program: ybj\n * @description: 上传图片\n * @author: lwx\n * @create: 2019-06-04 15:37\n */\n@Controller\npublic class UploadController {\n\n    @RequestMapping(\"/uploadPage\")\n    public String uploadPage() {\n        return \"uploadPage\";\n    }\n\n    @RequestMapping(value = \"/upload\", method = RequestMethod.POST)\n    public String upload(HttpServletRequest req, @RequestParam(\"file\") MultipartFile file, Model m) {\n        try {\n            String fileName = System.currentTimeMillis()+file.getOriginalFilename();\n            String destFileName=req.getServletContext().getRealPath(\"\")+\"uploaded\"+ File.separator+fileName;\n\n            File destFile = new File(destFileName);\n            destFile.getParentFile().mkdirs();\n            file.transferTo(destFile);\n\n            m.addAttribute(\"fileName\",fileName);\n        } catch (FileNotFoundException e) {\n            e.printStackTrace();\n            return \"上传失败,\" + e.getMessage();\n        } catch (IOException e) {\n            e.printStackTrace();\n            return \"上传失败,\" + e.getMessage();\n        }\n\n        return \"showImg\";\n    }\n}**\n\n哈哈哈,小句郭sdlaj\n\n\n\n\n```![9.png](1)', null, '2019-06-20', '2019-06-26', '0', '1', '1', null, '184', '16', '/usr/local/tmp2/upload/1561534396140java.md', '0');
INSERT INTO `notebook` VALUES ('280', '演示', '<h1><a href=\"#笔记\" name=\"笔记\"></a>笔记</h1>\n<p><strong>java</strong><br/><code>\npublic static void main()\nhaha\n</code></p>\n<pre><code class=\"java\"> FileInputStream fileInputStream=new FileInputStream(destFile);//文件输入流\n      byte[] all =new byte[(int) destFile.length()];//文件长度\n    while (fileInputStream.read(all) != -1) {\n        html = new String(all);\n    }\n    PegDownProcessor pdp = new PegDownProcessor(Integer.MAX_VALUE);\n    html = pdp.markdownToHtml(html);//生成html文件\nnotebook.setNotebookTitle(file.getOriginalFilename());\n    notebook.setCategorizeId(1);\n    notebook.setNotebookContent(html);\n    noteService.createNote(notebook);\n\n    m.addAttribute(&amp;quot;md&amp;quot;,html);\n    return &amp;quot;/home&amp;quot;;\n}\n\n</code></pre>\n<p><img src=\"http://106.14.145.180/images/1560992346871笔记.jpg\" alt=\"笔记\" /><br/>hahaha</p>', null, '2019-06-20', '2019-06-26', '0', '1', '1', null, '175', '16', '/usr/local/tmp2/upload/1561534397580演示.md', '0');
INSERT INTO `notebook` VALUES ('281', '新建笔记', 'efsd', null, '2019-06-20', '2019-06-21', '0', '1', '0', null, '113', '19', '/usr/local/tmp2/upload/1561084051878新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('282', '新建笔记', '', null, '2019-06-20', '2019-06-21', '0', '1', '0', null, '179', '19', '/usr/local/tmp2/upload/1561076851070新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('288', 'ybj1', 'java', null, '2019-06-20', '2019-06-21', '0', '1', '1', null, '179', '19', '/usr/local/tmp2/upload/1561084078218ybj1.md', '0');
INSERT INTO `notebook` VALUES ('291', '新建笔记', null, null, '2019-06-20', '2019-06-20', '0', '0', '0', null, '171', '20', null, '0');
INSERT INTO `notebook` VALUES ('292', '新建笔记', null, null, '2019-06-20', '2019-06-20', '0', '0', '0', null, '171', '20', null, '0');
INSERT INTO `notebook` VALUES ('293', 'YBJ123', 'wwwwwwwwwwwwwwwwwwww', null, '2019-06-21', '2019-06-21', '0', '1', '0', null, '183', '19', '/usr/local/tmp2/upload/1561084052625YBJ123.md', '0');
INSERT INTO `notebook` VALUES ('296', '新建笔记', '', null, '2019-06-21', '2019-06-21', '0', '0', '1', null, '109', '16', '/usr/local/tmp2/upload/1561084905896新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('297', '新建笔记', '', null, '2019-06-21', '2019-06-21', '0', '0', '0', null, '109', '16', '/usr/local/tmp2/upload/1561084498969新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('298', 'How2J', '<h1><a href=\"#how2j\" name=\"how2j\"></a>How2J</h1>\n<h2><a href=\"#1-servlet\" name=\"1-servlet\"></a>1.servlet</h2>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558232614841.png\" alt=\"1558232614841\" /></p>\n<pre><code class=\"java\">注: 比较的时候把常量字符串&quot;admin&quot; &quot;123&quot;放前面，因为用户可能没有输入账号密码就提交，servlet会获取到null。 这样就规避了空指针异常的问题。\r\n\r\n注: 这里输出的响应是success和fail，不是中文。 如果使用中文浏览器有可能看到乱码。\r\nif (&quot;admin&quot;.equals(name) &amp;&amp; &quot;123&quot;.equals(password))\r\n            html = &quot;&lt;div style=&#39;color:green&#39;&gt;success&lt;/div&gt;&quot;;\r\n        else\r\n            html = &quot;&lt;div style=&#39;color:red&#39;&gt;fail&lt;/div&gt;&quot;;\r\n\r\n        PrintWriter pw = response.getWriter();\r\n        pw.println(html);\n</code></pre>\n<h3><a href=\"#1-2-service\" name=\"1-2-service\"></a>1.2.service</h3>\n<p>实际上，在执行doGet()或者doPost()之前，都会先执行service()</p>\n<p>由service()方法进行判断，到底该调用doGet()还是doPost()</p>\n<p>可以发现，service(), doGet(), doPost() 三种方式的参数列表都是一样的。</p>\n<p>所以，有时候也会**直接重写service()**方法，在其中提供相应的服务，就不用区分到底是get还是post了。</p>\n<p>比如把前面的登录的LoginServlet，改为提供service方法，也可以达到相同的效果 </p>\n<pre><code class=\"java\"> protected void service(HttpServletRequest request, HttpServletResponse response)\r\n            throws ServletException, IOException {\r\n \n</code></pre>\n<h3><a href=\"#1-3-中文问题\" name=\"1-3-中文问题\"></a>1.3.中文问题</h3>\n<pre><code class=\"java\">&lt;meta http-equiv=&quot;Content-Type&quot; content=&quot;text/html; charset=UTF-8&quot;&gt;\n</code></pre>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558233362407.png\" alt=\"1558233362407\" /></p>\n<h3><a href=\"#1-4-跳转1558233598712\" name=\"1-4-跳转1558233598712\"></a>1.4.跳转<img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558233598712.png\" alt=\"1558233598712\" /></h3>\n<pre><code class=\"java\">response.sendRedirect(&quot;fail.html&quot;);\n</code></pre>\n<h3><a href=\"#1-5-优先级\" name=\"1-5-优先级\"></a>1.5.优先级</h3>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558234056301.png\" alt=\"1558234056301\" /></p>\n<h3><a href=\"#1-6-获取路径和参数request\" name=\"1-6-获取路径和参数request\"></a>1.6.获取路径和参数request</h3>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558234107813.png\" alt=\"1558234107813\" /></p>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558234242570.png\" alt=\"1558234242570\" /></p>\n<h3><a href=\"#1-7-response\" name=\"1-7-response\"></a>1.7.response</h3>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558234448781.png\" alt=\"1558234416968\" /></p>\n<pre><code class=\"java\">1. response.setContentType(&quot;text/html; charset=UTF-8&quot;);\r\n2. response.setCharacterEncoding(&quot;UTF-8&quot;);\n</code></pre>\n<h3><a href=\"#1-8-上传文件\" name=\"1-8-上传文件\"></a>1.8.上传文件</h3>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558234691111.png\" alt=\"1558234691111\" /></p>\n<pre><code class=\"java\">import java.io.File;\r\nimport java.io.FileNotFoundException;\r\nimport java.io.FileOutputStream;\r\nimport java.io.InputStream;\r\nimport java.io.PrintWriter;\r\nimport java.util.Iterator;\r\nimport java.util.List;\r\n \r\nimport javax.servlet.ServletException;\r\nimport javax.servlet.http.HttpServlet;\r\nimport javax.servlet.http.HttpServletRequest;\r\nimport javax.servlet.http.HttpServletResponse;\r\n \r\nimport org.apache.commons.fileupload.FileItem;\r\nimport org.apache.commons.fileupload.FileUploadException;\r\nimport org.apache.commons.fileupload.disk.DiskFileItemFactory;\r\nimport org.apache.commons.fileupload.servlet.ServletFileUpload;\r\n \r\npublic class UploadPhotoServlet extends HttpServlet {\r\n \r\n    public void doPost(HttpServletRequest request, HttpServletResponse response) {\r\n \r\n        String filename = null;\r\n        try {\r\n            DiskFileItemFactory factory = new DiskFileItemFactory();\r\n            ServletFileUpload upload = new ServletFileUpload(factory);\r\n            // 设置上传文件的大小限制为1M\r\n            factory.setSizeThreshold(1024 * 1024);\r\n            \r\n            List items = null;\r\n            try {\r\n                items = upload.parseRequest(request);\r\n            } catch (FileUploadException e) {\r\n                e.printStackTrace();\r\n            }\r\n \r\n            Iterator iter = items.iterator();\r\n            while (iter.hasNext()) {\r\n                FileItem item = (FileItem) iter.next();\r\n                if (!item.isFormField()) {\r\n \r\n                    // 根据时间戳创建头像文件\r\n                    filename = System.currentTimeMillis() + &quot;.jpg&quot;;\r\n                    \r\n                    //通过getRealPath获取上传文件夹，如果项目在e:/project/j2ee/web,那么就会自动获取到 e:/project/j2ee/web/uploaded\r\n                    String photoFolder =request.getServletContext().getRealPath(&quot;uploaded&quot;);\r\n                    \r\n                    File f = new File(photoFolder, filename);\r\n                    f.getParentFile().mkdirs();\r\n \r\n                    // 通过item.getInputStream()获取浏览器上传的文件的输入流\r\n                    InputStream is = item.getInputStream();\r\n \r\n                    // 复制文件\r\n                    FileOutputStream fos = new FileOutputStream(f);\r\n                    byte b[] = new byte[1024 * 1024];\r\n                    int length = 0;\r\n                    while (-1 != (length = is.read(b))) {\r\n                        fos.write(b, 0, length);\r\n                    }\r\n                    fos.close();\r\n \r\n                } else {\r\n                	System.out.println(item.getFieldName());\r\n                    String value = item.getString();\r\n                    value = new String(value.getBytes(&quot;ISO-8859-1&quot;), &quot;UTF-8&quot;);\r\n                    System.out.println(value);\r\n                }\r\n            }\r\n            \r\n            String html = &quot;&lt;img width=&#39;200&#39; height=&#39;150&#39; src=&#39;uploaded/%s&#39; /&gt;&quot;;\r\n            response.setContentType(&quot;text/html&quot;);\r\n            PrintWriter pw= response.getWriter();\r\n            \r\n            pw.format(html, filename);\r\n            \r\n        } catch (FileNotFoundException e) {\r\n            // TODO Auto-generated catch block\r\n            e.printStackTrace();\r\n        } catch (Exception e) {\r\n            // TODO Auto-generated catch block\r\n            e.printStackTrace();\r\n        }\r\n    }\r\n}\r\n\n</code></pre>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558235306614.png\" alt=\"1558235306614\" /></p>\n<h3><a href=\"#1-8-http协议\" name=\"1-8-http协议\"></a>1.8.http协议</h3>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558236060040.png\" alt=\"1558236060040\" /></p>\n<h2><a href=\"#2-socket\" name=\"2-socket\"></a>2.Socket</h2>\n<h3><a href=\"#2-1连接-测试\" name=\"2-1连接-测试\"></a>2.1连接-测试</h3>\n<pre><code class=\"java\"> public static void main(String[] args)  {\r\n        try {\r\n            //服务端打开端口8888\r\n            ServerSocket ss = new ServerSocket(8888);\r\n               \r\n            //在8888端口上监听，看是否有连接请求过来\r\n            System.out.println(&quot;监听在端口号:8888&quot;);\r\n            Socket s =  ss.accept();\r\n               \r\n            System.out.println(&quot;有连接过来&quot; + s);\r\n             \r\n            //打开输入流\r\n            InputStream is = s.getInputStream();\r\n \r\n            //读取客户端发送的数据\r\n            int msg = is.read();\r\n            //打印出来\r\n            System.out.println(msg);\r\n            is.close();\r\n        } catch (IOException e) {\r\n            // TODO Auto-generated catch block\r\n            e.printStackTrace();\r\n        }\r\n           \r\n    }\r\n\r\n public static void main(String[] args)  {\r\n           \r\n        try {\r\n            //连接到本机的8888端口\r\n            Socket s = new Socket(&quot;127.0.0.1&quot;,8888);\r\n            System.out.println(s);\r\n            // 打开输出流\r\n            OutputStream os = s.getOutputStream();\r\n \r\n            // 发送数字110到服务端\r\n            os.write(110);\r\n            os.close();\r\n \r\n            s.close();\r\n        } catch (UnknownHostException e) {\r\n            // TODO Auto-generated catch block\r\n            e.printStackTrace();\r\n        } catch (IOException e) {\r\n            // TODO Auto-generated catch block\r\n            e.printStackTrace();\r\n        }\r\n    }\n</code></pre>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558239480314.png\" alt=\"1558239480314\" /></p>\n<p><img src=\"C:\\Users\\刘\\AppData\\Roaming\\Typora\\typora-user-images\\1558239493076.png\" alt=\"1558239493076\" /></p>\n<h2><a href=\"#3-date\" name=\"3-date\"></a>3.Date</h2>', null, '2019-06-21', '2019-06-21', '0', '1', '0', null, '175', '16', '/usr/local/tmp2/upload/1561080554517How2J.md', '0');
INSERT INTO `notebook` VALUES ('299', '新建笔记', '```\naaa\n\n```  \n# 一级标题  \n**粗体**', null, '2019-06-21', '2019-06-21', '0', '1', '0', null, '187', '29', '/usr/local/tmp2/upload/1561081567140新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('300', '新建笔记', '', null, '2019-06-21', '2019-06-21', '0', '1', '0', null, '187', '29', '/usr/local/tmp2/upload/1561081980399新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('301', '新建笔记', '**![9.png](1)粗体**', null, '2019-06-21', '2019-06-23', '0', '1', '0', null, '184', '16', '/usr/local/tmp2/upload/1561263114758新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('302', '新建笔记', '**halhfa**\nfdsl![9.png](1)![g.jpg](2)\n\n![图片.png](3)\n\n\n![9.png](4)', null, '2019-06-21', '2019-06-26', '0', '1', '0', null, '109', '16', '/usr/local/tmp2/upload/1561534398461新建笔记.md', '0');
INSERT INTO `notebook` VALUES ('303', '新建文本文档 (2)', '<p>55<br/>Ӣ��ħ����220<br/>43<br/>Խ��Խ�ã�8 60<br/>��Դ��Ų�� 30</p>', null, '2019-06-21', '2019-06-26', '0', '1', '0', null, '186', '16', '/usr/local/tmp2/upload/1561534184076新建文本文档 (2).md', '0');
INSERT INTO `notebook` VALUES ('304', '新建笔', '# ::: hljs-center\n\n春削\n\n:::\n![1](http://106.14.145.180/images/15612636000281.png)', null, '2019-06-23', '2019-06-23', '0', '1', '1', null, '189', '30', '/usr/local/tmp2/upload/1561264342481新建笔.md', '0');

-- ----------------------------
-- Table structure for roles
-- ----------------------------
DROP TABLE IF EXISTS `roles`;
CREATE TABLE `roles` (
  `id` int(11) NOT NULL,
  `name` varchar(255) DEFAULT NULL COMMENT '角色名字',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles
-- ----------------------------
INSERT INTO `roles` VALUES ('1', '超级管理员');
INSERT INTO `roles` VALUES ('2', '普通用户');

-- ----------------------------
-- Table structure for roles_user
-- ----------------------------
DROP TABLE IF EXISTS `roles_user`;
CREATE TABLE `roles_user` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `rid` int(11) DEFAULT NULL,
  `uid` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `rid` (`rid`),
  KEY `uid` (`uid`),
  CONSTRAINT `roles_user_ibfk_1` FOREIGN KEY (`rid`) REFERENCES `roles` (`id`),
  CONSTRAINT `roles_user_ibfk_2` FOREIGN KEY (`uid`) REFERENCES `user` (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of roles_user
-- ----------------------------
INSERT INTO `roles_user` VALUES ('16', '1', '16');
INSERT INTO `roles_user` VALUES ('17', '2', '17');
INSERT INTO `roles_user` VALUES ('18', '2', '18');
INSERT INTO `roles_user` VALUES ('19', '1', '19');
INSERT INTO `roles_user` VALUES ('20', '2', '20');
INSERT INTO `roles_user` VALUES ('21', '2', '21');
INSERT INTO `roles_user` VALUES ('27', '2', '27');
INSERT INTO `roles_user` VALUES ('29', '2', '29');
INSERT INTO `roles_user` VALUES ('30', '2', '30');

-- ----------------------------
-- Table structure for user
-- ----------------------------
DROP TABLE IF EXISTS `user`;
CREATE TABLE `user` (
  `user_id` int(11) NOT NULL AUTO_INCREMENT COMMENT '用户id',
  `username` varchar(255) NOT NULL,
  `user_nickname` char(50) DEFAULT NULL COMMENT '用户昵称',
  `password` varchar(255) NOT NULL COMMENT '用户密码',
  `user_email` char(50) NOT NULL COMMENT '用户邮箱',
  `user_picture` char(255) NOT NULL COMMENT '用户头像',
  `user_regdate` date NOT NULL COMMENT '创建时间',
  `enabled` varchar(255) NOT NULL DEFAULT '1' COMMENT '权限控制_1表示用户可以使用0表示用户不能使用',
  PRIMARY KEY (`user_id`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=utf8;

-- ----------------------------
-- Records of user
-- ----------------------------
INSERT INTO `user` VALUES ('16', 'lwx', 'ran', 'fcea920f7412b5da7be0cf42b8c93759', '1747613113@qq.com', 'http://106.14.145.180/images/1561083041589g.jpg', '2019-06-21', '1');
INSERT INTO `user` VALUES ('17', 'lwx2', 'ran', 'e10adc3949ba59abbe56e057f20f883e', '129343719@qq.com', 'http://106.14.145.180/images/15610711255479.png', '2019-06-20', '1');
INSERT INTO `user` VALUES ('18', 'wang', 'rangss', 'e10adc3949ba59abbe56e057f20f883e', '1402981929@qq.com', 'http://106.14.145.180/images/1560911958643timg.jpg', '2019-06-20', '1');
INSERT INTO `user` VALUES ('19', 'zsang', 'z1111111sang', 'e10adc3949ba59abbe56e057f20f883e', '3161754347@qq.com', 'http://106.14.145.180/images/1561075054344QQ图片20190621075711.jpg', '2019-06-20', '1');
INSERT INTO `user` VALUES ('20', 'gpc', 'ran', 'e10adc3949ba59abbe56e057f20f883e', '2376306355@qq.com', 'http://106.14.145.180/images/1560991791477b.jpg', '2019-06-19', '1');
INSERT INTO `user` VALUES ('21', '一川~~~', 'ran', 'e3b96c5d5871b79f43489a928a4091ef', '3403492959@qq.com', 'http://106.14.145.180:8081/note/uploaded/1560179087701b.jpg', '2019-06-19', '1');
INSERT INTO `user` VALUES ('27', 'lwx3', 'ran', 'fcea920f7412b5da7be0cf42b8c93759', '174761311@qq.com', 'http://106.14.145.180:8081/note/uploaded/1560179087701b.jpg', '2019-06-20', '1');
INSERT INTO `user` VALUES ('29', 'lwxs', 'ran', 'e10adc3949ba59abbe56e057f20f883e', '1293437197@qq.com', 'http://106.14.145.180:8081/note/uploaded/1560179087701b.jpg', '2019-06-21', '1');
INSERT INTO `user` VALUES ('30', 'lwh', 'ran', '0e292c0bb8ab0633973ca81ea3a9a086', '501540399@qq.com', 'http://106.14.145.180/images/15612636000281.png', '2019-06-23', '1');
