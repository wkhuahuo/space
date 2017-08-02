package com.algorithm.batAlgorithm.string;

/**
 * Created by wkhua on 16/12/13.
 */
public class Prior {
    public String findSmallest(String[] strs, int n) {

        shellSort(strs,n);
        StringBuffer stringBuffer = new StringBuffer();
        for(String str:strs){
            stringBuffer.append(str);
        }
        return stringBuffer.toString();
    }

    public String[] shellSort(String[] A, int n) {
        int step = n/2;
        while (step>0) {
            for (int i = 0; i <step; i++) {
                for (int j = i + step; j < n; j += step) {
                    for(int k = j-step;k>=i;k-=step){
                        if(compare(A,k,k+step)){
                            swap(A,k,k+step);
                        }else{
                            break;
                        }
                    }

                }
            }
            step/=2;
        }
        return A;
    }

    private void swap(String[] a, int k, int i) {
        String tmp;
        tmp = a[k];
        a[k] = a[i];
        a[i] = tmp;
    }

    private boolean compare(String[] a, int k, int i) {
        String tmpk = a[k]+a[i];
        String tmpi = a[i]+a[k];

        if(tmpk.compareTo(tmpi)>0) {
            return true;//a[k]>a[i]
        }else {
            return false;
        }
    }

}
