package com.algorithms.wz.data.structure.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/4sum-ii/description/">454.四数相加II</a>
 * 给你四个整数数组 nums1、nums2、nums3 和 nums4 ，数组长度都是 n ，请你计算有多少个元组 (i, j, k, l) 能满足：
 *
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 */
public class FourSumII {

    /**
     * 四数相加，最直观的，暴力破解，但是很大的可能会超时
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                for (int k : nums3) {
                    for (int m : nums4) {
                        if (i + j + k + m == 0) {
                            count ++;
                        }
                    }
                }
            }
        }
        return count;
    }

    public int fourSumCount2(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums4) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int i : nums1) {
            for (int j : nums2) {
                for (int k : nums3) {
                    if (map.containsKey(-i - j - k)) {
                        count += map.getOrDefault(-i - j - k, 0);
                    }
                }
            }
        }
        return count;
    }

    /**
     * 分组 + 哈希表的思路，分成两组计算
     * @param nums1
     * @param nums2
     * @param nums3
     * @param nums4
     * @return
     */
    public static int fourSumCount3(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map1 = new HashMap<>();
        for (int i : nums1) {
            for (int j : nums2) {
                map1.put(i + j, map1.getOrDefault(i + j, 0) + 1);
            }
        }
        int count = 0;
        Map<Integer, Integer> map2 = new HashMap<>();
        for (int i : nums3) {
            for (int j : nums4) {
                if (map1.containsKey(- i - j)) {
                    count += map1.get(- i - j);
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(fourSumCount3(new int[]{1, 2}, new int[]{-2, -1}, new int[]{-1, 2}, new int[]{0, 2}));
    }
}
