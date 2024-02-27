package com.joaquin.steps;

import com.joaquin.entities.Person;
import com.joaquin.service.IPersonService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.batch.item.ItemWriter;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

@Slf4j
public class PersonItemWriter implements ItemWriter<Person> {

    @Autowired
    private IPersonService personService;

    @Override
    public void write(List<? extends Person> list) throws Exception {

        //list.forEach(Person::toString);
        personService.saveAll((List<Person>) list);

    }
}
