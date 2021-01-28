package com.shiyuhao.od;

import java.util.Scanner;

/**
 * @Description
 * 有一堆积木，小明和小王兄弟两平方，但小明只认识二进制，而且不会进位（舍掉进位），求最终小王可以获得的最大积木重量
 * 比如：3 5 6
 * 3的二进制：11
 * 5的二进制：101
 * 6的二进制：110
 * 小明的舍掉进位算法
 * 5和6的二进制运算= 011 = 3
 * 所以小王最多可以拿到 5+6 = 11
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2021/1/26 上午11:19
 **/
public class OdTest2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line = scanner.nextLine();
        String[] s = line.split(" ");
        int max = Integer.MIN_VALUE;
        int max1 = Integer.MIN_VALUE;
        for (int i = 0; i < s.length - 1; i++) {
            int a = Integer.parseInt(s[i]);
            for (int j = i + 1; j < s.length; j++) {
                int b = Integer.parseInt(s[j]);
                int i1 = a ^ b;
                if (i1 > max1) {
                    max1 = i1;
                    max = a + b;
                }
            }
        }
        System.out.println(max);
    }
}
