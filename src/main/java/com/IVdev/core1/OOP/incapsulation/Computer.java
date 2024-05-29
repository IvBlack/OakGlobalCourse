package com.IVdev.core1.OOP.incapsulation;

public class Computer {
    /*
    Инкапсуляция - сокрытие данных и сложности кода от внешнего доступа (private)
    полезно при написании кода, которым будут пользоваться кто-то другой, например
    другая команда.
    */
    private Ssd ssd;
    private Ram ram;

    {
        System.out.println("Init block PC");
    }

    static {
        System.out.println("Static block PC");
    }

    public Computer(Ssd ssd, Ram ram) {
        this.ssd = ssd;
        this.ram = ram;
    }

    public Computer() {
        System.out.println("Constructor computer");
    }

    //открытая часть класса, можно использовать другими классами
    public void load() {
        System.out.println("PC загрузился.");
    }

    public Ssd getSsd() {
        return ssd;
    }

    public Ram getRam() {
        return ram;
    }
}
