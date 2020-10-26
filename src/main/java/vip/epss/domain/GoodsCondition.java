package vip.epss.domain;

import java.io.Serializable;
import java.util.Date;

public class GoodsCondition extends Goods implements Serializable {
    private Double minPrice;
    private Double maxPrice;
    private Date startDate;
    private Date endDate;

    public GoodsCondition() {
    }

    public GoodsCondition(Integer gid, String gname, String gdes, Double gprice, String gavatar, Integer fbid, Business business, Integer ftid, Types types, Date addTime, Double minPrice, Double maxPrice, Date startDate, Date endDate) {
        super(gid, gname, gdes, gprice, gavatar, fbid, business, ftid, types, addTime);
        this.minPrice = minPrice;
        this.maxPrice = maxPrice;
        this.startDate = startDate;
        this.endDate = endDate;
    }

    public Double getMinPrice() {
        return minPrice;
    }

    public void setMinPrice(Double minPrice) {
        this.minPrice = minPrice;
    }

    public Double getMaxPrice() {
        return maxPrice;
    }

    public void setMaxPrice(Double maxPrice) {
        this.maxPrice = maxPrice;
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
