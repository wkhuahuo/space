package com.work.practice.hiveDataAnalise;

/**
 * Created by wangkai43 on 2018/1/19.
 */
public enum CardTypeEnum {

    CC("CC"),
    DC("DC")
    ;
    private String name;
    CardTypeEnum(String name){
        this.name = name;
    }
}
