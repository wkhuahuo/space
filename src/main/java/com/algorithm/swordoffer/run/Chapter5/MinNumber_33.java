package com.algorithm.swordoffer.run.Chapter5;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

/**
 * Created by wkhuahuo on 2017/3/26.
 */
public class MinNumber_33 {

    public String PrintMinNumber(int [] numbers) {
        getposition(numbers,0,numbers.length-1);
        StringBuffer strb = new StringBuffer();
        for(int i=0;i<numbers.length;i++){
            strb.append(numbers[i]);
        }

        return strb.toString();
    }

    private void getposition(int[] arrs,int left, int right){
        if(left>=right){
            return;
        }
        int pos = arrs[left];
        int tl = left;
        int tr = right;

        while(tl<tr){
            int tmp =0;

            while (tl<tr && myCompare(arrs[tr],pos)>0){//先从右向左找到一个小于pos的数
                tr--;
            }
            if(tr>tl){//因为未越界。直接给最左赋值。
                arrs[tl++] = arrs[tr];//赋值之后自增
            }
            while (tl<tr && myCompare(arrs[tl],pos)<0) {//从自增后的位置从左向右寻找第一个大于pos的数
                tl++;
            }
            if(tr>tl){//把这个数赋值给上次的tright位置
                 arrs[tr--] = arrs[tl];
            }
        }
        //寻找到了中间位置

            arrs[tl] = pos;
            getposition(arrs,left,tl-1);
            getposition(arrs,tl+1,right);

    }

    /***
     * 自定义比较函数
     * @param a
     * @param b
     * @return int  >0  :a bigger than b
     *              <0  :a smaller than b
     *              ==0 :a equals to b
     */
    private int myCompare(int a,int b){
       // int atmp = new Integer(a+""+b);//不能用这个方法比较
       // int btmp = new Integer(b+""+a);
        String astr = a+""+b;
        String bstr = b+""+a;

        for(int i=0; i<astr.length();i++){
            if(astr.charAt(i)< bstr.charAt(i)){
                return -1;
            }else if(astr.charAt(i)> bstr.charAt(i)){
                return 1;
            }
        }
        return 0;
      // return atmp-btmp;
    }



    /***
     * 普通解法
     * @param numbers
     * @return
     */
    public String PrintMinNumber1(int [] numbers) {

        if(numbers == null || numbers.length == 0){
            return "";
        }
        ArrayList<Integer> nums = new ArrayList<>();
        for(int i=0;i<numbers.length; i++){
            nums.add(numbers[i]);
        }
        Collections.sort(nums, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {


                return new Integer(o1+""+o2) - new Integer(o2+""+o1);
            }
        });
        StringBuffer strb = new StringBuffer();
        for(int i: nums){
            strb.append(i);
        }

        return strb.toString();
    }

}
