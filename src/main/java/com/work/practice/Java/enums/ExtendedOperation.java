package com.work.practice.Java.enums;

/**
 * Created by wangkai43 on 2018/7/4.
 */
public enum ExtendedOperation implements Operation {
    EXP("^"){
        @Override
        public double apply(double x, double y) {
            return Math.pow(x, y);
        }
    },
    PEMAINDER("%"){
        @Override
        public double apply(double x, double y) {
            return x% y;
        }
    };

    private final String symbol;
    ExtendedOperation(String symbol) {
        this.symbol = symbol;
    }

    @Override
    public String toString(){
        return symbol;
    }
}
