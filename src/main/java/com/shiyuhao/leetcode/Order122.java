package com.shiyuhao.leetcode;

/**
 * @Description
 * 买卖股票最大利润
 *
 * 给定一个数组，它的第 i 个元素是一支给定股票第 i 天的价格。
 * 设计一个算法来计算你所能获取的最大利润。你可以尽可能地完成更多的交易（多次买卖一支股票）。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）
 * 贪心算法：判断后一个值大于前一个值就获取两者差值加入到总利润中
 * @Author shiyuhao
 * @Email shi.yuhao@scimall.org.cn
 * @Date 2020/7/31 4:34 下午
 **/
public class Order122 {
    public static void main(String[] args) {
        int[] prices = new int[]{1, 5, 3, 6, 4};
        System.out.println(maxProfit(prices));
    }

    public static int maxProfit(int[] prices) {
        int sum = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                sum += prices[i] - prices[i - 1];
            }
        }
        return sum;
    }
}
