package com.donler.gym.service;

import com.donler.gym.expection.AttrValidateException;
import com.donler.gym.model.Config;
import com.donler.gym.model.Token;
import com.donler.gym.model.User;
import com.donler.gym.repo.TokenRepo;
import com.donler.gym.repo.UserRepo;
import com.donler.gym.util.MD5Utils;
import com.donler.gym.util.NullCheckUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jason on 4/13/16.
 */
@Service
public class UserService {



  @Autowired
  private UserRepo userRepo;
  @Autowired
  private Config config;
  @Autowired
  private TokenRepo tokenRepo;


  public UserRepo getUserRepo() {
    return userRepo;
  }

  public UserService() {
  }


  /**
   * 通过用户名和密码验证用户
   * @param username
   * @param password
   * @return 数据库中的用户数据
   */
  public User validateUserByUserNameAndPassword(String username, String password) {
    User user = userRepo.findUserByUsername(username);
    if (NullCheckUtils.isNullOrEmpty(user)) {
      return null;
    }
    if (!user.getPassword().equals(MD5Utils.md5Encode(password))) {
      return null;
    }
    return user;
  }

 /**
   * 通过用户名和密码验证用户
   * @param email
   * @param password
   * @return 数据库中的用户数据
   */
  public User validateUserByEmailAndPassword(String email, String password) {
    User user = userRepo.findUserByEmail(email);
    if (NullCheckUtils.isNullOrEmpty(user)) {
      return null;
    }
    if (!user.getPassword().equals(MD5Utils.md5Encode(password))) {
      return null;
    }
    return user;
  }
 /**
   * 通过用户名和密码验证用户
   * @param phoneNumber
   * @param password
   * @return 数据库中的用户数据
   */
  public User validateUserByPhoneNumberAndPassword(String phoneNumber, String password) {
    User user = userRepo.findUserByPhoneNumber(phoneNumber);
    if (NullCheckUtils.isNullOrEmpty(user)) {
      return null;
    }
    if (!user.getPassword().equals(MD5Utils.md5Encode(password))) {
      return null;
    }
    return user;
  }


  /**
   * 通过登录名和登录密码来验证用户
   *
   * @param loginName
   * @param loginPassword
   * @return
   */
  public User validateUserByLoginNameAndLoginPassword(String loginName, String loginPassword) {
    User user = userRepo.findUserByUsername(loginName);
    if (NullCheckUtils.isNullOrEmpty(user)) {
      user = userRepo.findUserByEmail(loginName);
      if (NullCheckUtils.isNullOrEmpty(user)) {
        user = userRepo.findUserByPhoneNumber(loginName);
        if (NullCheckUtils.isNullOrEmpty(user)) {
          return null;
        }
      }
    }

    if (!user.getPassword().equals(MD5Utils.md5Encode(loginPassword))) {
      return null;
    }

    return user;
  }


  /**
   * 根据用户的id 生成token 并且更新user 表
   * @param userID
   * @return
   */
  public Token generateTokenByUserID(Long userID) {

    User user = userRepo.findUserById(userID);

    if (NullCheckUtils.isNullOrEmpty(user)) {
      throw new AttrValidateException("用户信息出错");
    }

    Token token = new Token();

    Date now = new Date();
    String expiredTime = String.valueOf(now.getTime() + Long.parseLong(config.getTokenExpiredTime()));
    token.setToken(encodeToken(String.valueOf(user.getId())));
    token.setUserId(user.getId());
    token.setExpiredTime(expiredTime);
    Token newToken = tokenRepo.save(token);

    /**
     * 更新user model 中的引用
     */
    user.setTokenId(token.getId());
    userRepo.save(user);

    return newToken;
  }

  private String encodeToken(String str) {
    String afterStr = Jwts.builder().setSubject(str).signWith(SignatureAlgorithm.HS512, config.getAppSecret()).compact();
    return afterStr;
  }


}
