package com.test.entity;

import org.hibernate.envers.Audited;
import org.hibernate.validator.constraints.NotEmpty;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

@Entity
@Table(name = "person")
@Audited
public class Person implements Serializable
{
  private static final long serialVersionUID = 1L;
  private static Map<String, String> cityMap = new HashMap<String, String>();
  private static Map<String, String> genderOptions = new HashMap<String, String>();
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "person_id")
  private int pid;
  @Size(min = 5, max = 20)
  @Column(name = "username")
  private String username;
  @Size(min = 8, max = 15)
  @Column(name = "password")
  private String password;
  @Min(18)
  @Max(100)
  @Column(name = "age")
  private int age;
  @NotNull
  @Column(name = "gender")
  private String gender;
  @NotEmpty
  @Column(name = "city")
  private String city;

  @OneToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
  @JoinColumn(name = "contact_id")
  private Contact contact;

  public static Map<String, String> getPersonMap()
  {
    if (cityMap.size() == 0)
    {
      cityMap.put("Varanasi", "Varanasi");
      cityMap.put("Allahabad", "Allahabad");
      cityMap.put("Ghaziabad", "Ghaziabad");
      cityMap.put("Noida", "Noida");
    }
    return cityMap;
  }

  public static Map<String, String> getGenderOptions()
  {
    if (genderOptions.size() == 0)
    {
      genderOptions.put("M", "Male");
      genderOptions.put("F", "Female");
    }
    return genderOptions;
  }

  public int getAge()
  {
    return age;
  }

  public void setAge(int age)
  {
    this.age = age;
  }

  public int getPid()
  {
    return pid;
  }

  public void setPid(int pid)
  {
    this.pid = pid;
  }

  public String getGender()
  {
    return gender;
  }

  public void setGender(String gender)
  {
    this.gender = gender;
  }

  public String getUsername()
  {
    return username;
  }

  public void setUsername(String username)
  {
    this.username = username;
  }

  public String getPassword()
  {
    return password;
  }

  public void setPassword(String password)
  {
    this.password = password;
  }

  public String getCity()
  {
    return city;
  }

  public void setCity(String city)
  {
    this.city = city;
  }

  public Contact getContact()
  {
    return contact;
  }

  public void setContact(Contact contact)
  {
    this.contact = contact;
  }
}
