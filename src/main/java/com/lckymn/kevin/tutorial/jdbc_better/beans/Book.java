/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.beans;

import java.util.Date;

/**
 * @author Lee, SeongHyun (Kevin)
 * @version 0.0.1 (2011-09-04)
 */
public class Book
{
  private Long id;
  private String title;
  private String authours;
  private String edition;
  private String isbn10;
  private String isbn13;
  private String publisher;
  private Date publishingDate;

  public Book()
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

  public String getTitle()
  {
    return title;
  }

  public void setTitle(final String title)
  {
    this.title = title;
  }

  public String getAuthours()
  {
    return authours;
  }

  public void setAuthours(final String authours)
  {
    this.authours = authours;
  }

  public String getEdition()
  {
    return edition;
  }

  public void setEdition(final String edition)
  {
    this.edition = edition;
  }

  public String getIsbn10()
  {
    return isbn10;
  }

  public void setIsbn10(final String isbn10)
  {
    this.isbn10 = isbn10;
  }

  public String getIsbn13()
  {
    return isbn13;
  }

  public void setIsbn13(final String isbn13)
  {
    this.isbn13 = isbn13;
  }

  public String getPublisher()
  {
    return publisher;
  }

  public void setPublisher(final String publisher)
  {
    this.publisher = publisher;
  }

  public Date getPublishingDate()
  {
    return publishingDate;
  }

  public void setPublishingDate(final Date publishingDate)
  {
    this.publishingDate = publishingDate;
  }

  @Override
  public String toString()
  {
    /* @formatter:off */
    return new StringBuilder("Book [")
        .append("id=")
        .append(id)
        .append(", title=")
        .append(title)
        .append(", authours=")
        .append(authours)
        .append(", edition=")
        .append(edition)
        .append(", isbn10=")
        .append(isbn10)
        .append(", isbn13=")
        .append(isbn13)
        .append(", publisher=")
        .append(publisher)
        .append(", publishingDate=")
        .append(publishingDate)
        .append("]")
        .toString();
    /* @formatter:on */
  }
}
