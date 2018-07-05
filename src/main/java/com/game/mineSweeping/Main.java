package com.game.mineSweeping;

import java.util.Scanner;

/**
 * @author wangkai43
 * @create 2017-09-30-17:11
 * @email wangkai43@meituan.com
 */
public class Main {

    public static void main(String[] args) {
        System.out.println();
        Mine m = null;

        if(args.length == 2 ){
            int width = Integer.valueOf(args[0]);
            int booms = Integer.valueOf(args[1]);
            if(width*width>booms){
                m = new Mine(width, booms);
            }else {
                m = new Mine();
            }
        }else {
            m = new Mine();
        }

        int isContinue = 0;

        while(true) {
            Scanner in = new Scanner(System.in);
            int x = in.nextInt();
            int y = in.nextInt();
            isContinue = m.turnACard(x,y);
            if(isContinue == 0){//游戏结束
                System.out.println("Success Congratulation!");
                break;
            }
            if(isContinue == 1){//游戏继续
                System.out.println("Can next!");
            }
            if(isContinue == -1){
                System.out.println("GameOver");
                break;
            }

        }

    }
}
