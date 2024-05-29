package com.IVdev.core2.StreamAPIbyTregulov;
//package com.IVdev.Core2.StreamAPI;
//
//import java.util.Comparator;
//import java.util.List;
//
//public class BasicExplanation {
//    public static void main(String[] args) {
//
//        /*
//        Java 8 привнесла удобный лаконичный стиль работы с коллекциями в виде стримов.
//        Метод stream() по умолчанию добавлен во все коллекции, это последовательность элементов.
//        Огромное количество промежуточных методов, модифицирующих поток любым образом
//        */
//        List<String> strings = List.of("11", "22", "33","44","55","66");
//        strings.stream()
//                .map(string -> string + string)
//                .map(Integer::valueOf)
//                .filter(value -> value % 2 == 0)
//                .sorted()
//                .skip(1)
//                .limit(2)
//                .forEach(System.out::println);
//
//        for (String string : strings) {
//            String value = string + string;
//            Integer intValue = Integer.valueOf(value);
//            if (intValue % 2 == 0) {
//                System.out.println(intValue);
//            }
//        }
//
//        System.out.println("***********************************");
//
//        /*
//        В динамике о том, как из методов функциональных интерфейсов получается lambda-выражение:
//        К лямбадам можно последовательно прийти от обычных функциональных интерфейсов.
//        По сути это просто функция, которую мы переопределяем у нашего ф.интерфейса.
//        Как это происходит, по шагам:
//            1. убираем модификатор доступа для метода
//            2. уходит тип возвращаемого значения, он ясен из контекста после return
//            3. уходит имя метода, т.к. он является единственным в функ.интерфейсе.
//        Подставим получившуюся конструкцию вместо вызова объекта компаратора, немного отрефакторим и компилятор пропустит этот код
//        */
//
//        Comparator<Integer> comparator = Integer::compare;
//        System.out.println(comparator.compare(25, 200));
//    }
//
//    private static class IntegerComparator implements Comparator<Integer> {
//        @Override
//        public int compare(Integer o1, Integer o2) {
//            return Integer.compare(o1, o2);
//        }
//
//        /*
//            вставим "урезанный" код ниже в строку 45 вместо объявления new IntegerComparator(), запустим.
//
//            (Integer o1, Integer o2) -> {
//              return Integer.compare(o1, o2);
//            }
//
//            далее редуцируется до:
//            (o1, o2) -> Integer.compare(o1, o2);
//
//            и далее еще до:
//            Integer::compare;
//        */
//    }
//}
