package vip.epss.domain;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(value = "handler")    //用于解决mybatis关联查询时使用了懒加载方式过程中数据封装引发的问题

public class Activity implements Serializable {
    private Integer aid;

    private String aname;

    private String ades;

    private Integer atype;

    private List<Business> businesses;//参与该活动的商家
    private Date addTime;

    public Activity(Integer aid, String aname, String ades, Integer atype, Date addTime) {
        this.aid = aid;
        this.aname = aname;
        this.ades = ades;
        this.atype = atype;
        this.addTime = addTime;
    }

    public Activity() {
    }

    public List<Business> getBusinesses() {
        return businesses;
    }

    public void setBusinesses(List<Business> businesses) {
        this.businesses = businesses;
    }

    public Integer getAid() {
        return aid;
    }

    public void setAid(Integer aid) {
        this.aid = aid;
    }

    public String getAname() {
        return aname;
    }

    public void setAname(String aname) {
        this.aname = aname;
    }

    public String getAdes() {
        return ades;
    }

    public void setAdes(String ades) {
        this.ades = ades;
    }

    public Integer getAtype() {
        return atype;
    }

    public void setAtype(Integer atype) {
        this.atype = atype;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}