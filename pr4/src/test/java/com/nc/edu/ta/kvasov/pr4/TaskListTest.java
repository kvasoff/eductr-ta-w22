package com.nc.edu.ta.kvasov.pr4;

import org.junit.jupiter.api.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;

public abstract class TaskListTest {

    protected AbstractTaskList tasks;
        
    // utility functions --------------------------------------------------

    private static void assertContains(Task[] expected, Task[] actualA) {
        assertEquals(expected.length, actualA.length, "Unexpected size");
        List<Task> actual = new ArrayList<>();
        Collections.addAll(actual, actualA);
        for (Task task : expected) {
            if (actual.contains(task)){
                actual.remove(task);
            }
            else {
                fail("Task " + task + " expected to be in list");
            }
        }
        if (! actual.isEmpty()) {
            fail("Tasks " + actual + " are unexpected in list");
        }
    }

    private void assertContains(Task[] expected) {
        Task[] actual = new Task[tasks.size()];
        for (int i = 0; i < tasks.size(); i++)
            actual[i] = tasks.getTask(i);
        assertContains(expected, actual);
    }

    private static Task task(String title) {
        return new Task(title, 0);
    }
    
    private static Task task(String title, int time, boolean active) {
        Task t = new Task(title, time);
        t.setActive(active);
        return t;
    }

    private static Task task(String title, int from, int to, int interval, boolean active) {
        Task t = new Task(title, from, to, interval);
        t.setActive(active);
        return t;
    }
    
    private void addAll(Task[] ts) {
        for (Task t : ts)
            tasks.add(t);
    }        

    // tests --------------------------------------------------------------

    @Test
    public void testSizeAddGet() {
        assertEquals(0, tasks.size());
        Task[] ts = {task("A"), task("B"), task("C")};
        addAll(ts);
        assertEquals(ts.length, tasks.size());
        assertContains(ts);
    }    
    
    @Test
    public void testWrongAdd() {
        assertThrows(RuntimeException.class, ()->tasks.add(null));
    }
    
    @Test
    public void testInvalidGet() {
        tasks.add(task("Task"));
        Exception e1 = null, e2 = null;
        try {
            tasks.getTask(-1);
            fail("On getTask(-1) exception expected");
        }
        catch (RuntimeException e) {
            e1 = e;
        }
        try {
            tasks.getTask(tasks.size());
            fail("On getTask(size) exception expected");
        }
        catch (RuntimeException e) {
            e2 = e;
        }
        assertEquals(e1.getClass(), e2.getClass(), "Exception of index < 0 and index >= size must be the same");
    }
    
    @Test
    public void testAddManyTasks() {
        Task[] ts = new Task[1000];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new Task("Task#"+ i, i);
            tasks.add(ts[i]);
        }
        assertContains(ts);
    }
}












