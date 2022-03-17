package com.nc.edu.ta.kvasov.pr5;

import com.sun.org.apache.xml.internal.serializer.ToSAXHandler;

import java.util.Objects;

public class Task implements Cloneable {

    private String title;
    private boolean active;
    private int start;
    private int end;
    private int repeat;


    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if(title == null) throw new NullPointerException();
        if(title.equals("")) throw new IllegalArgumentException();
        this.title = title;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public void setTime(int time) {
        setTime(time, time, 0);
    }

    public void setTime(int start, int end, int repeat)  {
        if (start < 0)
        {
            this.start = 0;
            this.end = 0;
            this.repeat = 0;
        }
        else if (end < 0 || repeat <0)
        {
            this.start = start;
            this.end = start;
            this.repeat = 0;
        }
        else
        {
            this.start    = start;
            this.end      = end;
            this.repeat   = repeat;
        }
        if(start < 0) throw new IllegalArgumentException();
    }

    public int getTime() {
        return start;
    }

    public int getStartTime() {
        return start;
    }

    public int getEndTime() {
        return end;

    }

    public int getRepeatInterval() {
        return repeat;
    }

    public boolean isRepeated() {
        return repeat > 0;
    }


    public int nextTimeAfter(int time) {
        if (!isActive() || time >= end || time > end - repeat)
        {
            return -1;
        }


        if (time < getTime())
        {
            return getTime();
        }

        if ((time < (start + repeat) || (time == start)) && isRepeated())
        {
            return start + repeat;
        }

        if (time > (end-repeat)&&time<end && isRepeated())
        {
            return end;
        }

        else
        {
            int iter  = (end-start)/repeat;
            int iter2 = 1;
            while (iter2<iter)
            {
                int check = start + (repeat * iter2);
                if(time == check)
                {
                    return check+repeat;
                }
                iter2++;
            }

            for (int i=start; i<end; i+=repeat)
            {
                if ((time>=i)&&(time<i+repeat)&&((time<end)&&((i+repeat)<=end))||((time<end-repeat)&&(time>end-(repeat*2))))
                {
                    return i + repeat;
                }
            }
        }
        return -1;
    }

    public Task(String title, int time) {
        if(title == null) throw new NullPointerException();
        if(title.equals("")) throw new IllegalArgumentException();
        this.title = title;
        setTime(time);
        this.active = false;
    }

    public Task(String title, int start, int end, int repeat) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.repeat = repeat;

        if(start < 0 | repeat < 0 | end < start) throw new IllegalArgumentException();
    }

    @Override
    public Task clone() {
        Task tasks = null;
        try {
            tasks = (Task) super.clone();

        } catch (CloneNotSupportedException e) {
            tasks = new Task (this.title, this.start, this.end, this.repeat);
        }
        return tasks;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Task task = (Task) o;
        return active == task.active && start == task.start && end == task.end && repeat == task.repeat && Objects.equals(title, task.title);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, active, start, end, repeat);
    }

}