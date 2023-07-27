package com.IVdev.SOLID.OCP;

import com.IVdev.SOLID.SR.Computer;

public class SaveComputerToDB implements SaveInterface{
    @Override
    public void save(String path, Computer comp) {
        System.out.println("Saving to DB " + path + ", " + comp);
    }
}
