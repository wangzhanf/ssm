package vip.epss.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/22 0022
 * @描述
 */
public class UserCondition extends User implements Serializable {
    private Integer uidCondition;//对于通过指定范围的整数型内容,一般选择此种条件限定方式
    private Date startDate;
    private Date endDate;

    public UserCondition() {
    }

    public UserCondition(Integer uid, String username, String password, Date addTime, Integer uidCondition, Date startDate, Date endDate) {
        super(uid, username, password, addTime);
        this.uidCondition = uidCondition;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    @Override
    public String toString() {
        return "UserCondition{" +
                "uidCondition=" + uidCondition +
                ", startDate=" + startDate +
                ", endDate=" + endDate +
                "} " + super.toString();
    }

    public Integer getUidCondition() {
        return uidCondition;
    }

    public void setUidCondition(Integer uidCondition) {
        this.uidCondition = uidCondition;
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
