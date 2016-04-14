package com.donler.gym.expection;

/**
 * Created by jason on 4/14/16.
 */
public class AttrValidateException extends RuntimeException {
  public AttrValidateException() {
  }

  public AttrValidateException(String message) {
    super(message);
  }

  public AttrValidateException(String message, Throwable cause) {
    super(message, cause);
  }

  public AttrValidateException(Throwable cause) {
    super(cause);
  }

  public AttrValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
