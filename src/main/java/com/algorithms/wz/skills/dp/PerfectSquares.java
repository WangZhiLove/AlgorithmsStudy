package com.algorithms.wz.skills.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/perfect-squares/description/">279. 完全平方数</a>
 * 给你一个整数 n ，返回 和为 n 的完全平方数的最少数量 。
 * <p>
 * 完全平方数 是一个整数，其值等于另一个整数的平方；换句话说，其值等于一个整数自乘的积。例如，1、4、9 和 16 都是完全平方数，而 3 和 11 不是。
 */
public class PerfectSquares {

    /**
     * 这道题目我不是很有思路，但是我做出来了，按照动态规划五部曲
     * @param n 整数 n
     * @return 返回 和为 n 的完全平方数的最少数量
     */
    public int numSquares(int n) {
        // 首先确定 dp 数组，索引肯定就是整数，那值就是和为索引的完全平方数的最少数量
        int[] dp = new int[n + 1];
        // 这里就是难点了，递推公式是什么呢？，关键是转化成了完全背包问题，这道题目的背包确定了，物品就是所有的完全平方数，这个没办法量化
        // 所以这里就是难点了，那我是不是可以找到 n 之前所有的完全平方数呢，理论上可以，
        List<Integer> perfSquare = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            if (isPerfectSquare(i)) {
                perfSquare.add(i);
            }
        }
        // 物品有了，那递推公式是什么呢? dp[j] = Math.min(dp[j], dp[j - perfSquare[i]] + 1);
        // 初始化
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        // 遍历，物品背包
        for (int i = 0; i < perfSquare.size(); i++) {
            for (int j = perfSquare.get(i); j < dp.length; j++) {
                dp[j] = Math.min(dp[j], dp[j - perfSquare.get(i)] + 1);
            }
        }
        return dp[n];
    }

    public boolean isPerfectSquare(int num) {
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public static void main(String[] args) {
        PerfectSquares perfectSquares = new PerfectSquares();
        System.out.println(perfectSquares.numSquares(12));
        // System.out.println(perfectSquares.numSquares(13));
    }

}
