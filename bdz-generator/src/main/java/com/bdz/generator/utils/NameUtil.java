package com.bdz.generator.utils;

import org.springframework.util.StringUtils;

/**
 * @author bdz
 * @date 2018/6/12 11:05
 */
public class NameUtil {

  /**
   * 驼峰命名
   *
   * @param str
   * @return
   */
  public static String replaceUnderLineAndUpperCase(String str) {
    StringBuffer sb = new StringBuffer();
    sb.append(str);
    int count = sb.indexOf("_");
    while (count != 0) {
      int num = sb.indexOf("_", count);
      count = num + 1;
      if (num != -1) {
        char ss = sb.charAt(count);
        char ia = (char) (ss - 32);
        sb.replace(count, count + 1, ia + "");
      }
    }
    String result = sb.toString().replaceAll("_", "");
    return StringUtils.capitalize(result);
  }
}
