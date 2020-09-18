package com.shiyuhao.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/26 2:41 下午
 **/
public class InsertionSortTest {

    public static void main(String[] args) {
        int[] a = new int[]{4, 12, 4, 56, 13, 56, 13, 123};
        sort(a, a.length);
        Arrays.stream(a).forEach(System.out::println);
    }

    public static void sort(int[] a, int n) {
        for (int i = 1; i < n; i++) {
            for (int j = i; j > 0; j--) {
                if (a[j] < a[j - 1]) {
                    int tmp = a[j];
                    a[j] = a[j - 1];
                    a[j - 1] = tmp;
                }
            }
        }
    }


}
