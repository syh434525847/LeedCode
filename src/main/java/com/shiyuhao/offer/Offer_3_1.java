package com.shiyuhao.offer;

/**
 * @Description 不修改数组找出重复的元素，在一个长度n+1的数组中所有数字都在1～n范围内，所以必定有元素重复，找出该重复的元素，但是不能修改数组
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/17 4:46 下午
 **/
public class Offer_3_1 {
    // 1。创建一个n+1的数组，然后将每个元素放到该数组的对应位置上，这样很容易找到重复的元素
    // 空间复杂度O(n)
    public static int getDuplicated(int[] nums, int n) {
        if (nums == null || n < 0) {
            return -1;
        }

        int[] temp = new int[n];

        for (int i = 0; i < n; i++) {
            int num = nums[i];
            int i1 = temp[num];
            if (i1 > 0) {
                return num;
            }
            temp[num] = num;
        }
        return -1;
    }

    // 2。类似二分查找方式查找，所有数都在1～n范围内，取中间数m，判断数组中1～m的出现的次数，如果大于m，则表示重复数字出现在1～m中
    // 并不能找出所有重复元素
    // TODO, 有问题
    public static int getDuplicated1(int[] nums, int n) {
        if (nums == null || n < 0) {
            return -1;
        }
        return getNum(nums, 1, n - 1);
    }

    private static int getNum(int[] nums, int start, int end) {

        if (end == start) {
            int scount = 0;
            for (int i = 0; i < nums.length; i++) {
                if (start == nums[i]) {
                    scount++;
                }
            }
            if (scount > 1) {
                return start;
            }
        }
        int mid = start + (end - start) / 2;
        int preCount = 0;
        int lastCount = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] >= start && nums[i] <= mid) {
                preCount++;
            }
            if (nums[i] >= mid + 1 && nums[i] <= end) {
                lastCount++;
            }
        }

        if (preCount > mid - start + 1) {
            return getNum(nums, start, mid);
        } else if (lastCount > end - (mid + 1) + 1) {
            return getNum(nums, mid + 1, end);
        }
        return -1;
    }

    public static int getDuplicated2(int[] nums, int n) {
        if (nums == null || n < 0) {
            return -1;
        }
        int start = 1;
        int end = n - 1;
        while (end >= start) {
            int mid = start + (end - start) / 2;
            int count = countRange(nums, n, start, mid);
            if (end == start) {
                if (count > 1) {
                    return start;
                } else {
                    break;
                }
            }
            if (count > mid - start + 1) {
                end = mid;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int countRange(int[] nums, int length, int start, int end) {
        int count = 0;
        for (int i = 0; i < length; i++) {
            if (nums[i] >= start && nums[i] <= end) {
                count++;
            }
        }
        return count;
    }

    public static void main(String[] args) {
//        int[] nums = new int[]{1,1,2,2,6,6,7,7};
//        int[] nums = new int[]{1,2,3,4,5,6,7,8};
//        int[] nums = new int[]{2, 3, 5, 4, 3, 2, 6, 7};
        int[] nums = null;
        System.out.println(getDuplicated1(nums, nums.length));
    }
}
