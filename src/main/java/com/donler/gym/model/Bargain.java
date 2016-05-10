package com.donler.gym.model;

import io.swagger.annotations.ApiModelProperty;
import org.hibernate.validator.constraints.Email;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import java.util.Date;

/**
 * 合同
 *
 * Created by jason on 4/15/16.
 */
@Entity
public class Bargain {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @ApiModelProperty(example = "小张",required = true)
  @NotNull(message = "姓名不能为空")
  private String name;

  @ApiModelProperty(example = "lefttjs@gmail.com", required = true)
  @NotNull(message = "邮箱不能为空")
  @Email
  private String email;

  @ApiModelProperty(required = true)
  @NotNull
  @Lob
  private String avatarData;


  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAvatarData() {
    return avatarData;
  }

  public void setAvatarData(String avatarData) {
    this.avatarData = avatarData;
  }

  @ApiModelProperty(example = "男", allowableValues = "男,女",required = true)
  @NotNull(message = "性别不能为空")
  @Pattern(regexp = "^[男,女]$",message = "性别必须是[男,女]")
  private String sex;

  @ApiModelProperty(example = "XiaoZhang",required = false)
  private String spell; // 拼音

  @NotNull(message = "身份证号码不能为空")
  @ApiModelProperty(example = "321000000000000000", required = true)
  private String idCard;

  @ApiModelProperty(example = "18205253786",required = true)
  @NotNull(message = "电话号码不能为空")
  private String phoneNumber;


  @ApiModelProperty(required = true)
  @Temporal(value = TemporalType.DATE)
  @NotNull(message = "生日不能为空")
  private Date birthday = new Date();
  public void setId(Long id) {
    this.id = id;
  }

  @NotNull(message = "地址不能为空")
  @ApiModelProperty(example = "枫林路485号")
  private String address;

  @NotNull(message = "业务期限不能为空")
  @Min(1)
  @ApiModelProperty(example = "3",required = true)
  private int monthCount;


  @NotNull(message = "业务价格不能为空")
  @ApiModelProperty(example = "1000",required = true)
  private int price;

  @NotNull(message = "起始时间不能为空")
  @ApiModelProperty(required = true)
  private Date startDate;


  public String getPdfPath() {
    return pdfPath;
  }

  public void setPdfPath(String pdfPath) {
    this.pdfPath = pdfPath;
  }

  /**
   * 服务端上传pdf后填入的path
   */

  @ApiModelProperty(example = "", notes = "服务端上传pdf后填入的path")
  private String pdfPath;

  private Long salerId;


  public Long getId() {
    return id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getSex() {
    return sex;
  }

  public void setSex(String sex) {
    this.sex = sex;
  }

  public String getSpell() {
    return spell;
  }

  public void setSpell(String spell) {
    this.spell = spell;
  }

  public String getIdCard() {
    return idCard;
  }

  public void setIdCard(String idCard) {
    this.idCard = idCard;
  }

  public String getPhoenNumber() {
    return phoneNumber;
  }

  public void setPhoenNumber(String phoenNumber) {
    this.phoneNumber = phoenNumber;
  }

  public Date getBirthday() {
    return birthday;
  }

  public void setBirthday(Date birthday) {
    this.birthday = birthday;
  }

  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }



  public Long getSalerId() {
    return salerId;
  }

  public void setSalerId(Long salerId) {
    this.salerId = salerId;
  }

  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }

  public int getMonthCount() {
    return monthCount;
  }

  public void setMonthCount(int monthCount) {
    this.monthCount = monthCount;
  }

  public int getPrice() {
    return price;
  }

  public void setPrice(int price) {
    this.price = price;
  }

  public Bargain(String name, String email, String avatarData, String sex, String spell, String idCard, String phoneNumber, Date birthday, String address, int monthCount, int price, Date startDate, String pdfPath, Long salerId) {
    this.name = name;
    this.email = email;
    this.avatarData = avatarData;
    this.sex = sex;
    this.spell = spell;
    this.idCard = idCard;
    this.phoneNumber = phoneNumber;
    this.birthday = birthday;
    this.address = address;
    this.monthCount = monthCount;
    this.price = price;
    this.startDate = startDate;
    this.pdfPath = pdfPath;
    this.salerId = salerId;
  }

  public Date getStartDate() {
    return startDate;
  }

  public void setStartDate(Date startDate) {
    this.startDate = startDate;
  }

  public Bargain() {
  }
}
