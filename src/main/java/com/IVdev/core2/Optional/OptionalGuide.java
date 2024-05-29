package com.IVdev.core2.Optional;

/*
Можно воспринимать Optional, как некую коробку, обертку, в которую кладется какой-либо объект.
Optional всего лишь контейнер: он может содержать объект некоторого типа <Т>, а может быть пустым.
(c)DevMark
*/

import java.util.Objects;
import java.util.Optional;

//Случай работы с репозиторием данных
public class OptionalGuide {

    public static void main(String[] args) {

        //что есть Optional-контейнер по сути своей
        Optional<Object> empty = Optional.empty();
        System.out.println(empty.isPresent()); //false
        System.out.println(empty.isEmpty()); //true

        System.out.println("//----------------ofNullable-------------------");
        Optional<String> hello = Optional.ofNullable("hello");
        System.out.println(hello.isPresent());
        System.out.println(hello.isEmpty());

        System.out.println("//-----------------orElse------------------");
        System.out.println(hello.orElse("world"));

        System.out.println("//-----------------ifPresent------------------");
        //ifPresent
        hello.ifPresent(System.out::println);

        System.out.println("//---------------ifPresentOrElse--------------------");
        //ifPresentOrElse
        Optional<String> ifPresent = Optional.empty();
        ifPresent.ifPresentOrElse(System.out::println, () -> System.out.println("world"));
    }


}
