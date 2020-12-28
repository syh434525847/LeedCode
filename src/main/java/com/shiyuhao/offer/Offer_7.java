package com.shiyuhao.offer;

import com.shiyuhao.common.TreeNode;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/22 4:34 下午
 **/
public class Offer_7 {
    public static void main(String[] args) {
        int[] pred = new int[]{1, 2, 4, 7, 3, 5, 6, 8};
        int[] mid = new int[]{4, 7, 2, 1, 5, 3, 8, 6};
        TreeNode treeNode = buildTree(pred, mid);
        System.out.println(treeNode);
    }

    public static TreeNode buildTree(int[] pred, int[] mid) {
        if (pred.length == 0 || mid.length == 0) {
            return null;
        }
        return helper(pred, 0, pred.length - 1, mid, 0, mid.length - 1);
    }

    public static TreeNode helper(int[] pred, int preStart, int preEnd, int[] mid, int midStart, int midEnd) {
        if (preStart > preEnd || midStart > midEnd) {
            return null;
        }
        int headVal = pred[preStart];
        // 创建头节点
        TreeNode head = new TreeNode(headVal, null, null);
        // 在中序遍历数组中找到左右分支的位置
        int i = midStart;
        while (midStart <= midEnd) {
            if (headVal == mid[i]) {
                head.left = helper(pred, preStart + 1, preStart + i - midStart, mid, midStart, i - 1);
                head.right = helper(pred, preStart + 1 + i - midStart, preStart + i - midStart + midEnd - i, mid, i + 1, i + midEnd - i);
                break;
            }
            i++;
        }
        return head;
    }
}
