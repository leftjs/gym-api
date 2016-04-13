package com.donler.gym.controller;

import com.donler.gym.expection.DataFormatException;
import com.donler.gym.expection.ResourceNotFoundException;
import com.donler.gym.model.RestErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

/**
 * Created by jason on 4/13/16.
 */



@ControllerAdvice
@EnableWebMvc
public class ErrorController {
  protected final Logger log = LoggerFactory.getLogger(this.getClass());

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(DataFormatException.class)
  public
  @ResponseBody
  RestErrorInfo handleDataStoreException(Exception ex) {
    log.info("数据库错误: " + ex.getMessage());
    return new RestErrorInfo("数据库错误",ex.getLocalizedMessage());
  }

  @ResponseStatus(HttpStatus.NOT_FOUND)
  @ExceptionHandler(ResourceNotFoundException.class)
  public
  @ResponseBody
  RestErrorInfo handleResourceNotFoundException(Exception ex) {
    log.info("资源未找到: " + ex.getMessage());
    return new RestErrorInfo("资源未找到", ex.getLocalizedMessage());
  }

  @ExceptionHandler(RuntimeException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  @ResponseBody
  public RestErrorInfo handleDefaultException(Exception ex) {
    log.info("未知错误: " + ex.getMessage());
    return new RestErrorInfo("未知错误", ex.getLocalizedMessage());
  }

}
