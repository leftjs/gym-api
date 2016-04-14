package com.donler.gym.model;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by jason on 4/13/16.
 */
@Component
@ConfigurationProperties(prefix = "config")
public class Config {
  private String appSecret;
  private String tokenExpiredTime;

  public String getTokenExpiredTime() {
    return tokenExpiredTime;
  }

  public void setTokenExpiredTime(String tokenExpiredTime) {
    this.tokenExpiredTime = tokenExpiredTime;
  }

  public String getAppSecret() {
    return appSecret;
  }

  public void setAppSecret(String appSecret) {
    this.appSecret = appSecret;
  }


}
