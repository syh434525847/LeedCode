package com.shiyuhao.algorithm4.find;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @Description 红黑树
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/24 2:51 下午
 **/
public class RedBlackBST<Key extends Comparable<Key>, Value> {

    public static void main(String[] args) {
//        RedBlackBST redBlackBST = new RedBlackBST();
//        redBlackBST.put("A", "A");
//        redBlackBST.put("C", "C");
//        redBlackBST.put("E", "E");
//        redBlackBST.put("H", "H");
//        System.out.println(redBlackBST);
        List<Integer> list = new ArrayList<>();
        System.out.println(list.size());
        list.add(0, 1);
        list.forEach(System.out::println);
    }

    private Node root;
    private static final boolean RED = true;
    private static final boolean BLACK = false;

    public void put(Key key, Value val) {
        root = put(root, key, val);
        root.color = BLACK;
    }

    private Node put(Node h, Key key, Value val) {
        if (h == null) {
            return new Node(key, val, 1, RED);
        }
        int cmp = key.compareTo(h.key);
        if (cmp < 0) {
            h.left = put(h.left, key, val);
        } else if (cmp > 0) {
            h.right = put(h.right, key, val);
        } else {
            h.value = val;
        }

        if (isRed(h.right) && !isRed(h.left)) {
            h = rotateLeft(h);
        }
        if (isRed(h.left) && isRed(h.left.left)) {
            h = rotateRight(h);
        }
        if (isRed(h.left) && isRed(h.right)) {
            flipColors(h);
        }
        h.N = size(h.left) + size(h.right) + 1;
        return h;
    }

    private Node rotateLeft(Node h) {
        Node x = h.right;
        h.right = x.left;
        x.left = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    private Node rotateRight(Node h) {
        Node x = h.left;
        h.left = x.right;
        x.right = h;
        x.color = h.color;
        h.color = RED;
        x.N = h.N;
        h.N = 1 + size(h.left) + size(h.right);
        return x;
    }

    public int size() {
        return size(root);
    }

    public int size(Node x) {
        if (x == null) {
            return 0;
        } else {
            return x.N;
        }
    }

    private void flipColors(Node h) {
        h.right.color = BLACK;
        h.left.color = BLACK;
        h.color = RED;
    }

    private class Node {
        // 键
        Key key;
        // 值
        Value value;
        // 左右子树
        Node left, right;
        // 树的节点总数
        int N;
        // 由其父节点指向它的链接的颜色
        boolean color;

        public Node(Key key, Value value, int n, boolean color) {
            this.key = key;
            this.value = value;
            this.N = n;
            this.color = color;
        }
    }

    private boolean isRed(Node x) {
        if (x == null) return false;
        return x.color == RED;
    }
}
