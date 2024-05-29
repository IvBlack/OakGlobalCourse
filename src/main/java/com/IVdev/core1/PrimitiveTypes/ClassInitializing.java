package com.IVdev.core1.PrimitiveTypes;

/*
В общем случае инициализация классов в Java проходит так:
- инициализация стат.блоков
- переменных стат.блоков
- инициализация анонимных блоков
- инициализация констуктора
*/

public class ClassInitializing {
    public static void main(String[] args) {

        //инициализируем класс А и стат.блок последовательно
        //результат виден в консоли
        A a = new A();
    }
}

class A {
    String strA;
    int intA;

    public A() {
        System.out.println("Constructor A.");
    }

    {
        System.out.println("Anonymous block is called!");
        System.out.println("strA = " + strA);
        System.out.println("intA = " + intA);
        strA = "default";
        intA = 2;

        System.out.println("strA = " + strA);
        System.out.println("intA = " + intA);
    }

    static String st = "static field";
    static {
        System.out.println("Static block is called!");
        st = "new static field";
        System.out.println(st);
    }
}
