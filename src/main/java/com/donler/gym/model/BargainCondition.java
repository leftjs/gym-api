package com.donler.gym.model;

import io.swagger.annotations.ApiModelProperty;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 合同条款
 *
 * Created by jason on 4/15/16.
 */
@Entity
public class BargainCondition {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  @Lob
  @NotNull(message = "空白条款不能为空")
  @ApiModelProperty(notes = "空白合同条款", example = "<html>我是空白合同条款</html>")
  private String blackCondition;

  @Lob
  @NotNull(message = "模板条款不能为空")
  @ApiModelProperty(notes = "模板合同条款", example = "<html>我是模板合同条款</html>")
  private String templateCondition;

  @Temporal(TemporalType.TIMESTAMP)
  @ApiModelProperty(notes = "修改时间")
  private Date updated_time;

  public BargainCondition() {
  }

  public BargainCondition(String blackCondition, String templateCondition) {

    this.blackCondition = blackCondition;
    this.templateCondition = templateCondition;
  }

  public BargainCondition(String blackCondition, String templateCondition, Date updated_time) {

    this.blackCondition = blackCondition;
    this.templateCondition = templateCondition;
    this.updated_time = updated_time;
  }

  public Long getId() {

    return id;
  }

  public void setId(Long id) {
    this.id = id;
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

  public Date getUpdated_time() {
    return updated_time;
  }

  public void setUpdated_time(Date updated_time) {
    this.updated_time = updated_time;
  }
}
