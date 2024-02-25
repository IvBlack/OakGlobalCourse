package com.IVdev.Core2.functionaljava;

import java.util.List;

import static com.IVdev.Core2.functionaljava.Main.Gender.*;

public class Main {
    public static void main(String[] args) {
        List<Person> persons = List.of(
            new Person("John", MALE),
            new Person("Maria", FEMALE),
            new Person("Aisha", FEMALE),
            new Person("Alex", MALE),
            new Person("Alice", FEMALE)
        );
    }

    static class Person {
        private final String name;
        private final Gender gender;

        Person(String name, Gender gender) {
            this.name = name;
            this.gender = gender;
        }
    }

    enum  Gender { MALE, FEMALE }
}
