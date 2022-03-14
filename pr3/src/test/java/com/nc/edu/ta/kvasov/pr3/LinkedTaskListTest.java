package com.nc.edu.ta.kvasov.pr3;

import org.junit.jupiter.api.BeforeEach;

public class LinkedTaskListTest extends TaskListTest {

    @BeforeEach
    public void before()
    {
        tasks = new LinkedTaskList();
    }
}
