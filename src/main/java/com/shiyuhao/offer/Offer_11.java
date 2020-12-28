package com.shiyuhao.offer;

/**
 * @Description 旋转数组找最小值
 * 利用二分查找的思想，两个指针，一个放在头，一个放在尾，然后找到中间元素，如果中间元素大于头指针，说明这个元素在前半段的数组中，
 * 如果中间元素小于尾指针，则说明中间元素在后半段的数组中，最后当两个指针位置差一的时候，尾指针指向的数字就是最小值
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/24 2:13 下午
 **/
public class Offer_11 {
    public static void main(String[] args) {
        int[] arr = new int[]{1,1,1,0,1};
        System.out.println(xz(arr));
    }

    public static int xz(int[] arr) {
        if (arr.length == 0) {
            throw new IllegalArgumentException("数组无效");
        }
        if (arr.length < 2) {
            return arr[0];
        }
        int p = 0;
        int q = arr.length - 1;
        int mid = 0;
        while (arr[p] >= arr[q]) {
            if (q - p == 1) {
                mid = q;
                break;
            }
            mid = (q + p) / 2;
            if (arr[mid] == arr[p] && arr[mid] == arr[q]) {
                int min = arr[0];
                for (int i = 1; i < arr.length; i++) {
                    if (arr[i] < min) {
                        min = arr[i];
                    }
                }
                return min;
            }
            if (arr[mid] >= arr[p]) {
                p = mid;
            } else if (arr[mid] <= arr[q]) {
                q = mid;
            }
        }
        return arr[mid];
    }
}
