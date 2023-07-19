package com.algorithms.wz.data.structure.array;

/**
 * <a href="https://leetcode-cn.com/problems/find-minimum-in-rotated-sorted-array/">153. 寻找旋转排序数组中的最小值</a>
 * <p>
 * 已知一个长度为 n 的数组，预先按照升序排列，经由 1 到 n 次 旋转 后，得到输入数组。例如，原数组 nums = [0,1,2,4,5,6,7] 在变化后可能得到：
 * 若旋转 4 次，则可以得到 [4,5,6,7,0,1,2]
 * 若旋转 7 次，则可以得到 [0,1,2,4,5,6,7]
 * 注意，数组 [a[0], a[1], a[2], ..., a[n-1]] 旋转一次 的结果为数组 [a[n-1], a[0], a[1], a[2], ..., a[n-2]] 。
 * <p>
 * 给你一个元素值 互不相同 的数组 nums ，它原来是一个升序排列的数组，并按上述情形进行了多次旋转。请你找出并返回数组中的 最小元素 。
 * <p>
 * 你必须设计一个时间复杂度为 O(log n) 的算法解决此问题。
 * </p>
 *
 * @author wangzhi
 */
public class FindMinimumInRotatedSortedArray {

    public static void main(String[] args) {
        System.out.println(findMin2(new int[] {3, 1, 2}));
    }

    /**
     * 旋转就是在原来数组的基础上，将最后一位提到第一位，这道题目可以用 O(n) 的时间复杂度，如果用 O(log n) 如何解决呢？还得想象
     *
     * @param nums 数组
     * @return 返回最小的值
     */
    public static int findMin(int[] nums) {
        int min = nums[0];
        for (int num : nums) {
            min = Math.min(num, min);
        }
        return min;
    }

    /**
     * 提到 O(log n)，还得是二分查找呀
     *
     * @param nums 数组
     * @return 返回最小的值
     */
    public static int findMin2(int[] nums) {
        int left = 0;
        int right = nums.length - 1;
        while (left < right) {
            int middle = (left + right) / 2;
            if (nums[middle] > nums[right]) {
                left = middle + 1;
            } else {
                // 为什么这里不需要减一呢？原因在于这里没有相等的判断逻辑，如果减一，则会漏掉 middle 索引的判断，所以这里不需要减一
                right = middle;
            }
        }
        // 这里为什么返回 nums[left] 而不是 nums[right] 呢？其实这个时候 left 和 right 都是相同的索引，所以返回 nums[left] 和 nums[right] 都可以
        return nums[left];
    }
}
