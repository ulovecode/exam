package com.ulovecode.modules.user.entity;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserInfoExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserInfoExample() {
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

        public Criteria andUseridIsNull() {
            addCriterion("userid is null");
            return (Criteria) this;
        }

        public Criteria andUseridIsNotNull() {
            addCriterion("userid is not null");
            return (Criteria) this;
        }

        public Criteria andUseridEqualTo(String value) {
            addCriterion("userid =", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotEqualTo(String value) {
            addCriterion("userid <>", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThan(String value) {
            addCriterion("userid >", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridGreaterThanOrEqualTo(String value) {
            addCriterion("userid >=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThan(String value) {
            addCriterion("userid <", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLessThanOrEqualTo(String value) {
            addCriterion("userid <=", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridLike(String value) {
            addCriterion("userid like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotLike(String value) {
            addCriterion("userid not like", value, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridIn(List<String> values) {
            addCriterion("userid in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotIn(List<String> values) {
            addCriterion("userid not in", values, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridBetween(String value1, String value2) {
            addCriterion("userid between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andUseridNotBetween(String value1, String value2) {
            addCriterion("userid not between", value1, value2, "userid");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNull() {
            addCriterion("realname is null");
            return (Criteria) this;
        }

        public Criteria andRealnameIsNotNull() {
            addCriterion("realname is not null");
            return (Criteria) this;
        }

        public Criteria andRealnameEqualTo(String value) {
            addCriterion("realname =", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotEqualTo(String value) {
            addCriterion("realname <>", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThan(String value) {
            addCriterion("realname >", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameGreaterThanOrEqualTo(String value) {
            addCriterion("realname >=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThan(String value) {
            addCriterion("realname <", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLessThanOrEqualTo(String value) {
            addCriterion("realname <=", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameLike(String value) {
            addCriterion("realname like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotLike(String value) {
            addCriterion("realname not like", value, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameIn(List<String> values) {
            addCriterion("realname in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotIn(List<String> values) {
            addCriterion("realname not in", values, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameBetween(String value1, String value2) {
            addCriterion("realname between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andRealnameNotBetween(String value1, String value2) {
            addCriterion("realname not between", value1, value2, "realname");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNull() {
            addCriterion("passwd is null");
            return (Criteria) this;
        }

        public Criteria andPasswdIsNotNull() {
            addCriterion("passwd is not null");
            return (Criteria) this;
        }

        public Criteria andPasswdEqualTo(String value) {
            addCriterion("passwd =", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotEqualTo(String value) {
            addCriterion("passwd <>", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThan(String value) {
            addCriterion("passwd >", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdGreaterThanOrEqualTo(String value) {
            addCriterion("passwd >=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThan(String value) {
            addCriterion("passwd <", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLessThanOrEqualTo(String value) {
            addCriterion("passwd <=", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdLike(String value) {
            addCriterion("passwd like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotLike(String value) {
            addCriterion("passwd not like", value, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdIn(List<String> values) {
            addCriterion("passwd in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotIn(List<String> values) {
            addCriterion("passwd not in", values, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdBetween(String value1, String value2) {
            addCriterion("passwd between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andPasswdNotBetween(String value1, String value2) {
            addCriterion("passwd not between", value1, value2, "passwd");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeIsNull() {
            addCriterion("login_dtime is null");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeIsNotNull() {
            addCriterion("login_dtime is not null");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeEqualTo(Date value) {
            addCriterion("login_dtime =", value, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeNotEqualTo(Date value) {
            addCriterion("login_dtime <>", value, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeGreaterThan(Date value) {
            addCriterion("login_dtime >", value, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("login_dtime >=", value, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeLessThan(Date value) {
            addCriterion("login_dtime <", value, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeLessThanOrEqualTo(Date value) {
            addCriterion("login_dtime <=", value, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeIn(List<Date> values) {
            addCriterion("login_dtime in", values, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeNotIn(List<Date> values) {
            addCriterion("login_dtime not in", values, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeBetween(Date value1, Date value2) {
            addCriterion("login_dtime between", value1, value2, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLoginDtimeNotBetween(Date value1, Date value2) {
            addCriterion("login_dtime not between", value1, value2, "loginDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeIsNull() {
            addCriterion("logout_dtime is null");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeIsNotNull() {
            addCriterion("logout_dtime is not null");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeEqualTo(Date value) {
            addCriterion("logout_dtime =", value, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeNotEqualTo(Date value) {
            addCriterion("logout_dtime <>", value, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeGreaterThan(Date value) {
            addCriterion("logout_dtime >", value, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("logout_dtime >=", value, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeLessThan(Date value) {
            addCriterion("logout_dtime <", value, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeLessThanOrEqualTo(Date value) {
            addCriterion("logout_dtime <=", value, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeIn(List<Date> values) {
            addCriterion("logout_dtime in", values, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeNotIn(List<Date> values) {
            addCriterion("logout_dtime not in", values, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeBetween(Date value1, Date value2) {
            addCriterion("logout_dtime between", value1, value2, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLogoutDtimeNotBetween(Date value1, Date value2) {
            addCriterion("logout_dtime not between", value1, value2, "logoutDtime");
            return (Criteria) this;
        }

        public Criteria andLoginHostIsNull() {
            addCriterion("login_host is null");
            return (Criteria) this;
        }

        public Criteria andLoginHostIsNotNull() {
            addCriterion("login_host is not null");
            return (Criteria) this;
        }

        public Criteria andLoginHostEqualTo(String value) {
            addCriterion("login_host =", value, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostNotEqualTo(String value) {
            addCriterion("login_host <>", value, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostGreaterThan(String value) {
            addCriterion("login_host >", value, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostGreaterThanOrEqualTo(String value) {
            addCriterion("login_host >=", value, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostLessThan(String value) {
            addCriterion("login_host <", value, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostLessThanOrEqualTo(String value) {
            addCriterion("login_host <=", value, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostLike(String value) {
            addCriterion("login_host like", value, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostNotLike(String value) {
            addCriterion("login_host not like", value, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostIn(List<String> values) {
            addCriterion("login_host in", values, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostNotIn(List<String> values) {
            addCriterion("login_host not in", values, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostBetween(String value1, String value2) {
            addCriterion("login_host between", value1, value2, "loginHost");
            return (Criteria) this;
        }

        public Criteria andLoginHostNotBetween(String value1, String value2) {
            addCriterion("login_host not between", value1, value2, "loginHost");
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