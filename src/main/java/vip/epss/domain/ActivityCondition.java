package vip.epss.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述
 */
public class ActivityCondition extends Activity implements Serializable {
    private Date startDate;
    private Date endDate;

    public ActivityCondition() {
    }

    public ActivityCondition(Integer aid, String aname, String ades, Integer atype, Date addTime, Date startDate, Date endDate) {
        super(aid, aname, ades, atype, addTime);
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
