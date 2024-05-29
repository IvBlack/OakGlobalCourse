package com.IVdev.core1.OOP.incapsulation;

import com.IVdev.core1.OOP.inheritance.Laptop;

public class OOPRunner {
    public static void main(String[] args) {
        //Computer computer = new Computer(new Ssd(1024), new Ram(500));
        //computer.load();
        //System.out.println("computer = " + computer);

        //laptop наследует через super() все методы и доступ к полям родителя
        //это хорошо видно в debug-режиме.
        //Laptop laptop = new Laptop(new Ssd(250), new Ram(512), 2);
        //laptop.open();
        //laptop.load();

        new Laptop();

    }

}
