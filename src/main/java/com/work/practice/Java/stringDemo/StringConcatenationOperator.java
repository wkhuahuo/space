package com.work.practice.Java.stringDemo;

/**
 * @author wangkai43
 * @create 2018-07-31-11:06
 * @email wangkai43@meituan.com
 */
public class StringConcatenationOperator {

    public static void main(String[] args) {
        StringConcatenationOperator stringConcatenationOperator = new StringConcatenationOperator();
        //long start = System.nanoTime();
        long start = System.currentTimeMillis();
        String str = stringConcatenationOperator.statementString();
        //long dur = System.nanoTime() - start;
        long dur = System.currentTimeMillis() - start;
        System.out.println("String= "+dur);
        //System.out.println(str);

        //start = System.nanoTime();
        start = System.currentTimeMillis();
        String strB = stringConcatenationOperator.statementStringBuilder();
        //dur = System.nanoTime() - start;
        dur = System.currentTimeMillis() - start;
        System.out.println("StringBuilder= "+dur);
       // System.out.println(strB);

    }


    public static int LINE_WIDTH = 8;
    public String statementString() {
        String result = "";
        for(int i=0; i< numItems(); i++){
            result += lineForItem(i);
        }

        return result;
    }

    private String lineForItem(int i) {
        return "wkhuahuowkhuahuowkhuahuowkhuahuowkhuahuowkhuahuowkhuahuowkhuahuowkhuahuowkhuahuo";
    }

    public String statementStringBuilder() {
        StringBuilder b = new StringBuilder(numItems() * LINE_WIDTH);
      //  StringBuilder b = new StringBuilder();
        for(int i=0; i< numItems(); i++){
            b.append(lineForItem(i));
        }

        return b.toString();
    }

    private int numItems() {
        return 10000;
    }
}
