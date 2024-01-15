package com.algorithms.wz.skills.greedy;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/maximize-sum-of-array-after-k-negations/description/">1005.K次取反后最大化的数组和</a>
 * 给你一个整数数组 nums 和一个整数 k ，按以下方法修改该数组：
 * <p>
 * 选择某个下标 i 并将 nums[i] 替换为 -nums[i] 。
 * 重复这个过程恰好 k 次。可以多次选择同一个下标 i 。
 * <p>
 * 以这种方式修改数组后，返回数组 可能的最大和 。
 */
public class MaximizeSumOfArrayAfterKNegations {

    /**
     * 好久没看到简单题目了，但是貌似也不是很简单呀
     *
     * @param nums 数组的大小
     * @param k    重复取反的次数
     * @return 最大和
     */
    public int largestSumAfterKNegations(int[] nums, int k) {
        Arrays.sort(nums);
        int index = 0;
        for (int i = 0; i < k; i++) {
            nums[index] = -nums[index];
            if (index < nums.length - 1 && nums[index] > 0) {
                index = Math.abs(nums[index]) >= Math.abs(nums[index + 1]) ? index + 1 : index;
            }
        }
        int result = 0;
        for (int num : nums) {
            result += num;
        }
        return result;
    }

    public static void main(String[] args) {
        MaximizeSumOfArrayAfterKNegations maximizeSumOfArrayAfterKNegations = new MaximizeSumOfArrayAfterKNegations();
        System.out.println(maximizeSumOfArrayAfterKNegations.largestSumAfterKNegations(
            new int[] {-4,-2,-3}, 4));

    }

}
