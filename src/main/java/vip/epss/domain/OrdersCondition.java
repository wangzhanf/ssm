package vip.epss.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/29 0029
 * @描述
 */
public class OrdersCondition extends Orders implements Serializable {
    private Date startDate;
    private Date endDate;

    public OrdersCondition() {
    }

    public OrdersCondition(Integer oid, Integer onumber, Integer ostatus, Integer fgid, Integer fcid, Integer fbid, Date addTime, Date startDate, Date endDate) {
        super(oid, onumber, ostatus, fgid, fcid, fbid, addTime);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
}
