package com.IVdev.core2.StreamAPIbyTregulov;

import java.util.*;
import java.util.stream.Collectors;

public class MapStreamClass {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        list.add("privet");
        list.add("kak dela?");
        list.add("ok");
        list.add("poka");

        //для каждого i установи значение длины элемента коллекции, старый способ
//        for(int i=0; i<list.size(); i++) {
//            list.set(i, String.valueOf(list.get(i).length()));
//        }


        /*
        map сопоставляет каждому элементу ту логику, кот в нем прописана, новый способ
        принимает интерфейс Function: на входе string, на выходе - int
        collect преобразует stream обратно в коллекцию
        */
        List<Integer> list2 = list.stream().map(elem -> elem.length())
                .collect(Collectors.toList());
//        System.out.println(list);


        //stream из массива со statement внутри метода map()
        int[] arr = {4, 6, 2, 3, 1};
        arr = Arrays.stream(arr).map(elem
                -> {
            if (elem % 3 == 0) {
                elem = elem / 3;
            }
            return elem;
        }).toArray();
//        System.out.println(Arrays.toString(arr));


        //stream над TreeSet
        Set<String> set = new TreeSet<>();
        set.add("privet");
        set.add("kak dela");
        set.add("ok");
        set.add("poka");
        System.out.println(set); //отсортирован

        //прогон в другой Set, преобразование в другой List
        Set<Integer> set2 = set.stream().map(e -> e.length()).collect(Collectors.toSet());
        List<Integer> list3 = set.stream().map(e -> e.length()).collect(Collectors.toList());
        System.out.println(list3);
    }
}
