package com.IVdev.Core1.switchCases;

import org.json.simple.JSONObject;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/*
Паттерн-матчинг для switch наконец-то был финализирован в java 21 и стал стабильной конструкцией языка.
Он появился в Java 17 и был в состоянии preview четыре релиза: 17, 18, 19 и 20.
Pattern matching позволяет разработчикам использовать шаблоны в метках кейсов,
что упрощает сопоставление и извлечение компонентов из объектов.
Это устраняет необходимость в приведении в действие и повторяющихся проверках instanceof, что приводит к более чистому и эффективному коду.
*/
public class Java21UseCases {
    public static void main(String[] args) {

    }

    //Подобно instanceof в условии if, регистр switch теперь может проверять
    //свое значение по типу и создает case-scoped переменную:
    static String matchingTypeValue(Object anyValue) {
        return switch (anyValue) {
            case String str      -> str;
            case JSONObject json -> json.toJSONString();
            case BigDecimal bd   -> bd.toEngineeringString();
            case Integer i       -> Integer.toString(i);
            case LocalDate ld    -> ld.format(DateTimeFormatter.ISO_LOCAL_DATE);
            default              -> "n/a";
        };
    }

    private void complexObject() {
        System.out.println("/---------------------------------------------");
        Object[] vehicles = new Object[0];

        for (Object v : vehicles) {
            if (v instanceof Car) {
                Car car = (Car) v;
                //car logic
            } else if (v instanceof Scooter) {
                Scooter scooter = (Scooter) v;
                //scooter logic
            } else if (v instanceof Jeep) {
                Jeep jeep = (Jeep) v;
                //jeep logic
            }
        }

        /*
        код выше может быть переписан, используя pattern matching,
        упрощает код и устраняет необходимость в явном приведении:

            for (Object v : vehicles) {
                return switch (v) {
                    case Car car -> {
                        //car logic
                    }
                    case Scooter scooter -> {
                        //scooter logic
                    }
                    case Jeep jeep -> {
                        //jeep logic
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + v);
                };
            }
        */
        System.out.println("/----------------------------------------------------");
    }

    private  void nullCases(String s) {
        if(s == null) {
            System.out.println("No message available!");
        }
        switch (s) {
            case "Hello", "Hi" -> System.out.println("Greetings");
            case "Bye" -> System.out.println("Goodbye!");
            default -> System.out.println("Same to u!");
        }

        /*
        Java 21 вводит новую обработку нулевого кейса.
        Приведенный выше код можно переписать следующим образом:
        */
        switch (s) {
            case null          -> System.out.println("No messages available!");
            case "Hello", "Hi" -> System.out.println("Hello there!");
            case "Bye"         -> System.out.println("Goodbye!");
            default            -> System.out.println("Same to u!");
        }
        System.out.println("/-------------------------------------------------------");
    }

    /*
    Можем упростить наш код, используя guard, позволяя предложениям ‘when’
    в блоках switch указывать guard для шаблонных меток кейсов, избегая дополнительных if:
    */
    private void withGuards(String response) {
        switch (response) {
            case null -> System.out.println("No messages available!");
            case String s when s.equalsIgnoreCase("MAYBE") -> {
                System.out.println("Pls, decide!");
            }
            case String s when s.equalsIgnoreCase("EXIT") -> {
                System.out.println("Exit, pls!");
            }
            default -> System.out.println("Pls, retry!");
        }
    }


}
