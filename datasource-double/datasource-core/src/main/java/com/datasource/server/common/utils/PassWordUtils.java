 package com.datasource.server.common.utils;

import org.apache.commons.lang3.StringUtils;


 public class PassWordUtils {

      /**
       * 根据密文获取明文密码 格式：enc(密文)
       * @param password 密文或者明文
       * @return 如果明文原样返回 如果 密文获取解密后的明文
       */
      public static String getEnc(String password) {
          if(StringUtils.isEmpty(password)) {
              return null;
          }
          String passwordNew = StringUtils.replaceEach(password.trim(), new String[]{"（", "）"}, new String[]{"(", ")"});
          if(StringUtils.startsWithIgnoreCase(passwordNew, "enc(")) {
              String dbUrlEncrypt = StringUtils.substring(passwordNew, 4);
              if(StringUtils.endsWith(passwordNew, ")")) {
                  dbUrlEncrypt = dbUrlEncrypt.substring(0, dbUrlEncrypt.length() - 1);
              }
              return password;
              //先屏蔽
              //return PassWordEncrypt.decrypt(dbUrlEncrypt);
          }
          return password;
      }
 }
