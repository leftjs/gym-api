package com.donler.gym.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

/**
 * 业务
 *
 * Created by jason on 4/15/16.
 */
@Entity
public class Business {


  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @NotNull(message = "业务期限不能为空")
  @Min(1)
  private int monthCount;


  @NotNull(message = "业务价格不能为空")
  private int price;

  public Long getId() {
    return id;
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


  public Business() {
  }

  public Business(int monthCount, int price) {

    this.monthCount = monthCount;
    this.price = price;
  }
}
