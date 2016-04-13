package com.donler.gym.model;


import javax.persistence.*;

/**
 * Created by jason on 4/13/16.
 */
@Entity
public class Account {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;
  /**
   * 登录名
   */
  private String username;
  private String password;

  public Account(String username, String password) {
    this.username = username;
    this.password = password;
  }

  /**
   * 为内存数据库提供无参构造方法
   */
  public Account() {
  }

  @OneToOne(optional = true)
  @JoinColumn(name = "user_id", unique = true)
  private User user;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }

  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }

  @Override
  public String toString() {
    return "Account{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", user=" + user +
        '}';
  }

  public User getUser() {
    return user;
  }

  public void setUser(User user) {
    this.user = user;
  }
}
