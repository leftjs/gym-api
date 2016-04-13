package com.donler.gym.model;

/**
 * Created by jason on 4/13/16.
 */
public class RestErrorInfo {
  private final String errorName;
  private final String errorMsg;

  public String getErrorName() {
    return errorName;
  }

  public String getErrorMsg() {
    return errorMsg;
  }

  public RestErrorInfo(String errorName, String errorMsg) {

    this.errorName = errorName;
    this.errorMsg = errorMsg;
  }
}
