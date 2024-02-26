package com.IVdev.Core2.StreamAPIbyTregulov;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ChainingStreamClass {
    public static void main(String[] args) {
        int[] arr = {3,8,1,5,9,12,4,21,81,7,18};

        //цепочка вызовов - chaining - позволяет модифицировать поток несколько раз
        int result = Arrays.stream(arr)
                .filter(e -> e%2 == 1)
                .map(e -> {
                    if(e%3 == 0) {e = e/3;} return e;
                })
                .reduce((a,e) -> a + e).getAsInt();
        System.out.println(result);
        System.out.println("__________________________________________________");

        //работа с объектами: выберем людей по полу, имена привели к upperCase
        Student st1 = new Student("Ivan", "m", 22, 3, 7.1);
        Student st2 = new Student("Petr", "m", 19, 1, 6.9);
        Student st3 = new Student("Jo", "m", 23, 4, 7.3);
        Student st4 = new Student("Garry", "m", 20, 2, 6.1);
        Student st5 = new Student("Mary", "f", 22, 3, 7.4);

        List<Student> students = new ArrayList<>();
        students.add(st1);
        students.add(st2);
        students.add(st3);
        students.add(st4);
        students.add(st5);

        //смапили к upperCase, отфильтровали по полу
        students.stream().map(e ->
                {
                    e.setName(e.getName().toUpperCase());
                    return e;
                })
                //.filter(elem -> elem.getSex() == 'f')
                .sorted((x,y) -> x.getAge() - y.getAge())
                .forEach(System.out::println);
    }
}
