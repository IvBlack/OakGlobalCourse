package com.IVdev.core2.StreamAPIbyTregulov;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class FilterStreamClass {
    public static void main(String[] args) {
        Student st1 = new Student("Ivan", "m", 22, 3, 7.1);
        Student st2 = new Student("Petr", "m", 19, 1, 6.9);
        Student st3 = new Student("Jo", "m", 23, 4, 7.3);
        Student st4 = new Student("Garry", "m", 20, 2, 6.1);
        Student st5 = new Student("Luk", "m", 22, 3, 7.4);

        List<Student> list = new ArrayList<>();
        list.add(st1);
        list.add(st2);
        list.add(st3);
        list.add(st4);
        list.add(st5);

        //фильтр фильтрует каждый элемент коллекции по какому-то условию
        List<Student> filteredList = list.stream().filter(e -> e.getAge() > 20 && e.getAvgGrade() < 7.2)
                .collect(Collectors.toList());
        System.out.println(filteredList);

        //второй способ создания стрима: метод of класса Stream
        Stream<Student> studentStream = Stream.of(st1, st2, st3, st4);
        studentStream.filter(e -> e.getAge() > 20 && e.getAvgGrade() < 7.2)
                .collect(Collectors.toSet());
    }
}

