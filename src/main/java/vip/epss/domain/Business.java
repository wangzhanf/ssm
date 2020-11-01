package vip.epss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = "handler")    //用于解决mybatis关联查询时使用了懒加载方式过程中数据封装引发的问题

public class Business implements Serializable {
    private Integer bid;

    private String bname;

    private String bpass;

    private String bdes;

    private String bdelivery;

    private Double bmark;

    private String bavatar;

    private String baddress;

    private Integer brecommendation;

    private Boolean bstatus;

    private List<Activity> activities;//商家参与的活动

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    private Date addTime;

    public Business(Integer bid, String bname, String bpass, String bdes, String bdelivery, Double bmark, String bavatar, String baddress, Integer brecommendation, Boolean bstatus, Date addTime) {
        this.bid = bid;
        this.bname = bname;
        this.bpass = bpass;
        this.bdes = bdes;
        this.bdelivery = bdelivery;
        this.bmark = bmark;
        this.bavatar = bavatar;
        this.baddress = baddress;
        this.brecommendation = brecommendation;
        this.bstatus = bstatus;
        this.addTime = addTime;
    }

    public Business() {
    }

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getBname() {
        return bname;
    }

    public void setBname(String bname) {
        this.bname = bname;
    }

    public String getBpass() {
        return bpass;
    }

    public void setBpass(String bpass) {
        this.bpass = bpass;
    }

    public String getBdes() {
        return bdes;
    }

    public void setBdes(String bdes) {
        this.bdes = bdes;
    }

    public String getBdelivery() {
        return bdelivery;
    }

    public void setBdelivery(String bdelivery) {
        this.bdelivery = bdelivery;
    }

    public Double getBmark() {
        return bmark;
    }

    public void setBmark(Double bmark) {
        this.bmark = bmark;
    }

    public String getBavatar() {
        return bavatar;
    }

    public void setBavatar(String bavatar) {
        this.bavatar = bavatar;
    }

    public String getBaddress() {
        return baddress;
    }

    public void setBaddress(String baddress) {
        this.baddress = baddress;
    }

    public Integer getBrecommendation() {
        return brecommendation;
    }

    public void setBrecommendation(Integer brecommendation) {
        this.brecommendation = brecommendation;
    }

    public Boolean getBstatus() {
        return bstatus;
    }

    public void setBstatus(Boolean bstatus) {
        this.bstatus = bstatus;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}