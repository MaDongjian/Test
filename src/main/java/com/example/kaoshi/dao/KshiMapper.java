package com.example.kaoshi.dao;


import com.example.kaoshi.pojo.BjWeather;
import com.example.kaoshi.pojo.Emp;
import com.example.kaoshi.pojo.Weather;
import com.example.kaoshi.pojo.dpei;

import java.util.List;


public interface KshiMapper {

    List<Emp> findEqm(Emp emp);

    List<dpei> findDpei();

    Boolean insertWeather(BjWeather bjWeather);

    boolean addWeather(Weather weather);
}
