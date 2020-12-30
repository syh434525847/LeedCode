package com.shiyuhao.offer;

/**
 * @Description 剪绳子问题
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/29 1:29 下午
 **/
public class Offer_14 {
    public static void main(String[] args) {
        System.out.println(max(4));
        System.out.println(max2(4));
    }

    // 动态规划
    public static int max(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }

        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
        dp[2] = 2;
        dp[3] = 3;
        int max = 0;
        for (int i = 4; i <= n; i++) {
            max = 0;
            for (int j = 1; j <= i / 2; j++) {
                int temp = dp[j] * dp[i - j];
                if (temp > max) {
                    max = temp;
                }
                dp[i] = max;
            }
        }
        max = dp[n];
        return max;
    }

    // 贪婪
    public static int max2(int n) {
        if (n < 2) {
            return 0;
        }
        if (n == 2) {
            return 1;
        }
        if (n == 3) {
            return 2;
        }
        int groupOf3 = n / 3;
        int last = n - 3 * groupOf3;
        if (last == 1) {
            groupOf3--;
        }

        int groupOf2 = (n - 3 * groupOf3) / 2;
        double sum = Math.pow(3, groupOf3) * Math.pow(2, groupOf2);
        return (int) sum;
    }

}
