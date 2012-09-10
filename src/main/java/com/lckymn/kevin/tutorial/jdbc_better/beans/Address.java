/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.beans;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public class Address
{
  private String street;
  private String suburb;
  private String state;
  private String country;
  private String postcode;

  public Address()
  {
  }

  public Address(final String street, final String suburb, final String state, final String country, final String postcode)
  {
    this.street = street;
    this.suburb = suburb;
    this.state = state;
    this.country = country;
    this.postcode = postcode;
  }

  public String getStreet()
  {
    return street;
  }

  public void setStreet(final String street)
  {
    this.street = street;
  }

  public String getSuburb()
  {
    return suburb;
  }

  public void setSuburb(final String suburb)
  {
    this.suburb = suburb;
  }

  public String getState()
  {
    return state;
  }

  public void setState(final String state)
  {
    this.state = state;
  }

  public String getCountry()
  {
    return country;
  }

  public void setCountry(final String country)
  {
    this.country = country;
  }

  public String getPostcode()
  {
    return postcode;
  }

  public void setPostcode(final String postcode)
  {
    this.postcode = postcode;
  }

  @Override
  public String toString()
  {
    /* @formatter:off */
    return new StringBuilder("Address [")
        .append("street=")
        .append(street)
        .append(", suburb=")
        .append(suburb)
        .append(", state=")
        .append(state)
        .append(", country=")
        .append(country)
        .append(", postcode=")
        .append(postcode)
        .append("]")
        .toString();
    /* @formatter:on */
  }
}
