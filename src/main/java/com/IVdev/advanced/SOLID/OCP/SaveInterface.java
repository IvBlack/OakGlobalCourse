package com.IVdev.advanced.SOLID.OCP;

import com.IVdev.advanced.SOLID.SR.Computer;

//интерфейс позволяет разбить функционал между классами
//имплементирубщими его метод
public interface SaveInterface {
    void save(String path, Computer comp);
}
