package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/longest-continuous-increasing-subsequence/description/">674. 最长连续递增序列</a>
 * 给定一个未经排序的整数数组，找到最长且 连续递增的子序列，并返回该序列的长度。
 * <p>
 * 连续递增的子序列 可以由两个下标 l 和 r（l < r）确定，如果对于每个 l <= i < r，都有 nums[i] < nums[i + 1] ，那么子序列 [nums[l], nums[l + 1], ..., nums[r - 1], nums[r]] 就是连续递增子序列。
 */
public class LongestContinuousIncreasingSubsequence {

    /**
     * 好久没见到简单题目了呀，这道题目可以用双指针，也可以用动态规划，先试用双指针吧
     * @param nums 整数数组
     * @return 最长的连续递增子序列
     */
    public int findLengthOfLCIS(int[] nums) {
        // 开始索引
        int left = 0;
        int length = 1;
        for (int i = 1; i < nums.length; i++) {
            if (nums[i] <= nums[i - 1]) {
                length = Math.max(length, i - left);
                left = i;
            }
        }
        length = Math.max(length, nums.length - left);
        return length;
    }

    public static void main(String[] args) {
        LongestContinuousIncreasingSubsequence longestContinuousIncreasingSubsequence = new LongestContinuousIncreasingSubsequence();
        System.out.println(longestContinuousIncreasingSubsequence.findLengthOfLCIS(new int[]{1,3,5,7}));
        System.out.println(longestContinuousIncreasingSubsequence.findLengthOfLCIS(new int[]{2,2,2,2,2}));
    }

    /**
     * 如果使用动态规划呢？
     * @param nums 数组
     * @return 最长的连续递增子序列
     */
    public int findLengthOfLCIS2(int[] nums) {
        int length = 1;
        // 声明 dp 数组，值表示的是最长的连续递增子序列
        int[] dp = new int[nums.length];
        // 递推公式，就是判断当前索引值是否大于前已格索引值，如果大，则 dp[i] = dp[i - 1] + 1，否则 dp[i] = 1
        // 初始化，直接初始化索引 0 就可以
        dp[0] = 1;
        // 遍历
        for (int i = 1; i < dp.length; i++) {
            if (nums[i] > nums[i - 1]) {
                dp[i] = dp[i - 1] + 1;
            } else {
                dp[i] = 1;
            }
            length = Math.max(dp[i], length);
        }
        return length;
    }
}
