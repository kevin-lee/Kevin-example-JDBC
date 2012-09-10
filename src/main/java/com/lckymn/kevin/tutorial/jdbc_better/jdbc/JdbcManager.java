/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.jdbc;

import java.util.List;

import com.lckymn.kevin.tutorial.jdbc_better.exception.DataAccessException;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public interface JdbcManager
{
  <T> List<T> select(String sql, RowMapper<T> rowMapper, Object... parameters) throws DataAccessException;

  long insertAndGetId(final String sql, final Object... parameters) throws DataAccessException;

  int update(final String sql, final Object... parameters) throws DataAccessException;
}
