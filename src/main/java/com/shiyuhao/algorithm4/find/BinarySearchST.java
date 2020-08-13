package com.shiyuhao.algorithm4.find;

/**
 * @Description 符号表，有序数组实现，二分查找
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/12 11:14 上午
 **/
public class BinarySearchST<Key extends Comparable<Key>, Value> {
    private Key[] keys;
    private Value[] vals;
    private int N;
    private static int DEFAULT_CAPACITY = 2;

    public BinarySearchST(int capacity) {
        keys = (Key[]) new Comparable[capacity];
        vals = (Value[]) new Object[capacity];
    }

    public BinarySearchST() {
        keys = (Key[]) new Comparable[DEFAULT_CAPACITY];
        vals = (Value[]) new Object[DEFAULT_CAPACITY];
    }

    public int size() {
        return N;
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public Value get(Key key) {
        if (isEmpty()) {
            return null;
        }
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            return vals[i];
        } else {
            return null;
        }
    }

    public void put(Key key, Value val) {
        int i = rank(key);
        if (i < N && keys[i].compareTo(key) == 0) {
            vals[i] = val;
            return;
        }
        for (int j = N; j > i; j--) {
            keys[j] = keys[j - 1];
            vals[j] = vals[j - 1];
        }
        keys[i] = key;
        vals[i] = val;
        N++;
    }

    public int rank(Key key) {
        int lo = 0;
        int hi = N - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2;
            int cmp = key.compareTo(keys[mid]);
            if (cmp < 0) {
                hi = mid - 1;
            } else if (cmp > 0) {
                lo = mid + 1;
            } else {
                return mid;
            }
        }
        return lo;
    }

    public int rank(Key key,int lo, int hi) {
        if (hi < lo) {
            return lo;
        }
        int mid = lo + (hi - lo) / 2;
        int cmp = key.compareTo(keys[mid]);
        if (cmp < 0) {
            return rank(key, lo, mid - 1);
        } else if (cmp > 0) {
            return rank(key, mid + 1, hi);
        } else {
            return mid;
        }
    }

    public Key min() {
        return keys[0];
    }

    public Key max() {
        return keys[N - 1];
    }

    public Key select(int k) {
        return keys[k];
    }

    public Key ceiling(Key key) {
        int i = rank(key);
        return keys[i];
    }

    public Key floor(Key key) {
        int i = rank(key);
        if (i == 0) {
            return null;
        } else {
            return keys[i - 1];
        }
    }

    public void delete(Key key) {
        if (key == null) {
            throw new NullPointerException();
        }
        if (isEmpty()) {
            return;
        }
        int i = rank(key);
        for (int j = i; i < N - 1; j++) {
            keys[j] = keys[j + 1];
            vals[j] = vals[j + 1];
        }
        keys[N] = null;
        vals[N] = null;
        N--;
    }
}
