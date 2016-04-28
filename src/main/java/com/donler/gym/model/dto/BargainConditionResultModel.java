package com.donler.gym.model.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.swagger.annotations.ApiModelProperty;

import java.util.Date;

/**
 * 合同条款
 *
 * Created by jason on 4/15/16.
 */

@JsonInclude(value = JsonInclude.Include.NON_EMPTY)
public class BargainConditionResultModel {


  @ApiModelProperty(notes = "空白合同条款", example = "<html>我是空白合同条款</html>")
  private String blackCondition;

  @ApiModelProperty(notes = "模板合同条款", example = "<html>我是模板合同条款</html>")
  private String templateCondition;


  @ApiModelProperty(notes = "更新时间")
  private Date updatedTime;

  @ApiModelProperty(notes = "新条款")
  private Boolean isNew;

  public BargainConditionResultModel() {
  }

  public BargainConditionResultModel(String blackCondition, String templateCondition, Date updatedTime, Boolean isNew) {

    this.blackCondition = blackCondition;
    this.templateCondition = templateCondition;
    this.updatedTime = updatedTime;
    this.isNew = isNew;
  }

  public String getBlackCondition() {

    return blackCondition;
  }

  public void setBlackCondition(String blackCondition) {
    this.blackCondition = blackCondition;
  }

  public String getTemplateCondition() {
    return templateCondition;
  }

  public void setTemplateCondition(String templateCondition) {
    this.templateCondition = templateCondition;
  }

  public Date getUpdatedTime() {
    return updatedTime;
  }

  public void setUpdatedTime(Date updatedTime) {
    this.updatedTime = updatedTime;
  }

  public Boolean getNew() {
    return isNew;
  }

  public void setNew(Boolean aNew) {
    isNew = aNew;
  }
}
