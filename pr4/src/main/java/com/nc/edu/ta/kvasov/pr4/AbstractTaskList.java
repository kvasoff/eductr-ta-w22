package com.nc.edu.ta.kvasov.pr4;

public abstract class AbstractTaskList {
    public int pointer = 0;
    public int size() {
        return pointer;
    };

    public abstract void add(Task task);
    public abstract void remove(Task task);
    abstract Task getTask(int index);
}