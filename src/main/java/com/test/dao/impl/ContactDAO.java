package com.test.dao.impl;

import com.test.dao.IContactDAO;
import com.test.entity.Contact;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

/**
 * Created by RKasturi on 12/8/2016.
 */
@Repository
public class ContactDAO implements IContactDAO
{
  @Autowired
  private HibernateTemplate hibernateTemplate;

  @Override
  public Contact getContactById(int cid) {
    return hibernateTemplate.get(Contact.class, cid);
  }

  @Override
  public void updateContact(Contact contact) {
    Contact savedContact = getContactById(contact.getContactId());
    savedContact.setEmailAddress(contact.getEmailAddress());
    savedContact.setPhoneNumber(contact.getPhoneNumber());
    hibernateTemplate.update(savedContact);
  }
}
