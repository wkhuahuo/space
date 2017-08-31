package com.work.practice.mianshi.toutiao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-08-22-19:42
 * @email wangkai43@meituan.com
 * 输入
第一行输入点集的个数 N， 接下来 N 行，每行两个数字代表点的 X 轴和 Y 轴。
输出
输出“最大的” 点集合， 按照 X 轴从小到大的方式输出，每行两个数字分别代表点的 X 轴和 Y轴。

样例输入
5
1 2
5 3
4 6
7 5
9 0
样例输出
输出结果按照 x 轴排序，如上例输出为：
4 6
7 5
9 0

Hint
对于 50%的数据,  1 <= n <= 10000;
对于 100%的数据, 1 <= n <= 500000;
 */
public class OneMain {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        Point[] p = new Point[num];
        int[][] map = new int[num][2];
        HashMap<Integer,Integer> maps = new HashMap<>();
        int maxX =0;

        int i=0;
        while (i<num){
            map[i][0] = sc.nextInt();
            maxX = maxX>map[i][0] ? maxX : map[i][0];
            map[i][1] = sc.nextInt();
            maps.put(map[i][0],map[i][1]);
            p[i].x = map[i][0];
            p[i].y = map[i][1];
            i++;
        }

        boolean[] nums = new boolean[maxX];

        for(int nu=0;nu<p.length;nu++){
            nums[p[nu].x] = true;
            maps.put(p[nu].x,p[nu].y);
        }

        int my = -1;
        for(int j=nums.length-1;j>=0;j--){
            if(nums[j]) {
                if (maps.get(j) > my) {
                   // System.out.println(j + " " + maps.get(j));
                    my =maps.get(j);

                }else{
                    nums[j] = false;
                }
            }
        }
        for(int j=0; j<nums.length; j++){
            if(nums[j]){
                System.out.println(j + " " + maps.get(j));
            }
        }


    }

}
class Point implements Comparable<Point>{
    public  int x;
    public  int y;

    @Override
    public String toString() {
        return "Point{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


    @Override
    public int compareTo(Point p) {

        return (p.x==this.x) ? (this.y - p.y) :( this.x - p.x);
    }
}