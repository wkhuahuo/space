package com.wk.batAlgorithm.string;

import org.junit.Test;

/**
 * Created by wkhua on 16/12/13.
 */
public class PriorTest {
    @Test
    public void findSmallest(){
        String[] strings = {"kid","yqt","i","k"};//["kid","yqt","i","k"],4 "ikidkyqt"
        Prior prior = new Prior();
        String result = prior.findSmallest(strings,strings.length);
        System.out.println(result);
    }
}
