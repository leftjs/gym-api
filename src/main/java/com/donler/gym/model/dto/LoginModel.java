package com.donler.gym.model.dto;

import javax.validation.constraints.NotNull;

/**
 * 接受登录信息的实体
 * Created by jason on 4/14/16.
 */
public class LoginModel {
  @NotNull(message = "请传入用户名或者邮箱或者手机号")
  private String loginName;
  @NotNull(message = "请传入登录登录密码")
  private String loginPassword;


  public String getLoginName() {
    return loginName;
  }

  public void setLoginName(String loginName) {
    this.loginName = loginName;
  }

  public String getLoginPassword() {
    return loginPassword;
  }

  public void setLoginPassword(String loginPassword) {
    this.loginPassword = loginPassword;
  }

  public LoginModel() {

  }

  public LoginModel(String loginName, String loginPassword) {

    this.loginName = loginName;
    this.loginPassword = loginPassword;
  }
}
