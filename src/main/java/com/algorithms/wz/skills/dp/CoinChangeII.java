package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/coin-change-ii/description/"> 518. 零钱兑换 II</a>
 * 给你一个整数数组 coins 表示不同面额的硬币，另给一个整数 amount 表示总金额。
 * <p>
 * 请你计算并返回可以凑成总金额的硬币组合数。如果任何硬币组合都无法凑出总金额，返回 0 。
 * <p>
 * 假设每一种面额的硬币有无限个。
 * <p>
 * 题目数据保证结果符合 32 位带符号整数。
 */
public class CoinChangeII {

    /**
     * 看到每个面额的硬币有无限个就可以理解为完全背包问题了，只要是装满背包，那当前背包的方法就要和前面的方法相加，而不是对比的关系
     * @param amount 金额
     * @param coins 不同面额的硬币
     * @return 不同面额的硬币构成金额的不同的组合数
     */
    public int change(int amount, int[] coins) {
        // 先声明 dp 数组，dp 数组的索引就是金额，值就是多少种不同的组合数
        int[] dp = new int[amount + 1];
        // 找出递推公式，dp[j] += dp[j - coins[i]]，为什么是这个呢？想想之前的目标和，只要是装满背包，基本都是这个公式
        // 这个就是 现在是物品 coins[i]，那我要达到 j，就看看 容量为 dp[j - coins[i]] 有多少种方法，那就是物品 coins[i] 的组合数
        // 初始化 dp 数组
        dp[0] = 1;
        // 遍历，现遍历物品，后遍历背包
        for (int i = 0; i < coins.length; i++) {
            for (int j = coins[i]; j < dp.length; j++) {
                dp[j] += dp[j - coins[i]];
            }
        }
        return dp[amount];
    }

    public static void main(String[] args) {
        CoinChangeII coinChangeII = new CoinChangeII();
        System.out.println(coinChangeII.change(5, new int[]{1,2,5}));
    }

}
