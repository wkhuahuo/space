package com.wk.batAlgorithm.string;

import junit.framework.Assert;
import org.junit.Test;

/**
 * Created by wkhua on 16/12/13.
 */
public class ParenthesisTest {
    @Test
    public void chkParenthesis(){
        String parenthesis = "()()(((())))";
        Parenthesis parenth = new Parenthesis();
        boolean b = parenth.chkParenthesis(parenthesis,parenthesis.length());
        Assert.assertTrue(b);
    }
}
