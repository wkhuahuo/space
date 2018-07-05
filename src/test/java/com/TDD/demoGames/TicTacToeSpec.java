package com.TDD.demoGames;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author wangkai43
 * @create 2018-06-06-23:56
 * @email wangkai43@meituan.com
 */
public class TicTacToeSpec {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();
    private TicTacToe ticTacToe;

    @Before
    public final void before() {
        ticTacToe = new TicTacToe();
    }

    @Test
    public void whenXOutsideBoardThenRuntimeException() {
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(5,2);
    }

    @Test
    public void whenYOutsideBoardThenRuntimeException() {
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(2,5);
    }

    @Test
    public void whenOccupiedThenRuntimeException() {
        ticTacToe.play(2, 1);
        expectedException.expect(RuntimeException.class);
        ticTacToe.play(2, 1);
    }
}
