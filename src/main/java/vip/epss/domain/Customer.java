package vip.epss.domain;

import lombok.Data;

import java.util.Date;
@Data
public class Customer {
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