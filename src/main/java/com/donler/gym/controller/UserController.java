package com.donler.gym.controller;

import com.donler.gym.model.Config;
import com.donler.gym.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

/**
 * Created by jason on 4/13/16.
 */

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private Config config;

  @RequestMapping(value = "/register", produces = {"application/json"}, method = RequestMethod.POST)
  @ResponseBody
  public String login(
      @RequestBody
      User input) {

    System.out.println("jasonzhang");
    return config.getAppSecret();
  }



}
