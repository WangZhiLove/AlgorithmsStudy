package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/maximum-length-of-repeated-subarray/description/">718. 最长重复子数组</a>
 * 给两个整数数组 nums1 和 nums2 ，返回 两个数组中 公共的 、长度最长的子数组的长度 。
 */
public class MaximumLengthOfRepeatedSubarray {

    /**
     * 动态规划我没有想出来，那就暴力破解吧，循环判断吧，但是大概率会超时，竟然没有超时，不过效率确实不怎么高，接下来该想想怎么用动态规划来解决
     * 这个题目了
     *
     * @param nums1 数组 1
     * @param nums2 数组 2
     * @return 最长的子数组的长度
     */
    public int findLength(int[] nums1, int[] nums2) {
        // 最长的子数组长度
        int maxLen = 0;
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                if (nums1[i] == nums2[j]) {
                    int tempLen = 1;
                    int left = i + 1, right = j + 1;
                    while (left < nums1.length && right < nums2.length && nums1[left] == nums2[right]) {
                        left++;
                        right++;
                        tempLen++;
                    }
                    maxLen = Math.max(maxLen, tempLen);
                }
            }
        }
        return maxLen;
    }

    /**
     * 动态规划如何实现呢，要做到这个就需要明确 dp 数组的定义，这个是我没有想出来的，具体的就放在代码里了
     *
     * @param nums1 数组 1
     * @param nums2 数组 2
     * @return 最长的子数组的长度
     */
    public int findLength1(int[] nums1, int[] nums2) {
        // 最长的子数组长度
        int maxLen = 0;
        // dp 数组，这里的 i 表示 nums1 的前 i - 1 个元素，j 表示 nums2 的前 j 个元素，
        // 值表示以 i-1 为结尾的 nums1以及以 j-1 为结尾的 nums2 的最长子数组的长度
        // 为什么是 i-1 和 j-1 呢，这个主要考虑初始化的问题，如果是以 i 结尾以及 j 结尾，那索引 0 就需要遍历数组进行初始化，而
        // i - 1 和 j - 1 的话，0 是无效索引，我们再进行动态规划的遍历的时候就包括了以 i 结尾以及 j 结尾的情况，所以这个使用 - 1
        int[][] dp = new int[nums1.length + 1][nums2.length + 1];
        // 递推公式 if(nums1[i - 1] == nums2[j - 1]) dp[i][j] = dp[i - 1][j - 1] + 1
        // 全部初始化为 0
        // 遍历
        for (int i = 1; i <= nums1.length; i++) {
            for (int j = 1; j <= nums2.length; j++) {
                if (nums1[i - 1] == nums2[j - 1]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                }
                maxLen = Math.max(maxLen, dp[i][j]);
            }
        }
        return maxLen;
    }

    public static void main(String[] args) {
        MaximumLengthOfRepeatedSubarray maximumLengthOfRepeatedSubarray = new MaximumLengthOfRepeatedSubarray();
        System.out.println(maximumLengthOfRepeatedSubarray.findLength1(new int[] {1, 2, 3}, new int[] {1, 2, 3}));
    }
}
