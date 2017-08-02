package com.algorithm.swordoffer.run.Chapter5;

/**
 * Created by wkhuahuo on 2017/3/27.
 */
public class InversePairsNum_36 {
    public int InversePairs(int [] array) {
        int num = 0;
        num =mergeSort(array,0,array.length-1);

    //    System.out.println(Arrays.toString(array));
        return num;
    }
    private int mergeSort(int[] array,int begin,int end){
        int num=0;
        if(begin >=end)
            return num;
        int mid = begin+(end-begin)/2;
        num+=mergeSort(array,begin,mid);
        num %=1000000007;
        num+=mergeSort(array,mid+1,end);
        num %=1000000007;
        num+=connect(array,begin,mid,end);
        num %=1000000007;
        return num;
    }
    private int connect(int[]array,int begin,int mid,int end){
        int num=0;
        int rmid = mid+1;
        int bi = begin;
        int ei = end;
        int pe = ei;
        int pm = mid;

        int[] tmparr = new int[end-begin+1];
        int index=tmparr.length-1;
        while (pm>=begin && pe>=rmid){
            if(array[pm]<=array[pe]) {
                tmparr[index--] =array[pe--];
            }else {
                num+=pe-rmid+1;
                num %=1000000007;
                tmparr[index--] = array[pm--];
            }
        }
        while (pe >= rmid){
            tmparr[index--] = array[pe--];
        }
        while (pm >= begin){
            tmparr[index--] = array[pm--];
        }
        bi = begin;
        for(int i=0;i<tmparr.length;i++){
            array[bi++] = tmparr[i];
        }
        return num;
    }
}
