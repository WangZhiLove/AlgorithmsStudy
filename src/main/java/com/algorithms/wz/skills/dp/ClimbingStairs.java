package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/climbing-stairs/description/">70. 爬楼梯</a>
 * 假设你正在爬楼梯。需要 n 阶你才能到达楼顶。
 * <p>
 * 每次你可以爬 1 或 2 个台阶。你有多少种不同的方法可以爬到楼顶呢？
 */
public class ClimbingStairs {

    /**
     * 继续动态规划
     * @param n n 阶
     * @return 到达楼顶的方法
     */
    public int climbStairs(int n) {
        if (n <= 2) {
            return n;
        }
        // 首先确定 dp 数组，下标表示第几个台阶，值表示到大这个台阶有多少种不同的方法
        int[] dp = new int[n + 1];
        // 确定递推公式，想一想 0 肯定是 0，1 肯定是 1，那 2 就是两种，要么是两次一个台阶，要么是一次两个台阶
        // 0
        // 1：1
        // 2：1 1；2
        // 3: 1 1 1；1 2； 2 1
        // 4：1 1 1 1； 1 2 1；1 1 2；2 1 1； 2 2
        // 所以递推公式和斐波那契数列是相同的，dp[i] = dp[i - 1] + dp[i - 2];为什么呢？因为每次可以爬 1 或 2 个台阶，
        // 所以上到第 n 层就可以是上到第 n - 1 的方法后面都加 1，或者是上到 n - 2 层方法后面都加 2，由此得到递推公式
        // 初始化 dp
        dp[1] = 1;
        dp[2] = 2;
        // 遍历
        for (int i = 3; i < dp.length; i++) {
            dp[i] = dp[i - 2] + dp[i - 1];
        }
        return dp[n];
    }

}
