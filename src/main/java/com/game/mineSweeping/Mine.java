package com.game.mineSweeping;

import java.util.*;

/**
 * @author wangkai43
 * @create 2017-09-30-17:12
 * @email wangkai43@meituan.com
 */
public class Mine {

    private int width;
    private int booms;
    private int[][] boomMap;//雷区图
    private Point[] boomPos;//记录所有地雷位置
    private int unopenPos;//还未被翻开的位置

    private int[][] boomFace;//展示图

    public Mine(){
        super();
        initMineMap();
        initBooms();
        PrintUtils.printArray(boomFace);
    }

    public Mine(int width, int booms){
        this.width = width;
        this.booms = booms;

        initMineMap();
        initBooms();
        PrintUtils.printArray(boomMap);
        PrintUtils.printArray(boomFace);
    }

    public int[][] getBoomMap() {
        return boomMap;
    }

    public void setBoomMap(int[][] boomMap) {
        this.boomMap = boomMap;
    }

    public Point[] getBoomPos() {
        return boomPos;
    }

    public void setBoomPos(Point[] boomPos) {
        this.boomPos = boomPos;
    }




    private void initMineMap(){
        if(this.width == 0){
            this.width =10;
        }

        this.boomMap = new int[width][width];
        this.boomFace = new int[width][width];
        this.unopenPos=width*width;
    }
    private void initBooms(){
        if(this.booms ==0){
            this.booms = 10;
        }


        int[] x = new int[this.booms];
        int[] y = new int[this.booms];
        this.boomPos = new Point[this.booms];
        generatePos(x,this.width);

        generatePos(y,this.width);

        for(int i=0;i<x.length;i++){
            Point p = new Point();
            p.setX(x[i]);
            p.setY(y[i]);
            boomPos[i] =p;
        }

        for(int i=0;i<this.booms;i++){
            boomMap[x[i]][y[i]] = -1;
        }
//        PrintUtils.printArray(x);
//        PrintUtils.printArray(y);
//        PrintUtils.printLine();
//        PrintUtils.printArray(boomMap);
//
//        PrintUtils.printLine();
        markNums(boomMap);
    //    PrintUtils.printArray(boomMap);

    }

    /**
     * 在 [0,range)范围内生成互不相同的数字填满指定数组
     * @param x
     * @param range
     */
    private void generatePos(int [] x,int range){//得到seedNums个互不相同的位置

        Random random = new Random();
        int[] map = new int[range];
        for(int i=0;i<map.length;i++){
            map[i] = i;
        }

        int nums = x.length;
        int pos=0;
        int count=0;
        while(pos<nums) {
            int tmpPos = random.nextInt(range-pos);
            int tmpVal = map[tmpPos];
            map[tmpPos] = map[range-pos-1];
            map[range-pos-1] = tmpVal;
            pos ++;
            x[count++] = tmpVal;
        }
    }

    private void markNums(int[][] boomMap){
        LinkedList<Integer> contents = new LinkedList<>();

        for(int i=0;i<this.boomPos.length;i++){
            increNum(boomMap,boomPos[i]);
        }
    }

