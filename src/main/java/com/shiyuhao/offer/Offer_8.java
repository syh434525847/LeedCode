package com.shiyuhao.offer;

import com.shiyuhao.common.TreeNode;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/22 5:20 下午
 **/
public class Offer_8 {
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

    }

    public static TreeNode getNextNode(TreeNode head, String target) {
        return null;
    }
}
