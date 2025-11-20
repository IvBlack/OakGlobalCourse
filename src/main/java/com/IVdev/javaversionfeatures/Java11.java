package com.IVdev.javaversionfeatures;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/*
    Синтаксис var - вместо полного объявления типа.
    Хорошо сокращает код при написании кода на собеседованиях, где нет auto-complete.
    Используется только внутри конструкторов, блоков инициализации, внутри методов.

    Ограничения var:
        - var нужно инициализировать сразу после именования — в одном операторе.
            При этом можно переносить такое объявление переменной на разные строки.
        - Объявлять сразу несколько переменных с помощью var в одном операторе нельзя.
        - Инициализировать var-переменную значением null без явного указания типа тоже нельзя.
        - Значение var-переменной в дальнейшем меняться может, а вот тип — нет.
        - нельзя c помощью var именовать тип: класс, интерфейс или перечисление.

    Не стоит использовать var:
        - Если тип неочевиден из контекста (снижает читаемость): var result = calculateSomething()
        - Для публичных API, где важна явная документация типов.
*/
public class Java11 {
        public static void main(String[] args) {

        var name = "Alice";     // String
        var age = 25;           // int
        var price = 19.99;      // double
        var isAlive = true;     // boolean


        Map<String, Integer> map = new HashMap<>();
        var map2 = new HashMap<>(); // <- лаконичнее

        var set = Set.of("a", "b", "c");

        // использование в цикле
        var nums = List.of(1,2,5,7,8,11,54);
        for(var num : nums) {
            System.out.println(num);
        }

        // использование в try
        try (var reader = new BufferedReader(new FileReader("input.txt"))) {
            String line;
            while ((line  = reader.readLine()) != null) {
                System.out.println(line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
