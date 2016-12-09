package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.entity.Person;

public interface IPersonService {
     List<Person> getAllPersons();
     Person getPersonById(int pid);
     boolean addPerson(Person person);
     void updatePerson(Person person);
     void deletePerson(int pid);

     Map<Integer, Person> findRevisions(Long pid);
}
