package com.IVdev.core2.collections.customArrayList;

import java.util.Iterator;

public class ArrayIterator<E> implements Iterator {
    private  int index = 0;
    private E[] values;

    ArrayIterator(E[] values) {
        this.values = values;
    }

    //индекс существует, если он меньше длины массива по номиналу
    @Override
    public boolean hasNext() {
        return index < values.length;
    }

    //просто следующий элемент
    @Override
    public E next() {
        return values[index++];
    }
}
