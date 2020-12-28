package com.shiyuhao.offer;

import com.shiyuhao.common.TreeNode;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

/**
 * @Description 二叉树所有遍历方式
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/23 11:10 上午
 **/
public class BSTLoop {
    public static void main(String[] args) {
        TreeNode<String> head = new TreeNode<>("a");
        head.left = new TreeNode("b");
        head.left.left = new TreeNode("d");
        head.left.right = new TreeNode("e");
        head.left.right.left = new TreeNode("h");
        head.left.right.right = new TreeNode("i");
        head.right = new TreeNode("c");
        head.right.left = new TreeNode("f");
        head.right.right = new TreeNode("g");
        bfs(head);
        System.out.println();
        System.out.println("------------");
        dfsDg(head);
    }

    public static void preLoopNotDg(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        stack.push(head);

        while (!stack.isEmpty()) {
            TreeNode currentNode = stack.pop();
            System.out.print(currentNode.val + " ");
            if (currentNode.right != null) {
                stack.push(currentNode.right);
            }
            if (currentNode.left != null) {
                stack.push(currentNode.left);
            }
        }
    }

    public static void preLoopByDg(TreeNode head) {
        if (head == null) {
            return;
        }
        System.out.print(head.val + " ");
        preLoopByDg(head.left);
        preLoopByDg(head.right);
    }

    public static void midLoopNotDg(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode p = head;

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                System.out.print(p.val + " ");
                p = p.right;
            }
        }
    }

    public static void midLoopByDg(TreeNode head) {
        if (head == null) {
            return;
        }
        midLoopByDg(head.left);
        System.out.println(head.val);
        midLoopByDg(head.right);
    }

    public static void afterLoopByDg(TreeNode head) {
        if (head == null) {
            return;
        }
        afterLoopByDg(head.left);
        afterLoopByDg(head.right);
        System.out.println(head.val);
    }

    public static void afterLoopNotDg(TreeNode head) {
        Stack<TreeNode> stack = new Stack<>();
        Stack<TreeNode> result = new Stack<>();
        TreeNode p = head;
        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                stack.push(p);
                result.push(p);
                p = p.right;
            } else {
                p = stack.pop();
                p = p.left;
            }
        }

        while (!result.isEmpty()) {
            System.out.print(result.pop().val + " ");
        }
    }

    // TODO 树深度遍历
    public static void dfsDg(TreeNode root) {
        if (root != null) {
            System.out.print(root.val + " ");
            dfsDg(root.left);
            dfsDg(root.right);
        }
    }
    public static void dfsNotDg(TreeNode root) {
        TreeNode p = root;
        Stack<TreeNode> stack = new Stack<>();

        while (p != null || !stack.isEmpty()) {
            if (p != null) {
                System.out.print(p.val + " ");
                stack.push(p);
                p = p.left;
            } else {
                p = stack.pop();
                p = p.right;
            }
        }
    }

    // TODO 树广度遍历
    public static void bfs(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            System.out.print(poll.val + " ");
            if (poll.left != null) {
                queue.add(poll.left);
            }
            if (poll.right != null) {
                queue.add(poll.right);
            }
        }
    }
}
