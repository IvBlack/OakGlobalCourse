package com.IVdev.core2.collections.customArrayList;

public interface IArrayList<E> extends Iterable{
    boolean add(E e);
    void delete(int index);
    E get(int index);
    int size();
    boolean update(int index, E e);
}
