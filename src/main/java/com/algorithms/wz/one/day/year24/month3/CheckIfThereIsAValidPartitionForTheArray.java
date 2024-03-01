package com.algorithms.wz.one.day.year24.month3;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/check-if-there-is-a-valid-partition-for-the-array/description/">2369.检查数据是否存在有效划分</a>
 * 给你一个下标从 0 开始的整数数组 nums ，你必须将数组划分为一个或多个 连续 子数组。
 * <p>
 * 如果获得的这些子数组中每个都能满足下述条件 之一 ，则可以称其为数组的一种 有效 划分：
 * <p>
 * 子数组 恰 由 2 个相等元素组成，例如，子数组 [2,2] 。
 * 子数组 恰 由 3 个相等元素组成，例如，子数组 [4,4,4] 。
 * 子数组 恰 由 3 个连续递增元素组成，并且相邻元素之间的差值为 1 。例如，子数组 [3,4,5] ，但是子数组 [1,3,5] 不符合要求。
 * 如果数组 至少 存在一种有效划分，返回 true ，否则，返回 false 。
 */
public class CheckIfThereIsAValidPartitionForTheArray {

    /**
     * 没有思路，那能不能暴力破解呢？想不出来，看了下提示，使用动态规划会更好一点，那问题来了，我怎么能想到这道题目是使用动态规划呢？
     * 如果当前的状态要依靠之前的状态推导出来，那大概率就是动态规划了，动态规划的难点就是动态规划五步曲，在这个题目中，当前的节点状态有 n - 2 或者
     * n - 3 这两个节点确认，有一个判断出来为真，那就为真，还得多练，水平不足呀
     * @param nums 给定的数组
     * @return 返回是否存在有效划分
     */
    public boolean validPartition(int[] nums) {
        // 声明 dp 数组，明确 dp 数组的含义，含义是前 n 个元素是否存在有效划分
        boolean[] dp = new boolean[nums.length + 1];
        // 找出递推公式，这块就有点难了，如果存在，那加上当前元素是否还存在呢？这里就是逻辑了，求求了，动动脑子吧
        // 这里就划分为两种情况，两个是或者的关系：
        // 1. 前 n - 2 存在有效划分，并且后两个元素相等
        // 2. 前 n - 3 存在有效划分，后三个元素递增，并且相差1
        // 数组初始化
        Arrays.fill(dp, false);
        dp[0] = true;
        // 遍历
        for (int i = 2; i <= nums.length; i++) {
            if (i >= 2) {
                dp[i] = dp[i - 2] && validTwo(nums[i - 2], nums[i - 1]);
            }
            if (i >= 3) {
                dp[i] = dp[i - 3] && validThree(nums[i - 3], nums[i - 2], nums[i - 1]) || dp[i];
            }
        }
        return dp[nums.length];
    }

    private boolean validThree(int num1, int num2, int num3) {
        return (num1 == num2 && num2 == num3) || (num1 + 1 == num2 && num2 + 1 == num3);
    }

    private boolean validTwo(int num1, int num2) {
        return num1 == num2;
    }

}
