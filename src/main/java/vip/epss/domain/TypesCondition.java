package vip.epss.domain;

import java.util.Date;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述
 */
public class TypesCondition extends Types {
    private Date startDate;
    private Date endDate;

    public TypesCondition(Integer tid, String tname, String tdes, String tavatar, Date addTime, Date startDate, Date endDate) {
        super(tid, tname, tdes, tavatar, addTime);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public TypesCondition() {
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
