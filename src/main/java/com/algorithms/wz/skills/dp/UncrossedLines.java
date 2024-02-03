package com.algorithms.wz.skills.dp;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/uncrossed-lines/description/">1035.不相交的线</a>
 * 在两条独立的水平线上按给定的顺序写下 nums1 和 nums2 中的整数。
 * <p>
 * 现在，可以绘制一些连接两个数字 nums1[i] 和 nums2[j] 的直线，这些直线需要同时满足满足：
 * <p>
 * nums1[i] == nums2[j]
 * 且绘制的直线不与任何其他连线（非水平线）相交。
 * 请注意，连线即使在端点也不能相交：每个数字只能属于一条连线。
 * <p>
 * 以这种方法绘制线条，并返回可以绘制的最大连线数。
 */
public class UncrossedLines {

    /**
     * 关于这道题目我没有思路，具体哪里没有想明白呢？就是我在连线过程中，如果想交了，应该保留哪一个，这道题目肯定也是二维数组来实现，dp 数组的
     * i 和 j 以及值分别就应该就是以 i - 1 结尾以及 j - 1 结尾的最大连线数，但是递推公式如何实现，目前还没有思路
     * 恍然大悟，这道题不就是求最长的公共子序列吗？
     * @param nums1 数组 1
     * @param nums2 数组 2
     * @return 最大的不相交的连续数
     */
    public int maxUncrossedLines(int[] nums1, int[] nums2) {
        // 最大连线数
        int result = 0;
        // 声明 dp 数组，i 和 j 以及值分别就应该就是以 i - 1 结尾以及 j - 1 结尾的最大连线数
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // 递推公式，这道题目不就是求最长公共子序列吗？
        // 如果值相等， dp[i][j] = dp[i - 1][j - 1] + 1
        // 不满足条件的话，就取前一位和上一位的最大值
        // 初始化，全部为 0 即可
        // 遍历
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }
}
