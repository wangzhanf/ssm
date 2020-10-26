package vip.epss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class GoodsExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public GoodsExample() {
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

        public Criteria andGidIsNull() {
            addCriterion("gid is null");
            return (Criteria) this;
        }

        public Criteria andGidIsNotNull() {
            addCriterion("gid is not null");
            return (Criteria) this;
        }

        public Criteria andGidEqualTo(Integer value) {
            addCriterion("gid =", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotEqualTo(Integer value) {
            addCriterion("gid <>", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThan(Integer value) {
            addCriterion("gid >", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidGreaterThanOrEqualTo(Integer value) {
            addCriterion("gid >=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThan(Integer value) {
            addCriterion("gid <", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidLessThanOrEqualTo(Integer value) {
            addCriterion("gid <=", value, "gid");
            return (Criteria) this;
        }

        public Criteria andGidIn(List<Integer> values) {
            addCriterion("gid in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotIn(List<Integer> values) {
            addCriterion("gid not in", values, "gid");
            return (Criteria) this;
        }

        public Criteria andGidBetween(Integer value1, Integer value2) {
            addCriterion("gid between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGidNotBetween(Integer value1, Integer value2) {
            addCriterion("gid not between", value1, value2, "gid");
            return (Criteria) this;
        }

        public Criteria andGnameIsNull() {
            addCriterion("gname is null");
            return (Criteria) this;
        }

        public Criteria andGnameIsNotNull() {
            addCriterion("gname is not null");
            return (Criteria) this;
        }

        public Criteria andGnameEqualTo(String value) {
            addCriterion("gname =", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotEqualTo(String value) {
            addCriterion("gname <>", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThan(String value) {
            addCriterion("gname >", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameGreaterThanOrEqualTo(String value) {
            addCriterion("gname >=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThan(String value) {
            addCriterion("gname <", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLessThanOrEqualTo(String value) {
            addCriterion("gname <=", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameLike(String value) {
            addCriterion("gname like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotLike(String value) {
            addCriterion("gname not like", value, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameIn(List<String> values) {
            addCriterion("gname in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotIn(List<String> values) {
            addCriterion("gname not in", values, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameBetween(String value1, String value2) {
            addCriterion("gname between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGnameNotBetween(String value1, String value2) {
            addCriterion("gname not between", value1, value2, "gname");
            return (Criteria) this;
        }

        public Criteria andGdesIsNull() {
            addCriterion("gdes is null");
            return (Criteria) this;
        }

        public Criteria andGdesIsNotNull() {
            addCriterion("gdes is not null");
            return (Criteria) this;
        }

        public Criteria andGdesEqualTo(String value) {
            addCriterion("gdes =", value, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesNotEqualTo(String value) {
            addCriterion("gdes <>", value, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesGreaterThan(String value) {
            addCriterion("gdes >", value, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesGreaterThanOrEqualTo(String value) {
            addCriterion("gdes >=", value, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesLessThan(String value) {
            addCriterion("gdes <", value, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesLessThanOrEqualTo(String value) {
            addCriterion("gdes <=", value, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesLike(String value) {
            addCriterion("gdes like", value, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesNotLike(String value) {
            addCriterion("gdes not like", value, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesIn(List<String> values) {
            addCriterion("gdes in", values, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesNotIn(List<String> values) {
            addCriterion("gdes not in", values, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesBetween(String value1, String value2) {
            addCriterion("gdes between", value1, value2, "gdes");
            return (Criteria) this;
        }

        public Criteria andGdesNotBetween(String value1, String value2) {
            addCriterion("gdes not between", value1, value2, "gdes");
            return (Criteria) this;
        }

        public Criteria andGpriceIsNull() {
            addCriterion("gprice is null");
            return (Criteria) this;
        }

        public Criteria andGpriceIsNotNull() {
            addCriterion("gprice is not null");
            return (Criteria) this;
        }

        public Criteria andGpriceEqualTo(Double value) {
            addCriterion("gprice =", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotEqualTo(Double value) {
            addCriterion("gprice <>", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceGreaterThan(Double value) {
            addCriterion("gprice >", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceGreaterThanOrEqualTo(Double value) {
            addCriterion("gprice >=", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceLessThan(Double value) {
            addCriterion("gprice <", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceLessThanOrEqualTo(Double value) {
            addCriterion("gprice <=", value, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceIn(List<Double> values) {
            addCriterion("gprice in", values, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotIn(List<Double> values) {
            addCriterion("gprice not in", values, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceBetween(Double value1, Double value2) {
            addCriterion("gprice between", value1, value2, "gprice");
            return (Criteria) this;
        }

        public Criteria andGpriceNotBetween(Double value1, Double value2) {
            addCriterion("gprice not between", value1, value2, "gprice");
            return (Criteria) this;
        }

        public Criteria andGavatarIsNull() {
            addCriterion("gavatar is null");
            return (Criteria) this;
        }

        public Criteria andGavatarIsNotNull() {
            addCriterion("gavatar is not null");
            return (Criteria) this;
        }

        public Criteria andGavatarEqualTo(String value) {
            addCriterion("gavatar =", value, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarNotEqualTo(String value) {
            addCriterion("gavatar <>", value, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarGreaterThan(String value) {
            addCriterion("gavatar >", value, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarGreaterThanOrEqualTo(String value) {
            addCriterion("gavatar >=", value, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarLessThan(String value) {
            addCriterion("gavatar <", value, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarLessThanOrEqualTo(String value) {
            addCriterion("gavatar <=", value, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarLike(String value) {
            addCriterion("gavatar like", value, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarNotLike(String value) {
            addCriterion("gavatar not like", value, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarIn(List<String> values) {
            addCriterion("gavatar in", values, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarNotIn(List<String> values) {
            addCriterion("gavatar not in", values, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarBetween(String value1, String value2) {
            addCriterion("gavatar between", value1, value2, "gavatar");
            return (Criteria) this;
        }

        public Criteria andGavatarNotBetween(String value1, String value2) {
            addCriterion("gavatar not between", value1, value2, "gavatar");
            return (Criteria) this;
        }

        public Criteria andFbidIsNull() {
            addCriterion("fbid is null");
            return (Criteria) this;
        }

        public Criteria andFbidIsNotNull() {
            addCriterion("fbid is not null");
            return (Criteria) this;
        }

        public Criteria andFbidEqualTo(Integer value) {
            addCriterion("fbid =", value, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidNotEqualTo(Integer value) {
            addCriterion("fbid <>", value, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidGreaterThan(Integer value) {
            addCriterion("fbid >", value, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidGreaterThanOrEqualTo(Integer value) {
            addCriterion("fbid >=", value, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidLessThan(Integer value) {
            addCriterion("fbid <", value, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidLessThanOrEqualTo(Integer value) {
            addCriterion("fbid <=", value, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidIn(List<Integer> values) {
            addCriterion("fbid in", values, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidNotIn(List<Integer> values) {
            addCriterion("fbid not in", values, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidBetween(Integer value1, Integer value2) {
            addCriterion("fbid between", value1, value2, "fbid");
            return (Criteria) this;
        }

        public Criteria andFbidNotBetween(Integer value1, Integer value2) {
            addCriterion("fbid not between", value1, value2, "fbid");
            return (Criteria) this;
        }

        public Criteria andFtidIsNull() {
            addCriterion("ftid is null");
            return (Criteria) this;
        }

        public Criteria andFtidIsNotNull() {
            addCriterion("ftid is not null");
            return (Criteria) this;
        }

        public Criteria andFtidEqualTo(Integer value) {
            addCriterion("ftid =", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidNotEqualTo(Integer value) {
            addCriterion("ftid <>", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidGreaterThan(Integer value) {
            addCriterion("ftid >", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidGreaterThanOrEqualTo(Integer value) {
            addCriterion("ftid >=", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidLessThan(Integer value) {
            addCriterion("ftid <", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidLessThanOrEqualTo(Integer value) {
            addCriterion("ftid <=", value, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidIn(List<Integer> values) {
            addCriterion("ftid in", values, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidNotIn(List<Integer> values) {
            addCriterion("ftid not in", values, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidBetween(Integer value1, Integer value2) {
            addCriterion("ftid between", value1, value2, "ftid");
            return (Criteria) this;
        }

        public Criteria andFtidNotBetween(Integer value1, Integer value2) {
            addCriterion("ftid not between", value1, value2, "ftid");
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