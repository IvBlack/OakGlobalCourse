package com.IVdev.advanced.SOLID.SR;

public class SavePC {
    public void saveToFile(String path, Computer cmp) {
        System.out.println("Saving to file " + path + ", " + cmp);
    }

    public void saveToDB(String path, Computer cmp) {
        System.out.println("Saving to DB " + path + ", " + cmp);
    }
}
