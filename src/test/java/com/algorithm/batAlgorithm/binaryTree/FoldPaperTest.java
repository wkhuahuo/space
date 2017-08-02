package com.wk.batAlgorithm.binaryTree;

import org.junit.Test;

import java.util.Arrays;

/**
 * Created by wkhuahuo on 14/02/17.
 */
public class FoldPaperTest {
    @Test
    public void foldPaperTest(){
        FoldPaper fold = new FoldPaper();
        String[] strs = fold.foldPaper(5);
        String str = Arrays.toString(strs);
        System.out.println(str);
        System.out.println(strs.length);
    }
}
