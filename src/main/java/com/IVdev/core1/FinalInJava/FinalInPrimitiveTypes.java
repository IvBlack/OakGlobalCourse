package com.IVdev.core1.FinalInJava;

public class FinalInPrimitiveTypes {

//    final-переменные являются read-only, изменить их значение нельзя

    /*
        public final int a = 10;

        public static void main(String[] args) {
        FinalVars fv = new FinalVars();
        fv.a = fv.a * 3;
        System.out.println(fv.a);
    }


    *****************************************
    final-переменные должны быть инициализированы до их использования:
    1. как instanct-переменные
    2. либо в каждом конструкторе (если переменная не non-static)
    Причем в разных конструкторах она м.принимать разное значение, инициализировано будет то значение, к конструктору которого оно привязано.
    Значение константы нельзя переназначить через объект класса, компилятору все равно, что их значения в поле класса и в объекте равны.
    */
    public  final int a = 10;

//    public FinalVars() {
//        a = 27;
//    }
//
//    public FinalVars(boolean b) {
//        a = 10;
//    }

        //локальные переменные так же м.б. финализированы, видны только в пределах метода
        //причем значение им м.б. присвоено после инициализации, в отличие от instance-переменной
        //параметры метода так же м.б. финализированы, изменять их в теле метода - нельзя
        public void abc(final short s) {
            final byte b;
            b = 5;
//            s++;
            System.out.println(s + b);

        }
        public static void main(String[] args) {
        FinalInPrimitiveTypes fv = new FinalInPrimitiveTypes();
//        fv.a = 10;
        System.out.println(fv.a);
    }

}