    private void increNum(int[][] boomMap, Point p){

        int x = p.getX();
        int y = p.getY();
        int width = boomMap.length;
        if(boomMap[x][y] == -1){
            //上
            if(x-1 >=0 && x-1 < width && y>=0 && y< width && isNotBoom(boomMap,x-1,y)){
                boomMap[x-1][y] = boomMap[x-1][y] ==0 ? 1: (boomMap[x-1][y]+1);
            }
            //下
            if(x+1 >=0 && x+1 < width && y>=0 && y< width && isNotBoom(boomMap,x+1,y)){
                boomMap[x+1][y] = boomMap[x+1][y] ==0 ? 1: (boomMap[x+1][y]+1);
            }
            //左
            if(x >=0 && x < width && y-1 >=0 && y-1 < width && isNotBoom(boomMap,x,y-1)){
                boomMap[x][y-1] = boomMap[x][y-1] ==0 ? 1: (boomMap[x][y-1]+1);
            }
            //右
            if(x >=0 && x < width && y+1 >=0 && y+1 < width && isNotBoom(boomMap,x,y+1)){
                boomMap[x][y+1] = boomMap[x][y+1] ==0 ? 1: (boomMap[x][y+1]+1);
            }
            //斜上左
            if(x-1 >=0 && x-1 < width && y-1>=0 && y-1 < width && isNotBoom(boomMap, x-1, y-1)){
                boomMap[x-1][y-1] = boomMap[x-1][y-1] ==0 ? 1: (boomMap[x-1][y-1]+1);
            }
            //斜下右
            if(x+1 >=0 && x+1 < width && y+1>=0 && y+1 < width && isNotBoom(boomMap, x+1, y+1)){
                boomMap[x+1][y+1] = boomMap[x+1][y+1] ==0 ? 1: (boomMap[x+1][y+1]+1);
            }
            //斜下左
            if(x+1 >=0 && x+1 < width && y-1>=0 && y-1 < width && isNotBoom(boomMap, x+1, y-1)){
                boomMap[x+1][y-1] = boomMap[x+1][y-1] ==0 ? 1: (boomMap[x+1][y-1]+1);
            }
            //斜上右
            if(x-1 >=0 && x-1 < width && y+1>=0 && y+1 < width && isNotBoom(boomMap, x-1, y+1)){
                boomMap[x-1][y+1] = boomMap[x-1][y+1] ==0 ? 1: (boomMap[x-1][y+1]+1);
            }
        }

    }
    private boolean isNotBoom(int [][]boomMap,int x,int y){

        if(x>=0 && x < boomMap.length && y>=0 && y< boomMap.length) {
            if (boomMap[x][y] != -1) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

    /**
     *
     * @param x
     * @param y
     * @return 0 所有雷都被找到，游戏结束。 -1 踩到地雷，游戏结束。1 继续游戏
     */
    public int turnACard(int x, int y){
        int result =0;
        System.out.println("x="+x+" y="+y);

//        if(lists.isEmpty()){
//            return;
//        }
//        Point tmp = lists.remove();


        if(this.boomMap[x][y] ==0){

            Point p = new Point();
            p.setX(x);
            p.setY(y);

            Queue<Point> lists = new LinkedList<>();
            lists.add(p);

            while (!lists.isEmpty()) {//获取所有地雷数为空的位置

                Point tmp = lists.poll();
                boomFace[tmp.getX()][tmp.getY()] = -9;
                boomMap[tmp.getX()][tmp.getY()] = -9;
                //上
                if (tmp.getX() - 1 >= 0 && tmp.getX() - 1 < this.boomMap.length && tmp.getY() >= 0 && tmp.getY() < this.boomMap.length) {
                    Point tmpP = new Point();
                    tmpP.setX(tmp.getX() - 1);
                    tmpP.setY(tmp.getY());
                    if(this.boomMap[tmpP.getX()][tmpP.getY()] == 0) {
                        lists.add(tmpP);
                    }else {
                        boomFace[tmpP.getX()][tmpP.getY()] = boomMap[tmpP.getX()][tmpP.getY()];
                    }

                }
                //下
                if (tmp.getX() + 1 >= 0 && tmp.getX() + 1 < this.boomMap.length && tmp.getY() >= 0 && tmp.getY() < this.boomMap.length) {
                    Point tmpP = new Point();
                    tmpP.setX(tmp.getX() + 1);
                    tmpP.setY(tmp.getY());
                    if(this.boomMap[tmpP.getX()][tmpP.getY()] == 0) {
                        lists.add(tmpP);
                    }else {
                        boomFace[tmpP.getX()][tmpP.getY()] = boomMap[tmpP.getX()][tmpP.getY()];
                    }

                }
                //左
                if (tmp.getX() >= 0 && tmp.getX() < this.boomMap.length && tmp.getY() - 1 >= 0 && tmp.getY() - 1 < this.boomMap.length) {
                    Point tmpP = new Point();
                    tmpP.setX(tmp.getX());
                    tmpP.setY(tmp.getY() - 1);
                    if(this.boomMap[tmpP.getX()][tmpP.getY()] == 0) {
                        lists.add(tmpP);
                    }else {
                        boomFace[tmpP.getX()][tmpP.getY()] = boomMap[tmpP.getX()][tmpP.getY()];
                    }

                }
                //右
                if (tmp.getX() >= 0 && tmp.getX() < this.boomMap.length && tmp.getY() + 1 >= 0 && tmp.getY() + 1 < this.boomMap.length) {
                    Point tmpP = new Point();
                    tmpP.setX(tmp.getX());
                    tmpP.setY(tmp.getY() +1);
                    if(this.boomMap[tmpP.getX()][tmpP.getY()] == 0) {
                        lists.add(tmpP);
                    }else {
                        boomFace[tmpP.getX()][tmpP.getY()] = boomMap[tmpP.getX()][tmpP.getY()];
                    }

                }

            }

            result=1;
        }else if(this.boomMap[x][y] ==-1){//踩雷，游戏结束
          //  System.out.println("Game Over!");
            boomFace[x][y] = boomMap[x][y];
            result = -1;
        }else {
            boomFace[x][y] = boomMap[x][y];
            result=1;

        }
        unopenPos = countUnopenPos(boomFace);
        if(unopenPos == boomPos.length){//翻完所有雷，胜利
            result = 0;
        }
        PrintUtils.printLine();
        PrintUtils.printArray(boomFace);
        System.out.println("unopenPos= "+unopenPos);
        return result;
    }


    private int countUnopenPos(int[][] boomFace){
        int num = 0;
        for(int i=0;i<boomFace.length;i++){
            for (int j=0;j<boomFace[0].length;j++){
                if(boomFace[i][j] ==0){
                    num++;
                }
            }
        }

        return num;
    }

    public static void main(String[] args) {
        Mine m = new Mine();
        int  isContinue = 0;

        isContinue = m.turnACard(1,2);
        System.out.println("isContinue:"+ isContinue);

 /*       int [] x = new int[6];

        m.generatePos(x, 10);
        for(int i=0;i<x.length;i++){
            System.out.println(x[i]);
        }
*/
      //  m.initBooms();

    }


}
