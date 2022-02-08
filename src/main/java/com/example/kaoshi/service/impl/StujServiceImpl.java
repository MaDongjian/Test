/*
package com.example.kaoshi.service.impl;


import com.example.kaoshi.dao.Stujmapper;
import com.example.kaoshi.pojo.Stujz;
import com.example.kaoshi.service.StujService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

*/
/**
 * @author Administrator
 * @create 2019-08-26 9:14
 * @desc
 **//*

@Service
public class StujServiceImpl implements StujService {
    @Resource
    private Stujmapper stujmapper;
    @Override
    public PageInfo<Stujz> findSj(Stujz stujz, int page, int pageSize) {
        //设置分页信息，分别是当前页数和每页显示的总记录数
        // 使用PageHelper开始分页
        PageHelper.startPage(page, pageSize);
        //先去查询所有的Emp 的信息
        List<Stujz> list = stujmapper.findSj(stujz);
        //返回的是一个PageInfo,包含了分页的所有信息
        PageInfo<Stujz> pageInfo = new PageInfo<>(list);
        return pageInfo;
    }

    @Override
    public int insertSj(Stujz stujz) {
        return stujmapper.insertSj(stujz);
    }
}
*/
