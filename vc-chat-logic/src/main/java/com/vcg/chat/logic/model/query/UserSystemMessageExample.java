package com.vcg.chat.logic.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserSystemMessageExample extends BaseExample<UserSystemMessageExample,UserSystemMessageExample.Criteria> implements Serializable {

	public static final String id = "id";

	public static final String userId = "user_id";

	public static final String systemMessageId = "system_message_id";

	public static final String createdTime = "created_time";

	public static final String uniId = "uni_id";


    public static class Columns extends ArrayList<String> {
		 public Columns andId() {
			add(id);
			return this;
		}

		 public Columns andUserId() {
			add(userId);
			return this;
		}

		 public Columns andSystemMessageId() {
			add(systemMessageId);
			return this;
		}

		 public Columns andCreatedTime() {
			add(createdTime);
			return this;
		}

		 public Columns andUniId() {
			add(uniId);
			return this;
		}
	}

    public static Columns newColumns() {
        return new Columns();
    }

    public static Criteria newCriteria() {
        return new Criteria();
    }

    public UserSystemMessageExample withDistinct(boolean distinct){
        setDistinct(distinct);
        return this;
    }


	private static final long serialVersionUID = 7855849478568987412L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserSystemMessageExample() {
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

protected abstract static class GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 8751208137422923678L;

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

        public Criteria andIdIsNull() {
            addCriterion("id is null");
            return (Criteria) this;
        }

        public Criteria andIdIsNotNull() {
            addCriterion("id is not null");
            return (Criteria) this;
        }

        public Criteria andIdEqualTo(Long value) {
            addCriterion("id =", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotEqualTo(Long value) {
            addCriterion("id <>", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThan(Long value) {
            addCriterion("id >", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdGreaterThanOrEqualTo(Long value) {
            addCriterion("id >=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThan(Long value) {
            addCriterion("id <", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdLessThanOrEqualTo(Long value) {
            addCriterion("id <=", value, "id");
            return (Criteria) this;
        }

        public Criteria andIdIn(List<Long> values) {
            addCriterion("id in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotIn(List<Long> values) {
            addCriterion("id not in", values, "id");
            return (Criteria) this;
        }

        public Criteria andIdBetween(Long value1, Long value2) {
            addCriterion("id between", value1, value2, "id");
            return (Criteria) this;
        }

        public Criteria andIdNotBetween(Long value1, Long value2) {
            addCriterion("id not between", value1, value2, "id");
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

        public Criteria andUserIdEqualTo(String value) {
            addCriterion("user_id =", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotEqualTo(String value) {
            addCriterion("user_id <>", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThan(String value) {
            addCriterion("user_id >", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("user_id >=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThan(String value) {
            addCriterion("user_id <", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLessThanOrEqualTo(String value) {
            addCriterion("user_id <=", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdLike(String value) {
            addCriterion("user_id like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotLike(String value) {
            addCriterion("user_id not like", value, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdIn(List<String> values) {
            addCriterion("user_id in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotIn(List<String> values) {
            addCriterion("user_id not in", values, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdBetween(String value1, String value2) {
            addCriterion("user_id between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andUserIdNotBetween(String value1, String value2) {
            addCriterion("user_id not between", value1, value2, "userId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdIsNull() {
            addCriterion("system_message_id is null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdIsNotNull() {
            addCriterion("system_message_id is not null");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdEqualTo(Long value) {
            addCriterion("system_message_id =", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdNotEqualTo(Long value) {
            addCriterion("system_message_id <>", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdGreaterThan(Long value) {
            addCriterion("system_message_id >", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdGreaterThanOrEqualTo(Long value) {
            addCriterion("system_message_id >=", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdLessThan(Long value) {
            addCriterion("system_message_id <", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdLessThanOrEqualTo(Long value) {
            addCriterion("system_message_id <=", value, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdIn(List<Long> values) {
            addCriterion("system_message_id in", values, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdNotIn(List<Long> values) {
            addCriterion("system_message_id not in", values, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdBetween(Long value1, Long value2) {
            addCriterion("system_message_id between", value1, value2, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andSystemMessageIdNotBetween(Long value1, Long value2) {
            addCriterion("system_message_id not between", value1, value2, "systemMessageId");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNull() {
            addCriterion("created_time is null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIsNotNull() {
            addCriterion("created_time is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeEqualTo(Date value) {
            addCriterion("created_time =", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotEqualTo(Date value) {
            addCriterion("created_time <>", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThan(Date value) {
            addCriterion("created_time >", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("created_time >=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThan(Date value) {
            addCriterion("created_time <", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("created_time <=", value, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeIn(List<Date> values) {
            addCriterion("created_time in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotIn(List<Date> values) {
            addCriterion("created_time not in", values, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeBetween(Date value1, Date value2) {
            addCriterion("created_time between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andCreatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("created_time not between", value1, value2, "createdTime");
            return (Criteria) this;
        }

        public Criteria andUniIdIsNull() {
            addCriterion("uni_id is null");
            return (Criteria) this;
        }

        public Criteria andUniIdIsNotNull() {
            addCriterion("uni_id is not null");
            return (Criteria) this;
        }

        public Criteria andUniIdEqualTo(String value) {
            addCriterion("uni_id =", value, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdNotEqualTo(String value) {
            addCriterion("uni_id <>", value, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdGreaterThan(String value) {
            addCriterion("uni_id >", value, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdGreaterThanOrEqualTo(String value) {
            addCriterion("uni_id >=", value, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdLessThan(String value) {
            addCriterion("uni_id <", value, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdLessThanOrEqualTo(String value) {
            addCriterion("uni_id <=", value, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdLike(String value) {
            addCriterion("uni_id like", value, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdNotLike(String value) {
            addCriterion("uni_id not like", value, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdIn(List<String> values) {
            addCriterion("uni_id in", values, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdNotIn(List<String> values) {
            addCriterion("uni_id not in", values, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdBetween(String value1, String value2) {
            addCriterion("uni_id between", value1, value2, "uniId");
            return (Criteria) this;
        }

        public Criteria andUniIdNotBetween(String value1, String value2) {
            addCriterion("uni_id not between", value1, value2, "uniId");
            return (Criteria) this;
        }
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 2490325021660986213L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 812827274117055381L;

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
