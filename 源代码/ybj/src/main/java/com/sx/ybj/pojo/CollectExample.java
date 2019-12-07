package com.sx.ybj.pojo;

import java.util.ArrayList;
import java.util.List;

public class CollectExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public CollectExample() {
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

        public Criteria andCollectIdIsNull() {
            addCriterion("collect_id is null");
            return (Criteria) this;
        }

        public Criteria andCollectIdIsNotNull() {
            addCriterion("collect_id is not null");
            return (Criteria) this;
        }

        public Criteria andCollectIdEqualTo(Integer value) {
            addCriterion("collect_id =", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotEqualTo(Integer value) {
            addCriterion("collect_id <>", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThan(Integer value) {
            addCriterion("collect_id >", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("collect_id >=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThan(Integer value) {
            addCriterion("collect_id <", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdLessThanOrEqualTo(Integer value) {
            addCriterion("collect_id <=", value, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdIn(List<Integer> values) {
            addCriterion("collect_id in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotIn(List<Integer> values) {
            addCriterion("collect_id not in", values, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdBetween(Integer value1, Integer value2) {
            addCriterion("collect_id between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andCollectIdNotBetween(Integer value1, Integer value2) {
            addCriterion("collect_id not between", value1, value2, "collectId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdIsNull() {
            addCriterion("notebook_id is null");
            return (Criteria) this;
        }

        public Criteria andNotebookIdIsNotNull() {
            addCriterion("notebook_id is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookIdEqualTo(Integer value) {
            addCriterion("notebook_id =", value, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdNotEqualTo(Integer value) {
            addCriterion("notebook_id <>", value, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdGreaterThan(Integer value) {
            addCriterion("notebook_id >", value, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("notebook_id >=", value, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdLessThan(Integer value) {
            addCriterion("notebook_id <", value, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdLessThanOrEqualTo(Integer value) {
            addCriterion("notebook_id <=", value, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdIn(List<Integer> values) {
            addCriterion("notebook_id in", values, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdNotIn(List<Integer> values) {
            addCriterion("notebook_id not in", values, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdBetween(Integer value1, Integer value2) {
            addCriterion("notebook_id between", value1, value2, "notebookId");
            return (Criteria) this;
        }

        public Criteria andNotebookIdNotBetween(Integer value1, Integer value2) {
            addCriterion("notebook_id not between", value1, value2, "notebookId");
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