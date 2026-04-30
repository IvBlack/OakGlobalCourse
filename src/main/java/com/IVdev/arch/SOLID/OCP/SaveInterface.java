package com.IVdev.arch.SOLID.OCP;

import com.IVdev.arch.SOLID.SR.Computer;

//интерфейс позволяет разбить функционал между классами
//имплементирубщими его метод
public interface SaveInterface {
    void save(String path, Computer comp);
}
