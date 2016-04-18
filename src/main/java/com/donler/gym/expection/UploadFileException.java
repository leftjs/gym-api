package com.donler.gym.expection;

/**
 * Created by jason on 4/18/16.
 */
public class UploadFileException extends RuntimeException {
  public UploadFileException() {
  }

  public UploadFileException(String message) {
    super(message);
  }

  public UploadFileException(String message, Throwable cause) {
    super(message, cause);
  }

  public UploadFileException(Throwable cause) {
    super(cause);
  }

  public UploadFileException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
    super(message, cause, enableSuppression, writableStackTrace);
  }
}
