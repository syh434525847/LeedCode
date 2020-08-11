package com.scimall.geekbang;

import java.util.HashMap;
import java.util.Map;

/**
 * @Description 字符串暴力匹配算法，也叫朴素匹配算法
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/7/27 4:45 下午
 **/
public class StringMatch {
    public static void main(String[] args) {
        String a = "abckdslsdfl";
        String b = "dsljjj";
        System.out.println(match1(a, b));
    }

    /**
     * @Description 利用hashMap来存储所有情况的串，然后判断hash中是否包含字串的key
     * @Param [a, b]
     * @Return boolean
     * @Author shiyuhao
     * @Date 2020/7/28 9:32 上午
     **/
    public static boolean match1(String a, String b) {
        int bLength = b.length();
        int aLength = a.length();
        if (aLength < bLength) {
            return false;
        }
        Map<String, Integer> hash = new HashMap<>(aLength - bLength + 1);
        for (int i = 0; i <= aLength - bLength; i++) {
            String aSplit = a.substring(i, i + bLength);
            hash.putIfAbsent(aSplit, 0);
            if (hash.containsKey(b)) {
                return true;
            }
        }
        return false;
    }

    public static boolean match(String a, String b) {
        int bLength = b.length();
        int aLength = a.length();
        if (aLength < bLength) {
            return false;
        }
        boolean flag = false;
        for (int i = 0; i < aLength - bLength; i++) {
            for (int j = 0, k = i; j < bLength; j++) {
                char bChar = b.charAt(j);
                char aChar = a.charAt(k++);
                if (aChar != bChar) {
                    flag = false;
                    break;
                } else {
                    flag = true;
                }
            }
            if (flag) {
                break;
            }
        }
        return flag;
    }
}
