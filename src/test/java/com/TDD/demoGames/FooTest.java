package com.TDD.demoGames;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

/**
 * @author wangkai43
 * @create 2018-06-06-23:45
 * @email wangkai43@meituan.com
 */
public class FooTest {

    Foo foo;
    @Rule
    public ExpectedException exceptedException = ExpectedException.none();

    @Before
    public void before(){
        foo = new Foo();
    }

    @Test
    public void whenDoFooThenThrowRuntimeException(){

        exceptedException.expect(RuntimeException.class);
        foo.doFoo();
    }


}
