package com.shiyuhao.offer;

/**
 * @Description 二维数组中，每一行都按照从左到右递增的顺序排列，每一列都按照从上到下递增的顺序排列，在这个二维数组中查找对应的元素，找到返回true，没找到返回false
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/18 5:15 下午
 **/
public class Offer_4 {

    public static void main(String[] args) {
        int[][] nums = new int[][]{
                {1, 2, 8, 9},
                {2, 4, 9, 12},
                {4, 7, 10, 13},
                {6, 8, 11, 15}
        };
        boolean found = getNum(nums, 5, nums.length, nums[0].length);
        System.out.println(found);
    }

    public static boolean getNum(int[][] nums, int target, int rowNum, int colNum) {
        int n = 0;
        int m = colNum - 1;
        boolean found = false;
        while (n < rowNum && m >= 0) {
            int curNum = nums[n][m];
            if (curNum == target) {
                found = true;
                break;
            }
            if (curNum > target) {
                m--;
            } else {
                n++;
            }
        }
        return found;
    }

}
