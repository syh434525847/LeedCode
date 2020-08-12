package com.shiyuhao.algorithm4.find;

/**
 * @Description 符号表
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/12 10:23 上午
 **/
public abstract class ST<Key extends Comparable<Key>, Value> {
    public ST() {
    }

    abstract void put(Key key, Value val);

    abstract Value get(Key key);

    abstract void delete(Key key);

    abstract boolean contains(Key key);

    abstract boolean isEmpty();

    abstract int size();

    abstract Key min();

    abstract Key max();

    abstract Key floor(Key key);

    abstract Key ceiling(Key key);

    abstract int rank(Key key);

    abstract Key select(int k);

    void deleteMin() {
        delete(min());
    }

    void deleteMax() {
        delete(max());
    }

    int size(Key lo, Key hi) {
        if (hi.compareTo(lo) < 0) {
            return 0;
        } else if (contains(hi)) {
            return rank(hi) - rank(lo) + 1;
        } else {
            return rank(hi) - rank(lo);
        }
    }

    abstract Iterable<Key> keys(Key lo, Key hi);

    Iterable<Key> keys() {
        return keys(min(), max());
    }



}
