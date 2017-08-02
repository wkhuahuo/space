package work.wk.mianshi.mianshi360;

import java.util.Scanner;



/**
 * Created by wkhuahuo on 2017/3/18.
 */
public class Main2 {

    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        sc.close();
        int index=0;
        while(index<num){

            printresult(index);
            index++;
        }
    }
    private static void printresult(int index){
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int[] golds = new int[num];
        for(int i=0;i<num;i++){
            golds[i] = sc.nextInt();
        }
        int sc1 = 0;
        int sc2 = 0;

        for(int i=0;i<num/2;i++){
            if((i&0x1) ==0){
                sc1 += golds[i]>golds[num-1-i]?golds[i]:golds[num-1-i];
                sc2 += golds[i]>golds[num-1-i]?golds[num-1-i]:golds[i];
            }else{
                sc2 += Math.max(golds[i],golds[num-1-i]);
                sc1 += Math.min(golds[i],golds[num-1-i]);
            }
        }
        System.out.println("Case #"+index+1+": "+sc1+" "+sc2);
    }
}
