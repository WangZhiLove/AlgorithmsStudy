package com.algorithms.wz.data.structure.array;

/**
 * <a href="https://leetcode.cn/problems/minimum-size-subarray-sum/">209. 长度最小的子数组</a>
 * 给定一个含有 n 个正整数的数组和一个正整数 target 。
 * <p>
 * 找出该数组中满足其总和大于等于 target 的长度最小的 连续子数组 [numsl, numsl+1, ..., numsr-1, numsr] ，并返回其长度。如果不存在符合条件的子数组，返回 0 。
 */
public class MinimumSizeSubarraySum {

    /**
     * 暴力破解法，双层 for 循环，判断每一层的个数，暴力破解在 leetcode 会超出时间限制
     *
     * @param target 目标值
     * @param nums   数组
     * @return 最小连续子数组的长度
     */
    public int minSubArrayLen(int target, int[] nums) {
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            if (sum >= target) {
                result = Math.min(result, 1);
            }
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (sum >= target) {
                    result = Math.min(result, j - i + 1);
                    break;
                }
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    /**
     * 使用滑动窗口看看，滑动窗口也算是双指针的使用
     * @param target 目标值
     * @param nums   数组
     * @return 最小连续子数组的长度
     */
    public static int minSubArrayLen2(int target, int[] nums) {
        // 左边界
        int left = 0;
        // 右边界
        int right = 0;
        // 滑动窗口内的所有数之和
        int sum = nums[0];
        // 滑动窗口之间的距离
        int result = Integer.MAX_VALUE;
        while (left <= right && right < nums.length ) {
            // 大于右移左边界
            while (sum >= target && left <= right) {
                result = Math.min(result, right - left + 1);
                sum -= nums[left];
                left ++;
            }
            // 小于右移右边界
            while (sum < target && left <= right && ++ right < nums.length) {
                sum += nums[right];
            }
        }
        return result == Integer.MAX_VALUE ? 0 : result;
    }

    public static void main(String[] args) {
        System.out.println(minSubArrayLen2(15, new int[]{1,2,3,4,5}));
    }
}
