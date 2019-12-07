package com.sx.ybj.pojo;

import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

public class NotebookExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public NotebookExample() {
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

        public Criteria andNotebookTitleIsNull() {
            addCriterion("notebook_title is null");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleIsNotNull() {
            addCriterion("notebook_title is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleEqualTo(String value) {
            addCriterion("notebook_title =", value, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleNotEqualTo(String value) {
            addCriterion("notebook_title <>", value, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleGreaterThan(String value) {
            addCriterion("notebook_title >", value, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleGreaterThanOrEqualTo(String value) {
            addCriterion("notebook_title >=", value, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleLessThan(String value) {
            addCriterion("notebook_title <", value, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleLessThanOrEqualTo(String value) {
            addCriterion("notebook_title <=", value, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleLike(String value) {
            addCriterion("notebook_title like", value, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleNotLike(String value) {
            addCriterion("notebook_title not like", value, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleIn(List<String> values) {
            addCriterion("notebook_title in", values, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleNotIn(List<String> values) {
            addCriterion("notebook_title not in", values, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleBetween(String value1, String value2) {
            addCriterion("notebook_title between", value1, value2, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookTitleNotBetween(String value1, String value2) {
            addCriterion("notebook_title not between", value1, value2, "notebookTitle");
            return (Criteria) this;
        }

        public Criteria andNotebookContentIsNull() {
            addCriterion("notebook_content is null");
            return (Criteria) this;
        }

        public Criteria andNotebookContentIsNotNull() {
            addCriterion("notebook_content is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookContentEqualTo(String value) {
            addCriterion("notebook_content =", value, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentNotEqualTo(String value) {
            addCriterion("notebook_content <>", value, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentGreaterThan(String value) {
            addCriterion("notebook_content >", value, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentGreaterThanOrEqualTo(String value) {
            addCriterion("notebook_content >=", value, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentLessThan(String value) {
            addCriterion("notebook_content <", value, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentLessThanOrEqualTo(String value) {
            addCriterion("notebook_content <=", value, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentLike(String value) {
            addCriterion("notebook_content like", value, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentNotLike(String value) {
            addCriterion("notebook_content not like", value, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentIn(List<String> values) {
            addCriterion("notebook_content in", values, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentNotIn(List<String> values) {
            addCriterion("notebook_content not in", values, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentBetween(String value1, String value2) {
            addCriterion("notebook_content between", value1, value2, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookContentNotBetween(String value1, String value2) {
            addCriterion("notebook_content not between", value1, value2, "notebookContent");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractIsNull() {
            addCriterion("notebook_abstract is null");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractIsNotNull() {
            addCriterion("notebook_abstract is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractEqualTo(String value) {
            addCriterion("notebook_abstract =", value, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractNotEqualTo(String value) {
            addCriterion("notebook_abstract <>", value, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractGreaterThan(String value) {
            addCriterion("notebook_abstract >", value, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractGreaterThanOrEqualTo(String value) {
            addCriterion("notebook_abstract >=", value, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractLessThan(String value) {
            addCriterion("notebook_abstract <", value, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractLessThanOrEqualTo(String value) {
            addCriterion("notebook_abstract <=", value, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractLike(String value) {
            addCriterion("notebook_abstract like", value, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractNotLike(String value) {
            addCriterion("notebook_abstract not like", value, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractIn(List<String> values) {
            addCriterion("notebook_abstract in", values, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractNotIn(List<String> values) {
            addCriterion("notebook_abstract not in", values, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractBetween(String value1, String value2) {
            addCriterion("notebook_abstract between", value1, value2, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookAbstractNotBetween(String value1, String value2) {
            addCriterion("notebook_abstract not between", value1, value2, "notebookAbstract");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateIsNull() {
            addCriterion("notebook_regdate is null");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateIsNotNull() {
            addCriterion("notebook_regdate is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateEqualTo(Date value) {
            addCriterionForJDBCDate("notebook_regdate =", value, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateNotEqualTo(Date value) {
            addCriterionForJDBCDate("notebook_regdate <>", value, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateGreaterThan(Date value) {
            addCriterionForJDBCDate("notebook_regdate >", value, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("notebook_regdate >=", value, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateLessThan(Date value) {
            addCriterionForJDBCDate("notebook_regdate <", value, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("notebook_regdate <=", value, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateIn(List<Date> values) {
            addCriterionForJDBCDate("notebook_regdate in", values, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateNotIn(List<Date> values) {
            addCriterionForJDBCDate("notebook_regdate not in", values, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("notebook_regdate between", value1, value2, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookRegdateNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("notebook_regdate not between", value1, value2, "notebookRegdate");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyIsNull() {
            addCriterion("notebook_modfiy is null");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyIsNotNull() {
            addCriterion("notebook_modfiy is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyEqualTo(Date value) {
            addCriterionForJDBCDate("notebook_modfiy =", value, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyNotEqualTo(Date value) {
            addCriterionForJDBCDate("notebook_modfiy <>", value, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyGreaterThan(Date value) {
            addCriterionForJDBCDate("notebook_modfiy >", value, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyGreaterThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("notebook_modfiy >=", value, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyLessThan(Date value) {
            addCriterionForJDBCDate("notebook_modfiy <", value, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyLessThanOrEqualTo(Date value) {
            addCriterionForJDBCDate("notebook_modfiy <=", value, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyIn(List<Date> values) {
            addCriterionForJDBCDate("notebook_modfiy in", values, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyNotIn(List<Date> values) {
            addCriterionForJDBCDate("notebook_modfiy not in", values, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("notebook_modfiy between", value1, value2, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookModfiyNotBetween(Date value1, Date value2) {
            addCriterionForJDBCDate("notebook_modfiy not between", value1, value2, "notebookModfiy");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessIsNull() {
            addCriterion("notebook_access is null");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessIsNotNull() {
            addCriterion("notebook_access is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessEqualTo(Integer value) {
            addCriterion("notebook_access =", value, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessNotEqualTo(Integer value) {
            addCriterion("notebook_access <>", value, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessGreaterThan(Integer value) {
            addCriterion("notebook_access >", value, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessGreaterThanOrEqualTo(Integer value) {
            addCriterion("notebook_access >=", value, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessLessThan(Integer value) {
            addCriterion("notebook_access <", value, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessLessThanOrEqualTo(Integer value) {
            addCriterion("notebook_access <=", value, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessIn(List<Integer> values) {
            addCriterion("notebook_access in", values, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessNotIn(List<Integer> values) {
            addCriterion("notebook_access not in", values, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessBetween(Integer value1, Integer value2) {
            addCriterion("notebook_access between", value1, value2, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookAccessNotBetween(Integer value1, Integer value2) {
            addCriterion("notebook_access not between", value1, value2, "notebookAccess");
            return (Criteria) this;
        }

        public Criteria andNotebookStateIsNull() {
            addCriterion("notebook_state is null");
            return (Criteria) this;
        }

        public Criteria andNotebookStateIsNotNull() {
            addCriterion("notebook_state is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookStateEqualTo(Integer value) {
            addCriterion("notebook_state =", value, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateNotEqualTo(Integer value) {
            addCriterion("notebook_state <>", value, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateGreaterThan(Integer value) {
            addCriterion("notebook_state >", value, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateGreaterThanOrEqualTo(Integer value) {
            addCriterion("notebook_state >=", value, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateLessThan(Integer value) {
            addCriterion("notebook_state <", value, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateLessThanOrEqualTo(Integer value) {
            addCriterion("notebook_state <=", value, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateIn(List<Integer> values) {
            addCriterion("notebook_state in", values, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateNotIn(List<Integer> values) {
            addCriterion("notebook_state not in", values, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateBetween(Integer value1, Integer value2) {
            addCriterion("notebook_state between", value1, value2, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookStateNotBetween(Integer value1, Integer value2) {
            addCriterion("notebook_state not between", value1, value2, "notebookState");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingIsNull() {
            addCriterion("notebook_sharing is null");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingIsNotNull() {
            addCriterion("notebook_sharing is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingEqualTo(Integer value) {
            addCriterion("notebook_sharing =", value, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingNotEqualTo(Integer value) {
            addCriterion("notebook_sharing <>", value, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingGreaterThan(Integer value) {
            addCriterion("notebook_sharing >", value, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingGreaterThanOrEqualTo(Integer value) {
            addCriterion("notebook_sharing >=", value, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingLessThan(Integer value) {
            addCriterion("notebook_sharing <", value, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingLessThanOrEqualTo(Integer value) {
            addCriterion("notebook_sharing <=", value, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingIn(List<Integer> values) {
            addCriterion("notebook_sharing in", values, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingNotIn(List<Integer> values) {
            addCriterion("notebook_sharing not in", values, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingBetween(Integer value1, Integer value2) {
            addCriterion("notebook_sharing between", value1, value2, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookSharingNotBetween(Integer value1, Integer value2) {
            addCriterion("notebook_sharing not between", value1, value2, "notebookSharing");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteIsNull() {
            addCriterion("notebook_activity_note is null");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteIsNotNull() {
            addCriterion("notebook_activity_note is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteEqualTo(Integer value) {
            addCriterion("notebook_activity_note =", value, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteNotEqualTo(Integer value) {
            addCriterion("notebook_activity_note <>", value, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteGreaterThan(Integer value) {
            addCriterion("notebook_activity_note >", value, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteGreaterThanOrEqualTo(Integer value) {
            addCriterion("notebook_activity_note >=", value, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteLessThan(Integer value) {
            addCriterion("notebook_activity_note <", value, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteLessThanOrEqualTo(Integer value) {
            addCriterion("notebook_activity_note <=", value, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteIn(List<Integer> values) {
            addCriterion("notebook_activity_note in", values, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteNotIn(List<Integer> values) {
            addCriterion("notebook_activity_note not in", values, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteBetween(Integer value1, Integer value2) {
            addCriterion("notebook_activity_note between", value1, value2, "notebookActivityNote");
            return (Criteria) this;
        }

        public Criteria andNotebookActivityNoteNotBetween(Integer value1, Integer value2) {
            addCriterion("notebook_activity_note not between", value1, value2, "notebookActivityNote");
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

        public Criteria andNotebookUrlIsNull() {
            addCriterion("notebook_url is null");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlIsNotNull() {
            addCriterion("notebook_url is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlEqualTo(String value) {
            addCriterion("notebook_url =", value, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlNotEqualTo(String value) {
            addCriterion("notebook_url <>", value, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlGreaterThan(String value) {
            addCriterion("notebook_url >", value, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlGreaterThanOrEqualTo(String value) {
            addCriterion("notebook_url >=", value, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlLessThan(String value) {
            addCriterion("notebook_url <", value, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlLessThanOrEqualTo(String value) {
            addCriterion("notebook_url <=", value, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlLike(String value) {
            addCriterion("notebook_url like", value, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlNotLike(String value) {
            addCriterion("notebook_url not like", value, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlIn(List<String> values) {
            addCriterion("notebook_url in", values, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlNotIn(List<String> values) {
            addCriterion("notebook_url not in", values, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlBetween(String value1, String value2) {
            addCriterion("notebook_url between", value1, value2, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookUrlNotBetween(String value1, String value2) {
            addCriterion("notebook_url not between", value1, value2, "notebookUrl");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectIsNull() {
            addCriterion("notebook_collect is null");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectIsNotNull() {
            addCriterion("notebook_collect is not null");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectEqualTo(Integer value) {
            addCriterion("notebook_collect =", value, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectNotEqualTo(Integer value) {
            addCriterion("notebook_collect <>", value, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectGreaterThan(Integer value) {
            addCriterion("notebook_collect >", value, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectGreaterThanOrEqualTo(Integer value) {
            addCriterion("notebook_collect >=", value, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectLessThan(Integer value) {
            addCriterion("notebook_collect <", value, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectLessThanOrEqualTo(Integer value) {
            addCriterion("notebook_collect <=", value, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectIn(List<Integer> values) {
            addCriterion("notebook_collect in", values, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectNotIn(List<Integer> values) {
            addCriterion("notebook_collect not in", values, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectBetween(Integer value1, Integer value2) {
            addCriterion("notebook_collect between", value1, value2, "notebookCollect");
            return (Criteria) this;
        }

        public Criteria andNotebookCollectNotBetween(Integer value1, Integer value2) {
            addCriterion("notebook_collect not between", value1, value2, "notebookCollect");
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