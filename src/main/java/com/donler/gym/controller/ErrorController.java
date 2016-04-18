package com.donler.gym.controller;

import com.donler.gym.expection.AttrValidateException;
import com.donler.gym.expection.AuthValidateException;
import com.donler.gym.expection.DataFormatException;
import com.donler.gym.expection.ResourceNotFoundException;
import com.donler.gym.model.RestErrorInfo;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * Created by jason on 4/13/16.
 */



@ControllerAdvice
//@EnableWebMvc
@Configuration
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

  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ExceptionHandler(AttrValidateException.class)
  public
  @ResponseBody
  RestErrorInfo handleAttrValidateException (Exception ex) {
    log.info("参数验证异常: " + ex.getMessage());
    return new RestErrorInfo("参数验证异常", ex.getLocalizedMessage());
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
    log.info("未知错误: " + ex.getClass());
    return new RestErrorInfo("未知错误", ex.getLocalizedMessage());
  }

  @ExceptionHandler(AuthValidateException.class)
  @ResponseStatus(HttpStatus.UNAUTHORIZED)
  @ResponseBody
  public RestErrorInfo handleAuthValidateException(Exception ex) {
    log.info("授权异常: " + ex.getClass());
    return new RestErrorInfo("授权异常", ex.getLocalizedMessage());
  }


  @ExceptionHandler(DataIntegrityViolationException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public RestErrorInfo handleDataIntegrityViolationException(DataIntegrityViolationException ex) {

    log.info("数据库操作异常", ex.getMostSpecificCause().getLocalizedMessage());
//    return new RestErrorInfo("数据库操作异常", ex.getMostSpecificCause().getLocalizedMessage());
    return new RestErrorInfo("数据库操作异常", ex.getMostSpecificCause().getLocalizedMessage());
  }


  @ExceptionHandler(MethodArgumentNotValidException.class)
  @ResponseStatus(HttpStatus.BAD_REQUEST)
  @ResponseBody
  public RestErrorInfo handleMethodArgumentNotValidException(MethodArgumentNotValidException ex) {

    StringBuilder stringBuilder = new StringBuilder();
    for (ObjectError error : ex.getBindingResult().getAllErrors()) {
      stringBuilder.append(error.getDefaultMessage() + ", ");

    }
    log.info("验证错误", stringBuilder.toString().substring(0, stringBuilder.toString().length() - 2));

    return new RestErrorInfo("验证错误",stringBuilder.toString().substring(0, stringBuilder.toString().length() - 2) );
  }

}
