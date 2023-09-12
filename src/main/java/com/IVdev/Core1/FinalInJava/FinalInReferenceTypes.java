package com.IVdev.Core1.FinalInJava;

public class FinalInReferenceTypes {
     /*
     Финализированные ссылочные типы данных - означает лишь неизменную ссылку на объект,
     но, не сам объект, на который она указывает. Нельзя изменить адрес, но можно изменить состояние объекта.
     Это значит, мы не можем ею сослаться на какой-то другой объект. Однако сам объект (его поля и методы) менять можно.
     */

    String color = "blue";
    String engine = "V6";
}


class Human {
    String name = "Ivan";
    final FinalInReferenceTypes frt = new FinalInReferenceTypes();
    public static void main(String[] args) {
        Human h1 = new Human();

//        нельзя поменять ссылку на другой FinalInReferenceTypes()-объект
//        h1.frt = new FinalInReferenceTypes();
//        h1.frt = new FinalInReferenceTypes();

        //но поле класса FinalInReferenceTypes поменять можно
        h1.frt.engine = "V8";
    }
}
