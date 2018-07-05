package com.work.practice.mianshi.airbnb;

/**
 * @author wangkai43
 * @create 2017-09-28-20:32
 * @email wangkai43@meituan.com
 */

/**
 *
 */
public class Airbnb2 {

    public static void main(String[] args) {

    }

    /*
     * Complete the function below.
     */
    static int minMoves(int[][] maze, int x, int y) {

        if(maze[0][1] == 1 && maze[1][0] == 1){
            return -1;
        }

        int[][] map = new int[maze.length][maze[0].length];
        for(int i=0;i<map[0].length; i++){
            for(int j=0;j<map.length;j++){

            }
        }
        int xL = map.length;
        int yL = map[0].length;
        int i=0;
        int j=0;
        map[0][0] = 0;
        while (i<xL-1 && j<yL-1){
            while(j<yL-1){//向右走
                if(maze[i][j+1] !=1 && maze[i][j+1] !=-1 ){
                    map[i][j+1] ++;
                }else {
                    while(j<yL-1){
                        map[i][j+1] =-1;
                    }
                }
            }
            while(i<xL-1){//向下走
                if(maze[i+1][j] !=1 && maze[i+1][j] !=-1 ){
                    map[i+1][j] ++;
                }else{
                    while(i<xL-1){
                        map[i+1][j] = -1;
                    }
                }
            }
        }


        return map[x][y];
    }


}
