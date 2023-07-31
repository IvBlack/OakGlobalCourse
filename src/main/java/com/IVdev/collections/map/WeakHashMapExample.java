package com.IVdev.collections.map;

import java.util.Map;
import java.util.WeakHashMap;

public class WeakHashMapExample {

/*
WeakHashMap — это подкласс java.util.HashMap, который используется для хранения пар "ключ-значение".
Основное отличие WeakHashMap заключается в том, что он хранит ключи в виде "слабых ссылок" (weak reference),
что означает их уничтожение при отсутствии сильной ссылки на объект.
Это позволяет использовать WeakHashMap для кэширования объектов, которые могут быть уничтожены сборщиком мусора
в случае, если на них не осталось сильных ссылок. Это может подойти для объектов, созданных на основе потребительских
запросов, которые не будут использоваться долгое время и не нужно хранить их в памяти постоянно.
В примере мы создаем объект и добавляем его в WeakHashMap. Затем мы обнуляем ссылку на этот объект и запускаем сборщик мусора.
После этого мы пытаемся получить значение по ключу и должны получить null, так как ключ был удален из WeakHashMap.
*/
    public static void main(String[] args) {
        Map<Object, String> map = new WeakHashMap<>();
        Object key = new Object();
        System.out.println("Value is: " + map.get(key));

        //обнулим ссылку, которая и так ссылается на null
        key = null;

        //запустим GC
        System.gc();

        //подождем сборщик некоторое время
        try{
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        //попробуем получить значение по ключу
        System.out.println("Value is: " + map.get(key));
    }
}