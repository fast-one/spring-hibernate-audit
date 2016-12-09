package com.test.service;

import java.util.List;
import java.util.Map;

import com.test.dao.IContactDAO;
import com.test.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.test.dao.IPersonDAO;
import com.test.entity.Person;
import org.springframework.transaction.annotation.Transactional;

@Service
public class PersonService implements IPersonService {
	@Autowired
	private IPersonDAO personDAO;

  @Autowired
  private IContactDAO contactDAO;

	@Override
	public Person getPersonById(int pid) {
		Person obj = personDAO.getPersonById(pid);
		return obj;
	}	
	@Override
	public List<Person> getAllPersons(){
		return personDAO.getAllPersons();
	}

  @Override
	@Transactional
	public synchronized boolean addPerson(Person person){
       if (personDAO.personExists(person.getUsername())) {
    	   return false;
       } else {
    	   personDAO.addPerson(person);
    	   return true;
       }
	}
	@Override
	@Transactional
	public void updatePerson(Person person) {
//		personDAO.updatePerson(person);
    Person p = personDAO.getPersonById(person.getPid());
		Contact contact = person.getContact();
		contact.setContactId(p.getContact().getContactId());
		contactDAO.updateContact(contact);

	}

  @Override
  @Transactional
  public Map<Integer, Person> findRevisions(Long pid)
  {
    return personDAO.findRevisions(pid);
  }

  @Override
	public void deletePerson(int pid) {
		personDAO.deletePerson(pid);
	}
}
