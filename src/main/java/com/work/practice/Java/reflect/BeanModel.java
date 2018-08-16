package com.work.practice.Java.reflect;

import java.util.List;

/**
 * @author wangkai43
 * @create 2018-08-16-12:51
 * @email wangkai43@meituan.com
 */
public class BeanModel {

    private String news;
    /**
     * 银行英文缩写如BOJS
     */
    private String bankCode;
    /**
     * 银行对应的partnerId唯一标识ID
     */
    private String partnerId;
    /**
     * 银行当前是否上线
     */
    private Integer status;
    /**
     * 用户白名单
     */
    private List<Long> userList;
    /**
     * 城市白名单
     */
    private List<Integer> cityList;
    /**
     * app白名单如group、waimai
     */
    private List<String> appList;
    /**
     *
     */
    private List<String> entryList;
    /**
     * 流量分配权重
     */
    private Integer weight;
    /**
     * 故障起始时间
     * 格式为：yyyMMdd HHmmss
     */
    private String downStart;
    /**
     * 故障结束时间
     * 格式为：yyyMMdd HHmmss
     */
    private String downEnd;
    /**
     * 健康条件判断： 0不可用；1:健康；2:试探期
     */
    private Integer healthCondition;

    public String getBankCode() {
        return bankCode;
    }

    public void setBankCode(String bankCode) {
        this.bankCode = bankCode;
    }

    public String getPartnerId() {
        return partnerId;
    }

    public void setPartnerId(String partnerId) {
        this.partnerId = partnerId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public List<Long> getUserList() {
        return userList;
    }

    public void setUserList(List<Long> userList) {
        this.userList = userList;
    }

    public List<Integer> getCityList() {
        return cityList;
    }

    public void setCityList(List<Integer> cityList) {
        this.cityList = cityList;
    }

    public List<String> getAppList() {
        return appList;
    }

    public void setAppList(List<String> appList) {
        this.appList = appList;
    }

    public List<String> getEntryList() {
        return entryList;
    }

    public void setEntryList(List<String> entryList) {
        this.entryList = entryList;
    }

    public Integer getWeight() {
        return weight;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public String getDownStart() {
        return downStart;
    }

    public void setDownStart(String downStart) {
        this.downStart = downStart;
    }

    public String getDownEnd() {
        return downEnd;
    }

    public void setDownEnd(String downEnd) {
        this.downEnd = downEnd;
    }

    public Integer getHealthCondition() {
        return healthCondition;
    }

    public void setHealthCondition(Integer healthCondition) {
        this.healthCondition = healthCondition;
    }

    @Override
    public String toString() {
        return "BeanModel{" +
                "bankCode='" + bankCode + '\'' +
                ", partnerId='" + partnerId + '\'' +
                ", status=" + status +
                ", userList=" + userList +
                ", cityList=" + cityList +
                ", appList=" + appList +
                ", entryList=" + entryList +
                ", weight=" + weight +
                ", downStart='" + downStart + '\'' +
                ", downEnd='" + downEnd + '\'' +
                ", healthCondition=" + healthCondition +
                '}';
    }
}
