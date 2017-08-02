package com.work.practice.mianshi.mianshi360;



import java.text.DecimalFormat;
import java.util.Scanner;

/**
 * Created by wkhuahuo on 2017/3/18.
 */
public class Main1 {
    public static void main(String[] args){

        Scanner s = new Scanner(System.in);
        int Length = s.nextInt();
        int R = s.nextInt();
      //  int Length = 1;
      //  int R = 2;

      /*  double y = R*Math.sin(Length*1.0/R);
        double x = R* Math.cos(Length*1.0/R);
        System.out.printf("%.3f %.3f\n",x,-y);
        System.out.printf("%.3f %.3f\n",x,y);
        */

        double circleL = 2*Math.PI*R;
        double minL = Length%circleL;//转换到一周
        double quarterL = circleL/4;
        double x=0.0;
        double y=0.0;


        int index =0;


        if(minL>=0 && minL<quarterL){
            index =1;
        }else if(minL>=quarterL && minL<2*quarterL){
            index = 2;
           minL = minL-quarterL;

        }else if(minL>=2*quarterL && minL<2*quarterL){
            index = 3;
            minL = minL-2*quarterL;
        }else{
            index = 4;
            minL = minL-3*quarterL;
        }
        if(Math.abs(minL-2*Math.PI*R)<0.0000001){

        }
        double  tmp = Math.pow(Math.sin(minL/(2*R)),2);

        x = R - tmp*2*R;
        y = Math.pow(R*R-x*x,0.5);

        DecimalFormat decimalFormat = new DecimalFormat("##.###");

        if(index == 1){
            System.out.println(decimalFormat.format(x)+" "+decimalFormat.format(-y));
            System.out.println(decimalFormat.format(x)+" "+decimalFormat.format(y));
        }else if(index == 2){
            System.out.println(decimalFormat.format(x)+" "+decimalFormat.format(-y));
            System.out.println(decimalFormat.format(x)+" "+decimalFormat.format(y));
        }else if(index == 3){
            System.out.println(decimalFormat.format(x)+" "+decimalFormat.format(-y));
            System.out.println(decimalFormat.format(x)+" "+decimalFormat.format(y));
        }else{
            System.out.println(decimalFormat.format(x)+" "+decimalFormat.format(-y));
            System.out.println(decimalFormat.format(x)+" "+decimalFormat.format(y));
        }

    }




}
