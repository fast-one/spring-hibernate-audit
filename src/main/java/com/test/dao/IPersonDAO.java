package com.test.dao;
import java.util.List;
import java.util.Map;

import com.test.entity.Person;
public interface IPersonDAO {
    List<Person> getAllPersons();
    Person getPersonById(int pid);
    boolean addPerson(Person person);
    void updatePerson(Person person);
    void deletePerson(int pid);
    boolean personExists(String username);
    Map<Integer, Person> findRevisions(Long pid);
}
 