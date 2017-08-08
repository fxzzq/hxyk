package com.rico.demo.tools;

import java.util.regex.Pattern;

/**
 * Created by Rico on 2017/8/7.
 */
public class ValidationTools {

    public static boolean isNull(String string) {
        if(string == null || string.trim().equals("") || string.trim().length() == 0) {
            return true;
        }
        return false;
    }

    public static boolean isInteger(String string) {
        if (string == null) {
            return false;
        }

        // 不好的写法，不能用异常来控制语句

      /*  try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }*/
        // 正确的写法：正则表达式判断 正整数
        //只能输入非零的正整数："^\+?[1-9][0-9]*$"。
       else{

            String regex="^\\+?[1-9][0-9]*$";

            return Pattern.matches(regex, string);

        }

    }
}
