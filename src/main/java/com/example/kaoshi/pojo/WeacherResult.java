package com.example.kaoshi.pojo;

import java.util.List;

/**
 * @ClassName WeacherResult
 * @Description TODO
 * @Created by Administrator on 2019/12/4 10:06
 * @Version 1.0
 **/
public class WeacherResult {

    private int id;
    //城市
    private String city;

    private WeatherRealtime realtime;

    private List<Weatherfuture> future;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public WeatherRealtime getRealtime() {
        return realtime;
    }

    public void setRealtime(WeatherRealtime realtime) {
        this.realtime = realtime;
    }

    public List<Weatherfuture> getFuture() {
        return future;
    }

    public void setFuture(List<Weatherfuture> future) {
        this.future = future;
    }

    @Override
    public String toString() {
        return "WeacherResult{" +
                "id=" + id +
                ", city='" + city + '\'' +
                ", realtime=" + realtime +
                ", future=" + future +
                '}';
    }
}
