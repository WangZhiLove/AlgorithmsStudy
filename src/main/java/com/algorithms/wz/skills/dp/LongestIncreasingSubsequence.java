package com.algorithms.wz.skills.dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/longest-increasing-subsequence/description/">300.最长递增子序列</a>
 * 给你一个整数数组 nums ，找到其中最长严格递增子序列的长度。
 * <p>
 * 子序列 是由数组派生而来的序列，删除（或不删除）数组中的元素而不改变其余元素的顺序。例如，[3,6,2,7] 是数组 [0,3,1,6,2,2,7] 的子序列。
 */
public class LongestIncreasingSubsequence {

    private List<Integer> list = new ArrayList<>();
    private int maxLen = 0;

    /**
     * 之前使用回溯做过类似的，这道题目其实也可以用回溯，还可以用贪心，就是枚举出所有的情况，找出最长严格递增子序列的长度，直接用双层 for 循环就可以实现
     * 双层 for 循环无法实现，还是需要使用回溯，使用回溯超出时间限制，所以还是得用动态规划
     *
     * @param nums 数组
     * @return 最长的子序列
     */
    public int lengthOfLIS(int[] nums) {
        lengthOfLIS(nums, 0);
        return maxLen;
    }

    private void lengthOfLIS(int[] nums, int index) {
        if (index >= nums.length) {
            maxLen = Math.max(maxLen, list.size());
            return;
        }
        for (int i = index; i < nums.length; i++) {
            if (list.isEmpty() || list.get(list.size() - 1) < nums[i]) {
                list.add(nums[i]);
                lengthOfLIS(nums, i + 1);
                list.remove(list.size() - 1);
            } else {
                lengthOfLIS(nums, i + 1);
            }
        }
    }

    public static void main(String[] args) {
        LongestIncreasingSubsequence longestIncreasingSubsequence = new LongestIncreasingSubsequence();
//        System.out.println(longestIncreasingSubsequence.lengthOfLIS1(new int[] {7, 7, 7, 7, 7, 7, 7, 7}));
//        System.out.println(longestIncreasingSubsequence.lengthOfLIS1(new int[] {10, 9, 2, 5, 3, 7, 101, 18}));
        System.out.println(longestIncreasingSubsequence.lengthOfLIS1(new int[] {1,3,6,7,9,4,10,5,6}));
    }

    /**
     * 使用动态规划，五部曲开始，这里开始没有想清楚，其实我遇到每一个元素都和计算过的所有元素对比一边，然后找出加上当前元素的最大值就可以了
     * @param nums 数组
     * @return 最长递增子序列
     */
    public int lengthOfLIS1(int[] nums) {
        // 声明 dp 数组，值表示的是以索引 i 为结尾的最长子序列的长度
        int[] dp = new int[nums.length];
        // 递推公式 dp[i] 要和计算过的每一个元素进行对比
        // 这里初始化0位置的最长
        dp[0] = 1;
        // 清楚 dp 数组的含义，就知道最长子序列的长度存储在哪里了
        int maxLen = 1;
        // 遍历
        for (int i = 1; i < dp.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                } else if (dp[i] == 0){
                    dp[i] = 1;
                }
            }
            maxLen = Math.max(dp[i], maxLen);
        }
        return maxLen;
    }

}
