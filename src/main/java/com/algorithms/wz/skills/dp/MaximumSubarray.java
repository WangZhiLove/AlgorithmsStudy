package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">53. 最大子序和</a>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 */
public class MaximumSubarray {
    /**
     * 这道题目之前做过，可以暴力破解，双层 for 循环，分别以不同元素为起点，求最长子序列，但是由于数组元素过多，因此可能超时，所以优化一下，
     * 使用动态规划的思路来实现
     *
     * @param nums 数组
     * @return 最大子数组的和
     */
    public int maxSubArray(int[] nums) {
        // 最大子数组和
        int result = nums[0];
        // 声明 dp，dp 就是最大子数组的和
        int[] dp = new int[nums.length];
        // 递推公式 dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
        // 初始化
        dp[0] = nums[0];
        // 遍历
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1] + nums[i], nums[i]);
            result = Math.max(result, dp[i]);
        }
        return dp[nums.length - 1];
    }

    /**
     * 其实可以去掉 dp 数组
     *
     * @param nums 数组
     * @return 最大子数组的和
     */
    public int maxSubArray1(int[] nums) {
        // 声明 dp，dp 就是最大子数组的和
        int result = nums[0];
        int sum = nums[0];
        // 遍历
        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);
            result = Math.max(result, sum);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }
}
