package com.IVdev.Core2.StreamAPI;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class ReduceStreamClass {

    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(8);
        list.add(5);
        list.add(4);
        list.add(3);
        list.add(2);
        list.add(6);

        //лямбда с двумя параметрами
        //accumulator накапливает значение по итерации elem
        //метод get() обязателен, т.к. reduce возращает Optional
        int result = list.stream().reduce((accumulator, elem) 
                -> accumulator*elem).get() ;
        System.out.println(result);

        // 8, 5, 4, 3, 2, 6
        //accumulator = 8   40  160    480  .....  
        //elem =        5   4   3      2
        System.out.println("______________________________________________________ \n");


        /* 
        Ситуации, когда нам возвращается null
        Optional может содержать null, это как обертка над нашим значением.
        isPresent позволяет проверить, возвращается ли null без падения на NoSuchElemenrException
        такое происходит, когда после фильтрации в стриме не остается элементов и reduce() пытается взять первый:
        */
        
        List<Integer> list100 = new ArrayList<>();
        Optional<Integer> o = list100.stream().reduce((accumulator, elem) 
                -> accumulator*elem);
        if(o.isPresent()) {
            System.out.println(o.get());
        } else {
            System.out.println("o is empty.");
        }
        System.out.println("______________________________________________________ \n");


        //метод reduce() с начальным параметром, Optional + метод get() не требуется
        //т.к. уже есть минимум значение аккумулятора
        int result2 = list.stream().reduce(1, (accumulator, elem)
                -> accumulator*elem);
        System.out.println(result2);

        // 8, 5, 4, 3, 2, 6
        //accumulator = 1   8  40    160  192    ...
        //elem =        8   5   4    3   2
        System.out.println("______________________________________________________ \n");


        //стрим с конкатенацией всех его элементов
        List<String> list3 = new ArrayList<>();
        list3.add("privet");
        list3.add("kak dela");
        list3.add("ok");
        list3.add("poka");

        list3.stream().reduce((a, e) -> a + " " + e).get();
        System.out.println(list3);

    } 
}
