/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.jdbc.impl;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import javax.sql.DataSource;

import com.lckymn.kevin.tutorial.jdbc_better.exception.DataAccessConnectionFailureException;
import com.lckymn.kevin.tutorial.jdbc_better.exception.DataAccessException;
import com.lckymn.kevin.tutorial.jdbc_better.exception.DataAccessOperationErrorException;
import com.lckymn.kevin.tutorial.jdbc_better.jdbc.JdbcManager;
import com.lckymn.kevin.tutorial.jdbc_better.jdbc.PreparedStatementParameterSetter;
import com.lckymn.kevin.tutorial.jdbc_better.jdbc.RowMapper;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public class JdbcManagerImpl2 implements JdbcManager
{
  // private final DataSource dataSource;
  //
  // public JdbcManagerImpl2(DataSource dataSource, PreparedStatementParameterSetter preparedStatementParameterSetter)
  // {
  // this.dataSource = dataSource;
  // this.preparedStatementParameterSetter = preparedStatementParameterSetter;
  // }

  private final PreparedStatementParameterSetter preparedStatementParameterSetter;

  private String url;
  private String username;
  private String password;

  public JdbcManagerImpl2(final PreparedStatementParameterSetter preparedStatementParameterSetter, final String url,
      final String username, final String password)
  {
    this.preparedStatementParameterSetter = preparedStatementParameterSetter;
    this.url = url;
    this.username = username;
    this.password = password;
  }

  protected final Connection getConnection()
  {
    try
    {
      // return dataSource.getConnection();
      return DriverManager.getConnection(url, username, password);
    }
    catch (final SQLException e)
    {
      throw new DataAccessConnectionFailureException(e);
    }

  }

  private void closeQuietly(final Connection connection, final PreparedStatement statement, final ResultSet resultSet)
  {
    /* @formatter:off */
    if (null != resultSet)
      try { resultSet.close(); }
      catch (final SQLException e) { e.printStackTrace(); }

    if (null != statement)
      try { statement.close(); }
      catch (final SQLException e) { e.printStackTrace(); }

    if (null != connection)
      try { connection.close(); }
      catch (final SQLException e) { e.printStackTrace(); }
    /* @formatter:on */
  }

  private void rollback(final Connection connection)
  {
    if (null != connection)
    {
      try
      {
        connection.rollback();
      }
      catch (final SQLException e)
      {
        e.printStackTrace();
      }
    }
  }

  @Override
  public <T> List<T> select(final String sql, final RowMapper<T> rowMapper, final Object... parameters)
      throws DataAccessException
  {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    final List<T> result = new ArrayList<T>();
    try
    {
      connection = getConnection();
      statement = connection.prepareStatement(sql);
      preparedStatementParameterSetter.setParameters(statement, parameters);
      resultSet = statement.executeQuery();
      while (resultSet.next())
      {
        result.add(rowMapper.map(resultSet));
      }
    }
    catch (final SQLException e)
    {
      throw new DataAccessOperationErrorException(e);
    }
    finally
    {
      closeQuietly(connection, statement, resultSet);
    }
    return result;
  }

  @Override
  public long insertAndGetId(final String sql, final Object... parameters) throws DataAccessException
  {
    Connection connection = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    try
    {
      connection = getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
      preparedStatementParameterSetter.setParameters(statement, parameters);
      final int result = statement.executeUpdate();
      Long id = null;
      if (0 != result)
      {
        resultSet = statement.getGeneratedKeys();
        if (resultSet.next())
        {
          id = resultSet.getLong(1);
        }
      }
      if (null == id)
      {
        throw new DataAccessOperationErrorException("No id is returned");
      }
      connection.commit();
      return id;
    }
    catch (final DataAccessException e)
    {
      rollback(connection);
      throw e;
    }
    catch (final Exception e)
    {
      rollback(connection);
      throw new DataAccessOperationErrorException(e);
    }
    finally
    {
      closeQuietly(connection, statement, resultSet);
    }
  }

  @Override
  public int update(final String sql, final Object... parameters) throws DataAccessException
  {
    Connection connection = null;
    PreparedStatement statement = null;
    final ResultSet resultSet = null;

    try
    {
      connection = getConnection();
      connection.setAutoCommit(false);
      statement = connection.prepareStatement(sql);
      preparedStatementParameterSetter.setParameters(statement, parameters);
      final int result = statement.executeUpdate();
      connection.commit();
      return result;
    }
    catch (final DataAccessException e)
    {
      rollback(connection);
      throw e;
    }
    catch (final Exception e)
    {
      rollback(connection);
      throw new DataAccessOperationErrorException(e);
    }
    finally
    {
      closeQuietly(connection, statement, resultSet);
    }
  }
}
