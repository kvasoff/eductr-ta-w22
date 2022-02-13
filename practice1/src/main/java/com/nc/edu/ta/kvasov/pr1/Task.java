package com.nc.edu.ta.kvasov.pr1;

import javax.swing.*;

/**
* Класс описывающий задачу
* @author Kvasov Andrey "Kvasov A.N - kvasoff.an@gmail.com"
* @version 0.1
*/
public class Task {
    /** Поле title */
    private String title;
    /** Метод для получения и установки задачи */
    public String getTitle() {
        return title;
    }
    /**
     * @param title - заголовок(название) задачи
     * */
    public void setTitle(String title) {
        this.title = title;
    }
    /** Поле active */
    private boolean active;
    /** Методы проверки статуса задачи */
    public boolean isActive() {
        return active;
    }
    /** Булев индикатор активности задачи */
    public void setActive(boolean active) {
        this.active = active;
    }
    /** Методы задания и получениея времени оповощения о задаче */
    private int time;
    /** время начала оповещения (для повторяющейся задачи) или
     время единственного оповещения (для единоразовой задачи) */
    public int getTime() {
        return time;
    }
    /** для единоразовой задачи, где time – время оповещения о
     задаче. Если задача повторяется, она должна стать неповторяющейся */
    public void setTime(int time) {
        this.time = time;
        //setTime(time, time, time);
    }

    private int start;
    private int end;
    private int repeat;
    /** для повторяющейся задачи, где start –
     время начала оповещения о задаче, end – время прекращения оповещения о
     задаче , repeat – интервал времени, через который необходимо повторить
     оповещение о задаче */
    void setTime(int start, int end, int repeat) {
        this.start = start;
        this.end = end;
        this.repeat = repeat;
    }
    /** время начала оповещения (для повторяющейся задачи) или
     время единственного оповещения (для единоразовой задачи) */
    public int getStartTime() {
        return start;
    }
    /** время окончания оповещения (для повторяющейся задачи)
     или время единственного оповещения (для единоразовой задачи)  */
    public int getEndTime() {
        return end;
    }
    /** интервал времени, через который необходимо
     повторить оповещение о задаче (для повторяющейся задачи) или 0 (для
     единоразовой задачи)  */
    public int getRepeatInterval() {
        return repeat;
    }

    boolean repeated;
    /** информация о том, повторяется ли задача  */
    public boolean isRepeated() {
        return repeat > 0;
    }
    /** возвращает строку со следующей информацией:
     * Task “<title>” is inactive – для неактивных задач
     * Task “<title>” at <time> – для активных единоразовых задач
     * Task “<title>” from <start> to <end> every <repeat> hours – для активных
     * повторяющихся задач. Пример: Task “Сделать зарядку для зрения” from 1
     * to 10 every 2 hours*/
    public String toString() {
        if(active)
            if(isRepeated())
                return "Task \"some\" from 10 to 100 every 20 seconds";
            else
            // String.format("Task \"%s" )
                return "Task " + '\"' + title + '\"' + " at " + time;
        else
            return "Task " + '\"' + title + '\"' + " is inactive";



    };
    /** Метод, возвращающий время следующего оповещения, после указанного времени time
     (не включая его): если после указанного времени оповещений больше
     нет или задача неактивна, то результат должен быть -1  */
    public int nextTimeAfter(int time) {
        if(time == 0) {
            time = start;
        } else {
            time += repeat;
        }
       return time;

    }
    /** конструктор Task для единоразовой задачи */
    public Task(String title, int time) {
        this.title = title;
        this.time = time;
    }
    /** конструктор Task для повторяющейся задачи */
    public Task(String title, int start, int end, int repeat) {
        this.title = title;
        this.start = start;
        this.end = end;
        this.repeat = repeat;
    }
}