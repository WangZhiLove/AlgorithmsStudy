package com.algorithms.wz.data.structure.hash;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/intersection-of-two-arrays/">349. 两个数组的交集</a>
 * 给定两个数组 nums1 和 nums2 ，返回 它们的交集 。输出结果中的每个元素一定是 唯一 的。我们可以 不考虑输出结果的顺序 。
 */
public class IntersectionOfTwoArrays {

    /**
     * 不用动脑，先暴力破解，双层 for 循环或者改成 contains，性能差别不是很大
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection(int[] nums1, int[] nums2) {
        Set<Integer> set1 = new HashSet<>();
        for (int i : nums1) {
            set1.add(i);
        }
        Set<Integer> set2 = new HashSet<>();
        for (int i : nums2) {
            set2.add(i);
        }
        Set<Integer> set = new HashSet<>();
        for (Integer i : set1) {
            if (set2.contains(i)) {
                set.add(i);
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            result[index ++] = num;
        }
        return result;
    }

    /**
     * 排序 + 双指针
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection2(int[] nums1, int[] nums2) {
        // 排序 + 双指针看看
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        Set<Integer> set = new HashSet<>();
        int nums1Point = 0;
        int nums2Point = 0;
        while (nums1Point < nums1.length && nums2Point < nums2.length) {
            if (nums1[nums1Point] == nums2[nums2Point]) {
                set.add(nums1[nums1Point]);
                nums1Point ++;
                nums2Point ++;
            } else if (nums1[nums1Point] > nums2[nums2Point]){
                nums2Point ++;
            } else {
                nums1Point ++;
            }
        }
        int[] result = new int[set.size()];
        int index = 0;
        for (Integer num : set) {
            result[index ++] = num;
        }
        return result;
    }

    /**
     * 根据提示来做，数组最长为 1000，那我声明一个 1001 大小的数组
     * @param nums1
     * @param nums2
     * @return
     */
    public int[] intersection3(int[] nums1, int[] nums2) {
        // 排序 + 双指针看看
        int[] arr = new int[1001];
        for (int i : nums1) {
            arr[i] = 1;
        }
        int index = 0;
        int[] result = new int[Math.max(nums1.length, nums2.length)];
        for (int i : nums2) {
            if (arr[i] == 1) {
                result[index ++] = i;
                // 重置的思路好呀
                arr[i] = 0;
            }
        }
        return Arrays.copyOfRange(result, 0, index);
    }


}
