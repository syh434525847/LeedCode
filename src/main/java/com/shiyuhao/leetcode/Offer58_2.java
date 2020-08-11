package com.shiyuhao.leetcode;

/**
 * @Description 剑指 Offer 58 - II. 左旋转字符串
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/6/24 10:13 上午
 **/
public class Offer58_2 {
    /**
     * @Description s = "abcdefg", k = 2，输出："cdefgab"
     * @Param [s, n]
     * @Return java.lang.String
     * @Author shiyuhao
     * @Date 2020/6/24 10:18 上午
     **/
    public String reverseLeftWords(String s, int n) {
        String firstStr = s.substring(0, n);
        String lastStr = s.substring(n);

        return lastStr + firstStr;
    }

    public static void main(String[] args) {
        System.out.println(new Offer58_2().reverseLeftWords("abcdefg", 6));
    }
}
