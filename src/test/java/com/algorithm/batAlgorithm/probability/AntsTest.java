package com.wk.batAlgorithm.probability;

import org.junit.Test;

/**
 * Created by wkhuahuo on 20/02/17.
 */
public class AntsTest {
    @Test
    public void collision(){
        Ants ant = new Ants();
        int[] m = ant.collision(3);
        System.out.println(m[0]+","+m[1]);
    }
}
