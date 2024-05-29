package com.IVdev.core1.StaticInJava;

public class AreaAndCircumference {
    public static final double  PI = 3.14;

    public double area(double radius) {
        double ploshad = PI * radius * radius;
        return ploshad;
    }

    public static double circumference(double radius2) {
        return PI * radius2 * 2;
    }

    //в нестатичном методе спокойно можно использовать как статичные, так и нестатичные вызовы других методов
    public void info(double radius3) {
        System.out.println("радиус = "+radius3);
        System.out.println("Длина окружности = "+area(radius3));
        System.out.println("Площадь круга = "+circumference(radius3));
    }
}

class AreaAndCircumferenceTest{
    public static void main(String[] args) {
        AreaAndCircumference aac = new AreaAndCircumference();
        aac.area(9);
        AreaAndCircumference.circumference(3.7);
        aac.info(7);
    }
}
