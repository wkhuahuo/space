package com.algorithm.batAlgorithm.sort.practice;

import java.util.Arrays;

/**
 * Created by wkhua on 16/11/15.
 */
public class RepeatChecker {

    public boolean checkDuplicate(int[] a, int n) {
        // write code here
        System.out.println(Arrays.toString(a ));
       minheapSort(a,a.length );
        System.out.println(Arrays.toString(a ));

        for(int i=0;i<a.length-1;i++){
            if(a[i]==a[i+1]){
                return true;
            }
        }

        return false;
    }

    public int[] minheapSort(int[] A, int n) {
        int tail_i=n-1;
        if(A==null||A.length==0){
            return A;
        }
        for(int i=0;i<n;i++){
            minAdjust(0, i, A);
        }
        for(tail_i=n-1;tail_i>=0;){
            swap(0,tail_i,A);
            tail_i--;
            minAdjust(0, tail_i, A);
        }
        return A;
    }

    public int[] minAdjust(int top_i, int tail_i, int[] A){
        int tmpTail_i=tail_i;
        if(tail_i<=2*top_i){
            return A;
        }
        while(tmpTail_i>0){
            int lChild = tail_i;
            int rChild = lChild;
            int smallerChild =lChild;

            if(tmpTail_i%2==0  ){
                lChild = tmpTail_i-1;
                rChild = tmpTail_i;
                if(asmallerb(A[lChild],A[rChild])){
                    smallerChild = lChild;
                }else {
                    smallerChild = rChild;
                }


            }else if(tmpTail_i+1<=tail_i){
                lChild = tmpTail_i;
                rChild = tmpTail_i+1;
                if(asmallerb(A[lChild],A[rChild])){
                    smallerChild = lChild;
                }else{
                    smallerChild = rChild;
                }
            }else {
                lChild = tmpTail_i;
                smallerChild = lChild;
            }

            tmpTail_i = (tmpTail_i-1)/2;//更新尾节点

            if( A[tmpTail_i]>A[smallerChild]){
                swap(tmpTail_i, smallerChild, A);
                tmpTail_i = smallerChild;
            }
        }

        return A;
    }
    public boolean abiggerb(int a, int b){
        return a>b? true: false;
    }

    public boolean asmallerb(int a, int b){
        return a<b? true: false;
    }

    public void swap(int top, int tail, int[] A){
        int tmp= A[top];
        A[top] = A[tail];
        A[tail] = tmp;
    }




    public boolean findDuplicate(int[] a, int n) {
        // write code here
        for(int i=0;i<n;i++){
            if(a[i]>0){//还未标记
                if(a[a[i]]<0){
                    return true;
                }else{
                    a[a[i]] = -a[a[i]];
                }

            }else{//标记过了
                if(a[-a[i]]>0){//查看标记过的地方指示的地方是否标记过
                    a[-a[i]] = -a[-a[i]];//
                }else{
                    return true;//标记过，说明存在
                }
            }
        }

        return false;
    }

}
