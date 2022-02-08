package com.example.kaoshi.pojo;

/**
 * @author Administrator
 * @create 2019-07-24 10:46
 * @desc
 **/
public class dpei {
    private int dId;
    private String dNmae;

    public dpei() {
        super();
    }

    public dpei(int dId, String dNmae) {
        this.dId = dId;
        this.dNmae = dNmae;
    }

    public int getdId() {
        return dId;
    }

    public void setdId(int dId) {
        this.dId = dId;
    }

    public String getdNmae() {
        return dNmae;
    }

    public void setdNmae(String dNmae) {
        this.dNmae = dNmae;
    }

    @Override
    public String toString() {
        return "dpei{" +
                "dId=" + dId +
                ", dNmae='" + dNmae + '\'' +
                '}';
    }
}
