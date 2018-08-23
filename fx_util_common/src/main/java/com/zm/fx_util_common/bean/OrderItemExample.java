package com.zm.fx_util_common.bean;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class OrderItemExample {
    protected String orderByClause;

    protected boolean distinct;

    protected List<Criteria> oredCriteria;

    public OrderItemExample() {
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

        public Criteria andOrderidIsNull() {
            addCriterion("orderid is null");
            return (Criteria) this;
        }

        public Criteria andOrderidIsNotNull() {
            addCriterion("orderid is not null");
            return (Criteria) this;
        }

        public Criteria andOrderidEqualTo(Long value) {
            addCriterion("orderid =", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotEqualTo(Long value) {
            addCriterion("orderid <>", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThan(Long value) {
            addCriterion("orderid >", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidGreaterThanOrEqualTo(Long value) {
            addCriterion("orderid >=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThan(Long value) {
            addCriterion("orderid <", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidLessThanOrEqualTo(Long value) {
            addCriterion("orderid <=", value, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidIn(List<Long> values) {
            addCriterion("orderid in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotIn(List<Long> values) {
            addCriterion("orderid not in", values, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidBetween(Long value1, Long value2) {
            addCriterion("orderid between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andOrderidNotBetween(Long value1, Long value2) {
            addCriterion("orderid not between", value1, value2, "orderid");
            return (Criteria) this;
        }

        public Criteria andItemidIsNull() {
            addCriterion("itemid is null");
            return (Criteria) this;
        }

        public Criteria andItemidIsNotNull() {
            addCriterion("itemid is not null");
            return (Criteria) this;
        }

        public Criteria andItemidEqualTo(Long value) {
            addCriterion("itemid =", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotEqualTo(Long value) {
            addCriterion("itemid <>", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThan(Long value) {
            addCriterion("itemid >", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidGreaterThanOrEqualTo(Long value) {
            addCriterion("itemid >=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThan(Long value) {
            addCriterion("itemid <", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidLessThanOrEqualTo(Long value) {
            addCriterion("itemid <=", value, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidIn(List<Long> values) {
            addCriterion("itemid in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotIn(List<Long> values) {
            addCriterion("itemid not in", values, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidBetween(Long value1, Long value2) {
            addCriterion("itemid between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemidNotBetween(Long value1, Long value2) {
            addCriterion("itemid not between", value1, value2, "itemid");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNull() {
            addCriterion("itemname is null");
            return (Criteria) this;
        }

        public Criteria andItemnameIsNotNull() {
            addCriterion("itemname is not null");
            return (Criteria) this;
        }

        public Criteria andItemnameEqualTo(String value) {
            addCriterion("itemname =", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotEqualTo(String value) {
            addCriterion("itemname <>", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThan(String value) {
            addCriterion("itemname >", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameGreaterThanOrEqualTo(String value) {
            addCriterion("itemname >=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThan(String value) {
            addCriterion("itemname <", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLessThanOrEqualTo(String value) {
            addCriterion("itemname <=", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameLike(String value) {
            addCriterion("itemname like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotLike(String value) {
            addCriterion("itemname not like", value, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameIn(List<String> values) {
            addCriterion("itemname in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotIn(List<String> values) {
            addCriterion("itemname not in", values, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameBetween(String value1, String value2) {
            addCriterion("itemname between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemnameNotBetween(String value1, String value2) {
            addCriterion("itemname not between", value1, value2, "itemname");
            return (Criteria) this;
        }

        public Criteria andItemdescIsNull() {
            addCriterion("itemdesc is null");
            return (Criteria) this;
        }

        public Criteria andItemdescIsNotNull() {
            addCriterion("itemdesc is not null");
            return (Criteria) this;
        }

        public Criteria andItemdescEqualTo(String value) {
            addCriterion("itemdesc =", value, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescNotEqualTo(String value) {
            addCriterion("itemdesc <>", value, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescGreaterThan(String value) {
            addCriterion("itemdesc >", value, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescGreaterThanOrEqualTo(String value) {
            addCriterion("itemdesc >=", value, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescLessThan(String value) {
            addCriterion("itemdesc <", value, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescLessThanOrEqualTo(String value) {
            addCriterion("itemdesc <=", value, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescLike(String value) {
            addCriterion("itemdesc like", value, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescNotLike(String value) {
            addCriterion("itemdesc not like", value, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescIn(List<String> values) {
            addCriterion("itemdesc in", values, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescNotIn(List<String> values) {
            addCriterion("itemdesc not in", values, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescBetween(String value1, String value2) {
            addCriterion("itemdesc between", value1, value2, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andItemdescNotBetween(String value1, String value2) {
            addCriterion("itemdesc not between", value1, value2, "itemdesc");
            return (Criteria) this;
        }

        public Criteria andAllpruceIsNull() {
            addCriterion("allpruce is null");
            return (Criteria) this;
        }

        public Criteria andAllpruceIsNotNull() {
            addCriterion("allpruce is not null");
            return (Criteria) this;
        }

        public Criteria andAllpruceEqualTo(Double value) {
            addCriterion("allpruce =", value, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceNotEqualTo(Double value) {
            addCriterion("allpruce <>", value, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceGreaterThan(Double value) {
            addCriterion("allpruce >", value, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceGreaterThanOrEqualTo(Double value) {
            addCriterion("allpruce >=", value, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceLessThan(Double value) {
            addCriterion("allpruce <", value, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceLessThanOrEqualTo(Double value) {
            addCriterion("allpruce <=", value, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceIn(List<Double> values) {
            addCriterion("allpruce in", values, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceNotIn(List<Double> values) {
            addCriterion("allpruce not in", values, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceBetween(Double value1, Double value2) {
            addCriterion("allpruce between", value1, value2, "allpruce");
            return (Criteria) this;
        }

        public Criteria andAllpruceNotBetween(Double value1, Double value2) {
            addCriterion("allpruce not between", value1, value2, "allpruce");
            return (Criteria) this;
        }

        public Criteria andNumIsNull() {
            addCriterion("num is null");
            return (Criteria) this;
        }

        public Criteria andNumIsNotNull() {
            addCriterion("num is not null");
            return (Criteria) this;
        }

        public Criteria andNumEqualTo(Integer value) {
            addCriterion("num =", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotEqualTo(Integer value) {
            addCriterion("num <>", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThan(Integer value) {
            addCriterion("num >", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumGreaterThanOrEqualTo(Integer value) {
            addCriterion("num >=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThan(Integer value) {
            addCriterion("num <", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumLessThanOrEqualTo(Integer value) {
            addCriterion("num <=", value, "num");
            return (Criteria) this;
        }

        public Criteria andNumIn(List<Integer> values) {
            addCriterion("num in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotIn(List<Integer> values) {
            addCriterion("num not in", values, "num");
            return (Criteria) this;
        }

        public Criteria andNumBetween(Integer value1, Integer value2) {
            addCriterion("num between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andNumNotBetween(Integer value1, Integer value2) {
            addCriterion("num not between", value1, value2, "num");
            return (Criteria) this;
        }

        public Criteria andOnepriceIsNull() {
            addCriterion("oneprice is null");
            return (Criteria) this;
        }

        public Criteria andOnepriceIsNotNull() {
            addCriterion("oneprice is not null");
            return (Criteria) this;
        }

        public Criteria andOnepriceEqualTo(Double value) {
            addCriterion("oneprice =", value, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceNotEqualTo(Double value) {
            addCriterion("oneprice <>", value, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceGreaterThan(Double value) {
            addCriterion("oneprice >", value, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceGreaterThanOrEqualTo(Double value) {
            addCriterion("oneprice >=", value, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceLessThan(Double value) {
            addCriterion("oneprice <", value, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceLessThanOrEqualTo(Double value) {
            addCriterion("oneprice <=", value, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceIn(List<Double> values) {
            addCriterion("oneprice in", values, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceNotIn(List<Double> values) {
            addCriterion("oneprice not in", values, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceBetween(Double value1, Double value2) {
            addCriterion("oneprice between", value1, value2, "oneprice");
            return (Criteria) this;
        }

        public Criteria andOnepriceNotBetween(Double value1, Double value2) {
            addCriterion("oneprice not between", value1, value2, "oneprice");
            return (Criteria) this;
        }

        public Criteria andImgIsNull() {
            addCriterion("img is null");
            return (Criteria) this;
        }

        public Criteria andImgIsNotNull() {
            addCriterion("img is not null");
            return (Criteria) this;
        }

        public Criteria andImgEqualTo(String value) {
            addCriterion("img =", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotEqualTo(String value) {
            addCriterion("img <>", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThan(String value) {
            addCriterion("img >", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgGreaterThanOrEqualTo(String value) {
            addCriterion("img >=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThan(String value) {
            addCriterion("img <", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLessThanOrEqualTo(String value) {
            addCriterion("img <=", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgLike(String value) {
            addCriterion("img like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotLike(String value) {
            addCriterion("img not like", value, "img");
            return (Criteria) this;
        }

        public Criteria andImgIn(List<String> values) {
            addCriterion("img in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotIn(List<String> values) {
            addCriterion("img not in", values, "img");
            return (Criteria) this;
        }

        public Criteria andImgBetween(String value1, String value2) {
            addCriterion("img between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andImgNotBetween(String value1, String value2) {
            addCriterion("img not between", value1, value2, "img");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeIsNull() {
            addCriterion("logisticscode is null");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeIsNotNull() {
            addCriterion("logisticscode is not null");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeEqualTo(String value) {
            addCriterion("logisticscode =", value, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeNotEqualTo(String value) {
            addCriterion("logisticscode <>", value, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeGreaterThan(String value) {
            addCriterion("logisticscode >", value, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeGreaterThanOrEqualTo(String value) {
            addCriterion("logisticscode >=", value, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeLessThan(String value) {
            addCriterion("logisticscode <", value, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeLessThanOrEqualTo(String value) {
            addCriterion("logisticscode <=", value, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeLike(String value) {
            addCriterion("logisticscode like", value, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeNotLike(String value) {
            addCriterion("logisticscode not like", value, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeIn(List<String> values) {
            addCriterion("logisticscode in", values, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeNotIn(List<String> values) {
            addCriterion("logisticscode not in", values, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeBetween(String value1, String value2) {
            addCriterion("logisticscode between", value1, value2, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andLogisticscodeNotBetween(String value1, String value2) {
            addCriterion("logisticscode not between", value1, value2, "logisticscode");
            return (Criteria) this;
        }

        public Criteria andIsreceiveIsNull() {
            addCriterion("isreceive is null");
            return (Criteria) this;
        }

        public Criteria andIsreceiveIsNotNull() {
            addCriterion("isreceive is not null");
            return (Criteria) this;
        }

        public Criteria andIsreceiveEqualTo(Integer value) {
            addCriterion("isreceive =", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotEqualTo(Integer value) {
            addCriterion("isreceive <>", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveGreaterThan(Integer value) {
            addCriterion("isreceive >", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveGreaterThanOrEqualTo(Integer value) {
            addCriterion("isreceive >=", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveLessThan(Integer value) {
            addCriterion("isreceive <", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveLessThanOrEqualTo(Integer value) {
            addCriterion("isreceive <=", value, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveIn(List<Integer> values) {
            addCriterion("isreceive in", values, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotIn(List<Integer> values) {
            addCriterion("isreceive not in", values, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveBetween(Integer value1, Integer value2) {
            addCriterion("isreceive between", value1, value2, "isreceive");
            return (Criteria) this;
        }

        public Criteria andIsreceiveNotBetween(Integer value1, Integer value2) {
            addCriterion("isreceive not between", value1, value2, "isreceive");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNull() {
            addCriterion("updated is null");
            return (Criteria) this;
        }

        public Criteria andUpdatedIsNotNull() {
            addCriterion("updated is not null");
            return (Criteria) this;
        }

        public Criteria andUpdatedEqualTo(Date value) {
            addCriterion("updated =", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotEqualTo(Date value) {
            addCriterion("updated <>", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThan(Date value) {
            addCriterion("updated >", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedGreaterThanOrEqualTo(Date value) {
            addCriterion("updated >=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThan(Date value) {
            addCriterion("updated <", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedLessThanOrEqualTo(Date value) {
            addCriterion("updated <=", value, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedIn(List<Date> values) {
            addCriterion("updated in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotIn(List<Date> values) {
            addCriterion("updated not in", values, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedBetween(Date value1, Date value2) {
            addCriterion("updated between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andUpdatedNotBetween(Date value1, Date value2) {
            addCriterion("updated not between", value1, value2, "updated");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNull() {
            addCriterion("created is null");
            return (Criteria) this;
        }

        public Criteria andCreatedIsNotNull() {
            addCriterion("created is not null");
            return (Criteria) this;
        }

        public Criteria andCreatedEqualTo(Date value) {
            addCriterion("created =", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotEqualTo(Date value) {
            addCriterion("created <>", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThan(Date value) {
            addCriterion("created >", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedGreaterThanOrEqualTo(Date value) {
            addCriterion("created >=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThan(Date value) {
            addCriterion("created <", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedLessThanOrEqualTo(Date value) {
            addCriterion("created <=", value, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedIn(List<Date> values) {
            addCriterion("created in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotIn(List<Date> values) {
            addCriterion("created not in", values, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedBetween(Date value1, Date value2) {
            addCriterion("created between", value1, value2, "created");
            return (Criteria) this;
        }

        public Criteria andCreatedNotBetween(Date value1, Date value2) {
            addCriterion("created not between", value1, value2, "created");
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