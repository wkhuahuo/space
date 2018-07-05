package com.work.practice.mianshi.jingdong;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.Stack;

/**
 * @author wangkai43
 * @create 2017-09-08-20:41
 * @email wangkai43@meituan.com
 */
public class JingDong2 {

    public static Map<String,Integer> tmpMap = new HashMap<>();

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        String str= in.nextLine();
        StringBuffer strBuffer = new StringBuffer();
        for(int i=0;i<str.length();i++){
            if(str.charAt(i)=='(')
                strBuffer.append('(');
            if(str.charAt(i)==')')
                strBuffer.append(')');
        }


        int result = getSum(strBuffer.toString());
        System.out.println(result);
    }

    public static int getSum(String str){
        if( str.charAt(0) !='(' )
            return 0;
        String nStr = str.substring(1);
        int sum = 0;
        for(int i=0;i<nStr.length();i++){

            if(nStr.charAt(i)==')'){
                String tmp = nStr.length()==i+1 ?
                        nStr.substring(0,i):
                        (nStr.substring(0,i)+nStr.substring(i+1));
                if("".equals(tmp)) {
                    sum += 1;
                }else if(tmpMap.get(tmp)!=null) {
                    sum += tmpMap.get(tmp);
                }else if(isDone(tmp)){
                    int n =  getSum(tmp);
                    tmpMap.put(tmp, n);
                    sum += n;
                }
            }
        }
        return sum;
    }
    public static boolean isDone(String str){

        Stack<String> left=new Stack<>();

        while (!str.isEmpty()){

            String cha=str.substring(0,1);
            str=str.substring(1);
            if( cha.equals("(") || cha.equals("[")|| cha.equals("{")){//左压入
                left.push(cha);

            }else if( cha.equals(")")|| cha.equals("]")|| cha.equals("}")){//右弹出

                if(left.isEmpty())
                    return false;

                String leftCha=left.pop();
                if( cha.equals(")")){
                    if(!leftCha.equals("(")) {
                        return false;
                    }
                }else if( cha.equals("]")){
                    if(!leftCha.equals("[")) {
                        return false;
                    }
                }else if( cha.equals("}")){

                    if(!leftCha.equals("{")) {
                        return false;
                    }
                }
            }
        }
        return left.isEmpty();
    }
}