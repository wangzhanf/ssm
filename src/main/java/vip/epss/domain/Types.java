package vip.epss.domain;

import java.util.Date;

public class Types {
    private Integer tid;

    private String tname;

    private String tdes;

    private String tavatar;

    private Date addTime;

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