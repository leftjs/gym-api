package com.donler.gym.expection;

/**
 * Created by jason on 4/15/16.
 */
public class TokenExpiredException extends RuntimeException {

  public TokenExpiredException() {
  }

  public TokenExpiredException(String message) {
    super(message);
  }

  public TokenExpiredException(String message, Throwable cause) {
    super(message, cause);
  }

  public TokenExpiredException(Throwable cause) {
    super(cause);
  }

  public TokenExpiredException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
