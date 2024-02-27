package com.joaquin.service;

import com.joaquin.entities.Person;
import java.util.List;

public interface IPersonService {
    Iterable<Person> saveAll(List<Person> personList);

}
