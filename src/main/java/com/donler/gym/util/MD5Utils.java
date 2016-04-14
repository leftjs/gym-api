package com.donler.gym.util;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;

/**
 * md5加密工具类
 *
 * Created by jason on 4/14/16.
 */
public class MD5Utils {
  /**
   * 简易md5加密
   * @param inStr
   * @return
   * @throws Exception
   */
  public static String md5Encode(String inStr) {
    MessageDigest md5 = null;
    try {
      md5 = MessageDigest.getInstance("MD5");
    } catch (Exception e) {
      System.out.println(e.toString());
      e.printStackTrace();
      return "";
    }

    byte[] byteArray = new byte[0];
    try {
      byteArray = inStr.getBytes("UTF-8");
    } catch (UnsupportedEncodingException e) {
      e.printStackTrace();
    }
    byte[] md5Bytes = md5.digest(byteArray);
    StringBuffer hexValue = new StringBuffer();
    for (int i = 0; i < md5Bytes.length; i++) {
      int val = ((int) md5Bytes[i]) & 0xff;
      if (val < 16) {
        hexValue.append("0");
      }
      hexValue.append(Integer.toHexString(val));
    }
    return hexValue.toString();
  }
}
