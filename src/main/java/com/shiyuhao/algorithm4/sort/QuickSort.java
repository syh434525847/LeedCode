package com.shiyuhao.algorithm4.sort;

import java.util.Stack;

/**
 * @Description 快速排序
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/11 11:15 上午
 **/
public class QuickSort {
    public static void sort(Comparable[] a) {
        sort1(a, 0, a.length - 1);
    }

    /**
     * @Description 非递归实现，用栈来存储一个分区的前后节点下标，当栈为空的时候，所有的成对分区节点就都取了出来，按照分区函数就都排好序了
     * @Param [a, lo, hi]
     * @Return void
     * @Author shiyuhao
     * @Date 2020/8/11 2:03 下午
     **/
    private static void sort1(Comparable[] a, int lo, int hi) {
        Stack<Integer> stack = new Stack<>();
        stack.push(hi);
        stack.push(lo);
        while (!stack.empty()) {
            int l = stack.pop();
            int r = stack.pop();
            int index = partition(a, l, r);
            if (l < index - 1) {
                stack.push(index - 1);
                stack.push(l);
            }
            if (r > index + 1) {
                stack.push(r);
                stack.push(index + 1);
            }
        }
    }

    /**
     * @Description 递归实现
     * @Param [a, lo, hi]
     * @Return void
     * @Author shiyuhao
     * @Date 2020/8/11 2:03 下午
     **/
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int j = partition(a, lo, hi);
        sort(a, lo, j - 1);
        sort(a, j + 1, hi);
    }

    private static int partition(Comparable[] a, int lo, int hi) {
        int i = lo, j = hi + 1;
        Comparable v = a[lo];

        while (true) {
            while (less(a[++i], v)) {
                if (i == hi) {
                    break;
                }
            }
            while (less(v, a[--j])) {
                if (j == lo) {
                    break;
                }
            }
            if (i >= j) {
                break;
            }
            exch(a, i, j);
        }
        // 将选择出来做切分的元素，放到正确的位置（左边小于它，右边的元素都大于它）
        exch(a, lo, j);
        return j;
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
        String[] a = new String[]{"A", "C", "B", "D", "C"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
