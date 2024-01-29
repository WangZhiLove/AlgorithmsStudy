package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">122. 买卖股票的最佳时机 II</a>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 */
public class BestTimeToBuyAndSellStockII {

    /**
     * 这道题目和一的不同之处在于我可以多次购买和多次卖出，这道题目之前做过，其实就是计算波峰，记录波低，一直求波峰就可以
     * @param prices 股票的价格
     * @return 最大利润
     */
    public int maxProfit(int[] prices) {
        int max = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > prices[i - 1]) {
                max += prices[i] - prices[i - 1];
            }
        }
        return max;
    }

    /**
     * 使用动态规划应该如何做呢
     * @param prices 股票的价格
     * @return 最大利润
     */
    public int maxProfit2(int[] prices) {
        // 声明 dp 数组，索引是前 n 天，值就是最大的利润
        int[] dp = new int[prices.length];
        // 递推公式： dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        // 初始化，dp[0] = 0
        // 遍历
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 1] + prices[i] - prices[i - 1]);
        }
        return dp[prices.length - 1];
    }

}
