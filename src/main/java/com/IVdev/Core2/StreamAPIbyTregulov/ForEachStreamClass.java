package com.IVdev.Core2.StreamAPIbyTregulov;

import java.util.Arrays;

public class ForEachStreamClass {
    public static void main(String[] args) {
        int[] arr = {4, 6, 2, 3, 1};

        //forEach возвращает void, производит действия с каждым элементом
        Arrays.stream(arr).forEach(e -> {e *= 2;
            System.out.println(e + "\n");});

        System.out.println("******************************");
        //сокращенная запись через reference-method
        Arrays.stream(arr).forEach(System.out::println);

        //самописный reference-method для понимания логики
        //каждый элемент стрима помести в метод myMethod
        Arrays.stream(arr).forEach(Utils::myMethod);
    }

}
