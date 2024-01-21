package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/unique-paths-ii/description/">63. 不同路径 II</a>
 * 一个机器人位于一个 m x n 网格的左上角 （起始点在下图中标记为 “Start” ）。
 * <p>
 * 机器人每次只能向下或者向右移动一步。机器人试图达到网格的右下角（在下图中标记为 “Finish”）。
 * <p>
 * 现在考虑网格中有障碍物。那么从左上角到右下角将会有多少条不同的路径？
 * <p>
 * 网格中的障碍物和空位置分别用 1 和 0 来表示。
 */
public class UniquePathsII {

    /**
     * 这个和不同路径有点相似，就是涉及到了阻碍物，如果是阻碍物，那就是 0
     * @param obstacleGrid 网格
     * @return 不同的路径
     */
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int m = obstacleGrid.length, n = obstacleGrid[0].length;
        if (obstacleGrid[0][0] == 1 || obstacleGrid[m - 1][n - 1] == 1) {
            return 0;
        }
        // m 行和 n 列，先声明 dp 数组，dp 数组的行列就对应着网格，网格对应的值代表的到这个格不同的路径
        int[][] dp = new int[m][n];
        // 找出递推公式 dp[m][n] = dp[m - 1][n] + dp[m][n - 1];
        // 初始化 dp 数组，也就是 0 行 0 列初始化为 1，遇到阻碍物直接退出
        for (int i = 0; i < m; i++) {
            if (obstacleGrid[i][0] == 0){
                dp[i][0] = 1;
            } else {
                break;
            }
        }
        for (int j = 0; j < n; j++) {
            if (obstacleGrid[0][j] == 0){
                dp[0][j] = 1;
            } else {
                break;
            }
        }
        // 接下来就是遍历二维数组，求出每一个格子的不同路数
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < dp[i].length; j++) {
                if (obstacleGrid[i][j] == 0) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return dp[m - 1][n - 1];
    }

    public static void main(String[] args) {
        UniquePathsII uniquePathsII = new UniquePathsII();
        System.out.println(uniquePathsII.uniquePathsWithObstacles(new int[][]{{0,0}, {1,1}, {0,0}}));
    }
}
