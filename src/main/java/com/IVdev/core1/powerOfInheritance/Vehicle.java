package com.IVdev.core1.powerOfInheritance;

/*
    Вся мощь наследования по Шилдту.
    Ключевой момент состоит в том , что после создания суперкласса , опре-
    деляющего общие аспекты объекта, такой суперкласс может быть унасле-
    дован для формирования специализированных классов. Каждый подкласс
    просто добавляет собственные уникальные характеристики. В этом и есть
    суть наследования .
* */

import lombok.Data;

@Data
public class Vehicle {
    private int passengers;
    private int fuelcap;
    private int mpg;

    Vehicle(int p, int f, int m) {
        passengers = p;
        fuelcap = f;
        mpg = m;
    }

    //дальность поездки
    int range() {
        return fuelcap * mpg;
    }

    //объем топлива на заданное расстояние
    double fuelNeeded(int miles) {
        return (double) fuelcap / miles;
    }
}
