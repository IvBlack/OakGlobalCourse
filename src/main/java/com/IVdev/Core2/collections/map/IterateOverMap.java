package com.IVdev.Core2.collections.map;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class IterateOverMap {
    public static void main(String[] args) {

        //дана map, как пройтись по ней? Есть три способа.
        Map<String, String> map = new HashMap<>();
        map.put("1", "Понедельник");
        map.put("2", "Вторник");
        map.put("3", "Среда");

        //1й способ
        // Map.Entry - описываем пару (ключ - значение) "3=Среда" и т.п.
        // entrySet - возращает множество со значениями карты, т.е. [3=Среда, 2=Вторник, 1=Понедельник]
        for (Map.Entry<String, String> entry : map.entrySet()) {
            System.out.println("ID =  " + entry.getKey() + " День недели = " + entry.getValue());
        }

        System.out.println("***************************************************");

        //2й способ
        // Iterator - интерфейс, для организации цикла для перебора коллекций
        // hasNext - true, если есть еще элементы
        // next - возвращает слудующий элемент
        Iterator<Map.Entry<String, String>> entries = map.entrySet().iterator();
        while (entries.hasNext()) {
            Map.Entry<String, String> entry = entries.next();
            System.out.println("ID = " + entry.getKey() + " День недели = " + entry.getValue());
        }

        System.out.println("***************************************************");

        //3й способ
        // keySet - возвращает множество ключей
        for (String key : map.keySet()) {
            System.out.println("ID = " + key + ", День недели = " +  map.get(key));
        }
    }
}
