package com.example.kaoshi.pojo;

/**
 * @ClassName WeatherfutureVo
 * @Description TODO
 * @Created by Administrator on 2019/12/4 11:06
 * @Version 1.0
 **/
public class WeatherfutureVo {
    private String day;

    private String night;

    public String getDay() {
        return day;
    }

    public void setDay(String day) {
        this.day = day;
    }

    public String getNight() {
        return night;
    }

    public void setNight(String night) {
        this.night = night;
    }

    @Override
    public String toString() {
        return "WeatherfutureVo{" +
                "day='" + day + '\'' +
                ", night='" + night + '\'' +
                '}';
    }
}
