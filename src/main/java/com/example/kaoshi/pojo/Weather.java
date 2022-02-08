package com.example.kaoshi.pojo;

import java.util.List;

/**
 * @ClassName WEATHER
 * @Description TODO
 * @Created by Administrator on 2019/12/4 10:05
 * @Version 1.0
 **/
public class Weather {
    //主键
    private int id;

    private String reason;

    private WeacherResult result;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public WeacherResult getResult() {
        return result;
    }

    public void setResult(WeacherResult result) {
        this.result = result;
    }

    @Override
    public String toString() {
        return "Weather{" +
                "reason='" + reason + '\'' +
                ", result=" + result +
                '}';
    }
}
