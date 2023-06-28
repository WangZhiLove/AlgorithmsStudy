package com.algorithms.wz.array;

/**
 * <a href="https://leetcode.cn/problems/search-insert-position/">35. 搜索插入位置</a>
 * 给定一个排序数组和一个目标值，在数组中找到目标值，并返回其索引。如果目标值不存在于数组中，返回它将会被按顺序插入的位置。
 * 请必须使用时间复杂度为 O(log n) 的算法。
 *
 * @author wangzhi
 */
public class SearchInsertPosition {

    public static void main(String[] args) {
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 5));
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 2));
        System.out.println(searchInsert(new int[] {1, 3, 5, 6}, 7));
    }

    /**
     * 这道题目最简单的方法就是顺序查找，但这个时间复杂度是 O(n)，如果是 O(log n) 那就需要考虑二分查找了，试试看
     * 下面这段代码可以正确通过，但是我总觉得不是特别清晰明了，看看答案，和我的对比一下，二分查找的思路应该是没有问题
     *
     * @param nums   已排序好的数组
     * @param target 目标值
     * @return 找到返回索引，未找到返回按顺序插入的位置
     */
    public static int searchInsert(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length;
        while (leftIndex < rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (nums[middleIndex] == target) {
                return middleIndex;
            }
            if (nums[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex;
            }
        }
        return leftIndex;
    }

    public static int searchInsert2(int[] nums, int target) {
        int leftIndex = 0, rightIndex = nums.length - 1;
        while (leftIndex <= rightIndex) {
            int middleIndex = (leftIndex + rightIndex) / 2;
            if (nums[middleIndex] == target) {
                return middleIndex;
            }
            if (nums[middleIndex] < target) {
                leftIndex = middleIndex + 1;
            } else {
                rightIndex = middleIndex - 1;
            }
        }
        return leftIndex;
    }

}
