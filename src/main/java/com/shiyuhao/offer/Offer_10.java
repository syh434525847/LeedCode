package com.shiyuhao.offer;

/**
 * @Description 斐波那契数列
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/12/23 2:37 下午
 **/
public class Offer_10 {
    public static void main(String[] args) {
        System.out.println(fibonacci(48));
        System.out.println(fibonacciByDp(48));
        System.out.println(fibonacciB(48));
    }
    // 递归实现，效率最差
    public static int fibonacci(int i) {
        if (i == 0) {
            return 0;
        }
        if (i == 1) {
            return 1;
        }
        return fibonacci(i - 1) + fibonacci(i - 2);
    }

    // 动态规划实现
    public static int fibonacciByDp(int n) {
        int[] dp = new int[n + 1];
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    private static int fibonacciB(int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1 || n == 2) {
            return 1;
        }
        int[] arr = new int[n +1];
        arr[1] = 1;
        arr[2] = 1;
        for(int i = 3;i< n+1;i++) {
            arr[i] = arr[i-1] + arr[i-2];
        }
        return arr[n];
    }
}
