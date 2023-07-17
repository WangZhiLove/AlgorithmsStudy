package com.algorithms.wz.skills.pointer;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-size-subarray-sum/">209. 长度最小的子数组</a>
 * <p>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其和 ≥ target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 * </p>
 * @author wangzhi
 */
public class MinimumSizeSubarraySum {

    public static void main(String[] args) {
        System.out.println(minSubArrayLen(7, new int[] {2, 3, 1, 2, 4, 3}));
        System.out.println(minSubArrayLen(4, new int[] {1,4,4}));
        System.out.println(minSubArrayLen(11, new int[] {1,1,1,1,1,1,1,1}));
    }

    /**
     * 这道题目也是快慢指针，其实也叫滑动窗口
     * @param target 目标值
     * @param nums 数组
     * @return 最小长度
     */
    public static int minSubArrayLen(int target, int[] nums) {
        int left = 0;
        int right = 0;
        int sum = 0;
        int minLen = Integer.MAX_VALUE;
        while (left <= right && right < nums.length) {
            while (right < nums.length && sum < target) {
                sum += nums[right ++];
            }
            while (sum >= target) {
                minLen = Math.min(right - left, minLen);
                sum -= nums[left ++];
            }
        }
        return minLen == Integer.MAX_VALUE ? 0 : minLen;
    }
}
