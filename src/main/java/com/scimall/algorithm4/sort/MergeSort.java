package com.scimall.algorithm4.sort;

/**
 * @Description 归并排序，自顶向下，递归解决
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/4 2:40 下午
 **/
public class MergeSort {

    private static Comparable[] tmp;

    public static void sort(Comparable[] a) {
        int N = a.length;
        sort(a, 0, N - 1);
    }

    public static void sort(Comparable[] a, int p, int r) {
        if (p >= r) {
            return;
        }
        int q = p + (r - p) / 2;
        sort(a, p, q);
        sort(a, q + 1, r);
        merge(a, p, q, r);
    }

    public static void merge(Comparable[] a, int p, int q, int r) {
        tmp = new Comparable[r - p + 1];
        int i = p, j = q + 1, k = 0;
        while (i <= q && j <= r) {
            if (less(a[i], a[j])) {
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
            a[p + m] = tmp[m];
        }
    }

    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a[i], a[i - 1])) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[] a = new String[]{"a", "z", "b", "j", "c"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
