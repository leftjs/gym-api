package com.donler.gym.expection;

/**
 * Created by jason on 4/13/16.
 */
public class DataFormatException extends RuntimeException {

  public DataFormatException() {
  }

  public DataFormatException(String message) {
    super(message);
  }

  public DataFormatException(String message, Throwable cause) {
    super(message, cause);
  }

  public DataFormatException(Throwable cause) {
    super(cause);
  }

  public DataFormatException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
