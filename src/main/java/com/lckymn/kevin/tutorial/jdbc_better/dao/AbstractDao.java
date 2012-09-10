/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.dao;

import com.lckymn.kevin.tutorial.jdbc_better.jdbc.JdbcManager;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public abstract class AbstractDao
{
  private JdbcManager jdbcManager;

  public AbstractDao(final JdbcManager jdbcManager)
  {
    this.jdbcManager = jdbcManager;
  }

  protected final JdbcManager jdbcManager()
  {
    return jdbcManager;
  }
}
