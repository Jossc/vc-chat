package com.vcg.chat.logic.model.query;

import java.io.Serializable;
import com.vcg.common.base.BaseExample;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class UserDialogueExample extends BaseExample<UserDialogueExample,UserDialogueExample.Criteria> implements Serializable {

	public static final String id = "id";

	public static final String userId = "user_id";

	public static final String toUserId = "to_user_id";

	public static final String parentId = "parent_id";

	public static final String parentMake = "parent_make";

	public static final String createdTime = "created_time";

	public static final String updatedTime = "updated_time";

	public static final String unreadTotal = "unread_total";

	public static final String ordered = "ordered";

	public static final String push = "push";

	public static final String uniId = "uni_id";

	public static final String type = "type";

	public static final String lastMessage = "last_message";


    public static class Columns extends ArrayList<String> {
		 public Columns andId() {
			add(id);
			return this;
		}

		 public Columns andUserId() {
			add(userId);
			return this;
		}

		 public Columns andToUserId() {
			add(toUserId);
			return this;
		}

		 public Columns andParentId() {
			add(parentId);
			return this;
		}

		 public Columns andParentMake() {
			add(parentMake);
			return this;
		}

		 public Columns andCreatedTime() {
			add(createdTime);
			return this;
		}

		 public Columns andUpdatedTime() {
			add(updatedTime);
			return this;
		}

		 public Columns andUnreadTotal() {
			add(unreadTotal);
			return this;
		}

		 public Columns andOrdered() {
			add(ordered);
			return this;
		}

		 public Columns andPush() {
			add(push);
			return this;
		}

		 public Columns andUniId() {
			add(uniId);
			return this;
		}

		 public Columns andType() {
			add(type);
			return this;
		}

		 public Columns andLastMessage() {
			add(lastMessage);
			return this;
		}
	}

    public static Columns newColumns() {
        return new Columns();
    }

    public static Criteria newCriteria() {
        return new Criteria();
    }

    public UserDialogueExample withDistinct(boolean distinct){
        setDistinct(distinct);
        return this;
    }


	private static final long serialVersionUID = 2210805695338599293L;

    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public UserDialogueExample() {
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

	private static final long serialVersionUID = 6856749236547813057L;

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

        public Criteria andToUserIdIsNull() {
            addCriterion("to_user_id is null");
            return (Criteria) this;
        }

        public Criteria andToUserIdIsNotNull() {
            addCriterion("to_user_id is not null");
            return (Criteria) this;
        }

        public Criteria andToUserIdEqualTo(String value) {
            addCriterion("to_user_id =", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotEqualTo(String value) {
            addCriterion("to_user_id <>", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThan(String value) {
            addCriterion("to_user_id >", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdGreaterThanOrEqualTo(String value) {
            addCriterion("to_user_id >=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThan(String value) {
            addCriterion("to_user_id <", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLessThanOrEqualTo(String value) {
            addCriterion("to_user_id <=", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdLike(String value) {
            addCriterion("to_user_id like", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotLike(String value) {
            addCriterion("to_user_id not like", value, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdIn(List<String> values) {
            addCriterion("to_user_id in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotIn(List<String> values) {
            addCriterion("to_user_id not in", values, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdBetween(String value1, String value2) {
            addCriterion("to_user_id between", value1, value2, "toUserId");
            return (Criteria) this;
        }

        public Criteria andToUserIdNotBetween(String value1, String value2) {
            addCriterion("to_user_id not between", value1, value2, "toUserId");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNull() {
            addCriterion("parent_id is null");
            return (Criteria) this;
        }

        public Criteria andParentIdIsNotNull() {
            addCriterion("parent_id is not null");
            return (Criteria) this;
        }

        public Criteria andParentIdEqualTo(Long value) {
            addCriterion("parent_id =", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotEqualTo(Long value) {
            addCriterion("parent_id <>", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThan(Long value) {
            addCriterion("parent_id >", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdGreaterThanOrEqualTo(Long value) {
            addCriterion("parent_id >=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThan(Long value) {
            addCriterion("parent_id <", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdLessThanOrEqualTo(Long value) {
            addCriterion("parent_id <=", value, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdIn(List<Long> values) {
            addCriterion("parent_id in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotIn(List<Long> values) {
            addCriterion("parent_id not in", values, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdBetween(Long value1, Long value2) {
            addCriterion("parent_id between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentIdNotBetween(Long value1, Long value2) {
            addCriterion("parent_id not between", value1, value2, "parentId");
            return (Criteria) this;
        }

        public Criteria andParentMakeIsNull() {
            addCriterion("parent_make is null");
            return (Criteria) this;
        }

        public Criteria andParentMakeIsNotNull() {
            addCriterion("parent_make is not null");
            return (Criteria) this;
        }

        public Criteria andParentMakeEqualTo(Integer value) {
            addCriterion("parent_make =", value, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeNotEqualTo(Integer value) {
            addCriterion("parent_make <>", value, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeGreaterThan(Integer value) {
            addCriterion("parent_make >", value, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeGreaterThanOrEqualTo(Integer value) {
            addCriterion("parent_make >=", value, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeLessThan(Integer value) {
            addCriterion("parent_make <", value, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeLessThanOrEqualTo(Integer value) {
            addCriterion("parent_make <=", value, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeIn(List<Integer> values) {
            addCriterion("parent_make in", values, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeNotIn(List<Integer> values) {
            addCriterion("parent_make not in", values, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeBetween(Integer value1, Integer value2) {
            addCriterion("parent_make between", value1, value2, "parentMake");
            return (Criteria) this;
        }

        public Criteria andParentMakeNotBetween(Integer value1, Integer value2) {
            addCriterion("parent_make not between", value1, value2, "parentMake");
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

        public Criteria andUpdatedTimeIsNull() {
            addCriterion("updated_time is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIsNotNull() {
            addCriterion("updated_time is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeEqualTo(Date value) {
            addCriterion("updated_time =", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotEqualTo(Date value) {
            addCriterion("updated_time <>", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThan(Date value) {
            addCriterion("updated_time >", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeGreaterThanOrEqualTo(Date value) {
            addCriterion("updated_time >=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThan(Date value) {
            addCriterion("updated_time <", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeLessThanOrEqualTo(Date value) {
            addCriterion("updated_time <=", value, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeIn(List<Date> values) {
            addCriterion("updated_time in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotIn(List<Date> values) {
            addCriterion("updated_time not in", values, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeBetween(Date value1, Date value2) {
            addCriterion("updated_time between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUpdatedTimeNotBetween(Date value1, Date value2) {
            addCriterion("updated_time not between", value1, value2, "updatedTime");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalIsNull() {
            addCriterion("unread_total is null");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalIsNotNull() {
            addCriterion("unread_total is not null");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalEqualTo(Integer value) {
            addCriterion("unread_total =", value, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalNotEqualTo(Integer value) {
            addCriterion("unread_total <>", value, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalGreaterThan(Integer value) {
            addCriterion("unread_total >", value, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalGreaterThanOrEqualTo(Integer value) {
            addCriterion("unread_total >=", value, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalLessThan(Integer value) {
            addCriterion("unread_total <", value, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalLessThanOrEqualTo(Integer value) {
            addCriterion("unread_total <=", value, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalIn(List<Integer> values) {
            addCriterion("unread_total in", values, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalNotIn(List<Integer> values) {
            addCriterion("unread_total not in", values, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalBetween(Integer value1, Integer value2) {
            addCriterion("unread_total between", value1, value2, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andUnreadTotalNotBetween(Integer value1, Integer value2) {
            addCriterion("unread_total not between", value1, value2, "unreadTotal");
            return (Criteria) this;
        }

        public Criteria andOrderedIsNull() {
            addCriterion("ordered is null");
            return (Criteria) this;
        }

        public Criteria andOrderedIsNotNull() {
            addCriterion("ordered is not null");
            return (Criteria) this;
        }

        public Criteria andOrderedEqualTo(Long value) {
            addCriterion("ordered =", value, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedNotEqualTo(Long value) {
            addCriterion("ordered <>", value, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedGreaterThan(Long value) {
            addCriterion("ordered >", value, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedGreaterThanOrEqualTo(Long value) {
            addCriterion("ordered >=", value, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedLessThan(Long value) {
            addCriterion("ordered <", value, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedLessThanOrEqualTo(Long value) {
            addCriterion("ordered <=", value, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedIn(List<Long> values) {
            addCriterion("ordered in", values, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedNotIn(List<Long> values) {
            addCriterion("ordered not in", values, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedBetween(Long value1, Long value2) {
            addCriterion("ordered between", value1, value2, "ordered");
            return (Criteria) this;
        }

        public Criteria andOrderedNotBetween(Long value1, Long value2) {
            addCriterion("ordered not between", value1, value2, "ordered");
            return (Criteria) this;
        }

        public Criteria andPushIsNull() {
            addCriterion("push is null");
            return (Criteria) this;
        }

        public Criteria andPushIsNotNull() {
            addCriterion("push is not null");
            return (Criteria) this;
        }

        public Criteria andPushEqualTo(Integer value) {
            addCriterion("push =", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushNotEqualTo(Integer value) {
            addCriterion("push <>", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushGreaterThan(Integer value) {
            addCriterion("push >", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushGreaterThanOrEqualTo(Integer value) {
            addCriterion("push >=", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushLessThan(Integer value) {
            addCriterion("push <", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushLessThanOrEqualTo(Integer value) {
            addCriterion("push <=", value, "push");
            return (Criteria) this;
        }

        public Criteria andPushIn(List<Integer> values) {
            addCriterion("push in", values, "push");
            return (Criteria) this;
        }

        public Criteria andPushNotIn(List<Integer> values) {
            addCriterion("push not in", values, "push");
            return (Criteria) this;
        }

        public Criteria andPushBetween(Integer value1, Integer value2) {
            addCriterion("push between", value1, value2, "push");
            return (Criteria) this;
        }

        public Criteria andPushNotBetween(Integer value1, Integer value2) {
            addCriterion("push not between", value1, value2, "push");
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

        public Criteria andTypeIsNull() {
            addCriterion("`type` is null");
            return (Criteria) this;
        }

        public Criteria andTypeIsNotNull() {
            addCriterion("`type` is not null");
            return (Criteria) this;
        }

        public Criteria andTypeEqualTo(Integer value) {
            addCriterion("`type` =", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotEqualTo(Integer value) {
            addCriterion("`type` <>", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThan(Integer value) {
            addCriterion("`type` >", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeGreaterThanOrEqualTo(Integer value) {
            addCriterion("`type` >=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThan(Integer value) {
            addCriterion("`type` <", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeLessThanOrEqualTo(Integer value) {
            addCriterion("`type` <=", value, "type");
            return (Criteria) this;
        }

        public Criteria andTypeIn(List<Integer> values) {
            addCriterion("`type` in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotIn(List<Integer> values) {
            addCriterion("`type` not in", values, "type");
            return (Criteria) this;
        }

        public Criteria andTypeBetween(Integer value1, Integer value2) {
            addCriterion("`type` between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andTypeNotBetween(Integer value1, Integer value2) {
            addCriterion("`type` not between", value1, value2, "type");
            return (Criteria) this;
        }

        public Criteria andLastMessageIsNull() {
            addCriterion("last_message is null");
            return (Criteria) this;
        }

        public Criteria andLastMessageIsNotNull() {
            addCriterion("last_message is not null");
            return (Criteria) this;
        }

        public Criteria andLastMessageEqualTo(String value) {
            addCriterion("last_message =", value, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageNotEqualTo(String value) {
            addCriterion("last_message <>", value, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageGreaterThan(String value) {
            addCriterion("last_message >", value, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageGreaterThanOrEqualTo(String value) {
            addCriterion("last_message >=", value, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageLessThan(String value) {
            addCriterion("last_message <", value, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageLessThanOrEqualTo(String value) {
            addCriterion("last_message <=", value, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageLike(String value) {
            addCriterion("last_message like", value, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageNotLike(String value) {
            addCriterion("last_message not like", value, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageIn(List<String> values) {
            addCriterion("last_message in", values, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageNotIn(List<String> values) {
            addCriterion("last_message not in", values, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageBetween(String value1, String value2) {
            addCriterion("last_message between", value1, value2, "lastMessage");
            return (Criteria) this;
        }

        public Criteria andLastMessageNotBetween(String value1, String value2) {
            addCriterion("last_message not between", value1, value2, "lastMessage");
            return (Criteria) this;
        }
    }

public static class Criteria extends GeneratedCriteria implements Serializable {

	private static final long serialVersionUID = 3749463389069179574L;


        protected Criteria() {
            super();
        }
    }

public static class Criterion implements Serializable {

	private static final long serialVersionUID = 7163390989695415327L;

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
