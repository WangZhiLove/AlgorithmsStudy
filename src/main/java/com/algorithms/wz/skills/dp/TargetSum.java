package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/target-sum/description/">494. 目标和 </a>
 * 给你一个非负整数数组 nums 和一个整数 target 。
 * <p>
 * 向数组中的每个整数前添加 '+' 或 '-' ，然后串联起所有整数，可以构造一个 表达式 ：
 * <p>
 * 例如，nums = [2, 1] ，可以在 2 之前添加 '+' ，在 1 之前添加 '-' ，然后串联起来得到表达式 "+2-1" 。
 * 返回可以通过上述方法构造的、运算结果等于 target 的不同 表达式 的数目。
 */
public class TargetSum {

    /**
     * 这道题目还是没什么思路，虽然知道是 0-1 背包问题，但还是不会思考，暴力肯定超时，可以使用回溯试试暴力破解，这里就不想了，做了这么几道题，
     * 还是没有掌握将问题转化成 0-1 背包的动态规划问题。
     * 没想到这道题目用上了数学转换，其实也是分堆的，一堆是正数 left，一堆是负数 right，总和是 sum，那我们的推导过程是下面这样的：
     * left + right = sum
     * left - right = target
     * left - sum + left = target
     * left = (target + sum) / 2
     * 如果 (target + sum) / 2 除不尽，则得不到正确的结果，举个例子 {1,1,1,1,1}，target 为 2， (2 + 5) / 2 得不到整数，这个结果返回的就是 0
     * 接下来就是转换成 0-1 背包的问题了，这是这道题目的第二个难点，转换过程直接写代码里面了
     *
     * @param nums   数组
     * @param target 目标值 target
     * @return 多少种不同的方法
     */
    public int findTargetSumWays(int[] nums, int target) {
        int sum = 0;
        for (int num : nums) {
            sum += num;
        }
        if ((sum + target) % 2 != 0 || sum + target < 0) {
            return 0;
        }
        // 声明 dp 数组，dp 数组的索引表示的是背包的容量，值表示的是刚好达到这个容量的方法有多少种
        int bigLength = (sum + target) / 2;
        int[] dp = new int[bigLength + 1];
        // 找到递推公式，那这道题目的递推公式是什么呢? dp[j] += dp[j - nums[i]]，为什么是这个呢？举例子就知道了
        // 已知 nums[i]，注意 dp 的索引和值表示的是什么，例如，nums[i] = 1，我们求的是 nums[5]，那就是 nums[4] 有多少种方法，
        // 那 nums[5] 就有多少种方法，依次的就是把所有的 dp[j - nums[i]] 加起来就是我们需要的结果了
        // 如何初始化呢？dp[0] = 1，为什么不能初始化为 0，因为我们的 dp 都是根据前面的推导出来的，并且这个 dp[0] 的值并不是准确的结果，
        // 只是我们临时的一个变量，不代表真的只有一种方法
        dp[0] = 1;
        // 遍历背包
        for (int i = 0; i < nums.length; i++) {
            for (int j = dp.length - 1; j >= 0; j--) {
                if (j >= nums[i]) {
                    dp[j] += dp[j - nums[i]];
                }
            }
        }
        return dp[bigLength];
    }

    public static void main(String[] args) {
        TargetSum targetSum = new TargetSum();
        System.out.println(targetSum.findTargetSumWays(new int[] {100}, -200));
    }
}
