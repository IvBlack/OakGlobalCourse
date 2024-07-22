package com.IVdev.core1.primitivetypes;

import java.text.DecimalFormat;
/*
Задание:
    Реализовать метод calcCircleRaduis(double area), который вычисляет радиус окружности по заданной площади и выводит его на экран.
    Точность - 3 знака после запятой. Для указания количества знаков после запятой используйте метод
    для форматированного вывода System.out.printf
*/

public class CircleRadius {
    public static void main(String[] args) {
        calcCircleRadius(59);
    }

    public static void calcCircleRadius(double area) {
        DecimalFormat dF = new DecimalFormat( "#.###" );
        System.out.print(dF.format(Math.sqrt(area / 3.14)));
    }
}

