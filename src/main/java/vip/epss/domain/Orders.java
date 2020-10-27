package vip.epss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;

@JsonIgnoreProperties(value = "handler")    //用于解决mybatis关联查询时使用了懒加载方式过程中数据封装引发的问题

public class Orders {
    private Integer oid;

    private Integer onumber;

    private Integer ostatus;

    private Integer fgid;

    private Integer fcid;

    private Integer fbid;

    private Date addTime;

    public Orders(Integer oid, Integer onumber, Integer ostatus, Integer fgid, Integer fcid, Integer fbid, Date addTime) {
        this.oid = oid;
        this.onumber = onumber;
        this.ostatus = ostatus;
        this.fgid = fgid;
        this.fcid = fcid;
        this.fbid = fbid;
        this.addTime = addTime;
    }

    public Orders() {
    }

    public Integer getOid() {
        return oid;
    }

    public void setOid(Integer oid) {
        this.oid = oid;
    }

    public Integer getOnumber() {
        return onumber;
    }

    public void setOnumber(Integer onumber) {
        this.onumber = onumber;
    }

    public Integer getOstatus() {
        return ostatus;
    }

    public void setOstatus(Integer ostatus) {
        this.ostatus = ostatus;
    }

    public Integer getFgid() {
        return fgid;
    }

    public void setFgid(Integer fgid) {
        this.fgid = fgid;
    }

    public Integer getFcid() {
        return fcid;
    }

    public void setFcid(Integer fcid) {
        this.fcid = fcid;
    }

    public Integer getFbid() {
        return fbid;
    }

    public void setFbid(Integer fbid) {
        this.fbid = fbid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}