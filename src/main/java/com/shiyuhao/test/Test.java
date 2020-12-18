package com.shiyuhao.test;

import java.util.*;

/**
 * @Description TODO
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/8/26 3:35 下午
 **/
public class Test {
    public static void main(String[] args) {
        System.out.println(2147483647 - (-2147483647));

    }
    public List<String> summaryRanges(int[] nums) {
        List<String> strList = new ArrayList<>();
        int min = 0;
        int max = 0;
        while (max < nums.length) {
            while (max + 1 < nums.length && (nums[max + 1] - nums[max]) == 1) {
                max++;
            }
            if (max - min > 0) {
                strList.add(nums[min] + "->" + nums[max]);
            } else {
                strList.add(String.valueOf(nums[min]));
            }
            max++;
            min = max;
        }
        return strList;
    }
    public static int maxSubArray(int[] nums) {
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            if (sum > max) {
                max = sum;
            }
            if (sum <= 0) {
                sum = 0;
            }
        }
        return max;
    }

    public static int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] res = new int[2];
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                res[0] = i;
                res[1] = map.get(target - nums[i]);
                return res;
            }
            map.put(nums[i], i);
        }
        return res;
    }

    public static TreeNode helper(int[] preorder, int l, int r) {
        if (l >= r || l == -1) {
            return null;
        }
        int rootVal = preorder[l];
        TreeNode node = new TreeNode(rootVal);
        // 找出比rootVal大的第一个下标
        int index = r;
        for (int i = l;i < r; i++) {
            if (preorder[i] > rootVal) {
                index = i;
                break;
            }
        }
        node.left = helper(preorder, l + 1, index);
        node.right = helper(preorder, index, r);
        return node;
    }

    public static TreeNode constructMaximumBinaryTree(int[] nums) {
        return helper1(nums, 0, nums.length - 1);
    }

    public static TreeNode helper1(int[] nums, int l, int r) {
        if (l > r) {
            return null;
        }
        int index = -1;
        int max = Integer.MIN_VALUE;
        for (int i = l; i <= r; i++) {
            if (nums[i] > max) {
                index = i;
                max = nums[i];
            }
        }
        TreeNode temp = new TreeNode(max);
        temp.left = helper(nums, l, index - 1);
        temp.right = helper(nums, index + 1, r);
        return temp;
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
