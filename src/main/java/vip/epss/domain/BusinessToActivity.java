package vip.epss.domain;

import java.util.Date;

public class BusinessToActivity {
    private Integer baid;

    private Integer fbid;

    private Integer faid;

    private Date addTime;

    public Integer getBaid() {
        return baid;
    }

    public void setBaid(Integer baid) {
        this.baid = baid;
    }

    public Integer getFbid() {
        return fbid;
    }

    public void setFbid(Integer fbid) {
        this.fbid = fbid;
    }

    public Integer getFaid() {
        return faid;
    }

    public void setFaid(Integer faid) {
        this.faid = faid;
    }

    public Date getAddTime() {
        return addTime;
    }

    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }
}