package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/best-time-to-buy-and-sell-stock-ii/description/">122. 买卖股票的最佳时机 II</a>
 * 给你一个整数数组 prices ，其中 prices[i] 表示某支股票第 i 天的价格。
 * <p>
 * 在每一天，你可以决定是否购买和/或出售股票。你在任何时候 最多 只能持有 一股 股票。你也可以先购买，然后在 同一天 出售。
 * <p>
 * 返回 你能获得的 最大 利润 。
 */
public class BestTimeToBuyAndSellStockIi {

    /**
     * 这个其实是求波谷和波峰的差值，直到这点再写代码就比较容易了
     *
     * @param prices 股票的价格
     * @return 最大的利润
     */
    public int maxProfit(int[] prices) {
        int result = 0;
        int left = -1;
        int right = 1;
        for (; right < prices.length; right++) {
            if (prices[right] >= prices[right - 1]) {
                if (left == -1) {
                    left = right - 1;
                }
            } else {
                if (left == -1) {
                    continue;
                }
                result += prices[right - 1] - prices[left];
                left = -1;
            }
        }
        if (left != -1) {
            result += prices[prices.length - 1] - prices[left];
        }
        return result;
    }

    public static void main(String[] args) {
        BestTimeToBuyAndSellStockIi bestTimeToBuyAndSellStockIi = new BestTimeToBuyAndSellStockIi();
        System.out.println(bestTimeToBuyAndSellStockIi.maxProfit3(new int[] {7, 1, 5, 3, 6, 4}));
        System.out.println(bestTimeToBuyAndSellStockIi.maxProfit3(new int[] {1, 2, 3, 4, 5}));
        System.out.println(bestTimeToBuyAndSellStockIi.maxProfit3(new int[] {7, 6, 4, 3, 1}));
        System.out.println(bestTimeToBuyAndSellStockIi.maxProfit3(new int[] {7, 6, 4, 3, 1, 4}));
    }

    /**
     * 优化一下，我一直和前一个对比，那我能不能和我找到的最小值对比呢？其实这个思路和我之前有点不同，这个是在递增子序列中每一个都计算
     *
     * @param prices 股票
     * @return 最大的利润
     */
    public int maxProfit2(int[] prices) {
        int result = 0;
        int minPrice = prices[0];
        for (int i = 1; i < prices.length; i++) {
            if (minPrice >= prices[i]) {
                minPrice = prices[i];
            } else {
                result += prices[i] - minPrice;
                minPrice = prices[i];
            }
        }
        return result;
    }

    public int maxProfit3(int[] prices) {
        int result = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= prices[i - 1]) {
                result += prices[i] - prices[i - 1];
            }
        }
        return result;
    }
}
