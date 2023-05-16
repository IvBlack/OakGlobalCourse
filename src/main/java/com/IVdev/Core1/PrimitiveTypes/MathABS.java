package com.IVdev.Core1.PrimitiveTypes;

/*
Реализуйте метод, возвращающий ответ на вопрос: правда ли, что a + b = c?
Допустимая погрешность – 0.0001 (1E-4)
*/

public class MathABS {
    public static void main(String[] args) {
        System.out.println(doubleExpression(2.0, 3.8, 5.8));
        }

    //сравним разницу слагаемых со значением 'с' по модулю
    public static boolean doubleExpression(double a, double b, double c) {
        boolean x = Math.abs((a + b) - c) < 1E-4;
        return x;
    }
}
