package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-with-transaction-fee/description/">714.买卖股票的最佳时机含手续费  </a>
 * 给定一个整数数组 prices，其中 prices[i]表示第 i 天的股票价格 ；整数 fee 代表了交易股票的手续费用。
 * <p>
 * 你可以无限次地完成交易，但是你每笔交易都需要付手续费。如果你已经购买了一个股票，在卖出它之前你就不能再继续购买股票了。
 * <p>
 * 返回获得利润的最大值。
 * <p>
 * 注意：这里的一笔交易指买入持有并卖出股票的整个过程，每笔交易你只需要为支付一次手续费。
 */
public class BestTimeToBuyAndSellStockWithTransactionFee {

    /**
     * 这道题目其实和买卖股票 II 差不多，我做买卖股票 2 的时候计算的是波峰，但是这里不可以，这里要支付手续费，如果手续费超过本次的利润，
     * 那就不适合交易了，这么看递归更简单点，动用动态规划来实现吧
     *
     * @param prices 股票 i 天价格
     * @param fee    手续费
     * @return 最大的利润
     */
    public int maxProfit(int[] prices, int fee) {
        // 声明 dp 数组，索引 i 表示第 i 天，索引 j 表示情况，有两种 0 表示持有，1表示卖出
        int[][] dp = new int[prices.length][2];
        // 递推公式
        // 当天持有要么是保持持有状态，要么是前一天卖出，当天买入，扣除手续费
        // dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee)
        // 当天卖出则要么前一天就是卖出，要么前一天持有，当前卖出
        // dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i])
        // 初始化
        dp[0][0] = -prices[0] - fee;
        dp[0][1] = 0;
        // 遍历
        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.max(dp[i - 1][0], dp[i - 1][1] - prices[i] - fee);
            dp[i][1] = Math.max(dp[i - 1][1], dp[i - 1][0] + prices[i]);
        }
        return dp[prices.length - 1][1];
    }

}
