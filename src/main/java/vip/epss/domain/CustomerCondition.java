package vip.epss.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述
 */
public class CustomerCondition extends Customer implements Serializable {
    private Date startDate;
    private Date endDate;

    public CustomerCondition(Integer cid, String cname, String cphone, String cemail, String cpass, Date cbirth, String cavatar, Boolean cgender, Boolean cstatus, Date addTime, Date startDate, Date endDate) {
        super(cid, cname, cphone, cemail, cpass, cbirth, cavatar, cgender, cstatus, addTime);
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public CustomerCondition() {
    }
}
