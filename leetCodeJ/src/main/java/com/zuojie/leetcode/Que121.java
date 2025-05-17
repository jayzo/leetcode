package com.zuojie.leetcode;

/**
 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。

 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。

 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 * https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/?envType=study-plan-v2&envId=top-interview-150
 */
public class Que121 {
    public int maxProfit(int[] prices) {
        if (prices.length <= 1) {
            return 0;
        }
        int[] minPrice = new int[prices.length];
        minPrice[0] = prices[0];
        int maxFit = 0;
        for (int i = 1; i< prices.length; i++) {
            int sell = prices[i];
            int buy = minPrice(prices, minPrice, i);
            if (sell > buy && sell - buy > maxFit) {
                maxFit = sell - buy;
            }
        }
        return maxFit;
    }
    private int minPrice(int[] prices, int[] minPrice, int sellIdx) {
        minPrice[sellIdx] = Math.min(minPrice[sellIdx - 1], prices[sellIdx]);
        return minPrice[sellIdx];
    }

    public static void main(String[] args) {
        Que121 que = new Que121();
        int[] nums = {0,0,1,1,8,1,2,3,3};
        int k = que.maxProfit(nums);

        System.out.printf(k + "");

    }
}
