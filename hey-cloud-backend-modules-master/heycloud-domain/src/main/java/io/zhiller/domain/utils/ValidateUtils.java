package io.zhiller.domain.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidateUtils {
  public static boolean isPhoneNumber(String phone) {
    String regex = "^1[3-9]\\d{9}$";
    Pattern pattern = Pattern.compile(regex);
    Matcher matcher = pattern.matcher(phone);
    return matcher.matches();
  }
}
