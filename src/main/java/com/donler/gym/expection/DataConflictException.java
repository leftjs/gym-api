package com.donler.gym.expection;

/**
 * Created by jason on 4/14/16.
 */
public class DataConflictException extends RuntimeException {
  public DataConflictException() {
  }

  public DataConflictException(String message) {
    super(message);
  }

  public DataConflictException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataConflictException(Throwable cause) {
    super(cause);
  }

  public DataConflictException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
