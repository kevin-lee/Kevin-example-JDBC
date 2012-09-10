/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.exception;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public class DataAccessException extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public DataAccessException()
  {
  }

  public DataAccessException(final String message, final Throwable cause)
  {
    super(message, cause);
  }

  public DataAccessException(final String message)
  {
    super(message);
  }

  public DataAccessException(final Throwable cause)
  {
    super(cause);
  }
}
