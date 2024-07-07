package com.IVdev.core1.OOP.inheritance.linkToSuperClass;

/*
    По Шилдту:
    классы X и Y структурно одинаковы, присвоить ссылке X объект Y не-
    возможно, поскольку они имеют разные типы. В общем случае переменная
    ссылки на объект может ссылаться только на объекты своего типа.
* */
public class IncompatibleRef {
    public static void main(String[] args) {
        X x = new X(10);
        X x2;
        Y y = new Y(5);
        x2 = x;
//        x2 = y; // несовместимые типы
    }
}

class X {
    int a;
    X(int i) { a = i; }
}

class Y {
    int a;
    Y(int i) { a = i; }
}
