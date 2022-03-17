package com.nc.edu.ta.kvasov.pr5;

import java.util.AbstractList;
import java.util.List;
import java.util.Objects;

public abstract class AbstractTaskList implements Cloneable {
    public int pointer = 0;

    public int size() {
        return pointer;
    }

    ;

    public abstract void add(Task task);

    public abstract void remove(Task task);

    public abstract Task getTask(int index);


    @Override
    public AbstractTaskList clone() {
        try {
            AbstractTaskList clone = (AbstractTaskList) super.clone();
            clone.pointer = this.pointer;
            return clone;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        AbstractTaskList taskList = (AbstractTaskList) o;
        return pointer == taskList.pointer;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pointer);
    }

    @Override
    public String toString() {
        return "AbstractTaskList{" +
                "pointer=" + pointer +
                '}';
    }
}