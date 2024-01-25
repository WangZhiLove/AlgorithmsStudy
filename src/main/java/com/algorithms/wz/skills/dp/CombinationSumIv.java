package com.algorithms.wz.skills.dp;

import com.algorithms.wz.skills.backtracking.Combinations;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iv/description/">377. 组合总和 Ⅳ  </a>
 * 给你一个由 不同 整数组成的数组 nums ，和一个目标整数 target 。请你从 nums 中找出并返回总和为 target 的元素组合的个数。
 * <p>
 * 题目数据保证答案符合 32 位整数范围。
 */
public class CombinationSumIv {

    /**
     * 这道题目和零钱兑换 2 就有点类似了，但是不同点在于这道题目要求的顺序不同的序列可以视为不同的组合，其实说到这是不是可以用回溯
     * 但看这道题目的体量，回溯怕是要超时
     * <p>
     * 考虑顺序的话这道题目就不单单是组合，而是组合和排列，涉及到排列应该如何做呢？没想到是在遍历顺序上，先遍历背包，后遍历物品得到的是组合数，
     * 先遍历物品，后遍历背包得到的就是排列数
     *
     * @param nums   数组
     * @param target 目标和
     * @return 不同的种类
     */
    public int combinationSum4(int[] nums, int target) {
        // 声明 dp 数组， 索引就代表的是和，值代表的是多少中方法
        int[] dp = new int[target + 1];
        // 找出递推公式， dp[j] += dp[j - nums[i]]
        // 初始化 dp 数组，遇到这种类似的 dp[0] = 1
        dp[0] = 1;
        // 遍历
        for (int j = 0; j < dp.length; j++) {
            for (int i = 0; i < nums.length; i++) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[target];
    }

    public static void main(String[] args) {
        CombinationSumIv combinationSumIv = new CombinationSumIv();
        System.out.println(combinationSumIv.combinationSum4(new int[] {1, 2, 3}, 4));
    }

}
