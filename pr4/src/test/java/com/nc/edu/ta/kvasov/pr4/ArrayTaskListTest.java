package com.nc.edu.ta.kvasov.pr4;

import org.junit.jupiter.api.BeforeEach;

public class ArrayTaskListTest extends TaskListTest {
    @BeforeEach
    public void createTaskList() {
        tasks = new ArrayTaskList();
    }
}


