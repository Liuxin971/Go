package com.sx.ybj.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class FeedbackExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public FeedbackExample() {
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

        public Criteria andFeedbackIdIsNull() {
            addCriterion("feedback_id is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIsNotNull() {
            addCriterion("feedback_id is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdEqualTo(Integer value) {
            addCriterion("feedback_id =", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotEqualTo(Integer value) {
            addCriterion("feedback_id <>", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThan(Integer value) {
            addCriterion("feedback_id >", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback_id >=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThan(Integer value) {
            addCriterion("feedback_id <", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdLessThanOrEqualTo(Integer value) {
            addCriterion("feedback_id <=", value, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdIn(List<Integer> values) {
            addCriterion("feedback_id in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotIn(List<Integer> values) {
            addCriterion("feedback_id not in", values, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdBetween(Integer value1, Integer value2) {
            addCriterion("feedback_id between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackIdNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback_id not between", value1, value2, "feedbackId");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateIsNull() {
            addCriterion("feedback_create is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateIsNotNull() {
            addCriterion("feedback_create is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateEqualTo(Date value) {
            addCriterionForJDBCDate("feedback_create =", value, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateNotEqualTo(Date value) {
            addCriterionForJDBCDate("feedback_create <>", value, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateGreaterThan(Date value) {
            addCriterionForJDBCDate("feedback_create >", value, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("feedback_create >=", value, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateLessThan(Date value) {
            addCriterionForJDBCDate("feedback_create <", value, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("feedback_create <=", value, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateIn(List<Date> values) {
            addCriterionForJDBCDate("feedback_create in", values, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateNotIn(List<Date> values) {
            addCriterionForJDBCDate("feedback_create not in", values, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("feedback_create between", value1, value2, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackCreateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("feedback_create not between", value1, value2, "feedbackCreate");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeIsNull() {
            addCriterion("feedback_theme is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeIsNotNull() {
            addCriterion("feedback_theme is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeEqualTo(String value) {
            addCriterion("feedback_theme =", value, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeNotEqualTo(String value) {
            addCriterion("feedback_theme <>", value, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeGreaterThan(String value) {
            addCriterion("feedback_theme >", value, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_theme >=", value, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeLessThan(String value) {
            addCriterion("feedback_theme <", value, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeLessThanOrEqualTo(String value) {
            addCriterion("feedback_theme <=", value, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeLike(String value) {
            addCriterion("feedback_theme like", value, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeNotLike(String value) {
            addCriterion("feedback_theme not like", value, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeIn(List<String> values) {
            addCriterion("feedback_theme in", values, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeNotIn(List<String> values) {
            addCriterion("feedback_theme not in", values, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeBetween(String value1, String value2) {
            addCriterion("feedback_theme between", value1, value2, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackThemeNotBetween(String value1, String value2) {
            addCriterion("feedback_theme not between", value1, value2, "feedbackTheme");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIsNull() {
            addCriterion("feedback_content is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIsNotNull() {
            addCriterion("feedback_content is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentEqualTo(String value) {
            addCriterion("feedback_content =", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotEqualTo(String value) {
            addCriterion("feedback_content <>", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentGreaterThan(String value) {
            addCriterion("feedback_content >", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentGreaterThanOrEqualTo(String value) {
            addCriterion("feedback_content >=", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLessThan(String value) {
            addCriterion("feedback_content <", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLessThanOrEqualTo(String value) {
            addCriterion("feedback_content <=", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentLike(String value) {
            addCriterion("feedback_content like", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotLike(String value) {
            addCriterion("feedback_content not like", value, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentIn(List<String> values) {
            addCriterion("feedback_content in", values, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotIn(List<String> values) {
            addCriterion("feedback_content not in", values, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentBetween(String value1, String value2) {
            addCriterion("feedback_content between", value1, value2, "feedbackContent");
            return (Criteria) this;
        }

        public Criteria andFeedbackContentNotBetween(String value1, String value2) {
            addCriterion("feedback_content not between", value1, value2, "feedbackContent");
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

        public Criteria andFeedbackAdminIsNull() {
            addCriterion("feedback_admin is null");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminIsNotNull() {
            addCriterion("feedback_admin is not null");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminEqualTo(Integer value) {
            addCriterion("feedback_admin =", value, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminNotEqualTo(Integer value) {
            addCriterion("feedback_admin <>", value, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminGreaterThan(Integer value) {
            addCriterion("feedback_admin >", value, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminGreaterThanOrEqualTo(Integer value) {
            addCriterion("feedback_admin >=", value, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminLessThan(Integer value) {
            addCriterion("feedback_admin <", value, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminLessThanOrEqualTo(Integer value) {
            addCriterion("feedback_admin <=", value, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminIn(List<Integer> values) {
            addCriterion("feedback_admin in", values, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminNotIn(List<Integer> values) {
            addCriterion("feedback_admin not in", values, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminBetween(Integer value1, Integer value2) {
            addCriterion("feedback_admin between", value1, value2, "feedbackAdmin");
            return (Criteria) this;
        }

        public Criteria andFeedbackAdminNotBetween(Integer value1, Integer value2) {
            addCriterion("feedback_admin not between", value1, value2, "feedbackAdmin");
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