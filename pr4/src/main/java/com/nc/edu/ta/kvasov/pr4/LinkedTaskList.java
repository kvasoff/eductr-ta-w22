package com.nc.edu.ta.kvasov.pr4;

public class LinkedTaskList extends AbstractTaskList
{
    private Unit first = new Unit();

    private class Unit {
        Task task;
        Unit next;

        Unit() {
            task = null;
            next = null;
        }

        Unit(Task task) {
            this.task = task;
            next = null;
        }

        public void setElement(Task task) {
            this.task = task;
        }

        public Task getElement() {
            return task;
        }

        public void setNext(Unit next) {
            this.next = next;
        }

        public Unit getNext() {
            return next;
        }
    }

    public void add(Task task) {
        if (task != null) {
            if (size() == 0) {
                Unit newElement = new Unit(task);
                first = newElement;
                pointer++;
            }

            else {
                Unit current = first;

                for(int i = 1; i < size(); i++) {
                    if(current.getNext() == null) {
                        break;
                    }
                    else {
                        current = current.getNext();
                    }
                }

                Unit newElement = new Unit(task);
                current.setNext(newElement);
                pointer++;
            }
        }
        if(task == null) throw new ArithmeticException();
    }

    public Task getTask(int index)
    {

        if (index >= 0 && index < size())
        {
            Unit current = first;
            for(int i = 0; i < size(); i++)
            {
                if (i == index)
                {
                    break;
                }
                current = current.getNext();
            }
            return current.getElement();
        }
        else throw new ArrayIndexOutOfBoundsException();
    }


    public void remove(Task task)
    {
        Unit current = first.getNext(), previous = this.first;
        for(int i = 0; i < pointer; i++)
        {
            if (first.getElement().equals(task))
            {
                first.setElement(first.getNext().getElement());
                first.setNext(first.getNext().getNext());
                previous = first;
                current = first.getNext();
                pointer--;
            }
            else
            {
                if (current.getElement().equals(task))
                {
                    previous.setNext(current.getNext());
                    pointer--;
                }
                previous = current;
                if (current.getNext() != null)
                {
                    current = current.getNext();
                }
            }
        }
    }
}
