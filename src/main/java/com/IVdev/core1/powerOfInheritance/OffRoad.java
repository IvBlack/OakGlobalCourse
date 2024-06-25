package com.IVdev.core1.powerOfInheritance;

/*
    Многие другие типы классов могут быть производными от Vehicle.
    Например, класс, описывающий внедорожник со своими особенностями.
*/
public class OffRoad extends Vehicle {
    private int groundClearance;

    OffRoad(int p, int f, int m) {
        super(p, f, m);
    }

    //............................
}
