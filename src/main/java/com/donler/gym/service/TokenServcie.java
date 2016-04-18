package com.donler.gym.service;

import com.donler.gym.expection.AttrValidateException;
import com.donler.gym.model.Config;
import com.donler.gym.model.Token;
import com.donler.gym.model.User;
import com.donler.gym.repo.TokenRepo;
import com.donler.gym.repo.UserRepo;
import com.donler.gym.util.NullCheckUtils;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Created by jason on 4/15/16.
 */
@Service
public class TokenServcie {


  @Autowired
  private Config config;
  @Autowired
  private TokenRepo tokenRepo;
  @Autowired
  private UserRepo userRepo;


  /**
   * 生成token
   * @param str
   * @return
   */
  public String encodeToken(String str) {
    String afterStr = Jwts.builder().setSubject(str).signWith(SignatureAlgorithm.HS512, config.getAppSecret()).compact();
    return afterStr;
  }


  public User getUserFromCheckingToken(String tokenStr) {
    Token token = tokenRepo.findTokenByToken(tokenStr);
    if (NullCheckUtils.isNullOrEmpty(token)) {
      throw new AttrValidateException("token检验出错");
    }


    /**
     * TODO: 待测试
     */
    if (token.getExpiredTime().before(new Date())) {
      throw new AttrValidateException("token已过期,请重新登录");
    }

    User user = userRepo.findUserById(token.getUserId());
    if (NullCheckUtils.isNullOrEmpty(user)) {
      throw new AttrValidateException("未找到该用户");
    }
    return user;
  }
}
