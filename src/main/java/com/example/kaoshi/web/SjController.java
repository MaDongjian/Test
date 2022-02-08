
package com.example.kaoshi.web;


import com.alibaba.fastjson.JSONObject;
import com.example.kaoshi.pojo.*;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.SAXReader;
import org.dom4j.io.XMLWriter;
import org.springframework.boot.ApplicationHome;
import org.springframework.stereotype.Controller;
import org.springframework.util.ClassUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.stream.Collectors;


/**
 * @author Administrator
 * @create 2019-08-26 8:43
 * @desc
 **/

@RestController
@Api(value = "desc of class")
public class SjController {
    /*@ApiOperation(value = "tianjia")
    @PostMapping("insertSj")
    public void insertSj(@RequestBody Emp emp,MultipartFile file) throws IOException {
        Demo d = new Demo();
        d.setDemoId(11);
        d.setDemoName("凤姐");
        Demo d2 = new Demo();
        d2.setDemoId(22);
        d2.setDemoName("小花");
        Demo d3 = new Demo();
        d3.setDemoId(33);
        d3.setDemoName("狗子");

        List<Demo> list = new ArrayList<Demo>();
        list.add(d);
        list.add(d2);
        list.add(d3);

        //1.设置文件下载的response响应格式
        String fileName = "demo";  //文件名
        String fileType = "xml";    //文件类型
        *//*response.setHeader("Content-Disposition", "attachment;filename=" + fileName + "." + fileType);
        response.setContentType("multipart/form-data");*//*
        //2.将数据转为xml格式的字符串
        InputStream is = file.getInputStream();

        //1.创建工作簿
        Workbook workbook = null ;
        if (file.getName().endsWith("xls")) {
            workbook = new HSSFWorkbook(is);
        } else if (file.getName().endsWith("xlsx")) {
            workbook = new XSSFWorkbook(is);
        }

        //2.遍历Excel中所有的sheet
        for (int i = 0; i < workbook.getNumberOfSheets(); i++) {
            Sheet sheet = workbook.getSheetAt(i);
            if (sheet == null) {
                continue;
            }
            //3.遍历当前sheet中的所有行(从第二行开始，序号为1)
            for (int j = 1; j < sheet.getLastRowNum(); j++) {
                Row row = sheet.getRow(j);
                if (row == null) {
                    continue;
                }
                for(int p =1;p<row.getLastCellNum();p++){
                    row.getCell(p).getNumericCellValue();
                    row.getCell(p).getStringCellValue();
                    row.getCell(p).setCellType(CellType.STRING);
                }
                //4.把每个单元格的值赋给对象的对应属性

            }
        }

    }*/

    @GetMapping(value = "text")
    @ApiOperation("9999")
    public Set<Object> insertSj(HttpServletRequest request, HttpServletResponse response) throws IOException {
        List<Menus>  menuList= new ArrayList();
               /*插入一些数据*/
                menuList.add(new Menus("1","0","系统管理","/admin","Y"));
              menuList.add(new Menus("2","1","权限管理","/admin","Y"));
                menuList.add(new Menus("3","1","密码修改","/admin","Y"));
                menuList.add(new Menus("4","2","新加用户","/admin","Y"));
                menuList.add(new Menus("5","2","系统监控","/admin","Y"));
              menuList.add(new Menus("6","3","在线用户","/admin","Y"));
                menuList.add(new Menus("7","3","订阅区","/admin","Y"));
                menuList.add(new Menus("8","3","未知领域","/admin","Y"));
        //Set<List<String>> lists = new Set<List<String>>();
        Set<Object> lists = new HashSet<>();
        List<String> strings = new ArrayList<>();
        Set<Object> tree = createTree("0",menuList,lists,strings);
        return lists;
       /* response.setHeader( "Content-disposition ", "attachment; filename="+ fiString fileName = "倩倩";
        fileName = URLEncoder.encode(fileName,"UTF-8");
        response.reset();
        System.out.println(fileName);leName);*/
    }
    private Set<Object> createTree(String pid, List<Menus> menus,Set<Object> listList,List<String> strings) {

        for (Menus menu : menus) {
            if (menu.getParentId().equals(pid)) {
                strings.add(menu.getText());
                listList.add(strings);
                createTree(menu.getId(), menus,listList,new ArrayList<String>());

            }
        }

        return listList;
    }


    @GetMapping(value = "utpTEST")
    @ApiOperation("utpTEST")
    public void insertWeather(BjWeather bjWeather){
        Server();
        UdpClient();
        return ;
    }

