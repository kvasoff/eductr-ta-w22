package com.nc.edu.ta.kvasov.pr1;

class Task {
    // Переменные
    private String title;
    private boolean active;
    private int time;
    private int start;
    private int end;
    private int repeat;
    private int startTime;
    private int repeatInterval;
    private boolean isRepeated;
    private String toString;

    // Методы получения и установки заголовка задачи
    String getTitle() {
        return title;
    }
    void setTitle(String title) {
        this.title = title;
    }

    // Методы проверки статуса задачи
    boolean isActive() {
        return active;
    }
    void setActive(boolean active) {
        this.active = active;
    }

    // Методы задания и получения времени оповещения о задаче
    void setTime(int time) {
        this.time = time;
    }
    void setTime(int start, int end, int repeat) {
        this.start = start;
        this.end = end;
        this.repeat = repeat;
    }
    int getTime() {
        return time;
    }
    int getStartTime() {
        return startTime;
    }
    int EndTime() {
        return end;
    }
    int getRepeatInterval() {
        return repeatInterval;
    }
    boolean isRepeated() {
        return isRepeated;
    }

    // Метод, возвращающий описание данной задачи
    public String toString()  {
        return toString;
    }

    // Метод, возвращающий время следующего оповещения, после указанного времени time (не включая его):
    int nextTimeAfter(int time) {
        return time;
    }
    // констуруторы
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }

    public Task(String title, int start, int end, int repeat) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.repeat = repeat;
    }

    public static void main(String[] args) {
        System.out.println();
    }
}

