package com.work.practice.hiveDataAnalise;

/**
 * @author wangkai43
 * @create 2018-01-19-21:30
 * @email wangkai43@meituan.com
 */
public class Line {
    private String bankName;
    private String CardNo;
    private Integer nums;
    private String Type;//CC、DC

    public String getBankName() {
        return bankName;
    }

    public void setBankName(String bankName) {
        this.bankName = bankName;
    }

    public String getCardNo() {
        return CardNo;
    }

    public void setCardNo(String cardNo) {
        CardNo = cardNo;
    }

    public Integer getNums() {
        return nums;
    }

    public void setNums(Integer nums) {
        this.nums = nums;
    }

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }
}
