package com.donler.gym.util;

import java.util.Collection;
import java.util.Map;

/**
 * Created by jason on 4/14/16.
 */
public class NullCheckUtils {

  /**
   * 空对象判断
   * @param obj
   * @return
   */
  public static boolean isNullOrEmpty(Object obj){
    if (obj == null)
      return true;

    if (obj instanceof CharSequence)
      return ((CharSequence) obj).length() == 0;

    if (obj instanceof Collection)
      return ((Collection) obj).isEmpty();

    if (obj instanceof Map)
      return ((Map) obj).isEmpty();

    if (obj instanceof Object[]) {
      Object[] object = (Object[]) obj;
      if (object.length == 0) {
        return true;
      }
      boolean empty = true;
      for (int i = 0; i < object.length; i++) {
        if (!isNullOrEmpty(object[i])) {
          empty = false;
          break;
        }
      }
      return empty;
    }
    return false;
  }
}
