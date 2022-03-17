package com.nc.edu.ta.kvasov.pr5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

public class CloneListTest extends AbstractTaskListTest {

    @ParameterizedTest
    @MethodSource("params")
    public void testClone(Class <? extends AbstractTaskList> clazz) throws CloneNotSupportedException {
        setUp(clazz);
        Task[] elements = { task("A"), task("B"), task("C") };
        addAll(elements);

        AbstractTaskList clone = tasks.clone();
        
        assertEquals(tasks.size(), clone.size(), getTitle());
        AbstractTaskList ti = tasks;

        for(int i=0; i< ti.size(); i++)
            assertEquals(ti.clone(), clone.clone(), getTitle());

        assertNotSame(tasks, clone, getTitle());
        
        clone.add(task("D"));
        assertEquals(clone.size() - 1, tasks.size(), getTitle());
        
        clone.remove(task("D"));
        assertContains(elements);
    }
}
