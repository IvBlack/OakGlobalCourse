package com.IVdev.core1.OOP.inheritance.linkToSubClass;

import lombok.Data;

@Data
public class TwoDimShape {
    private double with;
    private double height;

    TwoDimShape() {
        with = height = 0;
    }

    TwoDimShape(double w, double h) {
        with = w;
        height = h;
    }

    TwoDimShape(double x) {
        with = height = x;
    }

    TwoDimShape(TwoDimShape ob) {
        with = ob.with;
        height = ob.height;
    }
}
