package com.donler.gym.model;

import org.springframework.http.HttpStatus;

/**
 * Created by jason on 4/13/16.
 */
public class RestErrorInfo {
  private final String errorName;
  private final String errorMsg;
  private final HttpStatus errorStatus;
  private final int errorCode;

  public int getErrorCode() {
    return errorCode;
  }

  public String getErrorName() {
    return errorName;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public HttpStatus getErrorStatus() {
    return errorStatus;
  }

  public RestErrorInfo(String errorName, String errorMsg, HttpStatus errorStatus) {

    this.errorName = errorName;
    this.errorMsg = errorMsg;
    this.errorStatus = errorStatus;
    this.errorCode = errorStatus.value();
  }


}
