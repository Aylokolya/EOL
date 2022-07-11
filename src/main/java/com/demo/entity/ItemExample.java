package com.demo.entity;

import java.util.ArrayList;
import java.util.List;

public class ItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public ItemExample() {
        oredCriteria = new ArrayList<>();
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
            criteria = new ArrayList<>();
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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Integer value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Integer value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Integer value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Integer value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Integer value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Integer value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Integer> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Integer> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Integer value1, Integer value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Integer value1, Integer value2) {
            addCriterion("id not between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andQidIsNull() {
            addCriterion("qid is null");
            return (Criteria) this;
        }

        public Criteria andQidIsNotNull() {
            addCriterion("qid is not null");
            return (Criteria) this;
        }

        public Criteria andQidEqualTo(Integer value) {
            addCriterion("qid =", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotEqualTo(Integer value) {
            addCriterion("qid <>", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidGreaterThan(Integer value) {
            addCriterion("qid >", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidGreaterThanOrEqualTo(Integer value) {
            addCriterion("qid >=", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidLessThan(Integer value) {
            addCriterion("qid <", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidLessThanOrEqualTo(Integer value) {
            addCriterion("qid <=", value, "qid");
            return (Criteria) this;
        }

        public Criteria andQidIn(List<Integer> values) {
            addCriterion("qid in", values, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotIn(List<Integer> values) {
            addCriterion("qid not in", values, "qid");
            return (Criteria) this;
        }

        public Criteria andQidBetween(Integer value1, Integer value2) {
            addCriterion("qid between", value1, value2, "qid");
            return (Criteria) this;
        }

        public Criteria andQidNotBetween(Integer value1, Integer value2) {
            addCriterion("qid not between", value1, value2, "qid");
            return (Criteria) this;
        }

        public Criteria andItemaIsNull() {
            addCriterion("itema is null");
            return (Criteria) this;
        }

        public Criteria andItemaIsNotNull() {
            addCriterion("itema is not null");
            return (Criteria) this;
        }

        public Criteria andItemaEqualTo(String value) {
            addCriterion("itema =", value, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaNotEqualTo(String value) {
            addCriterion("itema <>", value, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaGreaterThan(String value) {
            addCriterion("itema >", value, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaGreaterThanOrEqualTo(String value) {
            addCriterion("itema >=", value, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaLessThan(String value) {
            addCriterion("itema <", value, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaLessThanOrEqualTo(String value) {
            addCriterion("itema <=", value, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaLike(String value) {
            addCriterion("itema like", value, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaNotLike(String value) {
            addCriterion("itema not like", value, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaIn(List<String> values) {
            addCriterion("itema in", values, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaNotIn(List<String> values) {
            addCriterion("itema not in", values, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaBetween(String value1, String value2) {
            addCriterion("itema between", value1, value2, "itema");
            return (Criteria) this;
        }

        public Criteria andItemaNotBetween(String value1, String value2) {
            addCriterion("itema not between", value1, value2, "itema");
            return (Criteria) this;
        }

        public Criteria andItembIsNull() {
            addCriterion("itemb is null");
            return (Criteria) this;
        }

        public Criteria andItembIsNotNull() {
            addCriterion("itemb is not null");
            return (Criteria) this;
        }

        public Criteria andItembEqualTo(String value) {
            addCriterion("itemb =", value, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembNotEqualTo(String value) {
            addCriterion("itemb <>", value, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembGreaterThan(String value) {
            addCriterion("itemb >", value, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembGreaterThanOrEqualTo(String value) {
            addCriterion("itemb >=", value, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembLessThan(String value) {
            addCriterion("itemb <", value, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembLessThanOrEqualTo(String value) {
            addCriterion("itemb <=", value, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembLike(String value) {
            addCriterion("itemb like", value, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembNotLike(String value) {
            addCriterion("itemb not like", value, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembIn(List<String> values) {
            addCriterion("itemb in", values, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembNotIn(List<String> values) {
            addCriterion("itemb not in", values, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembBetween(String value1, String value2) {
            addCriterion("itemb between", value1, value2, "itemb");
            return (Criteria) this;
        }

        public Criteria andItembNotBetween(String value1, String value2) {
            addCriterion("itemb not between", value1, value2, "itemb");
            return (Criteria) this;
        }

        public Criteria andItemcIsNull() {
            addCriterion("itemc is null");
            return (Criteria) this;
        }

        public Criteria andItemcIsNotNull() {
            addCriterion("itemc is not null");
            return (Criteria) this;
        }

        public Criteria andItemcEqualTo(String value) {
            addCriterion("itemc =", value, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcNotEqualTo(String value) {
            addCriterion("itemc <>", value, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcGreaterThan(String value) {
            addCriterion("itemc >", value, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcGreaterThanOrEqualTo(String value) {
            addCriterion("itemc >=", value, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcLessThan(String value) {
            addCriterion("itemc <", value, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcLessThanOrEqualTo(String value) {
            addCriterion("itemc <=", value, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcLike(String value) {
            addCriterion("itemc like", value, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcNotLike(String value) {
            addCriterion("itemc not like", value, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcIn(List<String> values) {
            addCriterion("itemc in", values, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcNotIn(List<String> values) {
            addCriterion("itemc not in", values, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcBetween(String value1, String value2) {
            addCriterion("itemc between", value1, value2, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemcNotBetween(String value1, String value2) {
            addCriterion("itemc not between", value1, value2, "itemc");
            return (Criteria) this;
        }

        public Criteria andItemdIsNull() {
            addCriterion("itemd is null");
            return (Criteria) this;
        }

        public Criteria andItemdIsNotNull() {
            addCriterion("itemd is not null");
            return (Criteria) this;
        }

        public Criteria andItemdEqualTo(String value) {
            addCriterion("itemd =", value, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdNotEqualTo(String value) {
            addCriterion("itemd <>", value, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdGreaterThan(String value) {
            addCriterion("itemd >", value, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdGreaterThanOrEqualTo(String value) {
            addCriterion("itemd >=", value, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdLessThan(String value) {
            addCriterion("itemd <", value, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdLessThanOrEqualTo(String value) {
            addCriterion("itemd <=", value, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdLike(String value) {
            addCriterion("itemd like", value, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdNotLike(String value) {
            addCriterion("itemd not like", value, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdIn(List<String> values) {
            addCriterion("itemd in", values, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdNotIn(List<String> values) {
            addCriterion("itemd not in", values, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdBetween(String value1, String value2) {
            addCriterion("itemd between", value1, value2, "itemd");
            return (Criteria) this;
        }

        public Criteria andItemdNotBetween(String value1, String value2) {
            addCriterion("itemd not between", value1, value2, "itemd");
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