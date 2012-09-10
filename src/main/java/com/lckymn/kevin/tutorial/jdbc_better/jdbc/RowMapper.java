/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.jdbc;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public interface RowMapper<T>
{
  T map(ResultSet resultSet) throws SQLException;
}