    private static ArrayList listname = new ArrayList();
    private static void  Server(){
        System.out.println("服务端启动...");
        //1.创建socket，用来发送和接收数据包
        DatagramSocket socket = null;
        DatagramPacket packet = null;
        Scanner sc = new Scanner(System.in);
        //2.创建数据包，用来接收客户端发送的数据和ip，端口
        byte[] buff = new byte[1024];
        try {
            socket = new DatagramSocket(7777);
            packet = new DatagramPacket(buff, buff.length);
            while(true) {
                //3.接收socket和数据包来接收客户端的信息
                socket.receive(packet);
                //4.输出客户端发来的信息
                byte[] buff2 = packet.getData();
                String reply = new String(buff2,0,packet.getLength());
                if("bye".equals(reply)) {
                    break;
                }
                InetAddress address = packet.getAddress();
                System.out.println("客户："+reply);
                //5.给客户端发送消息
                System.out.println("我：");
                //String info = sc.nextLine();
                byte[] bytes = "测试的".getBytes();
                DatagramPacket packet2 = new DatagramPacket(bytes,bytes.length,address,packet.getPort());
                socket.send(packet2);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //6.关闭socket
            socket.close();
        }

    }
    private static void UdpClient() {
        //1.创建Socket用于发送和接收数据
        DatagramSocket socket = null;
        DatagramPacket packet = null;
        Scanner sc = new Scanner(System.in);
        //2.创建数据报，用来存储
        try {
            socket = new DatagramSocket();
            while(true) {
                //String cInfo = sc.nextLine();
                byte[] buff = "cInfo发".getBytes();
                packet = new DatagramPacket(buff, buff.length, InetAddress.getByName("127.0.0.1"), 7777);
                //3.发送数据报
                socket.send(packet);
                if("cInfo".equals("bye")) {
                    break;
                }//4.接收服务端数据
                byte[] buff2 = new byte[1024];
                DatagramPacket packet2 = new DatagramPacket(buff2, buff2.length);
                socket.receive(packet2);
                byte[] data = packet2.getData();
                System.out.println("在线客服说："+new String(data,0,packet2.getLength()));
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //关闭流
            if(socket!=null) {
                socket.close();
            }
        }

    }

    public static void main(String[] args)throws Exception{
        /*List<String> allFiles = getAllFiles("E:\\home");
        for(String allFile:allFiles){
            System.out.println(allFile);
        }*/

        /*ApplicationHome h = new ApplicationHome(SjController.class);
        File jarF = h.getSource();
        //在jar包所在目录下生成一个upload文件夹用来存储上传的图片
        String dirPath = jarF.getParentFile().toString()+"\\upload\\";
        String path = System.getProperty("user.dir");
        String path1 = Class.class.getClass().getResource("/").getPath();
        System.out.println(path1);*/
       /* SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM-dd");
        List<Emp> list = new ArrayList<>();
        Emp  e = new Emp();
        e.setdId("10");
        e.setDate(sdf.parse("2020-10-05"));

        Emp  eq = new Emp();
        eq.setdId("100");
        eq.setDate(sdf.parse("2020-08-05"));

        Emp  ew = new Emp();
        ew.setdId("1000");
        ew.setDate(sdf.parse("2020-11-05"));
        list.add(e);
        list.add(eq);
        list.add(ew);
        List<Emp> collect = list.stream().sorted(Comparator.comparing(Emp::getDate).reversed()).collect(Collectors.toList());
        collect.forEach(c->{
            System.out.println(c.getdId());
        });*/
        List<Student> list1 = new ArrayList<>();
        list1.add(new Student("思乡渔夫","F0002"));
        list1.add(new Student("阿胖山","F0001"));
        list1.add(new Student("牛叔","N1003"));

        List<Student> list2 = new ArrayList<>();
        list2.add(new Student("牛叔","N1003"));
        list2.add(new Student("玉田","N1004"));
        // 交集.
        List<Student> intersection = list1.stream().filter(item -> list2.contains(item)).collect(Collectors.toList());

        System.out.println(JSONObject.toJSONString(intersection));
    }

    public static List<String> getAllFiles(String path) {
        List<String> list = new ArrayList<>();
        File fileDir = new File(path);
        // 判断是否是文件夹
        if (fileDir.isDirectory()) {
            File fileList[] = fileDir.listFiles();
            for (int i = 0; i < fileList.length; i++) {
                if (fileList[i].isDirectory()) {
                    // 使用递归获取文件夹下的文件夹中的文件
                    list.addAll(getAllFiles(fileList[i].getPath()));
                } else {
                    list.add(fileList[i].getPath());
                }
            }
        }else {
            list.add(fileDir.getPath());
        }
        return list;
    }


    public static void createXml(){
        try {
            // 1、创建document对象
            Document document = DocumentHelper.createDocument();
            // 2、创建根节点rss
            Element rss = document.addElement("rss");
            // 3、向rss节点添加version属性
            rss.addAttribute("version", "2.0");
            // 4、生成子节点及子节点内容
            Element channel = rss.addElement("channel");
            Element title = channel.addElement("title");
            title.setText("国内最新新闻");
            // 5、设置生成xml的格式
            OutputFormat format = OutputFormat.createPrettyPrint();
            // 设置编码格式
            format.setEncoding("UTF-8");


            // 6、生成xml文件
            File file = new File("rss.xml");
            XMLWriter writer = new XMLWriter(new FileOutputStream(file), format);
            // 设置是否转义，默认使用转义字符
            //writer.setEscapeText(false);
            writer.write(document);
            writer.close();
            System.out.println("生成rss.xml成功");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("生成rss.xml失败");
        }
    }


}

