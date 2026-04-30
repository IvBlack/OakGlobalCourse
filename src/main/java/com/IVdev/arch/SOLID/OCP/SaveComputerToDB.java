package com.IVdev.arch.SOLID.OCP;

import com.IVdev.arch.SOLID.SR.Computer;

public class SaveComputerToDB implements SaveInterface{
    @Override
    public void save(String path, Computer comp) {
        System.out.println("Saving to DB " + path + ", " + comp);
    }
}
