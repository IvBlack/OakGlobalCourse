package com.IVdev.Core2.functionaljava;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

import static com.IVdev.Core2.functionaljava.Main.Gender.*;

public class Main {

    public static void main(String[] args) {
        List<Person> people = List.of(
                new Person("John", MALE),
                new Person("Maria", FEMALE),
                new Person("Aisha", FEMALE),
                new Person("Alex", MALE),
                new Person("Alice", FEMALE)
        );

        System.out.println("//Imperative----------------------------------------------");
        List<Person> females = new ArrayList<>();
        for (Person person : people) {
            if (FEMALE.equals(person.gender)) {
                females.add(person);
//                System.out.println(person);
            }
        }

        for (Person female : females) {
            System.out.println(female);
        }

        Predicate<Person> personPredicate = person -> FEMALE.equals(person.gender);

        System.out.println("//Declarative----------------------------------------------");
        people.stream()
                .filter(personPredicate)
                .toList()
                .forEach(System.out::println);
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", gender=" + gender +
                    '}';
        }
    }

    enum  Gender { MALE, FEMALE }
}

