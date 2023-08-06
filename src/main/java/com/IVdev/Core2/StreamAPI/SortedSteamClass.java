package com.IVdev.Core2.StreamAPI;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class SortedSteamClass {
    public static void main(String[] args) {

        //java сортирует по умолчанию в порядке возрастания
        int[] arr = {3,8,1,5,9,12,4,21,81,7,18};
        arr = Arrays.stream(arr).sorted().toArray();
        System.out.println(Arrays.toString(arr));

        //сортировка строк требует наличие компаратора
        //т.к. java не знает, как по умолчанию сортировать объекты
        Student st1 = new Student("Ivan", "m", 22, 3, 7.1);
        Student st2 = new Student("Petr", "m", 19, 1, 6.9);
        Student st3 = new Student("Jo", "m", 23, 4, 7.3);
        Student st4 = new Student("Garry", "m", 20, 2, 6.1);
        Student st5 = new Student("Luk", "m", 22, 3, 7.4);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        //лямбда: возьми 2 элемента по имени и сравни
        students = students.stream().sorted((x,y)
                -> x.getName().compareTo(y.getName()))
                .collect(Collectors.toList());
    }
}
