package com.algorithms.wz.skills.pointer;

/**
 * <a href="https://leetcode-cn.com/problems/remove-element/">27. 移除元素</a>
 * <p>
 * 给你一个数组 nums和一个值 val，你需要 原地 移除所有数值等于val的元素， 并返回移除后数组的新长度。 不要使用额外的数组空间，
 * 你必须仅使用 O(1) 额外空间并 原地 修改输入数组。 元素的顺序可以改变。你不需要考虑数组中超出新长度后面的元素。
 *
 * @author wangzhi
 */
public class RemoveElement {

    public static void main(String[] args) {
        int num = removeElement(new int[] {3, 2, 2, 3}, 3);
        System.out.println(num);
    }

    /**
     * 关键在于 O(1) 的空间复杂度，所以双指针是最好的策略
     *
     * @param nums 数组
     * @param val  指定元素
     * @return 新数组的长度
     */
    public static int removeElement(int[] nums, int val) {
        int fast = 0;
        int slow = 0;
        for (int num : nums) {
            if (num == val) {
                fast++;
            } else {
                nums[slow++] = nums[fast++];
            }
        }
        return slow;
    }
}
