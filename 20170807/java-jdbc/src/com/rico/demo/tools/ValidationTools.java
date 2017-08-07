package com.rico.demo.tools;

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
        // 正确的写法：正则表达式判断 正整数
        try {
            Integer.parseInt(string);
            return true;
        } catch (Exception e) {
            return false;
        }
    }
}
