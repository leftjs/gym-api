package com.donler.gym.model.dto;

import io.swagger.annotations.ApiModelProperty;

/**
 * 删除成功后返回的状态信息的model
 *
 * Created by jason on 4/18/16.
 */
public class DeleteStatusModel {
  @ApiModelProperty(example = "删除成功")
  private String msg = "删除成功";

  public String getMsg() {
    return msg;
  }

  public void setMsg(String msg) {
    this.msg = msg;
  }
}
