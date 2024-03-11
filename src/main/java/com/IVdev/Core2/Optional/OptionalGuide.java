package com.IVdev.Core2.Optional;

/*
Можно воспринимать Optional, как некую коробку, обертку, в которую кладется какой-либо объект.
Optional всего лишь контейнер: он может содержать объект некоторого типа <Т>, а может быть пустым
*/

import java.util.Optional;

//Сучай работы с репозиторием данных
public class OptionalGuide {
    private static PersonRepository personRepository;

    public OptionalGuide(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    //найти пользователя в базе данных по идентификатору, вывести на консоль длину имени пользователя
//    final Optional<Person> optPerson = personRepository.findById(1L);
//    if (optPerson.isPresent()) {
//        final Person person = optPerson.get();
//        final String firstName = person.getFirstName();
//        if (firstName != null) {
//            System.out.println("Длина твоего имени: " + firstName.length());
//        }
//    }

    public static void main(String[] args) {
        OptionalGuide optionalGuide = new OptionalGuide(personRepository);
        optionalGuide.calculatePerson();
    }

    public void calculatePerson() {
        final Person person = personRepository.findById(1L);
        if (person != null) {
            final String firstName = person.getFirstName();
            if (firstName != null) {
                System.out.println("Длина твоего имени: " + firstName.length());
            }
        }
    }
}
