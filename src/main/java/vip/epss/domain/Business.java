package vip.epss.domain;

import java.util.Date;

public class Business {
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

    private Date addTime;

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