package com.IVdev.Core2.Optional;

import java.util.Optional;


/*
Можно воспринимать Optional, как некую коробку, обертку, в которую кладется какой-либо объект.
Optional всего лишь контейнер: он может содержать объект некоторого типа <Т>, а может быть пустым
*/
//Сучай работы с репозиторием данных
public class OptionalGuide {
    public static void main(String[] args) {
        System.out.println("//--------------//Spirit of Optional-----------");
        Optional<String> empty = Optional.ofNullable(null);
        System.out.println(empty.isPresent());
        System.out.println(empty.isEmpty());


        System.out.println("//--------------//ifPresent-----------");
        empty
            .map(String::toUpperCase)
            .ifPresent(System.out::println);

        empty.ifPresentOrElse(System.out::println, () -> System.out.println("word"));
    }

    //без использования Optional-----------------------------
//    public void calculatePerson() {
//        PersonRepository personRepository = null;
//        final Person person = personRepository.findById(1L);
//        if (person != null) {
//            final String firstName = person.getFirstName();
//            if (firstName != null) {
//                System.out.println("Длина твоего имени: " + firstName.length());
//            }
//        }

        //c Optional------------------------
//        final Optional<Person> optPerson = Optional.ofNullable(personRepository.findById(1L));
//        if (optPerson.isPresent()) {
//            final Person person2 = optPerson.get();
//            final String firstName = person2.getFirstName();
//            if (firstName != null) {
//                System.out.println("Длина твоего имени: " + firstName.length());
//            }
//        }
//    }
}
