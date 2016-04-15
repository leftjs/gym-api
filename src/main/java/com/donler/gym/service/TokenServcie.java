package com.donler.gym.service;

import com.donler.gym.model.Config;
import com.donler.gym.repo.TokenRepo;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by jason on 4/15/16.
 */
@Service
public class TokenServcie {


  @Autowired
  private Config config;
  @Autowired
  private TokenRepo tokenRepo;


  /**
   * 生成token
   * @param str
   * @return
   */
  public String encodeToken(String str) {
    String afterStr = Jwts.builder().setSubject(str).signWith(SignatureAlgorithm.HS512, config.getAppSecret()).compact();
    return afterStr;
  }


  // TODO:
//  public User getUserFromCheckingToken(String token) {
//
//  }
}
