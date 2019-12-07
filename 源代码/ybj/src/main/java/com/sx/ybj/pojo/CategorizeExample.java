package com.sx.ybj.pojo;

import java.util.ArrayList;
import java.util.List;

public class CategorizeExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CategorizeExample() {
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

        public Criteria andCategorizeIdIsNull() {
            addCriterion("categorize_id is null");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdIsNotNull() {
            addCriterion("categorize_id is not null");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdEqualTo(Integer value) {
            addCriterion("categorize_id =", value, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdNotEqualTo(Integer value) {
            addCriterion("categorize_id <>", value, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdGreaterThan(Integer value) {
            addCriterion("categorize_id >", value, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("categorize_id >=", value, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdLessThan(Integer value) {
            addCriterion("categorize_id <", value, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdLessThanOrEqualTo(Integer value) {
            addCriterion("categorize_id <=", value, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdIn(List<Integer> values) {
            addCriterion("categorize_id in", values, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdNotIn(List<Integer> values) {
            addCriterion("categorize_id not in", values, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdBetween(Integer value1, Integer value2) {
            addCriterion("categorize_id between", value1, value2, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeIdNotBetween(Integer value1, Integer value2) {
            addCriterion("categorize_id not between", value1, value2, "categorizeId");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameIsNull() {
            addCriterion("categorize_name is null");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameIsNotNull() {
            addCriterion("categorize_name is not null");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameEqualTo(String value) {
            addCriterion("categorize_name =", value, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameNotEqualTo(String value) {
            addCriterion("categorize_name <>", value, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameGreaterThan(String value) {
            addCriterion("categorize_name >", value, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameGreaterThanOrEqualTo(String value) {
            addCriterion("categorize_name >=", value, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameLessThan(String value) {
            addCriterion("categorize_name <", value, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameLessThanOrEqualTo(String value) {
            addCriterion("categorize_name <=", value, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameLike(String value) {
            addCriterion("categorize_name like", value, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameNotLike(String value) {
            addCriterion("categorize_name not like", value, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameIn(List<String> values) {
            addCriterion("categorize_name in", values, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameNotIn(List<String> values) {
            addCriterion("categorize_name not in", values, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameBetween(String value1, String value2) {
            addCriterion("categorize_name between", value1, value2, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andCategorizeNameNotBetween(String value1, String value2) {
            addCriterion("categorize_name not between", value1, value2, "categorizeName");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNull() {
            addCriterion("user_id is null");
            return (Criteria) this;
        }

        public Criteria andUserIdIsNotNull() {
            addCriterion("user_id is not null");
            return (Criteria) this;
        }

        public Criteria andUserIdEqualTo(Integer value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(Integer value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(Integer value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(Integer value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(Integer value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<Integer> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<Integer> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(Integer value1, Integer value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(Integer value1, Integer value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateIsNull() {
            addCriterion("categorize_state is null");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateIsNotNull() {
            addCriterion("categorize_state is not null");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateEqualTo(Integer value) {
            addCriterion("categorize_state =", value, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateNotEqualTo(Integer value) {
            addCriterion("categorize_state <>", value, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateGreaterThan(Integer value) {
            addCriterion("categorize_state >", value, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("categorize_state >=", value, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateLessThan(Integer value) {
            addCriterion("categorize_state <", value, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateLessThanOrEqualTo(Integer value) {
            addCriterion("categorize_state <=", value, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateIn(List<Integer> values) {
            addCriterion("categorize_state in", values, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateNotIn(List<Integer> values) {
            addCriterion("categorize_state not in", values, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateBetween(Integer value1, Integer value2) {
            addCriterion("categorize_state between", value1, value2, "categorizeState");
            return (Criteria) this;
        }

        public Criteria andCategorizeStateNotBetween(Integer value1, Integer value2) {
            addCriterion("categorize_state not between", value1, value2, "categorizeState");
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