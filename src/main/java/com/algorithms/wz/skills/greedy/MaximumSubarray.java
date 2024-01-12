package com.algorithms.wz.skills.greedy;

/**
 * <a href="https://leetcode.cn/problems/maximum-subarray/description/">53. 最大子序和 </a>
 * 给你一个整数数组 nums ，请你找出一个具有最大和的连续子数组（子数组最少包含一个元素），返回其最大和。
 * <p>
 * 子数组 是数组中的一个连续部分。
 */
public class MaximumSubarray {

    /**
     * 这个题目做过不止一遍，但是现在还是不会，没有想法，其实在这种情况下，能否暴力破解呢？
     * 暴力破解那就是我枚举出所有的情况，也就是使用回溯的方法，然后求出每一种情况和，就可以得到结果了
     * <p>
     * 除了暴力暴力破解呢，因为这道题目只返回最大和，不需要具体的子序列，所以肯定有简单的方法，看看题解吧，题解的思路是什么呢？
     * 当前元素前缀和如果大于当前元素，那就保留，如果小于，则从当前元素重新开始，因为说明当前元素加上之前的元素反而减小了，那就不要考虑了，这个就是局部最优解
     *
     * @param nums 原数组
     * @return 最大的和
     */
    public int maxSubArray(int[] nums) {
        int result = nums[0];
        int ans = 0;
        for (int num : nums) {
            ans = Math.max(ans + num, num);
            result = Math.max(ans, result);
        }
        return result;
    }

    public static void main(String[] args) {
        MaximumSubarray maximumSubarray = new MaximumSubarray();
        System.out.println(maximumSubarray.maxSubArray(new int[] {-2, 1, -3, 4, -1, 2, 1, -5, 4}));
    }

}
