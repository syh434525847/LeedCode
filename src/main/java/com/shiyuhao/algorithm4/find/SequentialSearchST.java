package com.shiyuhao.algorithm4.find;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/12 10:46 上午
 **/
public class SequentialSearchST<Key, Value> {
    private Node first;
    private int size = 0;

    class Node {
        Key key;
        Value value;
        Node next;

        public Node(Key key, Value value, Node next) {
            this.key = key;
            this.value = value;
            this.next = next;
        }
    }

    public Value get(Key key) {
        for (Node x = first; x != null; x = x.next) {
            if (x.key.equals(key)) {
                return x.value;
            }
        }
        return null;
    }

    public void put(Key key, Value value) {
        for (Node x = first; x != null; x = x.next) {
            if (key.equals(key)) {
                x.value = value;
                return;
            }
        }
        Node head = first;
        Node newNode = new Node(key, value, head);
        first = newNode;
        size++;
    }

    public void delete(Key key) {
        first = delete(first, key);
    }

    private Node delete(Node x, Key key) {
        if (x == null) {
            return null;
        }
        if (x.key.equals(key)) {
            size--;
            return x.next;
        }
        x.next = delete(x.next, key);
        return x;
    }
}
