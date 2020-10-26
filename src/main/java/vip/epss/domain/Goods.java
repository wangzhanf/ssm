package vip.epss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.sun.source.doctree.SerialDataTree;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@Data
@JsonIgnoreProperties(value = "handler")
public class Goods implements Serializable {
    private Integer gid;

    private String gname;

    private String gdes;

    private Double gprice;

    private String gavatar;

    private Integer fbid;

    private Business business;

    private Integer ftid;

    private Types types;

    private Date addTime;

    public Goods() {
    }

    public Goods(Integer gid, String gname, String gdes, Double gprice, String gavatar, Integer fbid, Business business, Integer ftid, Types types, Date addTime) {
        this.gid = gid;
        this.gname = gname;
        this.gdes = gdes;
        this.gprice = gprice;
        this.gavatar = gavatar;
        this.fbid = fbid;
        this.business = business;
        this.ftid = ftid;
        this.types = types;
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

    public Business getBusiness() {
        return business;
    }

    public void setBusiness(Business business) {
        this.business = business;
    }

    public Integer getFtid() {
        return ftid;
    }

    public void setFtid(Integer ftid) {
        this.ftid = ftid;
    }

    public Types getTypes() {
        return types;
    }

    public void setTypes(Types types) {
        this.types = types;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}