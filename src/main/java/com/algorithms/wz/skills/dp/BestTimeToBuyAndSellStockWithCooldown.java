package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-cooldown/description/">309.最佳买卖股票时机含冷冻期</a>
 * 给定一个整数数组prices，其中第  prices[i] 表示第 i 天的股票价格 。
 * <p>
 * 设计一个算法计算出最大利润。在满足以下约束条件下，你可以尽可能地完成更多的交易（多次买卖一支股票）:
 * <p>
 * 卖出股票后，你无法在第二天买入股票 (即冷冻期为 1 天)。
 * 注意：你不能同时参与多笔交易（你必须在再次购买前出售掉之前的股票）。
 */
public class BestTimeToBuyAndSellStockWithCooldown {

    /**
     * 没什么思路，先按照二维数组分情况来做吧
     *
     * @param prices 股票的价格
     * @return 最大的利润
     */
    public int maxProfit(int[] prices) {
        // 声明 dp 数组，数组 i 代表第 i 天，数组 j 代表4个值，0 表示持有，1表示卖出的持续状态，2表示卖出的状态，3表示冷冻期，值就是最大利润
        // 将卖出分为两种状态，卖出的持有和当天卖出的状态
        int[][] dp = new int[prices.length][4];
        // 那递推公式如何写呢？就是根据状态来推到，
        // 这里 0 表示持有，持有分两种，前一天持有和当天买入，当天买入的话前一天要么是冷冻期，要么是卖出的持续状态
        // dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
        // 1 表示卖出的持续状态，要么是前一天已经卖出，要么前一天是冷冻期
        // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3])
        // 2 表示当天卖出，那前一天一定是持有
        // dp[i][2] = dp[i - 1][0] + prices[i]
        // 3 表示冷冻期，那前一天一定是卖出
        // dp[1][3] = dp[i - 1][2]
        // 初始化
        dp[0][0] = -prices[0];
        dp[0][1] = 0;
        dp[0][2] = 0;
        dp[0][3] = 0;
        // 遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], Math.max(dp[i - 1][3] - prices[i], dp[i - 1][1] - prices[i]));
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][3]);
            dp[i][2] = dp[i - 1][0] + prices[i];
            dp[i][3] = dp[i - 1][2];
        }

        return Math.max(dp[prices.length - 1][1], Math.max(dp[prices.length - 1][2], dp[prices.length - 1][3]));
    }

}
