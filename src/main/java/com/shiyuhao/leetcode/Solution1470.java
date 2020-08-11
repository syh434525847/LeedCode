package com.shiyuhao.leetcode;

/**
 * @Description leetcode1470 重新排列新数组
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/6/23 4:46 下午
 **/
public class Solution1470 {

    public static void main(String[] args) {
        Solution1470 solution1470 = new Solution1470();
        int[] shuffle = solution1470.shuffle(new int[]{1,2,3,4,4,3,2,1}, 4);
        for (int i = 0; i < shuffle.length; i++) {
            System.out.println(shuffle[i]);
        }
    }

    public int[] shuffle(int[] nums, int n) {
        // 原数组上的迁移，n到2n的元素每个需要向前移动n-1次，n-2次，n-3次
        // j为要移动的次数
//        int j = n - 1;
//        for (int i = n; i < 2 * n; i++) {
        // 定义要移动的元素
//            int m = i;
//            for (int k = j; k > 0; k--) {
//                int temp = nums[m];
//                nums[m] = nums[m - 1];
//                nums[m - 1] = temp;
//                m--;
//            }
        // 移动完毕后需要减1，用于下一个元素的移动
//            j--;
//        }
//        return nums;

        // 开辟新数组的方式
        if (n <= 1) {
            return nums;
        }
        int[] result = new int[2 * n];
        int index = 0;
        for (int i = 0; i < n; i++) {
            result[index++] = nums[i];
            result[index++] = nums[i + n];
        }

        return result;
    }
}
