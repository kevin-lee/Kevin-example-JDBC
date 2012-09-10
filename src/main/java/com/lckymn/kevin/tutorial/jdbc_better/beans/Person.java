/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.beans;

import java.util.Date;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public class Person
{
  private Long id;

  private String surname;

  private String givenName;

  private Address address;

  private Date birthday;

  public Person()
  {
  }

  public Long getId()
  {
    return id;
  }

  public void setId(final Long id)
  {
    this.id = id;
  }

  public String getSurname()
  {
    return surname;
  }

  public void setSurname(final String surname)
  {
    this.surname = surname;
  }

  public String getGivenName()
  {
    return givenName;
  }

  public void setGivenName(final String givenName)
  {
    this.givenName = givenName;
  }

  public Address getAddress()
  {
    return address;
  }

  public void setAddress(final Address address)
  {
    this.address = address;
  }

  public Date getBirthday()
  {
    return birthday;
  }

  public void setBirthday(final Date birthday)
  {
    this.birthday = birthday;
  }

  @Override
  public String toString()
  {
    /* @formatter:off */
    return new StringBuilder("Person [")
        .append("id=")
        .append(id)
        .append(", surname=")
        .append(surname)
        .append(", givenName=")
        .append(givenName)
        .append(", address=")
        .append(address)
        .append(", birthday=")
        .append(birthday)
        .append("]")
        .toString();
    /* @formatter:on */
  }
}
