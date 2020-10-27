package vip.epss.domain;


import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.Date;

@JsonIgnoreProperties(value = "handler")    //用于解决mybatis关联查询时使用了懒加载方式过程中数据封装引发的问题

public class Customer implements Serializable {
    private Integer cid;

    private String cname;
    private String cphone;
    private String cemail;
    private String cpass;
    private Date cbirth;
    private String cavatar;
    private Boolean cgender;
    private Boolean cstatus;
    private Date addTime;

    public Customer(Integer cid, String cname, String cphone, String cemail, String cpass, Date cbirth, String cavatar, Boolean cgender, Boolean cstatus, Date addTime) {
        this.cid = cid;
        this.cname = cname;
        this.cphone = cphone;
        this.cemail = cemail;
        this.cpass = cpass;
        this.cbirth = cbirth;
        this.cavatar = cavatar;
        this.cgender = cgender;
        this.cstatus = cstatus;
        this.addTime = addTime;
    }

    public Customer() {
    }

    public Integer getCid() {
        return cid;
    }

    public void setCid(Integer cid) {
        this.cid = cid;
    }

    public String getCname() {
        return cname;
    }

    public void setCname(String cname) {
        this.cname = cname;
    }

    public String getCphone() {
        return cphone;
    }

    public void setCphone(String cphone) {
        this.cphone = cphone;
    }

    public String getCemail() {
        return cemail;
    }

    public void setCemail(String cemail) {
        this.cemail = cemail;
    }

    public String getCpass() {
        return cpass;
    }

    public void setCpass(String cpass) {
        this.cpass = cpass;
    }

    public Date getCbirth() {
        return cbirth;
    }

    public void setCbirth(Date cbirth) {
        this.cbirth = cbirth;
    }

    public String getCavatar() {
        return cavatar;
    }

    public void setCavatar(String cavatar) {
        this.cavatar = cavatar;
    }

    public Boolean getCgender() {
        return cgender;
    }

    public void setCgender(Boolean cgender) {
        this.cgender = cgender;
    }

    public Boolean getCstatus() {
        return cstatus;
    }

    public void setCstatus(Boolean cstatus) {
        this.cstatus = cstatus;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}