package com.example.kaoshi.dao;


import com.example.kaoshi.pojo.Stujz;

import java.util.List;

/**
 * @author Administrator
 * @create 2019-08-26 9:15
 * @desc
 **/
public interface Stujmapper {
    List<Stujz> findSj(Stujz stujz);

    int insertSj(Stujz stujz);
}
