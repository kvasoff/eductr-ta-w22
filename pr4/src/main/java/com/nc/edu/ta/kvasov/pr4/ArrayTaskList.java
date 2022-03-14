package com.nc.edu.ta.kvasov.pr4;

public class ArrayTaskList<T> extends AbstractTaskList {

    private final int INIT_SIZE = 16;
    private Task[] array = new Task[INIT_SIZE];
    /*
   Добавляет новый элемент в список. При достижении размера внутреннего
   массива происходит его увеличение в два раза.
   */

    @Override
    public void add(Task task) {
        if(pointer == array.length-1)
            resize(array.length*2);
        array[pointer++] = task;

        if(task == null) throw new NullPointerException();
    }
    /*
   Удаляет элемент списка по индексу. Все элементы справа от удаляемого
   перемещаются на шаг налево. Если после удаления элемента количество
   элементов стало в CUT_RATE раз меньше чем размер внутреннего массива,
   то внутренний массив уменьшается в два раза, для экономии занимаемого
   места.
   */
    @Override
    public void remove(Task task) {
        int index = 1;
        if (pointer - index >= 0) System.arraycopy(array, index + 1, array, index, pointer - index);
        array[pointer] = null;
        pointer--;
        int CUT_RATE = 16;
        if (array.length > INIT_SIZE && pointer < array.length / CUT_RATE)
            resize(array.length/2); // если элементов в CUT_RATE раз меньше чем
        // длина массива, то уменьшу в два раза
    }
    /*Возвращает элемент списка по индексу. */
    @Override
    public Task getTask(int index) {
        if(index == size()) throw new ArrayIndexOutOfBoundsException();

        return (Task) array[index];
    }

    /*Вспомогательный метод для масштабирования.*/
    private void resize(int newLength) {
        Task[] newArray = new Task[newLength];
        System.arraycopy(array, 0, newArray, 0, pointer);
        array = newArray;
    }

}