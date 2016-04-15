package com.donler.gym.controller;

import com.donler.gym.expection.AttrValidateException;
import com.donler.gym.model.Config;
import com.donler.gym.model.Token;
import com.donler.gym.model.User;
import com.donler.gym.model.dto.LoginModel;
import com.donler.gym.service.UserService;
import com.donler.gym.util.NullCheckUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * Created by jason on 4/13/16.
 */



@RestController
@RequestMapping("/user")
@Api(value = "user", tags = {"用户"})
public class UserController {

  @Autowired
  private Config config;

  @Autowired
  private UserService userService;


  @ApiOperation(notes = "根据用户信息注册一个新的用户", value = "用户注册")
  @RequestMapping(value = "/register", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
  @ResponseBody
  public ResponseEntity<User> register(

      @Valid @RequestBody User input) {

    User user = userService.getUserRepo().save(input);
    // 忽略密码
    user.setPassword(null);
    return ResponseEntity.ok(user);
  }

  @ApiOperation(notes = "根据用户信息进行登录验证", value = "用户登录")
  @RequestMapping(value = "/login", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json"})
  @ResponseBody
  public ResponseEntity<Token> login(
      @Valid @RequestBody LoginModel loginModel) {


    String loginName = loginModel.getLoginName();
    String loginPassword = loginModel.getLoginPassword();

    User user = userService.validateUserByLoginNameAndLoginPassword(loginName, loginPassword);

    if (NullCheckUtils.isNullOrEmpty(user)) {
      throw new AttrValidateException("用户名或密码出错");
    }
    Token token = userService.generateTokenByUserID(user.getId());
    return ResponseEntity.ok(token);
  }


}
