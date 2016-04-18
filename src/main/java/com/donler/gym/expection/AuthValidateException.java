package com.donler.gym.expection;

/**
 * 权限异常
 *
 * Created by jason on 4/18/16.
 */
public class AuthValidateException extends RuntimeException {

  public AuthValidateException() {
  }

  public AuthValidateException(String message) {
    super(message);
  }

  public AuthValidateException(String message, Throwable cause) {
    super(message, cause);
  }

  public AuthValidateException(Throwable cause) {
    super(cause);
  }

  public AuthValidateException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
