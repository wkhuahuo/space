package com.TDD.demoGames;

/**
 * @author wangkai43
 * @create 2018-06-06-23:55
 * @email wangkai43@meituan.com
 */
public class TicTacToe {

    private char[][] board = {
            {'\0','\0','\0'},
            {'\0','\0','\0'},
            {'\0','\0','\0'}
    };

    public void play(int x, int y) {
        checkAxis(x);
        checkAxis(y);
        setBox(x,y);
    }

    public void checkAxis(int axis){
        if(axis < 1 || axis > 3){
            throw new RuntimeException("it is outside board");
        }
    }

    public void setBox (int x, int y) {
        if (board[x-1][y-1] == '\0'){
            board[x-1][y-1] = 'X';
        } else {
            throw new RuntimeException("Box is occupied");
        }
    }
}
