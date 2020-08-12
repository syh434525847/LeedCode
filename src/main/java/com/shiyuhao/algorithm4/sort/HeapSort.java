package com.shiyuhao.algorithm4.sort;

/**
 * @Description 堆排序
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/11 5:34 下午
 **/
public class HeapSort {
    public static void sort(Comparable[] a) {
        int N = a.length;
        // 生成最大堆
        for (int k = N / 2; k >= 1; k--) {
            sink(a, k, N);
        }
        // 堆排序，每次将堆中第一个元素和最后一个元素替换，将最大数移到最后一位，然后重新维护堆保证第一位为剩余元素中的最大数
        while (N > 1) {
            exch(a, 1, N--);
            sink(a, 1, N);
        }
    }

    private static boolean less(Comparable[] a, int v, int w) {
        return a[v - 1].compareTo(a[w - 1]) < 0;
    }

    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i - 1];
        a[i - 1] = a[j - 1];
        a[j - 1] = t;
    }

    private static void show(Comparable[] a) {
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println();
    }

    public static boolean isSorted(Comparable[] a) {
        for (int i = 1; i < a.length; i++) {
            if (less(a, i, i - 1)) {
                return false;
            }
        }
        return true;
    }

    /**
     * @Description 数据下沉
     * @Param [k]
     * @Return void
     * @Author shiyuhao
     * @Date 2020/8/11 3:46 下午
     **/
    private static void sink(Comparable[] a, int k, int N) {
        while (2 * k <= N) {
            int j = 2 * k;
            // 取出字节点中最大的那个
            if (j < N && less(a, j, j + 1)) {
                j++;
            }
            // 判断k节点和j节点的大小，如果大于j节点，则退出循环，不用再比较
            if (!less(a, k, j)) {
                break;
            }
            // 交换k，j
            exch(a, k, j);
            k = j;
        }
    }

    public static void main(String[] args) {
        String[] a = new String[]{"A", "C", "B", "D"};
        sort(a);
        assert isSorted(a);
        show(a);
    }
}
