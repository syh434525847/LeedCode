package com.shiyuhao.test;

import edu.princeton.cs.algs4.In;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description 快速排序练习
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/17 10:15 上午
 **/
public class QuickSortTest {

    public static void main(String[] args) {
        String[] s = new String[]{"A", "D", "C", "Z", "G", "C", "K", "L", "M", "H"};
        sort1(s, 0, s.length - 1);
        Arrays.stream(s).forEach(System.out::println);
    }

    private static void sort(String[] a, int lo, int hi) {
        if (hi <= lo) {
            return;
        }
        int q = partition(a, lo, hi);
        sort(a, lo, q-1);
        sort(a, q + 1, hi);
    }

    private static void sort1(String[] a, int lo, int hi) {
        Stack<Integer> stack = new Stack<>();
        stack.push(hi);
        stack.push(lo);
        while (!stack.isEmpty()) {
            int start = stack.pop();
            int end = stack.pop();
            int p = partition(a, start, end);
            if (start < p - 1) {
                stack.push(p - 1);
                stack.push(start);
            }
            if (end > p + 1) {
                stack.push(end);
                stack.push(p + 1);
            }
        }
    }

    private static int partition(String[] a, int lo, int hi) {
        String pivot = a[hi];
        int i = lo;
        for (int j = lo; j < hi; j++) {
            if (a[j].compareTo(pivot) < 0) {
                String tmp = a[i];
                a[i] = a[j];
                a[j] = tmp;
                i++;
            }
        }
        String tmp = a[i];
        a[i] = a[hi];
        a[hi] = tmp;
        return i;
    }


}
