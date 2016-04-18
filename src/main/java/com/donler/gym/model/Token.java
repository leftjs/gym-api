package com.donler.gym.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.util.Date;

/**
 * Created by jason on 4/13/16.
 */
@Entity
@JsonIgnoreProperties
public class Token {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  public Date getExpiredTime() {
    return expiredTime;
  }

  public void setExpiredTime(Date expiredTime) {
    this.expiredTime = expiredTime;
  }

  /**
   * token的过期时间
   */
  @Temporal(TemporalType.TIMESTAMP)
  private Date expiredTime;
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

  public Token(Date expiredTime, Long userId, String token) {
    this.expiredTime = expiredTime;
    this.userId = userId;
    this.token = token;
  }
}
