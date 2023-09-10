package com.IVdev.Core1.PrimitiveTypes.OOP.inheritance;

import com.IVdev.Core1.PrimitiveTypes.OOP.incapsulation.Computer;
import com.IVdev.Core1.PrimitiveTypes.OOP.incapsulation.Ram;
import com.IVdev.Core1.PrimitiveTypes.OOP.incapsulation.Ssd;

/*
Наследование - свойство класса использовать функционал родительского класса +
привнести какой-то свой функционал (например weight).
Через super осуществляется доступ к конструктору родительского класса.
*/
public class Laptop extends Computer {

    private int weight;

    {
        System.out.println("Init block laptop");
    }

    static {
        System.out.println("Static block laptop");
    }

    public Laptop(){
        System.out.println("Constructor laptop");
    }

    public Laptop(Ssd ssd, Ram ram, int weight) {
        super(ssd, ram);
        this.weight = weight;

        //так же наследуются неявно getters/setters родительского класса
        super.getRam();
        //либо вызовом напрямую
        getSsd();
    }

    public void open() {
        System.out.println("Крышка laptop-а открыта.");
    }

    public int getWeight() {
        return weight;
    }
}
