package com.nc.edu.ta.kvasov.pr4;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class TaskTest {

    @BeforeAll
    public static void testDescription() {
        System.out.println("--- description test ---");
        Task task = new Task("Inactive repeated", 10, 100, 5);
        System.out.println(task);
        task = new Task("Active one-time", 50);
        task.setActive(true);
        System.out.println(task);
        System.out.println("------------------------");
    }

    @Test
    public void testTitle() {
        Task task = new Task("test", 0);
        assertEquals("test", task.getTitle());
        task.setTitle("other");
        assertEquals("other", task.getTitle());
    }
    
    @Test
    public void testWrongTitle() {
        assertThrows(RuntimeException.class, ()-> new Task(null, 0));
    }        

    @Test
    public void testWrongTitle2() {
        assertThrows(RuntimeException.class, ()-> (new Task("OK", 0)).setTitle(null));
    }  

	@Test
    public void testWrongTitle3() {
        assertThrows(RuntimeException.class, ()-> new Task("", 0));
    }  	
	
	@Test
    public void testWrongTitle4() {
        assertThrows(RuntimeException.class, ()-> {
            Task task = new Task("OK", 0);
            task.setTitle("");
        });
    }	
    
    @Test
    public void testActive() {
        Task task = new Task("test", 0);
        assertFalse(task.isActive());
        task.setActive(true);
        assertTrue(task.isActive());
    }
    @Test
    public void testConstructorNonrepeated() {
        Task task = new Task("test", 10);
        assertFalse( task.isActive(), "active");
        assertEquals( 10, task.getTime(),"time");
        assertEquals( 10, task.getStartTime(),"start");
        assertEquals( 10, task.getEndTime(),"end");
        assertFalse( task.isRepeated(),"repeated");
		assertEquals( 0, task.getRepeatInterval(),"repeatInterval");
    }
    @Test
    public void testConstructorRepeated() {
        Task task = new Task("test", 10, 100, 5);
        assertFalse(task.isActive(), "active");
        assertEquals( 10, task.getTime(), "time");
        assertEquals( 10, task.getStartTime(), "start");
        assertEquals( 100, task.getEndTime(), "end");
        assertTrue( task.isRepeated(), "repeated");
        assertEquals( 5, task.getRepeatInterval(), "repeatInterval");
    }
    @Test
    public void testTimeNonRepeated() {
        Task task = new Task("test", 0, 100, 15);
        task.setTime(50);
        assertEquals( 50, task.getTime(), "time");
        assertEquals( 50, task.getStartTime(), "start");
        assertEquals( 50, task.getEndTime(), "end");
        assertFalse( task.isRepeated(), "repeated");
		assertEquals( 0, task.getRepeatInterval(), "repeatInterval");
    }
    @Test
    public void testTimeRepeated() {
        Task task = new Task("test", 10);
        task.setTime(5, 20, 1);
        assertEquals( 5, task.getTime(), "time");
        assertEquals( 5, task.getStartTime(), "start");
        assertEquals( 20, task.getEndTime(), "end");
        assertTrue( task.isRepeated(), "repeated");
        assertEquals( 1, task.getRepeatInterval(), "repeatInterval");
    }
    
    @Test
    public void testWrongTime() {
        assertThrows(RuntimeException.class, ()->  new Task("Title", -1));
    }

    @Test()
    public void testWrongStart() {
        assertThrows(RuntimeException.class, ()-> new Task("Title", -1, 10, 5));
    }

    @Test
    public void testWrongEnd() {
        assertThrows(RuntimeException.class, ()-> new Task("Title", 10, 6, 3));
    }

    @Test
    public void testWrongInterval() {
        assertThrows(RuntimeException.class, ()->  new Task("Title", 10, 100, -1));
    }

    @Test
    public void testWrongSetTime() {
        assertThrows(RuntimeException.class, ()-> {
            Task task = new Task("Title", 0);
            task.setTime(-1);
        });
    }

    @Test
    public void testWrongSetStart() {
        assertThrows(RuntimeException.class, ()-> {
            Task task = new Task("Title", 0);
            task.setTime(-1, 10, 3);
        });
    }

}










