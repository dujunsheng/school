package com.school.po;

import java.util.ArrayList;
import java.util.List;

public class ClassExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ClassExample() {
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

        public Criteria andClassIdIsNull() {
            addCriterion("class_id is null");
            return (Criteria) this;
        }

        public Criteria andClassIdIsNotNull() {
            addCriterion("class_id is not null");
            return (Criteria) this;
        }

        public Criteria andClassIdEqualTo(Integer value) {
            addCriterion("class_id =", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotEqualTo(Integer value) {
            addCriterion("class_id <>", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThan(Integer value) {
            addCriterion("class_id >", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("class_id >=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThan(Integer value) {
            addCriterion("class_id <", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdLessThanOrEqualTo(Integer value) {
            addCriterion("class_id <=", value, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdIn(List<Integer> values) {
            addCriterion("class_id in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotIn(List<Integer> values) {
            addCriterion("class_id not in", values, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdBetween(Integer value1, Integer value2) {
            addCriterion("class_id between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIdNotBetween(Integer value1, Integer value2) {
            addCriterion("class_id not between", value1, value2, "classId");
            return (Criteria) this;
        }

        public Criteria andClassIsNull() {
            addCriterion("class is null");
            return (Criteria) this;
        }

        public Criteria andClassIsNotNull() {
            addCriterion("class is not null");
            return (Criteria) this;
        }

        public Criteria andClassEqualTo(Integer value) {
            addCriterion("class =", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassNotEqualTo(Integer value) {
            addCriterion("class <>", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassGreaterThan(Integer value) {
            addCriterion("class >", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassGreaterThanOrEqualTo(Integer value) {
            addCriterion("class >=", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassLessThan(Integer value) {
            addCriterion("class <", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassLessThanOrEqualTo(Integer value) {
            addCriterion("class <=", value, "class");
            return (Criteria) this;
        }

        public Criteria andClassIn(List<Integer> values) {
            addCriterion("class in", values, "class");
            return (Criteria) this;
        }

        public Criteria andClassNotIn(List<Integer> values) {
            addCriterion("class not in", values, "class");
            return (Criteria) this;
        }

        public Criteria andClassBetween(Integer value1, Integer value2) {
            addCriterion("class between", value1, value2, "class");
            return (Criteria) this;
        }

        public Criteria andClassNotBetween(Integer value1, Integer value2) {
            addCriterion("class not between", value1, value2, "class");
            return (Criteria) this;
        }

        public Criteria andGradeIsNull() {
            addCriterion("grade is null");
            return (Criteria) this;
        }

        public Criteria andGradeIsNotNull() {
            addCriterion("grade is not null");
            return (Criteria) this;
        }

        public Criteria andGradeEqualTo(Integer value) {
            addCriterion("grade =", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotEqualTo(Integer value) {
            addCriterion("grade <>", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThan(Integer value) {
            addCriterion("grade >", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeGreaterThanOrEqualTo(Integer value) {
            addCriterion("grade >=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThan(Integer value) {
            addCriterion("grade <", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeLessThanOrEqualTo(Integer value) {
            addCriterion("grade <=", value, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeIn(List<Integer> values) {
            addCriterion("grade in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotIn(List<Integer> values) {
            addCriterion("grade not in", values, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeBetween(Integer value1, Integer value2) {
            addCriterion("grade between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andGradeNotBetween(Integer value1, Integer value2) {
            addCriterion("grade not between", value1, value2, "grade");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdIsNull() {
            addCriterion("head_tea_id is null");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdIsNotNull() {
            addCriterion("head_tea_id is not null");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdEqualTo(String value) {
            addCriterion("head_tea_id =", value, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdNotEqualTo(String value) {
            addCriterion("head_tea_id <>", value, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdGreaterThan(String value) {
            addCriterion("head_tea_id >", value, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdGreaterThanOrEqualTo(String value) {
            addCriterion("head_tea_id >=", value, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdLessThan(String value) {
            addCriterion("head_tea_id <", value, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdLessThanOrEqualTo(String value) {
            addCriterion("head_tea_id <=", value, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdLike(String value) {
            addCriterion("head_tea_id like", value, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdNotLike(String value) {
            addCriterion("head_tea_id not like", value, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdIn(List<String> values) {
            addCriterion("head_tea_id in", values, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdNotIn(List<String> values) {
            addCriterion("head_tea_id not in", values, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdBetween(String value1, String value2) {
            addCriterion("head_tea_id between", value1, value2, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andHeadTeaIdNotBetween(String value1, String value2) {
            addCriterion("head_tea_id not between", value1, value2, "headTeaId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdIsNull() {
            addCriterion("momitor_id is null");
            return (Criteria) this;
        }

        public Criteria andMomitorIdIsNotNull() {
            addCriterion("momitor_id is not null");
            return (Criteria) this;
        }

        public Criteria andMomitorIdEqualTo(String value) {
            addCriterion("momitor_id =", value, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdNotEqualTo(String value) {
            addCriterion("momitor_id <>", value, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdGreaterThan(String value) {
            addCriterion("momitor_id >", value, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdGreaterThanOrEqualTo(String value) {
            addCriterion("momitor_id >=", value, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdLessThan(String value) {
            addCriterion("momitor_id <", value, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdLessThanOrEqualTo(String value) {
            addCriterion("momitor_id <=", value, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdLike(String value) {
            addCriterion("momitor_id like", value, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdNotLike(String value) {
            addCriterion("momitor_id not like", value, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdIn(List<String> values) {
            addCriterion("momitor_id in", values, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdNotIn(List<String> values) {
            addCriterion("momitor_id not in", values, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdBetween(String value1, String value2) {
            addCriterion("momitor_id between", value1, value2, "momitorId");
            return (Criteria) this;
        }

        public Criteria andMomitorIdNotBetween(String value1, String value2) {
            addCriterion("momitor_id not between", value1, value2, "momitorId");
            return (Criteria) this;
        }

        public Criteria andSumIsNull() {
            addCriterion("sum is null");
            return (Criteria) this;
        }

        public Criteria andSumIsNotNull() {
            addCriterion("sum is not null");
            return (Criteria) this;
        }

        public Criteria andSumEqualTo(Integer value) {
            addCriterion("sum =", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotEqualTo(Integer value) {
            addCriterion("sum <>", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThan(Integer value) {
            addCriterion("sum >", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumGreaterThanOrEqualTo(Integer value) {
            addCriterion("sum >=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThan(Integer value) {
            addCriterion("sum <", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumLessThanOrEqualTo(Integer value) {
            addCriterion("sum <=", value, "sum");
            return (Criteria) this;
        }

        public Criteria andSumIn(List<Integer> values) {
            addCriterion("sum in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotIn(List<Integer> values) {
            addCriterion("sum not in", values, "sum");
            return (Criteria) this;
        }

        public Criteria andSumBetween(Integer value1, Integer value2) {
            addCriterion("sum between", value1, value2, "sum");
            return (Criteria) this;
        }

        public Criteria andSumNotBetween(Integer value1, Integer value2) {
            addCriterion("sum not between", value1, value2, "sum");
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