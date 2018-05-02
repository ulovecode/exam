package com.ulovecode.modules.entity.domain;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemExample() {
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

        public Criteria andItemIdIsNull() {
            addCriterion("item_id is null");
            return (Criteria) this;
        }

        public Criteria andItemIdIsNotNull() {
            addCriterion("item_id is not null");
            return (Criteria) this;
        }

        public Criteria andItemIdEqualTo(Integer value) {
            addCriterion("item_id =", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotEqualTo(Integer value) {
            addCriterion("item_id <>", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThan(Integer value) {
            addCriterion("item_id >", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("item_id >=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThan(Integer value) {
            addCriterion("item_id <", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdLessThanOrEqualTo(Integer value) {
            addCriterion("item_id <=", value, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdIn(List<Integer> values) {
            addCriterion("item_id in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotIn(List<Integer> values) {
            addCriterion("item_id not in", values, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdBetween(Integer value1, Integer value2) {
            addCriterion("item_id between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andItemIdNotBetween(Integer value1, Integer value2) {
            addCriterion("item_id not between", value1, value2, "itemId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNull() {
            addCriterion("course_id is null");
            return (Criteria) this;
        }

        public Criteria andCourseIdIsNotNull() {
            addCriterion("course_id is not null");
            return (Criteria) this;
        }

        public Criteria andCourseIdEqualTo(Integer value) {
            addCriterion("course_id =", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotEqualTo(Integer value) {
            addCriterion("course_id <>", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThan(Integer value) {
            addCriterion("course_id >", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("course_id >=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThan(Integer value) {
            addCriterion("course_id <", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdLessThanOrEqualTo(Integer value) {
            addCriterion("course_id <=", value, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdIn(List<Integer> values) {
            addCriterion("course_id in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotIn(List<Integer> values) {
            addCriterion("course_id not in", values, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdBetween(Integer value1, Integer value2) {
            addCriterion("course_id between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andCourseIdNotBetween(Integer value1, Integer value2) {
            addCriterion("course_id not between", value1, value2, "courseId");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNull() {
            addCriterion("item_type is null");
            return (Criteria) this;
        }

        public Criteria andItemTypeIsNotNull() {
            addCriterion("item_type is not null");
            return (Criteria) this;
        }

        public Criteria andItemTypeEqualTo(String value) {
            addCriterion("item_type =", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotEqualTo(String value) {
            addCriterion("item_type <>", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThan(String value) {
            addCriterion("item_type >", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeGreaterThanOrEqualTo(String value) {
            addCriterion("item_type >=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThan(String value) {
            addCriterion("item_type <", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLessThanOrEqualTo(String value) {
            addCriterion("item_type <=", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeLike(String value) {
            addCriterion("item_type like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotLike(String value) {
            addCriterion("item_type not like", value, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeIn(List<String> values) {
            addCriterion("item_type in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotIn(List<String> values) {
            addCriterion("item_type not in", values, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeBetween(String value1, String value2) {
            addCriterion("item_type between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andItemTypeNotBetween(String value1, String value2) {
            addCriterion("item_type not between", value1, value2, "itemType");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNull() {
            addCriterion("question is null");
            return (Criteria) this;
        }

        public Criteria andQuestionIsNotNull() {
            addCriterion("question is not null");
            return (Criteria) this;
        }

        public Criteria andQuestionEqualTo(String value) {
            addCriterion("question =", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotEqualTo(String value) {
            addCriterion("question <>", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThan(String value) {
            addCriterion("question >", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionGreaterThanOrEqualTo(String value) {
            addCriterion("question >=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThan(String value) {
            addCriterion("question <", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLessThanOrEqualTo(String value) {
            addCriterion("question <=", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionLike(String value) {
            addCriterion("question like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotLike(String value) {
            addCriterion("question not like", value, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionIn(List<String> values) {
            addCriterion("question in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotIn(List<String> values) {
            addCriterion("question not in", values, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionBetween(String value1, String value2) {
            addCriterion("question between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andQuestionNotBetween(String value1, String value2) {
            addCriterion("question not between", value1, value2, "question");
            return (Criteria) this;
        }

        public Criteria andOptionaIsNull() {
            addCriterion("optiona is null");
            return (Criteria) this;
        }

        public Criteria andOptionaIsNotNull() {
            addCriterion("optiona is not null");
            return (Criteria) this;
        }

        public Criteria andOptionaEqualTo(String value) {
            addCriterion("optiona =", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaNotEqualTo(String value) {
            addCriterion("optiona <>", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaGreaterThan(String value) {
            addCriterion("optiona >", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaGreaterThanOrEqualTo(String value) {
            addCriterion("optiona >=", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaLessThan(String value) {
            addCriterion("optiona <", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaLessThanOrEqualTo(String value) {
            addCriterion("optiona <=", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaLike(String value) {
            addCriterion("optiona like", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaNotLike(String value) {
            addCriterion("optiona not like", value, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaIn(List<String> values) {
            addCriterion("optiona in", values, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaNotIn(List<String> values) {
            addCriterion("optiona not in", values, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaBetween(String value1, String value2) {
            addCriterion("optiona between", value1, value2, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionaNotBetween(String value1, String value2) {
            addCriterion("optiona not between", value1, value2, "optiona");
            return (Criteria) this;
        }

        public Criteria andOptionbIsNull() {
            addCriterion("optionb is null");
            return (Criteria) this;
        }

        public Criteria andOptionbIsNotNull() {
            addCriterion("optionb is not null");
            return (Criteria) this;
        }

        public Criteria andOptionbEqualTo(String value) {
            addCriterion("optionb =", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbNotEqualTo(String value) {
            addCriterion("optionb <>", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbGreaterThan(String value) {
            addCriterion("optionb >", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbGreaterThanOrEqualTo(String value) {
            addCriterion("optionb >=", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbLessThan(String value) {
            addCriterion("optionb <", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbLessThanOrEqualTo(String value) {
            addCriterion("optionb <=", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbLike(String value) {
            addCriterion("optionb like", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbNotLike(String value) {
            addCriterion("optionb not like", value, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbIn(List<String> values) {
            addCriterion("optionb in", values, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbNotIn(List<String> values) {
            addCriterion("optionb not in", values, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbBetween(String value1, String value2) {
            addCriterion("optionb between", value1, value2, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptionbNotBetween(String value1, String value2) {
            addCriterion("optionb not between", value1, value2, "optionb");
            return (Criteria) this;
        }

        public Criteria andOptioncIsNull() {
            addCriterion("optionc is null");
            return (Criteria) this;
        }

        public Criteria andOptioncIsNotNull() {
            addCriterion("optionc is not null");
            return (Criteria) this;
        }

        public Criteria andOptioncEqualTo(String value) {
            addCriterion("optionc =", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncNotEqualTo(String value) {
            addCriterion("optionc <>", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncGreaterThan(String value) {
            addCriterion("optionc >", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncGreaterThanOrEqualTo(String value) {
            addCriterion("optionc >=", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncLessThan(String value) {
            addCriterion("optionc <", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncLessThanOrEqualTo(String value) {
            addCriterion("optionc <=", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncLike(String value) {
            addCriterion("optionc like", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncNotLike(String value) {
            addCriterion("optionc not like", value, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncIn(List<String> values) {
            addCriterion("optionc in", values, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncNotIn(List<String> values) {
            addCriterion("optionc not in", values, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncBetween(String value1, String value2) {
            addCriterion("optionc between", value1, value2, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptioncNotBetween(String value1, String value2) {
            addCriterion("optionc not between", value1, value2, "optionc");
            return (Criteria) this;
        }

        public Criteria andOptiondIsNull() {
            addCriterion("optiond is null");
            return (Criteria) this;
        }

        public Criteria andOptiondIsNotNull() {
            addCriterion("optiond is not null");
            return (Criteria) this;
        }

        public Criteria andOptiondEqualTo(String value) {
            addCriterion("optiond =", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondNotEqualTo(String value) {
            addCriterion("optiond <>", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondGreaterThan(String value) {
            addCriterion("optiond >", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondGreaterThanOrEqualTo(String value) {
            addCriterion("optiond >=", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondLessThan(String value) {
            addCriterion("optiond <", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondLessThanOrEqualTo(String value) {
            addCriterion("optiond <=", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondLike(String value) {
            addCriterion("optiond like", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondNotLike(String value) {
            addCriterion("optiond not like", value, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondIn(List<String> values) {
            addCriterion("optiond in", values, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondNotIn(List<String> values) {
            addCriterion("optiond not in", values, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondBetween(String value1, String value2) {
            addCriterion("optiond between", value1, value2, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptiondNotBetween(String value1, String value2) {
            addCriterion("optiond not between", value1, value2, "optiond");
            return (Criteria) this;
        }

        public Criteria andOptioneIsNull() {
            addCriterion("optione is null");
            return (Criteria) this;
        }

        public Criteria andOptioneIsNotNull() {
            addCriterion("optione is not null");
            return (Criteria) this;
        }

        public Criteria andOptioneEqualTo(String value) {
            addCriterion("optione =", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneNotEqualTo(String value) {
            addCriterion("optione <>", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneGreaterThan(String value) {
            addCriterion("optione >", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneGreaterThanOrEqualTo(String value) {
            addCriterion("optione >=", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneLessThan(String value) {
            addCriterion("optione <", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneLessThanOrEqualTo(String value) {
            addCriterion("optione <=", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneLike(String value) {
            addCriterion("optione like", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneNotLike(String value) {
            addCriterion("optione not like", value, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneIn(List<String> values) {
            addCriterion("optione in", values, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneNotIn(List<String> values) {
            addCriterion("optione not in", values, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneBetween(String value1, String value2) {
            addCriterion("optione between", value1, value2, "optione");
            return (Criteria) this;
        }

        public Criteria andOptioneNotBetween(String value1, String value2) {
            addCriterion("optione not between", value1, value2, "optione");
            return (Criteria) this;
        }

        public Criteria andOptionfIsNull() {
            addCriterion("optionf is null");
            return (Criteria) this;
        }

        public Criteria andOptionfIsNotNull() {
            addCriterion("optionf is not null");
            return (Criteria) this;
        }

        public Criteria andOptionfEqualTo(String value) {
            addCriterion("optionf =", value, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfNotEqualTo(String value) {
            addCriterion("optionf <>", value, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfGreaterThan(String value) {
            addCriterion("optionf >", value, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfGreaterThanOrEqualTo(String value) {
            addCriterion("optionf >=", value, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfLessThan(String value) {
            addCriterion("optionf <", value, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfLessThanOrEqualTo(String value) {
            addCriterion("optionf <=", value, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfLike(String value) {
            addCriterion("optionf like", value, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfNotLike(String value) {
            addCriterion("optionf not like", value, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfIn(List<String> values) {
            addCriterion("optionf in", values, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfNotIn(List<String> values) {
            addCriterion("optionf not in", values, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfBetween(String value1, String value2) {
            addCriterion("optionf between", value1, value2, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptionfNotBetween(String value1, String value2) {
            addCriterion("optionf not between", value1, value2, "optionf");
            return (Criteria) this;
        }

        public Criteria andOptiongIsNull() {
            addCriterion("optiong is null");
            return (Criteria) this;
        }

        public Criteria andOptiongIsNotNull() {
            addCriterion("optiong is not null");
            return (Criteria) this;
        }

        public Criteria andOptiongEqualTo(String value) {
            addCriterion("optiong =", value, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongNotEqualTo(String value) {
            addCriterion("optiong <>", value, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongGreaterThan(String value) {
            addCriterion("optiong >", value, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongGreaterThanOrEqualTo(String value) {
            addCriterion("optiong >=", value, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongLessThan(String value) {
            addCriterion("optiong <", value, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongLessThanOrEqualTo(String value) {
            addCriterion("optiong <=", value, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongLike(String value) {
            addCriterion("optiong like", value, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongNotLike(String value) {
            addCriterion("optiong not like", value, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongIn(List<String> values) {
            addCriterion("optiong in", values, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongNotIn(List<String> values) {
            addCriterion("optiong not in", values, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongBetween(String value1, String value2) {
            addCriterion("optiong between", value1, value2, "optiong");
            return (Criteria) this;
        }

        public Criteria andOptiongNotBetween(String value1, String value2) {
            addCriterion("optiong not between", value1, value2, "optiong");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNull() {
            addCriterion("answer is null");
            return (Criteria) this;
        }

        public Criteria andAnswerIsNotNull() {
            addCriterion("answer is not null");
            return (Criteria) this;
        }

        public Criteria andAnswerEqualTo(String value) {
            addCriterion("answer =", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotEqualTo(String value) {
            addCriterion("answer <>", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThan(String value) {
            addCriterion("answer >", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerGreaterThanOrEqualTo(String value) {
            addCriterion("answer >=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThan(String value) {
            addCriterion("answer <", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLessThanOrEqualTo(String value) {
            addCriterion("answer <=", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerLike(String value) {
            addCriterion("answer like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotLike(String value) {
            addCriterion("answer not like", value, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerIn(List<String> values) {
            addCriterion("answer in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotIn(List<String> values) {
            addCriterion("answer not in", values, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerBetween(String value1, String value2) {
            addCriterion("answer between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andAnswerNotBetween(String value1, String value2) {
            addCriterion("answer not between", value1, value2, "answer");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNull() {
            addCriterion("difficulty is null");
            return (Criteria) this;
        }

        public Criteria andDifficultyIsNotNull() {
            addCriterion("difficulty is not null");
            return (Criteria) this;
        }

        public Criteria andDifficultyEqualTo(Integer value) {
            addCriterion("difficulty =", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotEqualTo(Integer value) {
            addCriterion("difficulty <>", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThan(Integer value) {
            addCriterion("difficulty >", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyGreaterThanOrEqualTo(Integer value) {
            addCriterion("difficulty >=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThan(Integer value) {
            addCriterion("difficulty <", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyLessThanOrEqualTo(Integer value) {
            addCriterion("difficulty <=", value, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyIn(List<Integer> values) {
            addCriterion("difficulty in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotIn(List<Integer> values) {
            addCriterion("difficulty not in", values, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyBetween(Integer value1, Integer value2) {
            addCriterion("difficulty between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andDifficultyNotBetween(Integer value1, Integer value2) {
            addCriterion("difficulty not between", value1, value2, "difficulty");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIsNull() {
            addCriterion("knowledge is null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIsNotNull() {
            addCriterion("knowledge is not null");
            return (Criteria) this;
        }

        public Criteria andKnowledgeEqualTo(String value) {
            addCriterion("knowledge =", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNotEqualTo(String value) {
            addCriterion("knowledge <>", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeGreaterThan(String value) {
            addCriterion("knowledge >", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeGreaterThanOrEqualTo(String value) {
            addCriterion("knowledge >=", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeLessThan(String value) {
            addCriterion("knowledge <", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeLessThanOrEqualTo(String value) {
            addCriterion("knowledge <=", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeLike(String value) {
            addCriterion("knowledge like", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNotLike(String value) {
            addCriterion("knowledge not like", value, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeIn(List<String> values) {
            addCriterion("knowledge in", values, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNotIn(List<String> values) {
            addCriterion("knowledge not in", values, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeBetween(String value1, String value2) {
            addCriterion("knowledge between", value1, value2, "knowledge");
            return (Criteria) this;
        }

        public Criteria andKnowledgeNotBetween(String value1, String value2) {
            addCriterion("knowledge not between", value1, value2, "knowledge");
            return (Criteria) this;
        }

        public Criteria andClueIsNull() {
            addCriterion("clue is null");
            return (Criteria) this;
        }

        public Criteria andClueIsNotNull() {
            addCriterion("clue is not null");
            return (Criteria) this;
        }

        public Criteria andClueEqualTo(String value) {
            addCriterion("clue =", value, "clue");
            return (Criteria) this;
        }

        public Criteria andClueNotEqualTo(String value) {
            addCriterion("clue <>", value, "clue");
            return (Criteria) this;
        }

        public Criteria andClueGreaterThan(String value) {
            addCriterion("clue >", value, "clue");
            return (Criteria) this;
        }

        public Criteria andClueGreaterThanOrEqualTo(String value) {
            addCriterion("clue >=", value, "clue");
            return (Criteria) this;
        }

        public Criteria andClueLessThan(String value) {
            addCriterion("clue <", value, "clue");
            return (Criteria) this;
        }

        public Criteria andClueLessThanOrEqualTo(String value) {
            addCriterion("clue <=", value, "clue");
            return (Criteria) this;
        }

        public Criteria andClueLike(String value) {
            addCriterion("clue like", value, "clue");
            return (Criteria) this;
        }

        public Criteria andClueNotLike(String value) {
            addCriterion("clue not like", value, "clue");
            return (Criteria) this;
        }

        public Criteria andClueIn(List<String> values) {
            addCriterion("clue in", values, "clue");
            return (Criteria) this;
        }

        public Criteria andClueNotIn(List<String> values) {
            addCriterion("clue not in", values, "clue");
            return (Criteria) this;
        }

        public Criteria andClueBetween(String value1, String value2) {
            addCriterion("clue between", value1, value2, "clue");
            return (Criteria) this;
        }

        public Criteria andClueNotBetween(String value1, String value2) {
            addCriterion("clue not between", value1, value2, "clue");
            return (Criteria) this;
        }

        public Criteria andRecDtimeIsNull() {
            addCriterion("rec_dtime is null");
            return (Criteria) this;
        }

        public Criteria andRecDtimeIsNotNull() {
            addCriterion("rec_dtime is not null");
            return (Criteria) this;
        }

        public Criteria andRecDtimeEqualTo(Date value) {
            addCriterion("rec_dtime =", value, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeNotEqualTo(Date value) {
            addCriterion("rec_dtime <>", value, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeGreaterThan(Date value) {
            addCriterion("rec_dtime >", value, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeGreaterThanOrEqualTo(Date value) {
            addCriterion("rec_dtime >=", value, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeLessThan(Date value) {
            addCriterion("rec_dtime <", value, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeLessThanOrEqualTo(Date value) {
            addCriterion("rec_dtime <=", value, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeIn(List<Date> values) {
            addCriterion("rec_dtime in", values, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeNotIn(List<Date> values) {
            addCriterion("rec_dtime not in", values, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeBetween(Date value1, Date value2) {
            addCriterion("rec_dtime between", value1, value2, "recDtime");
            return (Criteria) this;
        }

        public Criteria andRecDtimeNotBetween(Date value1, Date value2) {
            addCriterion("rec_dtime not between", value1, value2, "recDtime");
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