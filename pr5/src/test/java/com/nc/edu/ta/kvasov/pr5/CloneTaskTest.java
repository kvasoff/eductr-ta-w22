package com.nc.edu.ta.kvasov.pr5;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class CloneTaskTest {

    @Test
    public void testClone(){
        Task task = new Task("Title", 10);
        Task clone = task.clone();
        assertEquals(task, clone, "Clone must equal original");
        assertNotSame(task, clone, "Clone must be different object");
        clone.setTitle("Clone");
        assertEquals("Title", task.getTitle());
        assertEquals("Clone", clone.getTitle());
        //noinspection SimplifiableAssertion
        assertFalse(task == clone, "Must be same value, but outer object");
        //noinspection StringEquality,SimplifiableAssertion
        assertFalse(task.getTitle() == clone.getTitle(), "Must be same value, but outer object");
    }

    @Test
    public void testRealClone(){
        Task task = new Task("Title", 10);
        Task clone = task.clone();
        assertEquals( task, clone, "Clone must equal original");
        assertNotSame(task, clone, "Clone must be different object");
        clone.setTitle("Clone");
        assertEquals("Title", task.getTitle());
        assertEquals("Clone", clone.getTitle());
    }
}










