package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/partition-equal-subset-sum/description/">416. 分割等和子集</a>
 * 给你一个 只包含正整数 的 非空 数组 nums 。请你判断是否可以将这个数组分割成两个子集，使得两个子集的元素和相等。
 */
public class PartitionEqualSubsetSum {

    /**
     * 0-1 背包问题，这道题目的要求是将数组分割成两个子集，其实就是看有没有元素加起来是所有元素之和的一半，其实说到这我就想到了双指针，数组嘛，排序
     * 加双指针看看能不能做出来，但是超时了，所以还是用动态规划吧，0-1背包，关键是把这个题如何转化为 0-1 背包，dp 数组如何声明和初始化的问题。
     * 首先 dp 数组索引表示的是背包的容量，那在这道题目里面，最大的容量其实就是所有元素之和的一半(target)，那我们最后需要得到的就是 dp[target] == target
     * @param nums 非空数组
     * @return 是否可以将这个数组分割成两个子集，使得两个子集的元素和相等
     */
    public boolean canPartition(int[] nums) {
        // 先求出所有的元素之和
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if (sum % 2 != 0) {
            return false;
        }
        int target = sum / 2;
        // 声明 dp 数组,索引表示的是背包的容量,值表示背包容量下所能存放的物品的价值
        int[] dp = new int[target + 1];
        // 递推公式 dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
        // 初始化，直接初始化为 0，因为计算要涉及索引小的元素
        // 遍历，先遍历物品，在遍历背包
        for (int i = 0; i < nums.length; i++) {
            for (int j = target; j >= nums[i]; j--) {
                dp[j] = Math.max(dp[j], dp[j - nums[i]] + nums[i]);
            }
            // 提前得到结果，直接结束
            if (dp[target] == target) {
                return true;
            }
        }
        return dp[target] == target;
    }

}
