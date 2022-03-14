package com.nc.edu.ta.kvasov.pr4;

import org.junit.jupiter.api.BeforeEach;

public class LinkedTaskListTest extends TaskListTest {
    @BeforeEach
    public void createTaskList() {
        tasks = new LinkedTaskList();
    }
}

