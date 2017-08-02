package work.wk.mianshi.toutiao;

import java.util.Scanner;

/**
 * 找出函数的最宽尖峰
 时间限制：C/C++语言 2000MS；其他语言 4000MS
 内存限制：C/C++语言 131072KB；其他语言 655360KB
 题目描述：
 按数组的形式给出函数f(x)的取值，即数组A的A[0]元素为f(0)的取值，数组的取值都为整数，函数在每个点都是严格单调递增或者严格递减（即A[i-1] != A[i] != A[i+1]），要求找出最宽的先上升后下降的区间（这个区间内函数的值必须先上升到一个点然后下降，区间的上升段和下降段长度必须都大于0）。
 1. 如果找到符合条件的最大区间输出数组对应的左右下标（有多个最大区间时，输出最左边的那个”）
 2. 找不到那么输出-1 -1
 输入
 n
 n长度的整数数组
 输出
 区间的范围

 样例输入
 10
 1 3 1 2 5 4 3 1 9 10
 样例输出
 2 7

 Hint
 数据规模
 对于 100% 的数据，1 <=n <=10, 000, 000
 * Created by wkhuahuo on 2017/3/30.
 */
public class Main {

   /* public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int in = scanner.nextInt();
        int[] array = new int[in];

        for (int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        int start=-1,end=-1;
        int max=Integer.MIN_VALUE;
        if (in<=2) {
            System.out.print(-1+" ");
            System.out.print(-1);
            return;
        }
        for (int i = 1; i < array.length-1; i++) {
            if (array[i]>array[i-1]) {
                int tempEnd=findend(array,i-1);
                if (tempEnd>i-1 && tempEnd-(i-1)>max) {
                    start=i-1;
                    end=tempEnd;
                    max=tempEnd-start;
                }
                if(tempEnd!=0){
                    i=tempEnd;
                }
            }
        }
        System.out.print(start+" ");
        System.out.print(end);
    }
    public static int findend(int [] array,int start){
        boolean sheng=true;
        int bian=0;
        for (int i = start+1; i < array.length; i++) {
            if (array[i]>array[i-1]) {
                //升
                if(sheng){
                    continue;
                }
                else{
                    if (i-bian>0) {
                        return i-1;
                    }
                    else{
                        return 0;
                    }
                }
            }
            else {
                if(sheng){
                    bian=i;
                    sheng=false;
                }
            }
        }
        return sheng? 0:array.length-1;

    }*/

  public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        int length = in.nextInt();
        int[] arrs = new int[length];
        for(int i=0;i<arrs.length;i++){
            arrs[i] = in.nextInt();
        }

        int maxstart=-1,maxend=-1;
        int newStart =0,newEnd =0;
        boolean sheng = false;
        int change = 0;
        boolean jiang = false;

        if (length<=2) {
            System.out.print(-1+" ");
            System.out.print(-1);
            return;
        }
        for(int i=0;i<arrs.length-1;i++){

            if (arrs[i] < arrs[i + 1]) {
                sheng = true;
                newEnd = i;
                if(jiang && change ==1) {
                    change = 2;
                }
                jiang = false;
            } else {
                jiang = true;
                if(sheng && change ==0){
                    change = 1;
                }else if(!sheng && change != 1 ){
                    newStart = i+1;
                }
                sheng = false;
                newEnd = i+1;
            }
            if(change ==2){
                if(newEnd-newStart > maxend-maxstart){
                    maxstart = newStart;
                    maxend = newEnd;
                    newStart = newEnd;
                    sheng = false;
                    jiang = false;
                    change =0;
                }
            }

        }

        if(jiang||change ==2){
            if(newEnd-newStart > maxend-maxstart){
                maxstart = newStart;
                maxend = newEnd;

            }
        }

        System.out.println(maxstart+" "+maxend);
    }
}
