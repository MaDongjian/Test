package com.example.kaoshi.utils;



import org.springframework.util.StringUtils;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import java.util.List;

public class JSONUtilss {
    /***
     * List 转为 JSON
     * @param list
     * @return
     */
    public static <T> String list2Json(List<T> list) {
        if(null != list && list.size() > 0){
            return JSONArray.toJSONString(list);
        }
        return "";
    }

    /***
     * JSON 转换为 List
     * @param jsonStr
     *         [{"age":12,"createTime":null,"id":"","name":"wxw","registerTime":null,"sex":1},{...}]
     * @param objectClass
     * @return
     */
    @SuppressWarnings("unchecked")
   public static <T> List<T> json2List(String jsonStr, Class<T> objectClass){

        if (!StringUtils.isEmpty(jsonStr)) {
            List<T> list = (List<T>) JSONArray.parse(jsonStr);

            return list;
        }
        return null;
    }


    /**
     * List<T> 转 json 保存到数据库
     */
    public static <T> String listToJson(List<T> ts) {
        String jsons = JSON.toJSONString(ts);
        return jsons;
    }

    /**
     * json 转 List<T>
     */
    public static <T> List<T> jsonToList(String jsonString, Class<T> clazz) {
        @SuppressWarnings("unchecked")
        List<T> ts = (List<T>) JSONArray.parseArray(jsonString, clazz);
        return ts;
    }



    /***
     * Object 转为  JSON
     * @param object
     * @return
     */
    public static String object2Json(Object object) {
        if(null != object){
            Object o = JSONArray.toJSON(object);
            return o.toString();
        }
        return "";
    }

    /***
     *
     * JSON 转 Object
     *
     * @param jsonStr
     *         [{"age":12,"createTime":null,"id":"","name":"wxw","registerTime":null,"sex":1}]
     * @param objectClass
     * @return
     */
    @SuppressWarnings("unchecked")
    public static <T> T json2Object(String jsonStr,  Class<T> objectClass){
       if(null != jsonStr){
            String leftStr = jsonStr.substring(0,2);
            String rightStr = jsonStr.substring(jsonStr.length()-2,jsonStr.length());
            if(leftStr.equals("[{")){
                jsonStr = jsonStr.substring(1,jsonStr.length());
            }
            if(rightStr.equals("}]")){
                jsonStr = jsonStr.substring(0,jsonStr.length()-1);
            }

           JSONObject jsonObject = JSONObject.parseObject(jsonStr);
           return (T) JSONObject.toJavaObject(jsonObject,objectClass);
        }
        return null;
    }

    /***
     * JsonArray 转为 JSON
     * @param jsonArray
     * @return
     */
    public static String jsonArrayToJSONString(JSONArray jsonArray) {
       /* if(null != jsonArray){
            return jsonArray.toString();
        }*/
        return "";
    }

    /***
     * JsonObject 转为  JSON
     * @param jsonObject
     * @return
     */
    public static String jsonObjectToJSONString(JSONObject jsonObject) {
        /*if(null != jsonObject){
            return jsonObject.toString();
        }*/
        return "";
    }

    /***
     * 将Object转换为JsonObject
     * @param object
     * @return
     */
    public static JSONObject object2JsonObject(Object object) {
       /* if(null != object){
            return JSONObject.fromObject(object);
        }*/
        return null;
    }


}
