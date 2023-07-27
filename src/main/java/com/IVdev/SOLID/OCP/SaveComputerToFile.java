package com.IVdev.SOLID.OCP;

import com.IVdev.SOLID.SR.Computer;

public class SaveComputerToFile implements SaveInterface{
    @Override
    public void save(String path, Computer comp) {
        System.out.println("Saving to file " + path + ", " + comp);
    }
}
