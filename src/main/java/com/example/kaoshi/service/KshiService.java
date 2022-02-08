package com.example.kaoshi.service;


import com.example.kaoshi.pojo.BjWeather;
import com.example.kaoshi.pojo.Emp;
import com.example.kaoshi.pojo.Weather;
import com.example.kaoshi.pojo.dpei;

import java.util.List;


public interface KshiService {

    List<dpei> findDpei();


    //PageInfo<Emp> findEqm(Emp emp, int page, int pageSize);

    Boolean insertWeather(BjWeather bjWeather);

    boolean addWeather(Weather weather);
}
