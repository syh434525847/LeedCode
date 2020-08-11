package com.scimall.algorithm4.sort;

/**
 * @Description 插入排序
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/3 3:10 下午
 **/
public class InsertionSort {
    public static void sort(Comparable[] a) {
        int n = a.length;
        for (int i = 1; i < n; i++) {
            // 从第二个元素开始，和前面的元素比较，如果小于前面的元素就交换位置
            // 这样交换下来，数组中最前面的元素就是已经排好序的
            // 当循环到最后的时候，整个数组就是有序数组了
            for (int j = i; j > 0 && less(a[j], a[j - 1]); j--) {
                exch(a, j, j - 1);
            }
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
        String[] a = new String[]{"A", "C", "B", "D"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
