package com.shiyuhao.algorithm4.find;

import com.sun.jmx.snmp.SnmpNull;

/**
 * @Description 二叉查找树BST
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/13 3:02 下午
 **/
public class BST<Key extends Comparable<Key>, Value> {

    public static void main(String[] args) {
        BST bst = new BST();
        bst.put(2, "2");
        bst.put(1, "1");
        bst.put(3, "3");
        bst.deleteMin();
        System.out.println(bst.size());
    }

    private Node root;

    class Node {
        private Key key;
        private Value val;
        private Node left, right;
        private int N;

        public Node(Key key, Value val, int n) {
            this.key = key;
            this.val = val;
            N = n;
        }
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

    public Value get(Key key) {
        return get(root, key);
    }

    private Value get(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return get(x.left, key);
        } else if (cmp > 0) {
            return get(x.right, key);
        } else {
            return x.val;
        }
    }

    public void put(Key key, Value val) {
        root = put(root, key, val);
    }

    private Node put(Node x, Key key, Value val) {
        if (x == null) {
            return new Node(key, val, 1);
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            x.left = put(x.left, key, val);
        } else if (cmp > 0) {
            x.right = put(x.right, key, val);
        } else {
            x.val = val;
        }
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }

    public Key min() {
        return min(root).key;
    }

    private Node min(Node x) {
        if (x.left == null) {
            return x;
        }
        return min(x.left);
    }

    public Key floor(Key key) {
        Node x = floor(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node floor(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        // 如果节点和key相等，则返回该节点
        if (cmp == 0) {
            return x;
        }
        // 如果key小于该节点，则说明小于key的最大key出现在左树中
        if (cmp < 0) {
            return floor(x.left, key);
        }
        // 如果key大于该节点，则判断是否存在一个节点等于key，如果存在则返回节点，如果不存在则返回x，说明x就是小于key的最大节点
        Node t = floor(x.right, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Key ceiling(Key key) {
        Node x = ceiling(root, key);
        if (x == null) {
            return null;
        }
        return x.key;
    }

    private Node ceiling(Node x, Key key) {
        if (x == null) {
            return null;
        }
        int cmp = key.compareTo(x.key);
        if (cmp == 0) {
            return x;
        }
        if (cmp > 0) {
            return ceiling(x.right, key);
        }
        Node t = ceiling(x.left, key);
        if (t != null) {
            return t;
        } else {
            return x;
        }
    }

    public Key select(int k) {
        return select(root, k).key;
    }

    private Node select(Node x, int k) {
        if (x == null) {
            return null;
        }
        int t = size(x.left);
        if (t > k) {
            return select(x.left, k);
        } else if (t < k) {
            return select(x.right, k - t - 1);
        } else {
            return x;
        }
    }

    public int rank(Key key) {
        return rank(root, key);
    }

    private int rank(Node x, Key key) {
        if (x == null) {
            return 0;
        }
        int cmp = key.compareTo(x.key);
        if (cmp < 0) {
            return rank(x.left, key);
        } else if (cmp > 0) {
            return 1 + size(x.left) + rank(x.right, key);
        } else {
            return size(x.left);
        }
    }

    public void deleteMin() {
        root = deleteMin(root);
    }

    private Node deleteMin(Node x) {
        if (x.left == null) {
            return x.right;
        }
        x.left = deleteMin(x.left);
        x.N = size(x.left) + size(x.right) + 1;
        return x;
    }
}
