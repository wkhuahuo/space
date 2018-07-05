package com.work.practice.Java.annotation.furitenum;

/**
 * @author wangkai43
 * @create 2018-01-17-21:26
 * @email wangkai43@meituan.com
 */
public class Apple {

    @FruitName("Apple")
    private String appleName;
    @FruitName
    private String defaultName;

    @FruitColor(fruitColor = FruitColor.Color.RED)
    private String appleColor;

    @FruitColor
    private String defaultColor;

    public void displayName(){
        System.out.print(appleName+" "+appleColor+" "+defaultName+" "+defaultColor);
    }

    public String getAppleName() {
        return appleName;
    }

    public void setAppleName(String appleName) {
        this.appleName = appleName;
    }

    public String getDefaultName() {
        return defaultName;
    }

    public void setDefaultName(String defaultName) {
        this.defaultName = defaultName;
    }

    public String getAppleColor() {
        return appleColor;
    }

    public void setAppleColor(String appleColor) {
        this.appleColor = appleColor;
    }

    public String getDefaultColor() {
        return defaultColor;
    }

    public void setDefaultColor(String defaultColor) {
        this.defaultColor = defaultColor;
    }
}
