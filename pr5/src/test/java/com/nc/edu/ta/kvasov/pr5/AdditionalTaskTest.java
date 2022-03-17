package com.nc.edu.ta.kvasov.pr5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class AdditionalTaskTest extends AbstractTaskListTest {

    // tests --------------------------------------------------------------
    /* Test for: getTask method is removed */
    @ParameterizedTest
    @MethodSource("params")
    public void  testTaskListHasNoGetTaskMethod(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        assertThrows(NoSuchMethodException.class, () -> tasks.getClass().getMethod("getTask", new Class[]{int.class}));
    }

}

