package vip.epss.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class CustomerExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CustomerExample() {
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

        protected void addCriterionForJDBCDate(String condition, Date value, String property) {
            if (value == null) {
                throw new RuntimeException("Value for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value.getTime()), property);
        }

        protected void addCriterionForJDBCDate(String condition, List<Date> values, String property) {
            if (values == null || values.size() == 0) {
                throw new RuntimeException("Value list for " + property + " cannot be null or empty");
            }
            List<java.sql.Date> dateList = new ArrayList<java.sql.Date>();
            Iterator<Date> iter = values.iterator();
            while (iter.hasNext()) {
                dateList.add(new java.sql.Date(iter.next().getTime()));
            }
            addCriterion(condition, dateList, property);
        }

        protected void addCriterionForJDBCDate(String condition, Date value1, Date value2, String property) {
            if (value1 == null || value2 == null) {
                throw new RuntimeException("Between values for " + property + " cannot be null");
            }
            addCriterion(condition, new java.sql.Date(value1.getTime()), new java.sql.Date(value2.getTime()), property);
        }

        public Criteria andCidIsNull() {
            addCriterion("cid is null");
            return (Criteria) this;
        }

        public Criteria andCidIsNotNull() {
            addCriterion("cid is not null");
            return (Criteria) this;
        }

        public Criteria andCidEqualTo(Integer value) {
            addCriterion("cid =", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotEqualTo(Integer value) {
            addCriterion("cid <>", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThan(Integer value) {
            addCriterion("cid >", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidGreaterThanOrEqualTo(Integer value) {
            addCriterion("cid >=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThan(Integer value) {
            addCriterion("cid <", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidLessThanOrEqualTo(Integer value) {
            addCriterion("cid <=", value, "cid");
            return (Criteria) this;
        }

        public Criteria andCidIn(List<Integer> values) {
            addCriterion("cid in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotIn(List<Integer> values) {
            addCriterion("cid not in", values, "cid");
            return (Criteria) this;
        }

        public Criteria andCidBetween(Integer value1, Integer value2) {
            addCriterion("cid between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCidNotBetween(Integer value1, Integer value2) {
            addCriterion("cid not between", value1, value2, "cid");
            return (Criteria) this;
        }

        public Criteria andCnameIsNull() {
            addCriterion("cname is null");
            return (Criteria) this;
        }

        public Criteria andCnameIsNotNull() {
            addCriterion("cname is not null");
            return (Criteria) this;
        }

        public Criteria andCnameEqualTo(String value) {
            addCriterion("cname =", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotEqualTo(String value) {
            addCriterion("cname <>", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThan(String value) {
            addCriterion("cname >", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameGreaterThanOrEqualTo(String value) {
            addCriterion("cname >=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThan(String value) {
            addCriterion("cname <", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLessThanOrEqualTo(String value) {
            addCriterion("cname <=", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameLike(String value) {
            addCriterion("cname like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotLike(String value) {
            addCriterion("cname not like", value, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameIn(List<String> values) {
            addCriterion("cname in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotIn(List<String> values) {
            addCriterion("cname not in", values, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameBetween(String value1, String value2) {
            addCriterion("cname between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCnameNotBetween(String value1, String value2) {
            addCriterion("cname not between", value1, value2, "cname");
            return (Criteria) this;
        }

        public Criteria andCphoneIsNull() {
            addCriterion("cphone is null");
            return (Criteria) this;
        }

        public Criteria andCphoneIsNotNull() {
            addCriterion("cphone is not null");
            return (Criteria) this;
        }

        public Criteria andCphoneEqualTo(String value) {
            addCriterion("cphone =", value, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneNotEqualTo(String value) {
            addCriterion("cphone <>", value, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneGreaterThan(String value) {
            addCriterion("cphone >", value, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneGreaterThanOrEqualTo(String value) {
            addCriterion("cphone >=", value, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneLessThan(String value) {
            addCriterion("cphone <", value, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneLessThanOrEqualTo(String value) {
            addCriterion("cphone <=", value, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneLike(String value) {
            addCriterion("cphone like", value, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneNotLike(String value) {
            addCriterion("cphone not like", value, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneIn(List<String> values) {
            addCriterion("cphone in", values, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneNotIn(List<String> values) {
            addCriterion("cphone not in", values, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneBetween(String value1, String value2) {
            addCriterion("cphone between", value1, value2, "cphone");
            return (Criteria) this;
        }

        public Criteria andCphoneNotBetween(String value1, String value2) {
            addCriterion("cphone not between", value1, value2, "cphone");
            return (Criteria) this;
        }

        public Criteria andCemailIsNull() {
            addCriterion("cemail is null");
            return (Criteria) this;
        }

        public Criteria andCemailIsNotNull() {
            addCriterion("cemail is not null");
            return (Criteria) this;
        }

        public Criteria andCemailEqualTo(String value) {
            addCriterion("cemail =", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailNotEqualTo(String value) {
            addCriterion("cemail <>", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailGreaterThan(String value) {
            addCriterion("cemail >", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailGreaterThanOrEqualTo(String value) {
            addCriterion("cemail >=", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailLessThan(String value) {
            addCriterion("cemail <", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailLessThanOrEqualTo(String value) {
            addCriterion("cemail <=", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailLike(String value) {
            addCriterion("cemail like", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailNotLike(String value) {
            addCriterion("cemail not like", value, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailIn(List<String> values) {
            addCriterion("cemail in", values, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailNotIn(List<String> values) {
            addCriterion("cemail not in", values, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailBetween(String value1, String value2) {
            addCriterion("cemail between", value1, value2, "cemail");
            return (Criteria) this;
        }

        public Criteria andCemailNotBetween(String value1, String value2) {
            addCriterion("cemail not between", value1, value2, "cemail");
            return (Criteria) this;
        }

        public Criteria andCpassIsNull() {
            addCriterion("cpass is null");
            return (Criteria) this;
        }

        public Criteria andCpassIsNotNull() {
            addCriterion("cpass is not null");
            return (Criteria) this;
        }

        public Criteria andCpassEqualTo(String value) {
            addCriterion("cpass =", value, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassNotEqualTo(String value) {
            addCriterion("cpass <>", value, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassGreaterThan(String value) {
            addCriterion("cpass >", value, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassGreaterThanOrEqualTo(String value) {
            addCriterion("cpass >=", value, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassLessThan(String value) {
            addCriterion("cpass <", value, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassLessThanOrEqualTo(String value) {
            addCriterion("cpass <=", value, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassLike(String value) {
            addCriterion("cpass like", value, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassNotLike(String value) {
            addCriterion("cpass not like", value, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassIn(List<String> values) {
            addCriterion("cpass in", values, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassNotIn(List<String> values) {
            addCriterion("cpass not in", values, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassBetween(String value1, String value2) {
            addCriterion("cpass between", value1, value2, "cpass");
            return (Criteria) this;
        }

        public Criteria andCpassNotBetween(String value1, String value2) {
            addCriterion("cpass not between", value1, value2, "cpass");
            return (Criteria) this;
        }

        public Criteria andCbirthIsNull() {
            addCriterion("cbirth is null");
            return (Criteria) this;
        }

        public Criteria andCbirthIsNotNull() {
            addCriterion("cbirth is not null");
            return (Criteria) this;
        }

        public Criteria andCbirthEqualTo(Date value) {
            addCriterionForJDBCDate("cbirth =", value, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthNotEqualTo(Date value) {
            addCriterionForJDBCDate("cbirth <>", value, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthGreaterThan(Date value) {
            addCriterionForJDBCDate("cbirth >", value, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cbirth >=", value, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthLessThan(Date value) {
            addCriterionForJDBCDate("cbirth <", value, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("cbirth <=", value, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthIn(List<Date> values) {
            addCriterionForJDBCDate("cbirth in", values, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthNotIn(List<Date> values) {
            addCriterionForJDBCDate("cbirth not in", values, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cbirth between", value1, value2, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCbirthNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("cbirth not between", value1, value2, "cbirth");
            return (Criteria) this;
        }

        public Criteria andCavatarIsNull() {
            addCriterion("cavatar is null");
            return (Criteria) this;
        }

        public Criteria andCavatarIsNotNull() {
            addCriterion("cavatar is not null");
            return (Criteria) this;
        }

        public Criteria andCavatarEqualTo(String value) {
            addCriterion("cavatar =", value, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarNotEqualTo(String value) {
            addCriterion("cavatar <>", value, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarGreaterThan(String value) {
            addCriterion("cavatar >", value, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarGreaterThanOrEqualTo(String value) {
            addCriterion("cavatar >=", value, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarLessThan(String value) {
            addCriterion("cavatar <", value, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarLessThanOrEqualTo(String value) {
            addCriterion("cavatar <=", value, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarLike(String value) {
            addCriterion("cavatar like", value, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarNotLike(String value) {
            addCriterion("cavatar not like", value, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarIn(List<String> values) {
            addCriterion("cavatar in", values, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarNotIn(List<String> values) {
            addCriterion("cavatar not in", values, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarBetween(String value1, String value2) {
            addCriterion("cavatar between", value1, value2, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCavatarNotBetween(String value1, String value2) {
            addCriterion("cavatar not between", value1, value2, "cavatar");
            return (Criteria) this;
        }

        public Criteria andCgenderIsNull() {
            addCriterion("cgender is null");
            return (Criteria) this;
        }

        public Criteria andCgenderIsNotNull() {
            addCriterion("cgender is not null");
            return (Criteria) this;
        }

        public Criteria andCgenderEqualTo(Boolean value) {
            addCriterion("cgender =", value, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderNotEqualTo(Boolean value) {
            addCriterion("cgender <>", value, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderGreaterThan(Boolean value) {
            addCriterion("cgender >", value, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderGreaterThanOrEqualTo(Boolean value) {
            addCriterion("cgender >=", value, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderLessThan(Boolean value) {
            addCriterion("cgender <", value, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderLessThanOrEqualTo(Boolean value) {
            addCriterion("cgender <=", value, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderIn(List<Boolean> values) {
            addCriterion("cgender in", values, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderNotIn(List<Boolean> values) {
            addCriterion("cgender not in", values, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderBetween(Boolean value1, Boolean value2) {
            addCriterion("cgender between", value1, value2, "cgender");
            return (Criteria) this;
        }

        public Criteria andCgenderNotBetween(Boolean value1, Boolean value2) {
            addCriterion("cgender not between", value1, value2, "cgender");
            return (Criteria) this;
        }

        public Criteria andCstatusIsNull() {
            addCriterion("cstatus is null");
            return (Criteria) this;
        }

        public Criteria andCstatusIsNotNull() {
            addCriterion("cstatus is not null");
            return (Criteria) this;
        }

        public Criteria andCstatusEqualTo(Boolean value) {
            addCriterion("cstatus =", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusNotEqualTo(Boolean value) {
            addCriterion("cstatus <>", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusGreaterThan(Boolean value) {
            addCriterion("cstatus >", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusGreaterThanOrEqualTo(Boolean value) {
            addCriterion("cstatus >=", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusLessThan(Boolean value) {
            addCriterion("cstatus <", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusLessThanOrEqualTo(Boolean value) {
            addCriterion("cstatus <=", value, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusIn(List<Boolean> values) {
            addCriterion("cstatus in", values, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusNotIn(List<Boolean> values) {
            addCriterion("cstatus not in", values, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusBetween(Boolean value1, Boolean value2) {
            addCriterion("cstatus between", value1, value2, "cstatus");
            return (Criteria) this;
        }

        public Criteria andCstatusNotBetween(Boolean value1, Boolean value2) {
            addCriterion("cstatus not between", value1, value2, "cstatus");
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