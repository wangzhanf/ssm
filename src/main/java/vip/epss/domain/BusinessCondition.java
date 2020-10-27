package vip.epss.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @创建人 epss[wangzhanf]
 * @创建时间 2020/10/27 0027
 * @描述
 */
public class BusinessCondition extends Business implements Serializable {
    private Integer bmarkCondition;
    private Integer brecommendationCondition;

    public BusinessCondition(Integer bid, String bname, String bpass, String bdes, String bdelivery, Double bmark, String bavatar, String baddress, Integer brecommendation, Boolean bstatus, Date addTime, Integer bmarkCondition, Integer brecommendationCondition) {
        super(bid, bname, bpass, bdes, bdelivery, bmark, bavatar, baddress, brecommendation, bstatus, addTime);
        this.bmarkCondition = bmarkCondition;
        this.brecommendationCondition = brecommendationCondition;
    }

    public BusinessCondition() {
    }

    public Integer getBmarkCondition() {
        return bmarkCondition;
    }

    public void setBmarkCondition(Integer bmarkCondition) {
        this.bmarkCondition = bmarkCondition;
    }

    public Integer getBrecommendationCondition() {
        return brecommendationCondition;
    }

    public void setBrecommendationCondition(Integer brecommendationCondition) {
        this.brecommendationCondition = brecommendationCondition;
    }
}
