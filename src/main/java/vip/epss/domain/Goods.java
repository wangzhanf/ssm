package vip.epss.domain;

import com.sun.source.doctree.SerialDataTree;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
public class Goods implements Serializable {
    private Integer gid;

    private String gname;

    private String gdes;

    private Double gprice;

    private String gavatar;

    private Integer fbid;

    private Integer ftid;

    private Date addTime;

    public Goods() {
    }

    public Goods(Integer gid, String gname, String gdes, Double gprice, String gavatar, Integer fbid, Integer ftid, Date addTime) {
        this.gid = gid;
        this.gname = gname;
        this.gdes = gdes;
        this.gprice = gprice;
        this.gavatar = gavatar;
        this.fbid = fbid;
        this.ftid = ftid;
        this.addTime = addTime;
    }

    public Integer getGid() {
        return gid;
    }

    public void setGid(Integer gid) {
        this.gid = gid;
    }

    public String getGname() {
        return gname;
    }

    public void setGname(String gname) {
        this.gname = gname;
    }

    public String getGdes() {
        return gdes;
    }

    public void setGdes(String gdes) {
        this.gdes = gdes;
    }

    public Double getGprice() {
        return gprice;
    }

    public void setGprice(Double gprice) {
        this.gprice = gprice;
    }

    public String getGavatar() {
        return gavatar;
    }

    public void setGavatar(String gavatar) {
        this.gavatar = gavatar;
    }

    public Integer getFbid() {
        return fbid;
    }

    public void setFbid(Integer fbid) {
        this.fbid = fbid;
    }

    public Integer getFtid() {
        return ftid;
    }

    public void setFtid(Integer ftid) {
        this.ftid = ftid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}