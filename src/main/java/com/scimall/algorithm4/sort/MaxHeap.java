package com.scimall.algorithm4.sort;

/**
 * @Description 最大堆
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/11 3:21 下午
 **/
public class MaxHeap<Key extends Comparable<Key>> {
    private Key[] pq;
    private int N = 0;

    public MaxHeap(int maxN) {
        pq = (Key[]) new Comparable[maxN + 1];
    }

    public boolean isEmpty() {
        return N == 0;
    }

    public int size() {
        return N;
    }

    public void insert(Key v) {
        pq[++N] = v;
        swim(N);
    }

    public Key delMax() {
        Key max = pq[1];
        exch(1, N--);
        pq[N + 1] = null;
        sink(1);
        return max;
    }

    /**
     * @Description 数据下沉
     * @Param [k]
     * @Return void
     * @Author shiyuhao
     * @Date 2020/8/11 3:46 下午
     **/
    private void sink(int k) {
        while (2 * k <= N) {
            int j = 2 * k;
            // 取出字节点中最大的那个
            if (j < N && less(j, j + 1)) {
                j++;
            }
            // 判断k节点和j节点的大小，如果大于j节点，则退出循环，不用再比较
            if (!less(k, j)) {
                break;
            }
            // 交换k，j
            exch(k, j);
            k = j;
        }
    }

    /**
     * @Description 数据上浮
     * @Param [k]
     * @Return void
     * @Author shiyuhao
     * @Date 2020/8/11 3:43 下午
     **/
    private void swim(int k) {
        while (k > 1 && less(k / 2, k)) {
            exch(k / 2, k);
            k = k / 2;
        }
    }

    private boolean less(int i, int j) {
        return pq[i].compareTo(pq[j]) < 0;
    }

    private void exch(int i, int j) {
        Key t = pq[i];
        pq[i] = pq[j];
        pq[j] = t;
    }
}
