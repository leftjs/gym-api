package com.donler.gym.util;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by jason on 4/14/16.
 */
public class Test {
  public static void main(String[] args) {
    Date date = DateUtils.timeStampToDate("1463214106800");
    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    System.out.println(sdf.format(date));
  }
}
