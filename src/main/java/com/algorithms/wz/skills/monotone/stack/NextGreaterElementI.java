package com.algorithms.wz.skills.monotone.stack;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Stack;

/**
 * <a href="https://leetcode.cn/problems/next-greater-element-i/description/">496.下一个更大元素 I</a>
 * nums1 中数字 x 的 下一个更大元素 是指 x 在 nums2 中对应位置 右侧 的 第一个 比 x 大的元素。
 * <p>
 * 给你两个 没有重复元素 的数组 nums1 和 nums2 ，下标从 0 开始计数，其中nums1 是 nums2 的子集。
 * <p>
 * 对于每个 0 <= i < nums1.length ，找出满足 nums1[i] == nums2[j] 的下标 j ，并且在 nums2 确定 nums2[j] 的 下一个更大元素 。如果不存在下一个更大元素，那么本次查询的答案是 -1 。
 * <p>
 * 返回一个长度为 nums1.length 的数组 ans 作为答案，满足 ans[i] 是如上所述的 下一个更大元素 。
 */
public class NextGreaterElementI {

    /**
     * 这道题的题目有点难以理解
     * @param nums1 nums2的子集
     * @param nums2 数组
     * @return 下一个更大元素
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        int[] ans = new int[nums1.length];
        Arrays.fill(ans, -1);
        // 关键是需要映射
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums1.length; i++) {
            map.put(nums1[i], i);
        }
        // 单调栈来遍历 nums2
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < nums2.length; i++) {
            while (!stack.empty() && nums2[stack.peek()] < nums2[i]) {
                if (map.containsKey(nums2[stack.peek()])) {
                    ans[map.get(nums2[stack.peek()])] = nums2[i];
                }
                stack.pop();
            }
            stack.push(i);
        }
        return ans;
    }
}
