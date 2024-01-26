package com.algorithms.wz.skills.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/coin-change/description/">322. 零钱兑换</a>
 * 给你一个整数数组 coins ，表示不同面额的硬币；以及一个整数 amount ，表示总金额。
 * <p>
 * 计算并返回可以凑成总金额所需的 最少的硬币个数 。如果没有任何一种硬币组合能组成总金额，返回 -1 。
 * <p>
 * 你可以认为每种硬币的数量是无限的。
 */
public class CoinChange {

    /**
     * 这道题目计算的是最少的硬币个数，之前的都是方法，所以这道题目我的思想就是计算出每一个金额的最少硬币数来计算
     * <p>
     * 完全背包问题
     *
     * @param coins  整数数组
     * @param amount 总金额
     * @return 最少的硬币个数
     */
    public int coinChange(int[] coins, int amount) {
        // 声明 dp 数组，dp 数组的索引代表着金额，值代表构成这个金额最少的硬币个数
        int[] dp = new int[amount + 1];
        // 递推公式是什么呢？这个比较关键，dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1)
        // 如何初始化呢？这里的初始化就比较有意思了，因为我们用的是 min，求最少的硬币个数，所以初始化为多少合适呢？
        // 这道题目就难在初始化，现在做出来了，看看为什么这么初始化话，首先呢，dp[0] 肯定是 0，因为 0 不可能有任何硬币可以组成
        // 其实非 0 下标初始化为 int 的最大值就可以，为什么呢？这是因为我们要求 min，为了防止初始值覆盖，这里脑袋没转过来
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;
        // 遍历，这里只能正序遍历，因为后面的要使用前面的结果
        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i < coins.length; i++) {
                if (j >= coins[i]) {
                    dp[j] = Math.min(dp[j], dp[j - coins[i]] + 1);
                }
            }
        }
        return dp[amount] > amount ? -1 : dp[amount];
    }

    public static void main(String[] args) {
        CoinChange coinChange = new CoinChange();
        /*System.out.println(coinChange.coinChange(new int[] {1, 2, 5}, 11));
        System.out.println(coinChange.coinChange(new int[] {2}, 3));
        System.out.println(coinChange.coinChange(new int[] {1}, 0));*/
        System.out.println(coinChange.coinChange(new int[] {83, 186, 408, 419}, 6249));
    }

}
