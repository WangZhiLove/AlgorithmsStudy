package com.algorithms.wz.data.structure.array;

/**
 * <a href="https://leetcode.cn/problems/binary-search/description/">704:二分查找</a>
 * 给定一个 n 个元素有序的（升序）整型数组 nums 和一个目标值 target  ，写一个函数搜索 nums 中的 target，如果目标值存在返回下标，否则返回 -1。
 */
public class BinarySearch {

    public static void main(String[] args) {
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 9));
        System.out.println(search(new int[]{-1,0,3,5,9,12}, 2));
    }

    /**
     * 题目要求使用二分查找，二分查找最关键的就是边界问题，考虑清楚什么时候加一减一就好，减一加一的关键在于区间是左闭右闭还是左闭右开
     * 我这边的想法是 left 为 0， right 为最大索引，然后取中间值，因为题目中已经排好序，所以这边不用重复排序
     * 根据中间值判断就有三中情况：
     * 1. 相等，则返回索引
     * 2. 大于，说明目标值在左半部分，所以 right = middle - 1，为什么不是 middle，因为 middle 已经判断过了，下面是相同的道理
     * 3. 小于，说明目标值在右半部分，所以 left = middle + 1
     * @param nums  有序数组
     * @param target  目标值
     * @return 目标值的索引
     */
    public static int search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }
        return -1;
    }

    /**
     * 左闭右开 的写法
     */
    public static int search2(int[] nums, int target) {
        int left = 0, right = nums.length;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] == target) {
                return middle;
            }
            if (nums[middle] < target) {
                left = middle + 1;
            } else {
                right = middle;
            }
        }
        return -1;
    }
}
