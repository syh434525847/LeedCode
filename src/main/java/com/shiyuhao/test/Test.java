package com.shiyuhao.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/26 3:35 下午
 **/
public class Test {
    public static void main(String[] args) {

        int i = 333;
        int b = i;
        System.out.println(i);
        System.out.println(b);
//        TreeNode head = new TreeNode(5);
//        head.left = new TreeNode(3);
//        head.right = new TreeNode(6);
//        head.left.left = new TreeNode(2);
//        head.left.right = new TreeNode(4);
//        head.left.left.left = new TreeNode(1);
//        head.right.right = new TreeNode(8);
//        head.right.right.left = new TreeNode(7);
//        head.right.right.right = new TreeNode(9);
//
//        List<Integer> list = new ArrayList<>();
//        helper(head, list);
//
//        TreeNode newhead = new TreeNode(0);
//        TreeNode temp = newhead;
//        for (int i = 0;i<list.size();i++) {
//            TreeNode cur = new TreeNode(list.get(i));
//            temp.right = cur;
//            temp.left = null;
//            temp = cur;
//        }
    }

    public static void helper(TreeNode root, List<Integer> list) {
        if(root == null) {
            return;
        }
        helper(root.left, list);
        list.add(root.val);
        helper(root.right, list);
    }

    static class TreeNode {
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode() {
        }

        TreeNode(int val) {
            this.val = val;
        }

        TreeNode(int val, TreeNode left, TreeNode right) {
            this.val = val;
            this.left = left;
            this.right = right;
        }
    }

}
