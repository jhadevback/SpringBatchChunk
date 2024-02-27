package com.joaquin.service;

import com.joaquin.entities.Person;
import com.joaquin.persistence.IPersonDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class PersonServiceImpl implements IPersonService{

    @Autowired
    private IPersonDAO personDAO;
    @Override
    public Iterable<Person> saveAll(List<Person> personList) {
        return personDAO.saveAll(personList);
    }
}
