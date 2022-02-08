package com.example.kaoshi.pojo;

/**
 * @author Administrator
 * @create 2019-08-26 8:34
 * @desc
 **/
public class Stujz {
    private Integer id;
    private String stuname;
    private String stuage;
    private String stusex;
    private String jzname;
    private String jztel;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getStuname() {
        return stuname;
    }

    public void setStuname(String stuname) {
        this.stuname = stuname;
    }

    public String getStuage() {
        return stuage;
    }

    public void setStuage(String stuage) {
        this.stuage = stuage;
    }

    public String getStusex() {
        return stusex;
    }

    public void setStusex(String stusex) {
        this.stusex = stusex;
    }

    public String getJzname() {
        return jzname;
    }

    public void setJzname(String jzname) {
        this.jzname = jzname;
    }

    public String getJztel() {
        return jztel;
    }

    public void setJztel(String jztel) {
        this.jztel = jztel;
    }

    @Override
    public String toString() {
        return "Stujz{" +
                "id=" + id +
                ", stuname='" + stuname + '\'' +
                ", stuage='" + stuage + '\'' +
                ", stusex='" + stusex + '\'' +
                ", jzname='" + jzname + '\'' +
                ", jztel=" + jztel +
                '}';
    }
}
