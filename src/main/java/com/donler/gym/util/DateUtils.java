package com.donler.gym.util;

import java.util.Date;

/**
 * Created by jason on 4/14/16.
 */
public class DateUtils {


  /**
   * 日期转字符串
   * @param date
   * @return
   */
  public static String dateToTimeStamp(Date date) {
//    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    String sd = String.valueOf(date.getTime());
    return sd;
  }

  /**
   * 字符串转Date
   * @param timeStamp
   * @return
   */
  public static Date timeStampToDate(String timeStamp) {
    return new Date(Long.parseLong(timeStamp));
  }




  public static void main(String[] args) {


    String timestamp = dateToTimeStamp(new Date());
    System.out.println(timestamp);

    Date myDate = timeStampToDate(timestamp);
    System.out.println(myDate.getTime());
  }
}
