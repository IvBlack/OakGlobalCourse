package com.IVdev.arch.SOLID.LSP;

import com.IVdev.arch.SOLID.SR.Computer;

public class OmenHP extends Computer {

    public OmenHP(String name, int memory_size) {
        super(name, memory_size);
    }

    //метод некорректно переопределяет родительский
    //нарушение принципа Барбары Лисков
    public void setData(String name) {
        this.name = name;
        this.memory_size = 8000;
    }
}
