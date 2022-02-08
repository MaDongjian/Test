package com.example.kaoshi.pojo;

import java.util.Date;

/**
 * @author Administrator
 * @create 2019-07-24 8:43
 * @desc
 **/
public class Emp {
    private String eId;
    private String eName;
    private String eSix;
    private String eWages;
    private String eLevel;
    private String dId;
    private String dName;
    private Date date;

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    @Override
    public String toString() {
        return "Emp{" +
                "eId='" + eId + '\'' +
                ", eName='" + eName + '\'' +
                ", eSix='" + eSix + '\'' +
                ", eWages='" + eWages + '\'' +
                ", eLevel='" + eLevel + '\'' +
                ", dId='" + dId + '\'' +
                ", dName='" + dName + '\'' +
                '}';
    }

    public String geteId() {
        return eId;
    }

    public void seteId(String eId) {
        this.eId = eId;
    }

    public String geteName() {
        return eName;
    }

    public void seteName(String eName) {
        this.eName = eName;
    }

    public String geteSix() {
        return eSix;
    }

    public void seteSix(String eSix) {
        this.eSix = eSix;
    }

    public String geteWages() {
        return eWages;
    }

    public void seteWages(String eWages) {
        this.eWages = eWages;
    }

    public String geteLevel() {
        return eLevel;
    }

    public void seteLevel(String eLevel) {
        this.eLevel = eLevel;
    }

    public String getdId() {
        return dId;
    }

    public void setdId(String dId) {
        this.dId = dId;
    }

    public String getdName() {
        return dName;
    }

    public void setdName(String dName) {
        this.dName = dName;
    }
}
