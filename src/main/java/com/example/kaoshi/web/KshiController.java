package com.example.kaoshi.web;


import com.alibaba.fastjson.JSONObject;
import com.example.kaoshi.pojo.*;
import com.example.kaoshi.service.KshiService;
import org.apache.http.HttpEntity;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.dom4j.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.io.*;
import java.util.*;

/**
 * @author Administrator
 * @create 2019-05-22 16:06
 * @desc
 **/
@Controller
public class KshiController {
/*
    @Autowired
    private KshiService kshiService;
    @RequestMapping("insertWeather")
    @ResponseBody
    public Boolean insertWeather(BjWeather bjWeather){
        Boolean b=kshiService.insertWeather(bjWeather);
        return b;
    }*/

    //@ResponseBody
    //@RequestMapping("/addWeather_2")
    //@Scheduled(cron = "2 */5 * * * ?")
    /*public boolean addWeather_2() throws IOException {
        System.out.println("第二题：：：：：");
        Calendar c = Calendar.getInstance();//可以对每个时间域单独修改
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        String name=hour+""+minute+".txt";
        System.out.println(name);
        boolean b=false;
        File file = new File("D:\\kaoshi\\bj\\2019-12-04\\"+name);
        String encoding = "GBK";
        //读取数据
        if (file.isFile() && file.exists()) { //判断文件是否存在
            InputStreamReader read = new InputStreamReader(
                    new FileInputStream(file), encoding);//考虑到编码格式

            BufferedReader bufferedReader = new BufferedReader(read);
            StringBuilder str=new StringBuilder();

            String lineTxt = null;
            while ((lineTxt = bufferedReader.readLine()) != null) {
                str.append(lineTxt);
            }
            //截取字符串获取当前天气
            int realtime = str.indexOf("realtime");
            int future = str.indexOf("future");
            String weather = str.substring(realtime + 11, future - 5);
            weather="[{"+weather+"}]";
            //json转化为对象
            Weather weather1 = JSONUtilss.json2Object(weather, Weather.class);
            //存到数据库
            System.out.println(weather1);
            b=kshiService.addWeather(weather1);
        }
        return b;
    }*/


   /* @Scheduled(cron = "0 0/5 * * * * ?")
    public void testTasks2() {
        // 创建默认的httpClient实例.
        CloseableHttpClient httpclient = HttpClients.createDefault();
        // 创建httppost
        HttpPost httpPost = new HttpPost("http://apis.juhe.cn/simpleWeather/query?city=%E5%8C%97%E4%BA%AC&key=db70c50154f8c4b19d61dff2870f1b22");
        // 响应模型
        CloseableHttpResponse response = null;
        try {
            // 由客户端执行(发送)Post请求
            response = httpclient.execute(httpPost);
            // 从响应模型中获取响应实体
            HttpEntity responseEntity = response.getEntity();

            System.out.println("响应状态为:" + response.getStatusLine());
            if (responseEntity != null) {
                System.out.println("响应内容长度为:" + responseEntity.getContentLength());
                //System.out.println(EntityUtils.toString(responseEntity));
                //Weather weather = JSONUtils.json2Ojbect(EntityUtils.toString(responseEntity), Weather.class);
                //kshiService.addWeather(weather);
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                // 释放资源
                if (httpclient != null) {
                    httpclient.close();
                }
                if (response != null) {
                    response.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }*/


   /* @RequestMapping("findDpei")
    @ResponseBody
    public List<dpei> findDpei(){
        //查询地区表 获取所有的地区信息
        List<dpei> list=kshiService.findDpei();
        return list;
    }*/
   /* @ResponseBody
    @RequestMapping("findEqm")
    public PageInfo<Emp> selectYearHonor(Emp emp,String dId, @RequestParam(required = true, defaultValue = "1") int page, @RequestParam(required = true, defaultValue = "2") int pageSize) throws Exception {

        return kshiService.findEqm(emp,page,pageSize);
    }*/
   public static void  main(String[] args) {
       String s = "<school><profession name=\"软件工程\"><class id=\"001\"><student><name id=\"1\">郭艾伦</name><name id=\"2\">易建联</name><name id=\"3\">周琦</name></student></class></profession><profession name=\"计算机信息工程\"><class id=\"001\"><student><name id=\"01\">丁彦雨航</name><name id=\"02\">周鹏</name><name id=\"03\">方硕</name></student></class></profession><profession name=\"大数据\"><class id=\"001\"></class></profession></school>";
       try {
           org.dom4j.Document document = DocumentHelper.parseText(s);
           // 获取根结点对象
           Element rootElement = document.getRootElement();
           List<Node> profession = rootElement.selectNodes("profession");
           for(Node n:profession){
               n.getName();
               System.out.println(n.getName()+"ppp"+n.getDocument().getNodeTypeName());
           }
           /*Element nodes = getNodes(node);
           System.out.println("eqwqeqw"+node.asXML());*/
       } catch (DocumentException e) {
           e.printStackTrace();
       }
   }

    private static Element getNodes(Element node){
        System.out.println("--------------------");

        //当前节点的名称、文本内容和属性
        System.out.println("当前节点名称："+node.getName());//当前节点名称
        System.out.println("当前节点的内容："+node.getTextTrim());//当前节点名称
        List<Attribute> listAttr=node.attributes();//当前节点的所有属性的list
        for(Attribute attr:listAttr){//遍历当前节点的所有属性
            String name=attr.getName();//属性名称
            String value=attr.getValue();//属性的值
            if("id".equals(name)){
                attr.setValue("10000");
            }
            String values=attr.getValue();//属性的值
            System.out.println("属性名称："+name+"属性值："+value+"s:"+values);
        }
        System.out.println(listAttr);
        //递归遍历当前节点所有的子节点
        List<Element> listElement=node.elements();//所有一级子节点的list
        for(Element e:listElement){//遍历所有一级子节点
            getNodes(e);//递归
        }
        return  node;
    }


}
