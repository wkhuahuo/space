package com.algorithm.batAlgorithm.stackAndSequence.practice;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by wkhua on 16/12/15.
 */
public class TwoStackSort {
    public ArrayList<Integer> twoStacksSort(int[] numbers) {
        Stack<Integer> help = new Stack<>();

        int index =0;
        while(index < numbers.length){
            int tmp = numbers[index];
            index++;
            if(help.isEmpty() || tmp<=help.peek()){
                while(help.isEmpty() || tmp<=help.peek()) {
                    help.push(tmp);
                    break;
                }
            }else {
                while (!help.isEmpty() && tmp > help.peek()) {
                    index--;
                    numbers[index] = help.pop();

                }
                index--;
                numbers[index] = tmp;
            }

        }
        while(!help.isEmpty()){
            index--;
            numbers[index] =help.pop();
        }
        ArrayList<Integer> arrayList = new ArrayList<>();
        for(int num:numbers) {
            arrayList.add(num);
        }
        return arrayList;

    }

}
