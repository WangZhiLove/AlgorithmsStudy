package com.algorithms.wz.data.structure.array;

/**
 * <a href="https://leetcode.cn/problems/remove-element/description/">27. 移除元素</a>
 * 给你一个数组 nums 和一个值 val，你需要 原地 移除所有数值等于 val 的元素，并返回移除后数组的新长度。
 * <p>
 * 不要使用额外的数组空间，你必须仅使用 O(1) 额外空间并 原地 修改输入数组。
 * <p>
 * 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 */
public class RemoveElement {

    public static void main(String[] args) {
        // System.out.println(removeElement(new int[]{3,2,2,3}, 3));
        // System.out.println(removeElement(new int[]{0,1,2,2,3,0,4,2}, 2));
        System.out.println(removeElement(new int[]{}, 0));
    }

    /**
     * 原地修改，也就是不使用额外的空间，双指针来做
     *
     * @param nums 原数组
     * @param val  目标元素
     * @return 移除后数组的新长度
     */
    public static int removeElement(int[] nums, int val) {
        int left = -1, right = 0;
        while (right < nums.length) {
            if (nums[right] == val && left == -1) {
                left = right;
            }
            if (nums[right] != val && left != -1) {
                nums[left ++] = nums[right];
            }
            right ++;
        }
        return left == -1 ? nums.length : left;
    }

    /**
     * 更简单的写法
     * @param nums 原数组
     * @param val  目标元素
     * @return 移除后数组的新长度
     */
    public static int removeElement2(int[] nums, int val) {
        int left = 0, right = 0;
        for (int num : nums) {
            if (num == val) {
                right ++;
            } else {
                nums[left ++] = nums[right ++];
            }
        }
        return left;
    }
}
