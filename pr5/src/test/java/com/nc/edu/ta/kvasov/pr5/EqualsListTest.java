package com.nc.edu.ta.kvasov.pr5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.*;

import static org.junit.jupiter.api.Assertions.*;


public class EqualsListTest extends AbstractTaskListTest {

    @ParameterizedTest
    @MethodSource("params")
    public void testEquals(Class <? extends AbstractTaskList> clazz) {
        setUp(clazz);
        Task[] elements = {task("A"), task("B"), task("C")};

        AbstractTaskList list1 = createList();
        AbstractTaskList list2 = createList();
        for (Task task : elements) {
            list1.add(task);
            list2.add(task);
        }
        assertEquals(list1, list2, getTitle());
        assertEquals(list2, list1, getTitle());
    }
    
    @ParameterizedTest
    @MethodSource("params")
    public void testEqualsNull(Class <? extends AbstractTaskList> clazz) {
        setUp(clazz);
        assertNotEquals(null, tasks);
    }
    
    @ParameterizedTest
    @MethodSource("params")
    public void testIdentityEquals(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        assertEquals(tasks, tasks, getTitle());
    }
    
    @ParameterizedTest
    @MethodSource("params")
    public void testSymmetricEquals(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        AbstractTaskList dummy = new DummyList();
        assertEquals( tasks.equals(dummy), dummy.equals(tasks), getTitle());
    }
    
    @ParameterizedTest
    @MethodSource("params")
    public void testHashCode(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        Task[] elements = {task("A"), task("B"), task("C")};

        AbstractTaskList list1 = createList();
        AbstractTaskList list2 = createList();
        for (Task task : elements) {
            list1.add(task);
            list2.add(task);
        }
        
        assertEquals(list1.hashCode(), list2.hashCode(), getTitle());
    }
}

class DummyList extends AbstractTaskList {
    
    public void add(Task task) { }
    
    public void remove(Task task) { }
    
    public int size() { 
        return 0; 
    }

    @Override
    public AbstractTaskList clone() {
       return null;
    }

    public Task getTask(int index) { 
        throw new IndexOutOfBoundsException();
    }

     @Override
     public Task[] incoming(int i, int i1) {
        throw new RuntimeException("Not necessary for this test");
     }

     public Iterator<Task> iterator() {
        return Collections.emptyIterator();
     }
    
    public boolean equals(Object obj) {
        return false;
    }
}












