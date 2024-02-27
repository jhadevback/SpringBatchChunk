package com.joaquin.persistence;

import com.joaquin.entities.Person;
import org.springframework.data.repository.CrudRepository;

public interface IPersonDAO extends CrudRepository<Person, Long> {
}
