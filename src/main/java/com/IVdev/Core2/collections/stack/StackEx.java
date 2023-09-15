package com.IVdev.Core2.collections.stack;

/*
Stack - структура данных, работает по принципу LIFO. Аналог из жизни - стопка тарелок, вы всегда берете верхнюю.
По принципу стэка в программировании работают вызовы вложенных функций. Это база.
*/
public class StackEx {
    static void abc1() {
        System.out.println("abc1 starts");
        System.out.println("abc1 ends");
    }

    static void abc2() {
        System.out.println("abc2 starts");
        abc1();
        System.out.println("abc2 ends");
    }

    static void abc3() {
        System.out.println("abc3 starts");
        abc2();
        System.out.println("abc3 ends");
    }


    //имитация вызова стека через вложенные методы: main -> abc3,2,1 -> abc1,2,3 -> main
    public static void main(String[] args) {
        System.out.println("main starts");
        abc3();
        System.out.println("main ends");
    }
}
