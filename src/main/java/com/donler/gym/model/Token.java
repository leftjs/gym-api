package com.donler.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 * Created by jason on 4/13/16.
 */
@Entity
@JsonIgnoreProperties
public class Token {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  /**
   * token的过期时间
   */
  private String expiredTime;
  /**
   * 用户的id
   */
  private Long userId;

  /**
   * token字符串
   */
  private String token;


  public Long getId() {
    return id;
  }

  public String getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(String expiredTime) {
    this.expiredTime = expiredTime;
  }

  public Long getUserId() {
    return userId;
  }

  public void setUserId(Long userId) {
    this.userId = userId;
  }

  public String getToken() {
    return token;
  }

  public void setToken(String token) {
    this.token = token;
  }

  public Token() {
  }

  public Token(String expiredTime, Long userId, String token) {
    setExpiredTime(expiredTime);
    this.userId = userId;
    this.token = token;
  }
}
