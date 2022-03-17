package com.nc.edu.ta.kvasov.pr5;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class TaskListTest extends AbstractTaskListTest {

    // tests --------------------------------------------------------------

    @ParameterizedTest
    @MethodSource("params")    
    public void testSizeAddGet(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        assertEquals(0, tasks.size(), getTitle());
        Task[] ts = {task("A"), task("B"), task("C")};
        addAll(ts);
        assertEquals(ts.length, tasks.size(), getTitle());
        assertContains(ts);
    }    
    
    @ParameterizedTest
    @MethodSource("params")
    public void testWrongAdd(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        assertThrows(RuntimeException.class, ()->tasks.add(null));
    }
        
    @ParameterizedTest
    @MethodSource("params")    
    public void testRemove(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        Task[] ts = {task("A"),task("B"),task("C"),task("D"),task("E")};
        addAll(ts);
            
        // remove first
        tasks.remove(task("A"));
        assertContains(new Task[] { ts[1], ts[2], ts[3], ts[4] });
        
        // remove last
        tasks.remove(task("E"));
        assertContains(new Task[] { ts[1], ts[2], ts[3] });

        // remove middle
        tasks.remove(task("C"));
        assertContains(new Task[] { ts[1], ts[3] });
    }

    @ParameterizedTest
    @MethodSource("params")    
    public void testUnexistedTask(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        Task[] ts = {task("A"),task("B"),task("C"),task("D"),task("E")};
        addAll(ts);
        assertThrows(RuntimeException.class, ()-> tasks.remove(task("F")));
    }
    
    @ParameterizedTest
    @MethodSource("params")    
    public void testInvalidRemove(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        assertThrows(RuntimeException.class, ()->tasks.remove(null));
    }
    
    @ParameterizedTest
    @MethodSource("params")    
    public void testAddManyTasks(Class <? extends AbstractTaskList> clazz){
        setUp(clazz);
        Task[] ts = new Task[1000];
        for (int i = 0; i < ts.length; i++) {
            ts[i] = new Task("Task#"+ i, i);
            tasks.add(ts[i]);
        }
        assertContains(ts);
    }

}












