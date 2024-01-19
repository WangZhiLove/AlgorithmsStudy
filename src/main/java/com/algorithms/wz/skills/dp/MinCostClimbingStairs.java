package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/min-cost-climbing-stairs/description/">746. 使用最小花费爬楼梯</a>
 * 给你一个整数数组 cost ，其中 cost[i] 是从楼梯第 i 个台阶向上爬需要支付的费用。一旦你支付此费用，即可选择向上爬一个或者两个台阶。
 * <p>
 * 你可以选择从下标为 0 或下标为 1 的台阶开始爬楼梯。
 * <p>
 * 请你计算并返回达到楼梯顶部的最低花费。
 */
public class MinCostClimbingStairs {

    /**
     * 计算爬到楼顶的最小花销
     * @param cost 当前层向上一层爬需要支付的费用
     * @return 最低花费
     */
    public int minCostClimbingStairs(int[] cost) {
        if (cost.length == 2) {
            return Math.min(cost[0], cost[1]);
        }
        // 想想想 dp 数组，还是一维数组，索引表示爬到当前台阶，值表示到大台阶的最小花销
        int[] dp = new int[cost.length + 1];
        // 想想递推公式，递推公式就是 dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2)，思路就是免费到第 0 和第 1 个台阶
        // 那到到第 2 个台阶就是到达 0 的最小开销 + cost[0]，到达 1 的最小开销 + cost[1]，就是这样的

        // 初始化 dp 数组，暂时不需要，因为 dp[0] 和 dp[1] 都是可以直接到的，默认是 0

        // 遍历，从 2 开始，因为题目中说明从下标 0 或者 1 开始爬
        for (int i = 2; i < dp.length; i++) {
            dp[i] = Math.min(dp[i - 1] + cost[i - 1], dp[i - 2] + cost[i - 2]);
        }
        return dp[dp.length - 1];
    }

}
