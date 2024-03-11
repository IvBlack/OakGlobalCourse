package com.IVdev.Core2.Optional;

import java.util.Map;
import java.util.Optional;

public class PersonRepository {
    private final Map<Long, Person> persons;

    public PersonRepository(Map<Long, Person> persons) {
        this.persons = persons;
    }

    public Person findById(Long id) {
        return persons.get(id);
    }
}
