package com.algorithm.swordoffer.run.chapter6;

import java.util.ArrayList;

/**
 * 时间限制：1秒 空间限制：32768K 热度指数：6606
 算法知识视频讲解
 题目描述
 小明很喜欢数学,有一天他在做数学作业时,要求计算出9~16的和,他马上就写出了正确答案是100。但是他并不满足于此,他在想究竟有多少种连续的正数序列的和为100(至少包括两个数)。没多久,他就得到另一组连续正数和为100的序列:18,19,20,21,22。现在把问题交给你,你能不能也很快的找出所有和为S的连续正数序列? Good Luck!
 输出描述:
 输出所有和为S的连续正数序列。序列内按照从小至大的顺序，序列间按照开始数字从小到大的顺序
 * Created by wkhuahuo on 2017/3/27.
 */
public class FindContinueSecquence_41 {

    /***
     * 注意的问题：
     *
     * @param sum
     * @return
     */
    public ArrayList<ArrayList<Integer>> FindContinuousSequence(int sum) {
        ArrayList<ArrayList<Integer>> sequenceList = new ArrayList<>();
        if(sum<=0){
            return sequenceList;
        }

        int tmpsum =1;//初始应该是1。tmpsum应该是大于1的
        int begin=1;//
        int end =2;
        while (begin<end && begin<sum/2){//begin应该小于sum。
                                        //或者begin<=sum/2 根据题意因为只有一个序列时不算一个连续序列

            if(tmpsum < sum){
                tmpsum +=end;
                end++;
            }else if(tmpsum >sum){
                tmpsum -=begin;
                begin++;

            }else {
                ArrayList<Integer> sequence = new ArrayList<>();
                //1.sequence声明位置的问题。因为每一个序列都应该向新的sequence中添加。//每次使用完应该清空
                for(int i=begin;i<end;i++){
                    sequence.add(i);
                }
                sequenceList.add(sequence);
                tmpsum -=begin;//存储完以后应该让begin增1
                begin++;
            }
        }
        return sequenceList;
    }
}
