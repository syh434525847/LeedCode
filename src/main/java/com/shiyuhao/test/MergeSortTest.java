package com.shiyuhao.test;

import java.util.Arrays;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/17 11:10 上午
 **/
public class MergeSortTest {
    public static void main(String[] args) {
        String[] s = new String[]{"A", "D", "C", "Z", "G", "C", "K", "L", "M", "H"};
        sort(s, 0, s.length - 1);
        Arrays.stream(s).forEach(System.out::println);
    }

    private static void sort(String[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int q = lo + (hi - lo) / 2;
        sort(a, lo, q);
        sort(a, q + 1, hi);
        merge(a, lo, q, hi);
    }

    /**
     * @Description l到q，q到r位置的元素进行排序合并
     * @Param [a, l, q, r]
     * @Return void
     * @Author shiyuhao
     * @Date 2020/8/17 11:29 上午
     **/
    private static void merge(String[] a, int l, int q, int r) {
        String[] tmp = new String[r - l + 1];
        int i = l, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (a[i].compareTo(a[j]) < 0) {
                tmp[k++] = a[i++];
            } else {
                tmp[k++] = a[j++];
            }
        }
        int start = i;
        int end = q;
        if (j <= r) {
            start = j;
            end = r;
        }
        while (start <= end) {
            tmp[k++] = a[start++];
        }
        for (int m = 0; m < tmp.length; m++) {
            a[l + m] = tmp[m];
        }
    }

}
