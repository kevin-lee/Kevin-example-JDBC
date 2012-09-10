/**
 *
 */
package com.lckymn.kevin.tutorial.jdbc_better.exception;

/**
 * @author Lee, SeongHyun (Kevin) / <a href="http://blog.lckymn.com">Kevin&#39;s Blog</a>
 * @version 0.0.1 (2011-09-04)
 */
public class DataAccessOperationErrorException extends RuntimeException
{
  private static final long serialVersionUID = 1L;

  public DataAccessOperationErrorException()
  {
  }

  public DataAccessOperationErrorException(final String message, final Throwable cause)
  {
    super(message, cause);
  }

  public DataAccessOperationErrorException(final String message)
  {
    super(message);
  }

  public DataAccessOperationErrorException(final Throwable cause)
  {
    super(cause);
  }
}
