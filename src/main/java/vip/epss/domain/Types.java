package vip.epss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(value = "handler")    //用于解决mybatis关联查询时使用了懒加载方式过程中数据封装引发的问题

public class Types {
    private Integer tid;

    private String tname;

    private String tdes;

    private String tavatar;

    private Date addTime;

    public Types(Integer tid, String tname, String tdes, String tavatar, Date addTime) {
        this.tid = tid;
        this.tname = tname;
        this.tdes = tdes;
        this.tavatar = tavatar;
        this.addTime = addTime;
    }

    public Types() {
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTname() {
        return tname;
    }

    public void setTname(String tname) {
        this.tname = tname;
    }

    public String getTdes() {
        return tdes;
    }

    public void setTdes(String tdes) {
        this.tdes = tdes;
    }

    public String getTavatar() {
        return tavatar;
    }

    public void setTavatar(String tavatar) {
        this.tavatar = tavatar;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}