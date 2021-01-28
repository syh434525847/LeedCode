package com.shiyuhao.offer;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * @Description 长度为n的数组中找出数组中任意一个重复的数字{2,3,1,0,2,5,1}，重复数字2或3，数组中数字在0～n-1范围中
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/16 1:59 下午
 **/
public class Offer_3 {
    // 1。排序后轮训判断
    public static boolean duplicated1(int[] nums, int n) {
        if (nums == null || n == 0) {
            return false;
        }
        // 边界判断，是否都在0～n-1范围内
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] > n - 1) {
                return false;
            }
        }
        Arrays.sort(nums);
        for (int i = 1; i < n; i++) {
            if (nums[i] == nums[i - 1]) {
                return true;
            }
        }
        return false;
    }
    // 2。放入map中，然后判断
    public static boolean duplicated2(int[] nums, int n) {
        if (nums == null || n == 0) {
            return false;
        }
        // 边界判断，是否都在0～n-1范围内
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] > n - 1) {
                return false;
            }
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            if (map.containsKey(nums[i])) {
                return true;
            } else {
                map.put(nums[i], i);
            }
        }
        return false;
    }

    // {1，3，2，0，2，5，3}
    // 第一次循环后：3，1，2，0，2，5，3
    // 第二次循环后：0，1，2，3，2，5，3
    // 第三次循环后：发现下标为4的数字与下标为2的数字相同，则说明是重复数字
    public static boolean duplicated3(int[] nums, int n) {
        if (nums == null || n == 0) {
            return false;
        }
        // 边界判断，是否都在0～n-1范围内
        for (int i = 0; i < n; i++) {
            if (nums[i] < 0 || nums[i] > n - 1) {
                return false;
            }
        }

        int i = 0;
        while (i < n) {
            if (i == nums[i]) {
                i++;
            } else {
                if (nums[i] == nums[nums[i]]) {
                    return true;
                }
                // swap nums[i] to nums[nums[i]]
                int temp = nums[i];
                nums[i] = nums[temp];
                nums[temp] = temp;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] nums = new int[]{2, 3, 1, 0, 5, 3};
        System.out.println(duplicated1(nums, nums.length));
        System.out.println(duplicated2(nums, nums.length));
        System.out.println(duplicated3(nums, nums.length));
    }
}
