package com.donler.gym.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;

/**
 * 合同
 *
 * Created by jason on 4/15/16.
 */
@Entity
@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class Company {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;


  @ApiModelProperty(example = "未来健身俱乐部-上海厚康体育投资有限公司",notes = "公司名称")
  @NotNull(message = "公司名称不能为空")
  private String name;

  @ApiModelProperty(example = "021-67600001", notes = "公司号码")
  @NotNull(message = "公司号码不能为空")
  private String phoneNumber;


  @ApiModelProperty(example = "membership@welikegyms.com", notes = "公司邮箱")
  @NotNull(message = "公司邮箱不能为空")
  private String email;

  @ApiModelProperty(notes = "经营地址", example = "上海市浦东新区杨高南路739号陆家嘴金融世纪广场3座2楼")
  @NotNull(message = "经营地址不能为空")
  private String address;


  @ApiModelProperty(notes = "法人代表",example = "Jason")
  @NotNull(message = "法人代表")
  private String incorporator;


  @ApiModelProperty(notes = "营业执照注册号", example = "1284057999")
  private String licenseCode;


  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }

  public String getIncorporator() {
    return incorporator;
  }

  public void setIncorporator(String incorporator) {
    this.incorporator = incorporator;
  }

  public String getLicenseCode() {
    return licenseCode;
  }

  public void setLicenseCode(String licenseCode) {
    this.licenseCode = licenseCode;
  }

  public Company() {

  }

  public Company(String name, String phoneNumber, String email, String address, String incorporator, String licenseCode) {

    this.name = name;
    this.phoneNumber = phoneNumber;
    this.email = email;
    this.address = address;
    this.incorporator = incorporator;
    this.licenseCode = licenseCode;
  }
}
