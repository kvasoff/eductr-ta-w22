package com.nc.edu.ta.kvasov.pr1;

public class Task {
    // Методы получения и установки заголовка задачи:
    private String title;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    // Методы проверки статуса задачи:
    private boolean active;

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    // Методы задания и получения времени оповещения о задаче:
    private int time;
    private int start;
    private int end;
    private int repeat;
    private boolean repeated;

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void setTime(int start, int end, int repeat) {
        this.start = start;
        this.end = end;
        this.repeat = repeat;
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
        return repeated;
    }

    @Override
    public String toString() {
        return "Task{" +
                "title='" + title + '\'' +
                ", time=" + time +
                ", start=" + start +
                ", end=" + end +
                ", repeat=" + repeat +
                '}';
    }

    public int nextTimeAfter(int time) {
        return time;
    }

    // Конструктор 1
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }

    // Конструктор 2

    public Task(String title, int start, int end, int repeat) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.repeat = repeat;
    }
}