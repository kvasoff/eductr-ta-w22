package com.nc.edu.ta.kvasov.pr5;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class EqualsTaskTest {

    @Test
    public void testEqualsToItself() {
        Task task1 = new Task("Some", 10);
        assertEquals( task1, task1, "Task must be equals to itself");
    }

    @Test
    public void testEquals() {
        Task task1 = new Task("Some", 10);
        Task task2 = new Task("Some", 10);
        assertEquals(task1, task2, "Tasks, created with same constructor must be equals");
        assertEquals(task2, task1, "a = b <=> b = a");
    }

    @Test
    public void testEqualsActivity() {
        Task task1 = new Task("Some", 10);
        Task task2 = new Task("Some", 10);
        task2.setActive(true);
        assertNotEquals(task1, task2, "Active task couldn't equal to inactive");
    }

    @Test
    public void testEqualsChanged() {
        Task task1 = new Task("Some", 100);
        Task task2 = new Task("Some", 18);
        task1.setTime(0, 50, 3);
        task2.setTime(0, 50, 3);
        assertEquals(task1, task2, "Tasks with same state must equal");
    }

    @Test
    public void testEqualsNull() {
        Task task1 = new Task("Some", 10);
        assertNotEquals(task1, null, "any.equals(null) must be false");
    }

    @Test
    public void testEqualsToString() {
        Task task1 = new Task("Some", 10);
        //noinspection AssertBetweenInconvertibleTypes
        assertNotEquals(task1, "some string", "Task can be equal only to task");
    }

    @Test
    public void testEqualsSymmetry() {
        Task egoist = new EgoistTask("Title", 10);
        Task simple = new Task("Title", 10);
        assertEquals(egoist.equals(simple), simple.equals(egoist), "equals must be symmetric");
    }

    @Test
    public void testHashCode() {
        Task task1 = new Task("Some", 100);
        task1.setTime(0, 12, 3);
        task1.setActive(true);
        Task task2 = new Task("Some", 18);
        task2.setTime(0, 12, 3);
        task2.setActive(true);
        
        assertEquals(task1.hashCode(), task2.hashCode());
    }
}

class EgoistTask extends Task {
    public EgoistTask(String title, int time) {
        super(title, time);
    }
    public boolean equals(Object obj) {
        return false;
    }
}












