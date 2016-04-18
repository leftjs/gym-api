package com.donler.gym.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
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

  @ApiModelProperty(example = "小张")
  @NotNull(message = "姓名不能为空")
  private String name;


  @ApiModelProperty(example = "男", allowableValues = "男,女")
  @NotNull(message = "性别不能为空")
  @Pattern(regexp = "^[男,女]$",message = "性别必须是[男,女]")
  private String sex;

  @ApiModelProperty(example = "XiaoZhang")
  private String spell; // 拼音

  @NotNull(message = "身份证号码不能为空")
  @ApiModelProperty(example = "321000000000000000")
  private String idCard;

  @ApiModelProperty(example = "18205253786")
  @NotNull(message = "电话号码不能为空")
  private String phoenNumber;


  @Temporal(value = TemporalType.DATE)
  private Date birthday = new Date();

  public void setId(Long id) {
    this.id = id;
  }

  @NotNull(message = "地址不能为空")
  @ApiModelProperty(example = "枫林路485号")
  private String address;


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
    return phoenNumber;
  }

  public void setPhoenNumber(String phoenNumber) {
    this.phoenNumber = phoenNumber;
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

  public Bargain(String name, String sex, String spell, String idCard, String phoenNumber, Date birthday, String address) {
    this.name = name;
    this.sex = sex;
    this.spell = spell;
    this.idCard = idCard;
    this.phoenNumber = phoenNumber;
    this.birthday = birthday;
    this.address = address;
  }

  public Bargain() {
  }
}
