package com.IVdev.SOLID.DIP;

public class MySQL implements ISQL{
    public void save(IForm frm) {
        System.out.println("persisting form into DB...");
    }
}
