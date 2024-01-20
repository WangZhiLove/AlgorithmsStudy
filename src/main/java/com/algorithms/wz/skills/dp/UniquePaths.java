package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/unique-paths/description/">62.不同路径</a>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish” ）。
 * <p>
 * 问总共有多少条不同的路径？
 */
public class UniquePaths {

    /**
     * 有多少不同的路径，只能向下或者向右，所以能到对角的就是前一格和上一格的路数总和
     * @param m 行
     * @param n 列
     * @return 达到中点的总路径
     */
    public int uniquePaths(int m, int n) {
        // m 行和 n 列，先声明 dp 数组，dp 数组的行列就对应着网格，网格对应的值代表的到这个格不同的路径
        int[][] dp = new int[m][n];
        // 找出递推公式 dp[m][n] = dp[m - 1][n] + dp[m][n - 1];
        // 初始化 dp 数组，也就是 0 行 0 列初始化为 1
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        // 接下来就是遍历二维数组，求出每一个格子的不同路数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePaths uniquePaths = new UniquePaths();
        System.out.println(uniquePaths.uniquePaths(3, 7));
    }

}
