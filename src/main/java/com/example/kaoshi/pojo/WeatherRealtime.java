package com.example.kaoshi.pojo;

/**
 * @ClassName WeatherRealtime
 * @Description TODO
 * @Created by Administrator on 2019/12/4 10:09
 * @Version 1.0
 **/
public class WeatherRealtime {
    //温度
    private String temperature;
    //湿度
    private String humidity;
    //天气情况
    private String info;
    //天气标识id
    private String wid;
    //风向
    private String direct;
    //风力
    private String power;
    //空气质量指数
    private String aqi;

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    public String getHumidity() {
        return humidity;
    }

    public void setHumidity(String humidity) {
        this.humidity = humidity;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }

    public String getWid() {
        return wid;
    }

    public void setWid(String wid) {
        this.wid = wid;
    }

    public String getDirect() {
        return direct;
    }

    public void setDirect(String direct) {
        this.direct = direct;
    }

    public String getPower() {
        return power;
    }

    public void setPower(String power) {
        this.power = power;
    }

    public String getAqi() {
        return aqi;
    }

    public void setAqi(String aqi) {
        this.aqi = aqi;
    }

    @Override
    public String toString() {
        return "WeatherRealtime{" +
                "temperature='" + temperature + '\'' +
                ", humidity='" + humidity + '\'' +
                ", info='" + info + '\'' +
                ", wid='" + wid + '\'' +
                ", direct='" + direct + '\'' +
                ", power='" + power + '\'' +
                ", aqi='" + aqi + '\'' +
                '}';
    }
}
