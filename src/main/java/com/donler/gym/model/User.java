package com.donler.gym.model;


import com.donler.gym.util.MD5Utils;
import com.donler.gym.util.NullCheckUtils;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.Length;
import org.hibernate.validator.constraints.NotBlank;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

/**
 * Created by jason on 4/13/16.
 */
@Entity
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class User {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "用户名不能为空")
  @Length(min = 5, message = "用户名至少需要5个字符")
  @Column(unique = true)
  private String username;

  @NotNull(message = "密码不能为空")
  @Length(min = 5, message = "密码至少需要5个字符")
//  @Pattern(regexp="^(?![0-9]+$)(?![a-zA-Z]+$)[0-9A-Za-z]{5,10}$",message="密码必须是5~10位数字和字母的组合")
  private String password;

//  @NotNull(message = "姓名不能为空")
  @NotBlank(message="姓名不能为空或者空串")
  @Length(min = 3, message = "姓名至少需要3个字符")
  @Column(unique = false)
  private String name;

//  @NotNull(message = "请输入邮箱")
  @Email(message = "请填入正确的邮箱")
  @Column(unique = true)
  private String email;

  //  @NotNull(message = "请输入电话号码")
//  @Pattern(regexp = "^(0|86|17951)?(13[0-9]|15[012356789]|17[678]|18[0-9]|14[57])[0-9]{8}$",message = "手机号码不正确")
  @Pattern(regexp = "^(1)\\d{10}$",message = "手机号码不正确")
  @Column(unique = true)
  private String phoneNumber;


  private Long tokenId;




  public User(String username, String password, String name, String email, String phoneNumber) {
    this.username = username;
    /**
     * 强制使用hook方法
     */
    setPassword(password);
    this.name = name;
    this.email = email;
    this.phoneNumber = phoneNumber;
  }

  public User(String username, String password, String name) {
    this.username = username;
    /**
     * 强制使用hook方法
     */
    setPassword(password);
    this.name = name;
  }

  public User() {
  }

  public Long getId() {

    return id;
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


  /**
   * hook 方法
   * @param password
   */
  public void setPassword(String password) {

    if (NullCheckUtils.isNullOrEmpty(password)) {
      this.password = null;
    } else {
      this.password = MD5Utils.md5Encode(password);
    }
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {


    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public Long getTokenId() {
    return tokenId;
  }

  public void setTokenId(Long tokenId) {
    this.tokenId = tokenId;
  }

  @Override
  public String toString() {
    return "User{" +
        "id=" + id +
        ", username='" + username + '\'' +
        ", password='" + password + '\'' +
        ", name='" + name + '\'' +
        ", email='" + email + '\'' +
        ", phoneNumber='" + phoneNumber + '\'' +
        '}';
  }
}
