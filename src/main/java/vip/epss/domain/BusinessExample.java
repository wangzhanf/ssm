package vip.epss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class BusinessExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public BusinessExample() {
        oredCriteria = new ArrayList<Criteria>();
    }

    public void setOrderByClause(String orderByClause) {
        this.orderByClause = orderByClause;
    }

    public String getOrderByClause() {
        return orderByClause;
    }

    public void setDistinct(boolean distinct) {
        this.distinct = distinct;
    }

    public boolean isDistinct() {
        return distinct;
    }

    public List<Criteria> getOredCriteria() {
        return oredCriteria;
    }

    public void or(Criteria criteria) {
        oredCriteria.add(criteria);
    }

    public Criteria or() {
        Criteria criteria = createCriteriaInternal();
        oredCriteria.add(criteria);
        return criteria;
    }

    public Criteria createCriteria() {
        Criteria criteria = createCriteriaInternal();
        if (oredCriteria.size() == 0) {
            oredCriteria.add(criteria);
        }
        return criteria;
    }

    protected Criteria createCriteriaInternal() {
        Criteria criteria = new Criteria();
        return criteria;
    }

    public void clear() {
        oredCriteria.clear();
        orderByClause = null;
        distinct = false;
    }

    protected abstract static class GeneratedCriteria {
        protected List<Criterion> criteria;

        protected GeneratedCriteria() {
            super();
            criteria = new ArrayList<Criterion>();
        }

        public boolean isValid() {
            return criteria.size() > 0;
        }

        public List<Criterion> getAllCriteria() {
            return criteria;
        }

        public List<Criterion> getCriteria() {
            return criteria;
        }

        protected void addCriterion(String condition) {
            if (condition == null) {
                throw new RuntimeException("Value for condition cannot be null");
            }
            criteria.add(new Criterion(condition));
        }

        protected void addCriterion(String condition, Object value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value));
        }

        protected void addCriterion(String condition, Object value1, Object value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            criteria.add(new Criterion(condition, value1, value2));
        }

        public Criteria andBidIsNull() {
            addCriterion("bid is null");
            return (Criteria) this;
        }

        public Criteria andBidIsNotNull() {
            addCriterion("bid is not null");
            return (Criteria) this;
        }

        public Criteria andBidEqualTo(Integer value) {
            addCriterion("bid =", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotEqualTo(Integer value) {
            addCriterion("bid <>", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThan(Integer value) {
            addCriterion("bid >", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidGreaterThanOrEqualTo(Integer value) {
            addCriterion("bid >=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThan(Integer value) {
            addCriterion("bid <", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidLessThanOrEqualTo(Integer value) {
            addCriterion("bid <=", value, "bid");
            return (Criteria) this;
        }

        public Criteria andBidIn(List<Integer> values) {
            addCriterion("bid in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotIn(List<Integer> values) {
            addCriterion("bid not in", values, "bid");
            return (Criteria) this;
        }

        public Criteria andBidBetween(Integer value1, Integer value2) {
            addCriterion("bid between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBidNotBetween(Integer value1, Integer value2) {
            addCriterion("bid not between", value1, value2, "bid");
            return (Criteria) this;
        }

        public Criteria andBnameIsNull() {
            addCriterion("bname is null");
            return (Criteria) this;
        }

        public Criteria andBnameIsNotNull() {
            addCriterion("bname is not null");
            return (Criteria) this;
        }

        public Criteria andBnameEqualTo(String value) {
            addCriterion("bname =", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotEqualTo(String value) {
            addCriterion("bname <>", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThan(String value) {
            addCriterion("bname >", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameGreaterThanOrEqualTo(String value) {
            addCriterion("bname >=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThan(String value) {
            addCriterion("bname <", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLessThanOrEqualTo(String value) {
            addCriterion("bname <=", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameLike(String value) {
            addCriterion("bname like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotLike(String value) {
            addCriterion("bname not like", value, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameIn(List<String> values) {
            addCriterion("bname in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotIn(List<String> values) {
            addCriterion("bname not in", values, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameBetween(String value1, String value2) {
            addCriterion("bname between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBnameNotBetween(String value1, String value2) {
            addCriterion("bname not between", value1, value2, "bname");
            return (Criteria) this;
        }

        public Criteria andBpassIsNull() {
            addCriterion("bpass is null");
            return (Criteria) this;
        }

        public Criteria andBpassIsNotNull() {
            addCriterion("bpass is not null");
            return (Criteria) this;
        }

        public Criteria andBpassEqualTo(String value) {
            addCriterion("bpass =", value, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassNotEqualTo(String value) {
            addCriterion("bpass <>", value, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassGreaterThan(String value) {
            addCriterion("bpass >", value, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassGreaterThanOrEqualTo(String value) {
            addCriterion("bpass >=", value, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassLessThan(String value) {
            addCriterion("bpass <", value, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassLessThanOrEqualTo(String value) {
            addCriterion("bpass <=", value, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassLike(String value) {
            addCriterion("bpass like", value, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassNotLike(String value) {
            addCriterion("bpass not like", value, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassIn(List<String> values) {
            addCriterion("bpass in", values, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassNotIn(List<String> values) {
            addCriterion("bpass not in", values, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassBetween(String value1, String value2) {
            addCriterion("bpass between", value1, value2, "bpass");
            return (Criteria) this;
        }

        public Criteria andBpassNotBetween(String value1, String value2) {
            addCriterion("bpass not between", value1, value2, "bpass");
            return (Criteria) this;
        }

        public Criteria andBdesIsNull() {
            addCriterion("bdes is null");
            return (Criteria) this;
        }

        public Criteria andBdesIsNotNull() {
            addCriterion("bdes is not null");
            return (Criteria) this;
        }

        public Criteria andBdesEqualTo(String value) {
            addCriterion("bdes =", value, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesNotEqualTo(String value) {
            addCriterion("bdes <>", value, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesGreaterThan(String value) {
            addCriterion("bdes >", value, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesGreaterThanOrEqualTo(String value) {
            addCriterion("bdes >=", value, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesLessThan(String value) {
            addCriterion("bdes <", value, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesLessThanOrEqualTo(String value) {
            addCriterion("bdes <=", value, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesLike(String value) {
            addCriterion("bdes like", value, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesNotLike(String value) {
            addCriterion("bdes not like", value, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesIn(List<String> values) {
            addCriterion("bdes in", values, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesNotIn(List<String> values) {
            addCriterion("bdes not in", values, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesBetween(String value1, String value2) {
            addCriterion("bdes between", value1, value2, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdesNotBetween(String value1, String value2) {
            addCriterion("bdes not between", value1, value2, "bdes");
            return (Criteria) this;
        }

        public Criteria andBdeliveryIsNull() {
            addCriterion("bdelivery is null");
            return (Criteria) this;
        }

        public Criteria andBdeliveryIsNotNull() {
            addCriterion("bdelivery is not null");
            return (Criteria) this;
        }

        public Criteria andBdeliveryEqualTo(String value) {
            addCriterion("bdelivery =", value, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryNotEqualTo(String value) {
            addCriterion("bdelivery <>", value, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryGreaterThan(String value) {
            addCriterion("bdelivery >", value, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryGreaterThanOrEqualTo(String value) {
            addCriterion("bdelivery >=", value, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryLessThan(String value) {
            addCriterion("bdelivery <", value, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryLessThanOrEqualTo(String value) {
            addCriterion("bdelivery <=", value, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryLike(String value) {
            addCriterion("bdelivery like", value, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryNotLike(String value) {
            addCriterion("bdelivery not like", value, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryIn(List<String> values) {
            addCriterion("bdelivery in", values, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryNotIn(List<String> values) {
            addCriterion("bdelivery not in", values, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryBetween(String value1, String value2) {
            addCriterion("bdelivery between", value1, value2, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBdeliveryNotBetween(String value1, String value2) {
            addCriterion("bdelivery not between", value1, value2, "bdelivery");
            return (Criteria) this;
        }

        public Criteria andBmarkIsNull() {
            addCriterion("bmark is null");
            return (Criteria) this;
        }

        public Criteria andBmarkIsNotNull() {
            addCriterion("bmark is not null");
            return (Criteria) this;
        }

        public Criteria andBmarkEqualTo(Double value) {
            addCriterion("bmark =", value, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkNotEqualTo(Double value) {
            addCriterion("bmark <>", value, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkGreaterThan(Double value) {
            addCriterion("bmark >", value, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkGreaterThanOrEqualTo(Double value) {
            addCriterion("bmark >=", value, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkLessThan(Double value) {
            addCriterion("bmark <", value, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkLessThanOrEqualTo(Double value) {
            addCriterion("bmark <=", value, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkIn(List<Double> values) {
            addCriterion("bmark in", values, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkNotIn(List<Double> values) {
            addCriterion("bmark not in", values, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkBetween(Double value1, Double value2) {
            addCriterion("bmark between", value1, value2, "bmark");
            return (Criteria) this;
        }

        public Criteria andBmarkNotBetween(Double value1, Double value2) {
            addCriterion("bmark not between", value1, value2, "bmark");
            return (Criteria) this;
        }

        public Criteria andBavatarIsNull() {
            addCriterion("bavatar is null");
            return (Criteria) this;
        }

        public Criteria andBavatarIsNotNull() {
            addCriterion("bavatar is not null");
            return (Criteria) this;
        }

        public Criteria andBavatarEqualTo(String value) {
            addCriterion("bavatar =", value, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarNotEqualTo(String value) {
            addCriterion("bavatar <>", value, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarGreaterThan(String value) {
            addCriterion("bavatar >", value, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarGreaterThanOrEqualTo(String value) {
            addCriterion("bavatar >=", value, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarLessThan(String value) {
            addCriterion("bavatar <", value, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarLessThanOrEqualTo(String value) {
            addCriterion("bavatar <=", value, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarLike(String value) {
            addCriterion("bavatar like", value, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarNotLike(String value) {
            addCriterion("bavatar not like", value, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarIn(List<String> values) {
            addCriterion("bavatar in", values, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarNotIn(List<String> values) {
            addCriterion("bavatar not in", values, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarBetween(String value1, String value2) {
            addCriterion("bavatar between", value1, value2, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBavatarNotBetween(String value1, String value2) {
            addCriterion("bavatar not between", value1, value2, "bavatar");
            return (Criteria) this;
        }

        public Criteria andBaddressIsNull() {
            addCriterion("baddress is null");
            return (Criteria) this;
        }

        public Criteria andBaddressIsNotNull() {
            addCriterion("baddress is not null");
            return (Criteria) this;
        }

        public Criteria andBaddressEqualTo(String value) {
            addCriterion("baddress =", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressNotEqualTo(String value) {
            addCriterion("baddress <>", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressGreaterThan(String value) {
            addCriterion("baddress >", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressGreaterThanOrEqualTo(String value) {
            addCriterion("baddress >=", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressLessThan(String value) {
            addCriterion("baddress <", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressLessThanOrEqualTo(String value) {
            addCriterion("baddress <=", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressLike(String value) {
            addCriterion("baddress like", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressNotLike(String value) {
            addCriterion("baddress not like", value, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressIn(List<String> values) {
            addCriterion("baddress in", values, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressNotIn(List<String> values) {
            addCriterion("baddress not in", values, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressBetween(String value1, String value2) {
            addCriterion("baddress between", value1, value2, "baddress");
            return (Criteria) this;
        }

        public Criteria andBaddressNotBetween(String value1, String value2) {
            addCriterion("baddress not between", value1, value2, "baddress");
            return (Criteria) this;
        }

        public Criteria andBrecommendationIsNull() {
            addCriterion("brecommendation is null");
            return (Criteria) this;
        }

        public Criteria andBrecommendationIsNotNull() {
            addCriterion("brecommendation is not null");
            return (Criteria) this;
        }

        public Criteria andBrecommendationEqualTo(Integer value) {
            addCriterion("brecommendation =", value, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationNotEqualTo(Integer value) {
            addCriterion("brecommendation <>", value, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationGreaterThan(Integer value) {
            addCriterion("brecommendation >", value, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationGreaterThanOrEqualTo(Integer value) {
            addCriterion("brecommendation >=", value, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationLessThan(Integer value) {
            addCriterion("brecommendation <", value, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationLessThanOrEqualTo(Integer value) {
            addCriterion("brecommendation <=", value, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationIn(List<Integer> values) {
            addCriterion("brecommendation in", values, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationNotIn(List<Integer> values) {
            addCriterion("brecommendation not in", values, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationBetween(Integer value1, Integer value2) {
            addCriterion("brecommendation between", value1, value2, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBrecommendationNotBetween(Integer value1, Integer value2) {
            addCriterion("brecommendation not between", value1, value2, "brecommendation");
            return (Criteria) this;
        }

        public Criteria andBstatusIsNull() {
            addCriterion("bstatus is null");
            return (Criteria) this;
        }

        public Criteria andBstatusIsNotNull() {
            addCriterion("bstatus is not null");
            return (Criteria) this;
        }

        public Criteria andBstatusEqualTo(Boolean value) {
            addCriterion("bstatus =", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotEqualTo(Boolean value) {
            addCriterion("bstatus <>", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusGreaterThan(Boolean value) {
            addCriterion("bstatus >", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("bstatus >=", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusLessThan(Boolean value) {
            addCriterion("bstatus <", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusLessThanOrEqualTo(Boolean value) {
            addCriterion("bstatus <=", value, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusIn(List<Boolean> values) {
            addCriterion("bstatus in", values, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotIn(List<Boolean> values) {
            addCriterion("bstatus not in", values, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusBetween(Boolean value1, Boolean value2) {
            addCriterion("bstatus between", value1, value2, "bstatus");
            return (Criteria) this;
        }

        public Criteria andBstatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("bstatus not between", value1, value2, "bstatus");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNull() {
            addCriterion("add_time is null");
            return (Criteria) this;
        }

        public Criteria andAddTimeIsNotNull() {
            addCriterion("add_time is not null");
            return (Criteria) this;
        }

        public Criteria andAddTimeEqualTo(Date value) {
            addCriterion("add_time =", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotEqualTo(Date value) {
            addCriterion("add_time <>", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThan(Date value) {
            addCriterion("add_time >", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("add_time >=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThan(Date value) {
            addCriterion("add_time <", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeLessThanOrEqualTo(Date value) {
            addCriterion("add_time <=", value, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeIn(List<Date> values) {
            addCriterion("add_time in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotIn(List<Date> values) {
            addCriterion("add_time not in", values, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeBetween(Date value1, Date value2) {
            addCriterion("add_time between", value1, value2, "addTime");
            return (Criteria) this;
        }

        public Criteria andAddTimeNotBetween(Date value1, Date value2) {
            addCriterion("add_time not between", value1, value2, "addTime");
            return (Criteria) this;
        }
    }

    public static class Criteria extends GeneratedCriteria {

        protected Criteria() {
            super();
        }
    }

    public static class Criterion {
        private String condition;

        private Object value;

        private Object secondValue;

        private boolean noValue;

        private boolean singleValue;

        private boolean betweenValue;

        private boolean listValue;

        private String typeHandler;

        public String getCondition() {
            return condition;
        }

        public Object getValue() {
            return value;
        }

        public Object getSecondValue() {
            return secondValue;
        }

        public boolean isNoValue() {
            return noValue;
        }

        public boolean isSingleValue() {
            return singleValue;
        }

        public boolean isBetweenValue() {
            return betweenValue;
        }

        public boolean isListValue() {
            return listValue;
        }

        public String getTypeHandler() {
            return typeHandler;
        }

        protected Criterion(String condition) {
            super();
            this.condition = condition;
            this.typeHandler = null;
            this.noValue = true;
        }

        protected Criterion(String condition, Object value, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.typeHandler = typeHandler;
            if (value instanceof List<?>) {
                this.listValue = true;
            } else {
                this.singleValue = true;
            }
        }

        protected Criterion(String condition, Object value) {
            this(condition, value, null);
        }

        protected Criterion(String condition, Object value, Object secondValue, String typeHandler) {
            super();
            this.condition = condition;
            this.value = value;
            this.secondValue = secondValue;
            this.typeHandler = typeHandler;
            this.betweenValue = true;
        }

        protected Criterion(String condition, Object value, Object secondValue) {
            this(condition, value, secondValue, null);
        }
    }
}