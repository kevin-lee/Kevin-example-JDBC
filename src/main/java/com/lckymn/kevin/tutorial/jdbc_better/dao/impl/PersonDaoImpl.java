/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.dao.impl;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.List;

import com.lckymn.kevin.tutorial.jdbc_better.beans.Address;
import com.lckymn.kevin.tutorial.jdbc_better.beans.Person;
import com.lckymn.kevin.tutorial.jdbc_better.dao.AbstractDao;
import com.lckymn.kevin.tutorial.jdbc_better.dao.PersonDao;
import com.lckymn.kevin.tutorial.jdbc_better.jdbc.JdbcManager;
import com.lckymn.kevin.tutorial.jdbc_better.jdbc.RowMapper;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public class PersonDaoImpl extends AbstractDao implements PersonDao
{
  private static final RowMapper<Person> PERSON_MAPPER = new RowMapper<Person>() {
    @Override
    public Person map(final ResultSet resultSet) throws SQLException
    {
      final Person person = new Person();
      person.setId(resultSet.getLong("person_id"));
      person.setSurname(resultSet.getString("surname"));
      person.setGivenName(resultSet.getString("given_name"));
      /* @formatter:off */
      final Address address =
          new Address(resultSet.getString("street"),
              resultSet.getString("city"),
              resultSet.getString("state"),
              resultSet.getString("country"),
              resultSet.getString("postcode"));
      person.setAddress(address);
      person.setBirthday(new Date(resultSet
                            .getDate("birthday")
                            .getTime()));
      /* @formatter:on */
      return person;
    }
  };

  public PersonDaoImpl(final JdbcManager jdbcManager)
  {
    super(jdbcManager);
  }

  @Override
  public Person find(final Long id)
  {
    final List<Person> result = jdbcManager().select("SELECT * FROM people WHERE person_id = ?", PERSON_MAPPER, id);
    return result.isEmpty() ? null : result.get(0);
  }

  @Override
  public List<Person> findPeopleByState(final String state)
  {
    return jdbcManager().select("SELECT * FROM people WHERE state = ?", PERSON_MAPPER, state);
  }

  @Override
  public List<Person> getAllPeople()
  {
    return jdbcManager().select("SELECT * FROM people", PERSON_MAPPER);
  }
}
