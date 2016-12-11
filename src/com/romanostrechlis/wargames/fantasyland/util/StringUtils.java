package com.romanostrechlis.wargames.fantasyland.util;

/**
 * Created by Romanos on 12/11/2016.
 */
public class StringUtils {

  public static boolean isEmptyOrNull(String param) {
    if (param == null || "".equalsIgnoreCase(param)) {
      return true;
    }
    return false;
  }

  public static boolean isNotEmptyOrNull(String param) {
    return !isEmptyOrNull(param);
  }

}
