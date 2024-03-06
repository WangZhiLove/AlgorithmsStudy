package com.algorithms.wz.one.day.year24.month3;

/**
 * <a href="https://leetcode.cn/problems/find-the-k-or-of-an-array/description/">2917. 找出数组中的K or 值</a>
 * 给你一个下标从 0 开始的整数数组 nums 和一个整数 k 。
 * <p>
 * nums 中的 K-or 是一个满足以下条件的非负整数：
 * <p>
 * 只有在 nums 中，至少存在 k 个元素的第 i 位值为 1 ，那么 K-or 中的第 i 位的值才是 1 。
 * 返回 nums 的 K-or 值。
 * <p>
 * 注意 ：对于整数 x ，如果 (2i AND x) == 2i ，则 x 中的第 i 位值为 1 ，其中 AND 为按位与运算符。
 */
public class FindTheKOrOfAnArray {

    /**
     * 简单题，解法简单，但是题目介绍跟阅读理解一样，真难理解
     * @param nums 整数数组
     * @param k 整数 k
     * @return 返回 nums 的 K-or 值
     */
    public int findKOr(int[] nums, int k) {
        int ans = 0;
        for (int i = 0; i < 31; ++i) {
            int cnt = 0;
            for (int num : nums) {
                if (((num >> i) & 1) != 0) {
                    ++cnt;
                }
            }
            if (cnt >= k) {
                ans |= 1 << i;
            }
        }
        return ans;
    }

}
