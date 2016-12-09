package com.test.dao;

import com.test.entity.Contact;

/**
 * Created by RKasturi on 12/8/2016.
 */
public interface IContactDAO
{
  Contact getContactById(int cid);

  void updateContact(Contact contact);
}
