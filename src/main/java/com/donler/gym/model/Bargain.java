package com.donler.gym.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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

  @NotNull(message = "姓名不能为空")
  private String name;


  private Boolean isMan = false;

  private String spell; // 拼音

  @NotNull(message = "身份证号码不能为空")
  private String idCard;

  @NotNull(message = "电话号码不能为空")
  private String phoenNumber;


  @Temporal(value = TemporalType.DATE)
  private Date birthday = new Date();

  @NotNull(message = "地址不能为空")
  private String address;

  public Long getId() {
    return id;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public Boolean getMan() {
    return isMan;
  }

  public void setMan(Boolean man) {
    isMan = man;
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


  public Bargain(String name, Boolean isMan, String spell, String idCard, String phoenNumber, Date birthday, String address) {
    this.name = name;
    this.isMan = isMan;
    this.spell = spell;
    this.idCard = idCard;
    this.phoenNumber = phoenNumber;
    this.birthday = birthday;
    this.address = address;
  }

  public Bargain() {
  }
}
