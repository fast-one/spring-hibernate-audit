package com.test.entity;

import org.hibernate.envers.Audited;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by RKasturi on 12/8/2016.
 */
@Entity
@Audited
@Table(name = "contact")
public class Contact implements Serializable
{
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "contact_id")
  private int contactId;

  @Column(name = "email_address")
  private String emailAddress;

  @Column(name = "phone_number")
  private String phoneNumber;
//  private List<Address> addressList = new ArrayList<Address>();


  public int getContactId()
  {
    return contactId;
  }
                                                                                                                                                                public void setContactId(int contactId)
  {
    this.contactId = contactId;
  }


  public String getEmailAddress()
  {
    return emailAddress;
  }

  public void setEmailAddress(String emailAddress)
  {
    this.emailAddress = emailAddress;
  }

  public String getPhoneNumber()
  {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber)
  {
    this.phoneNumber = phoneNumber;
  }

//  @OneToMany(fetch = FetchType.LAZY, cascade= CascadeType.ALL )
//  public List<Address> getAddressList()
//  {
//    return addressList;
//  }
//
//  public void setAddressList(List<Address> addressList)
//  {
//    this.addressList = addressList;
//  }

}
