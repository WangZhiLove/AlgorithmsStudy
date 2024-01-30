package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iv/description/">188. 买卖股票的最佳时机 IV</a>
 * 给你一个整数数组 prices 和一个整数 k ，其中 prices[i] 是某支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 k 笔交易。也就是说，你最多可以买 k 次，卖 k 次。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class BestTimeToBuyAndSellStockIV {

    /**
     * 如果买卖股票三做出来了，那这个四
     * @param k 可以购买 k 次
     * @param prices 股票的价格
     * @return 最大的利润
     */
    public int maxProfit(int k, int[] prices) {
        // 声明 dp 数组，索引 i 表示第 i 天，索引 j 表示持有状态
        int[][] dp = new int[prices.length][2 * k + 1];
        // 递推公式，当天状态都是由前一天和当前的价格推到出来的，按照买卖股票 III 的思路
        // 初始化
        dp[0][0] = 0;
        for (int i = 1; i < 2 * k + 1; i++) {
            if (i % 2 == 0) {
                dp[0][i] = 0;
            } else {
                dp[0][i] = - prices[0];
            }
        }
        // 遍历
        for (int i = 1; i < prices.length; i++) {
            for (int j = 1; j < 2 * k + 1; j++) {
                if (j % 2 == 0) {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] + prices[i]);
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i - 1][j - 1] - prices[i]);
                }
            }
        }
        return dp[prices.length - 1][2 * k];
    }
}
