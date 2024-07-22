package com.IVdev.core1.OOP.inheritance.linkToSubClass;

public class Triangle extends TwoDimShape{
    private String style;

    Triangle() {
        super();
        style = "undefined";
    }

    Triangle(String s, double w, double h) {
        super(w, h);
        style = s;
    }

    Triangle(double x) {
        super(x);
        style = "dark";
    }

    //передача ссылки на Triangle конструктору TwoDimShape
    Triangle(Triangle ob) {
        super(ob); //передача объекта конструктору класса TwoDimShape
        style = ob.style;
    }

}
