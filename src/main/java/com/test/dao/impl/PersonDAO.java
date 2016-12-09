package com.test.dao.impl;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.transaction.Transactional;

import com.test.dao.IContactDAO;
import com.test.dao.IPersonDAO;
import com.test.entity.Contact;
import org.hibernate.envers.AuditReader;
import org.hibernate.envers.AuditReaderFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import com.test.entity.Person;
@Transactional
@Repository
public class PersonDAO implements IPersonDAO
{
	@Autowired
	private HibernateTemplate  hibernateTemplate;

	@Autowired
	private IContactDAO contactDAO;

	@Override
	public Person getPersonById(int pid) {
		return hibernateTemplate.get(Person.class, pid);
	}
	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getAllPersons() {
		String hql = "FROM Person as p ORDER BY p.pid";
		return (List<Person>) hibernateTemplate.find(hql);
	}	
	@Override
	public boolean addPerson(Person person) {
		hibernateTemplate.save(person);
		return false;
	}
	@Override
	public void updatePerson(Person person) {
		Person p = getPersonById(person.getPid());
		p.setUsername(person.getUsername());
		p.setPassword(person.getPassword());
		p.setAge(person.getAge());
		p.setGender(person.getGender());
		p.setCity(person.getCity());
		Contact contact = p.getContact();
		contact.setEmailAddress(person.getContact().getEmailAddress());
		contact.setPhoneNumber(person.getContact().getPhoneNumber());
		hibernateTemplate.update(p);
	}
	@Override
	public void deletePerson(int pid) {
		hibernateTemplate.delete(getPersonById(pid));
	}
	@SuppressWarnings("unchecked")
	@Override
	public boolean personExists(String username) {
		String hql = "FROM Person as p WHERE p.username = ?";
		List<Person> persons = (List<Person>) hibernateTemplate.find(hql, username);
		return persons.size() > 0 ? true : false;
	}

	@Override
	@org.springframework.transaction.annotation.Transactional
	public Map<Integer, Person> findRevisions(Long pid)
	{
		Map<Integer, Person> tmp = new HashMap<Integer, Person>();
    AuditReader reader = AuditReaderFactory.get(hibernateTemplate.getSessionFactory().getCurrentSession());
		Contact c = contactDAO.getContactById(getPersonById(pid.intValue()).getContact().getContactId());

		List<Number> revisions = reader.getRevisions(Contact.class, new Integer(c.getContactId()));
    for (Number n : revisions) {
	    Person person = reader.find(Person.class, new Integer(pid.intValue()), n);
	    person.getContact().toString();
	    tmp.put(n.intValue(), person);
    }
		return tmp;
	}
}
