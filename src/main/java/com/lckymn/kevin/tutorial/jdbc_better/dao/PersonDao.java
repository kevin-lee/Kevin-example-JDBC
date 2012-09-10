/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.dao;

import java.util.List;

import com.lckymn.kevin.tutorial.jdbc_better.beans.Person;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public interface PersonDao
{
  Person find(Long id);

  List<Person> findPeopleByState(String state);

  List<Person> getAllPeople();

}
