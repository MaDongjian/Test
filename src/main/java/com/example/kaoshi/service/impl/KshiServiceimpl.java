package com.example.kaoshi.service.impl;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.example.kaoshi.dao.KshiMapper;
import com.example.kaoshi.pojo.*;
import com.example.kaoshi.service.KshiService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * @author Administrator
 * @create 2019-04-14 18:57
 * @desc impl
 **/
@Service
public class KshiServiceimpl implements KshiService {
    @Resource
    private KshiMapper kshiMapper;


    @Override
    public Boolean insertWeather(BjWeather bjWeather) {
        return kshiMapper.insertWeather(bjWeather);
    }

    @Override
    public boolean addWeather(Weather weather) {

        return kshiMapper.addWeather(weather);
    }






    @Override
    public List<dpei> findDpei() {

        return kshiMapper.findDpei();

    }

    public static void main(String[] args) {
        String name = ColorEnum.getName(2);
        System.out.println(name);
    }
}
