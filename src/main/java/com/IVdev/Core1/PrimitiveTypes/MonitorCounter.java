package com.IVdev.Core1.PrimitiveTypes;

public class MonitorCounter {
    public static void main(String[] args) {
        int i = drawisMonitorsCounter(59, 50);
        System.out.println(i);
    }

    public static int drawisMonitorsCounter(int monitors, int programmers) {
        return monitors % programmers;
    }
}

/*
Напишите программу, которая принимает на вход количество мониторов купленных компанией и 
количество программистов в ней, а возвращает количество мониторов, которые никому не достанутся. 
*/
