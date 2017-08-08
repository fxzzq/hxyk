package com.rico.demo;
import java.util.regex.Pattern;
import java.util.regex.Matcher;
/**
 * @author:xzq
 * @Descripition:
 * @Date: Created in 9:29 2017/8/8
 * @Modified:
 */
public class Test {
    public static void main(String[] args) {
        String regex = "\\d+"; // 1个或多个0-9的数字
        String s1 = "13";
        String s2 = "13ab";
        System.out.println(Pattern.matches(regex, s1));
        System.out.println(Pattern.matches(regex,s2));
    }


}
