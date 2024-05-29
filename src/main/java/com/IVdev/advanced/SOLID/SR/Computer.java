package com.IVdev.advanced.SOLID.SR;

public class Computer {
    public String name;
    public int memory_size;

    public Computer(String name, int memory_size) {
        this.name = name;
        this.memory_size = memory_size;
    }

    public void setData(String name) {
        this.name = name;
    }

    //нарушение первого принципа SOLID
    //у класса более одной ответственности, вынесем в отдельный класс
//    public void save() {
//        System.out.println("Saving to file.");
//    }
//
//    public void load() {
//        System.out.println("Upload from the file.");
//    }
}
