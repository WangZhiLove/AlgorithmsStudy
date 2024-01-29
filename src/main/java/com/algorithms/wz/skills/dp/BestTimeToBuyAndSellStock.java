package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock/description/">121. 买卖股票的最佳时机</a>
 * 给定一个数组 prices ，它的第 i 个元素 prices[i] 表示一支给定股票第 i 天的价格。
 * <p>
 * 你只能选择 某一天 买入这只股票，并选择在 未来的某一个不同的日子 卖出该股票。设计一个算法来计算你所能获取的最大利润。
 * <p>
 * 返回你可以从这笔交易中获取的最大利润。如果你不能获取任何利润，返回 0 。
 */
public class BestTimeToBuyAndSellStock {

    /**
     * 从动态规划进行优化一下
     *
     * @param prices 股票的价格
     * @return 最大的利润
     */
    public int maxProfit(int[] prices) {
        int min = prices[0], maxValue = 0;
        for (int i = 1; i < prices.length; i++) {
            maxValue = Math.max(maxValue, prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return maxValue;
    }

    /**
     * 动态规划五部曲来实现，只有定义好了 dp 数组，才有可能相处递推公式
     *
     * @param prices 股票的价格
     * @return 最大的利润
     */
    public int maxProfit2(int[] prices) {
        // 声明递推数组，索引表示 n 天，值表示前 n 天的最大利润
        int[] dp = new int[prices.length];
        // 递推公式 dp[i] = Math.max(dp[i - 1], price[i] - min)
        // 初始化
        dp[0] = 0;
        int min = prices[0];
        for (int i = 1; i < dp.length; i++) {
            dp[i] = Math.max(dp[i - 1], prices[i] - min);
            min = Math.min(min, prices[i]);
        }
        return dp[prices.length - 1];
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStock bestTimeToBuyAndSellStock = new BestTimeToBuyAndSellStock();
        System.out.println(bestTimeToBuyAndSellStock.maxProfit2(new int[] {7, 1, 5, 3, 6, 4}));
    }
}
