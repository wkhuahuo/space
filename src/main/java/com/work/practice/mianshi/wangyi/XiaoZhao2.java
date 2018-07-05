package com.work.practice.mianshi.wangyi;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-09-09-14:50
 * @email wangkai43@meituan.com
 */
public class XiaoZhao2 {

    public static List<String> result = new ArrayList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String line = in.nextLine();

        int left=0;
        int right = 0;
        for(int i=0; i< line.length();i++){
            if(line.charAt(i) == '('){
                left++;
            }
            if(line.charAt(i) == ')'){
                right++;
            }
        }

        int[] count = new int[1];
        printPar(left,right,line.toCharArray(),count[0]);
       // generate(left,right, line, result);
        String tmpStr = line;
        int length = line.length();

        for(String tmp : result){
            int a = findLCS(tmp,tmp.length(), tmpStr, tmpStr.length());

            length = length> a? a:length;

        }
        System.out.println(length);

    }

    public static void printPar(int l, int r, char[] str, int count){
        if(l<0 || r<l) return;
        if(l==0&&r==0){
         //   System.out.println(str);
            result.add(new String(str));
        }else{
            if(l>0){
                str[count]='(';
                printPar(l-1, r, str, count+1);
            }
            if(r>l){
                str[count]=')';
                printPar(l, r-1, str, count+1);
            }
        }

    }

    public static  int findLCS(String A, int n, String B, int m) {
        // 行对应A，比A长1，原因是0作为初始化。列同理。dp[n][m]指A[n-1],B[m-1]
        int[][] dp = new int[n+1][m+1];
        for(int i=0;i<dp.length;i++){
            dp[i][0]=0;
        }
        for(int i=0;i<dp[0].length;i++){
            dp[0][i]=0;
        }
        //事实上，数组默认也是0
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                //如果是字符串，用equals，由于charAt()是字符，可以运算，故可以用==
                if(A.charAt(i-1)==B.charAt(j-1)){//A[0]==B[0],对应dp[1][1]
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    dp[i][j]=Math.max(dp[i][j-1],dp[i-1][j]);
                }
            }

        }
        System.out.println(dp[n][m]);
        return dp[n][m];
    }
}
