package com.joaquin.steps;

import com.joaquin.entities.Person;
import org.springframework.batch.item.ItemProcessor;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class PersonItemProcessor implements ItemProcessor<Person, Person> {

    @Override
    public Person process(Person person) throws Exception {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        LocalDateTime date = LocalDateTime.now();

        person.setCreateAt(formatter.format(date));

        return person;
    }
}
