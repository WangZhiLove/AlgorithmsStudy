package com.algorithms.wz.data.structure.array;

/**
 * <a href="https://leetcode-cn.com/problems/remove-duplicates-from-sorted-array/">26. 删除有序数组中的重复项</a>
 * <p>
 * 给你一个 升序排列 的数组 nums ，请你 原地 删除重复出现的元素，使每个元素 只出现一次 ，返回删除后数组的新长度。元素的 相对顺序 应该保持 一致 。然后返回 nums 中唯一元素的个数。
 * <p>
 * 考虑 nums 的唯一元素的数量为 k ，你需要做以下事情确保你的题解可以被通过：
 * <p>
 * 更改数组 nums ，使 nums 的前 k 个元素包含唯一元素，并按照它们最初在 nums 中出现的顺序排列。nums 的其余元素与 nums 的大小不重要。
 * 返回 k 。
 * </p>
 *
 * @author wangzhi
 */
public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {
        System.out.println(removeDuplicates(new int[] {0}));
    }

    /**
     * 返回不同元素的个数，还需要原地元素替换，其实简单，快慢指针
     *
     * @param nums 数组
     * @return 不同元素的个数
     */
    public static int removeDuplicates(int[] nums) {
        int left = 0;
        int right = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right]) {
                // 优化
                if (right - left > 1) {
                    nums[left + 1] = nums[right];
                }
                left++;
            }
            right++;
        }
        return left + 1;
    }
}
