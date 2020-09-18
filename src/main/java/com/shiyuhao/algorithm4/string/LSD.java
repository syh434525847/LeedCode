package com.shiyuhao.algorithm4.string;

import java.util.Arrays;

/**
 * @Description 低位优先字符串排序
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/26 10:28 上午
 **/
public class LSD {

    public static void main(String[] args) {
        String[] a= new String[]{
                "4PGC938","2IYE230","3CI0720","1ICK750",
                "10HV845","4JZY524","1ICK750","3CI0720",
                "10HV845","10HV845","2RLA629","2RLA629",
                "3ATW723"
        };
        sort(a, 7);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void sort(String[] a, int w) {
        int N = a.length;
        int R = 256;
        String[] aux = new String[N];
        for (int d = w - 1; d >= 0; d--) {
            // 将车牌号中每一位出现的次数统计到count数组中
            int[] count = new int[R + 1];
            for (int i = 0; i < N; i++) {
                count[a[i].charAt(d) + 1]++;
            }
            // 将count数组中每一位都表示成小于该位的总数和
            for (int r = 0; r < R; r++) {
                count[r + 1] += count[r];
            }
            for (int i = 0; i < N; i++) {
                aux[count[a[i].charAt(d)]++] = a[i];
            }
            for (int i = 0; i < N; i++) {
                a[i] = aux[i];
            }
        }
    }

}
