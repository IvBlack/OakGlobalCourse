package com.IVdev.collections.customArrayList;

import java.util.Iterator;

/*
Самые сложные реализации add и delete основаны на концепции изменения длин исходного
и нового массивов + системная функция System.arraycopy
*/
public class CustomArrayList<E> implements IArrayList {
    public static void main(String[] args) {
        CustomArrayList<String> strings = new CustomArrayList<>();
        strings.add("first");
        strings.add("second");
        strings.add("3rd");

//        System.out.println(strings.update(1, "updated"));
//        System.out.println(strings.get(1));
//        System.out.println(strings.size());

        strings.delete(1);
        for (Object s : strings) {System.out.println(s);}
    }

    private E[] values;
    public CustomArrayList() {
        values = (E[]) new Object[0];
    }

    @Override
    public boolean add(Object e) {
        try{
            E[] temp = values;
            values = (E[])new Object[temp.length + 1];
            //источник корирования temp
            //куда копируем - values, и сколько элементов вставляем - temp.length
            System.arraycopy(temp, 0, values, 0, temp.length);
            values[values.length - 1] = (E) e;
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    @Override
    public void delete(int index) {
        try {
            E[] temp = values;
                //отличие от add: уменьшаем новый массив до заданного индекса
            values = (E[])new Object[temp.length - 1];
            System.arraycopy(temp, 0, values, 0, index);
            int amountElemAfterIndex = temp.length - index - 1;
                //скопировать вторую часть массива после индекса, удалив индекс
            System.arraycopy(
                    temp, index + 1,
                    values, index,
                    amountElemAfterIndex);
        } catch (ClassCastException ex) {
            ex.printStackTrace();
        }

    }

    @Override
    public E get(int index) {
        return values[index];
    }

    @Override
    public int size() {
        return values.length;
    }

    @Override
    public boolean update(int index, Object e) {
        values[index] = (E) e;
        return false;
    }

    @Override
    public Iterator iterator() {
        return new ArrayIterator<>(values);
    }
}
