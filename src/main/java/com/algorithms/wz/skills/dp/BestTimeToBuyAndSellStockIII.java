package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-iii/description/">123. 买卖股票的最佳时机 III</a>
 * 给定一个数组，它的第 i 个元素是一支给定的股票在第 i 天的价格。
 * <p>
 * 设计一个算法来计算你所能获取的最大利润。你最多可以完成 两笔 交易。
 * <p>
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class BestTimeToBuyAndSellStockIII {

    /**
     * 分情况讨论，这个非常不容易想到，思维还是想不到
     * @param prices 股票的价格
     * @return 最大的利润
     */
    public int maxProfit(int[] prices) {
        // 声明 dp 数组，这里要用到二维 dp 数组，索引 i 表示第 i 天，索引 j 表示持有状态，分别是不操作、第一次持有、第一次卖出、
        // 第二次持有、第二次卖出，这个 dp 数组很重要
        int[][] dp = new int[prices.length][5];
        // 递推公式
        // dp[i][0] = dp[i - 1][0] 不进行操作
        // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - price[i]) 前一天持有或者是当天买入
        // dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + price[i]) 前一天卖出或者是当前卖出，当天卖出前一天肯定是持有
        // dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] - price[i]) 同上
        // dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + price[i]) 同上
        // 初始化
        dp[0][0] = 0;
        dp[0][1] = - prices[0];
        dp[0][2] = 0;
        dp[0][3] = - prices[0];
        dp[0][4] = 0;
        // 遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] - prices[i]);
            dp[i][2] = Math.max(dp[i - 1][2], dp[i - 1][1] + prices[i]);
            dp[i][3] = Math.max(dp[i - 1][3], dp[i - 1][2] + prices[i]);
            dp[i][4] = Math.max(dp[i - 1][4], dp[i - 1][3] + prices[i]);
        }
        // 这里直接返回第二次卖出的价格就可以，因为第二次肯定包括了第一次
        return dp[prices.length - 1][4];
    }

}
