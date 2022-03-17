package com.nc.edu.ta.kvasov.pr5;

import org.junit.jupiter.api.AfterEach;

import java.util.*;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

public abstract class AbstractTaskListTest {

    protected AbstractTaskList tasks;

    private Class<? extends AbstractTaskList> tasksClass;

    public static Stream<Class<? extends AbstractTaskList>> params() {
       return Stream.of(ArrayTaskList.class, LinkedTaskList.class);
   }

    protected static Task task(String title) {
        return new Task(title, 0);
    }

    @SuppressWarnings("unused")
    protected static Task task(String title, int time, boolean active) {
        Task t = new Task(title, time);
        t.setActive(active);
        return t;
    }

    @SuppressWarnings("unused")
    protected static Task task(String title, int from, int to, int interval, boolean active) {
        Task t = new Task(title, from, to, interval);
        t.setActive(active);
        return t;
    }

    // utility functions --------------------------------------------------
    @AfterEach
    public void cleanUp(){
        this.tasksClass = null;
        this.tasks = null;
    }

    public void setUp(Class<? extends AbstractTaskList> tasksClass){
        this.tasksClass = tasksClass;
        tasks = createList();
    }

    public AbstractTaskList createList(){
        if (tasksClass == null){
            throw new RuntimeException("This test must be parametrized");
        }
        try {
            return tasksClass.getDeclaredConstructor().newInstance();
        } catch (Exception e) {
            throw new RuntimeException("Fail to create class instance", e);
        }
    }

    protected String getTitle() {
        return tasksClass.getSimpleName();
    }

    protected void assertContains(Task[] expected, Task[] actualA) {
        assertEquals(expected.length, actualA.length, getTitle() + ": Unexpected size");

        List<Task> actual = new ArrayList<>();
        Collections.addAll(actual, actualA);

        for (Task task : expected)
            if (actual.contains(task))
                actual.remove(task);
            else
                fail(getTitle() + ": Task " + task + " expected to be in list");

        if (!actual.isEmpty())
            fail(getTitle() + ": Tasks " + actual + " are unexpected in list");
    }

    protected void assertContains(Task[] expected) {
        Task[] actual = new Task[tasks.size()];
        int i = 0;
        //noinspection ConstantConditions
        if (tasks instanceof Iterable){
            for (Task task : tasks) {
                actual[i++] = task;
            }
        } else{
            try {
                //noinspection ConstantConditions
                tasks.getClass().getMethod("getTask", int.class);
                for (int j = 0; j < tasks.size(); j++)
                    actual[i++] = tasks.getTask(j);
            } catch (NoSuchMethodException ex) {
                fail("TaskList has no getTask method ( additional task) but iterator does not implemented");
            }
        }
        assertContains(expected, actual);
    }

    protected void addAll(Task[] ts) {
        for (Task t : ts)
            tasks.add(t);
    }
}
