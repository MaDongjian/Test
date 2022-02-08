package com.example.kaoshi.pojo;

/**
 * @ClassName Weatherfuture
 * @Description TODO
 * @Created by Administrator on 2019/12/4 10:07
 * @Version 1.0
 **/
public class Weatherfuture {

    private int weatherId;
    //日期
    private String date;
    //温度
    private String temperature;


    //天气
    private String weather;
    //风向
    private String direct;

    public int getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(int weatherId) {
        this.weatherId = weatherId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getWeather() {
        return weather;
    }

    public void setWeather(String weather) {
        this.weather = weather;
    }



    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    @Override
    public String toString() {
        return "Weatherfuture{" +
                "date='" + date + '\'' +
                ", temperature='" + temperature + '\'' +
                ", weather='" + weather + '\'' +
                ", direct='" + direct + '\'' +
                '}';
    }
}
