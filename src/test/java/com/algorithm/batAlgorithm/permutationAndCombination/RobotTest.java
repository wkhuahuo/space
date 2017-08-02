package com.wk.batAlgorithm.permutationAndCombination;

import org.junit.Test;

/**
 * Created by wkhuahuo on 18/02/17.
 */
public class RobotTest {
    @Test
    public void countWayTest(){
        Robot robot = new Robot();
        int ways = robot.countWays(6,9);
        System.out.println(ways);
    }
}
