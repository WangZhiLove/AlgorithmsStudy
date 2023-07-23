package com.algorithms.wz.data.structure.array;

/**
 * <a href="https://leetcode-cn.com/problems/move-zeroes/">283. 移动零</a>
 * <p>
 * 给定一个数组 nums，编写一个函数将所有 0 移动到数组的末尾，同时保持非零元素的相对顺序。
 * <p>
 * 请注意 ，必须在不复制数组的情况下原地对数组进行操作。
 * </p>
 * @author wangzhi
 */
public class MoveZeroes {

    public static void main(String[] args) {
        moveZeroes(new int[]{0,0,0,1,2,0,3,0,4,0});
    }

    /**
     * 移动 0，关键在于不复制数组，还需要保持非零元素的相对顺序，这还是双指针，不断交换 0 与非 0 元素，或者说单独复制，和26. 删除有序数组中的重复项极度想死
     * @param nums 数组
     */
    public static void moveZeroes(int[] nums) {
        int left = 0;
        int right = 0;
        while (right < nums.length) {
            if (nums[right] == 0) {
                right ++;
            } else {
                if (left != right) {
                    nums[left] = nums[right];
                }
                left ++;
                right ++;
            }

        }
        // 填充 0
        while (left < nums.length) {
            nums[left ++] = 0;
        }
    }

    /**
     * 换一种更简单的写法，right 表示浏览的最新索引，统计 0 的个数为 num ，就知道 需要和 right 交换的索引为 right - num
     * @param nums 数组
     */
    public static void moveZeroes2(int[] nums) {
        int zeroNum = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == 0) {
                zeroNum++;
            } else if (zeroNum > 0) {
                // 只判断大于 0 是如果没有 0 就不产生交换
                nums[i - zeroNum] = nums[i];
                // 将后面的元素置为 0，后续可能会与非 0 元素进行交换
                nums[i] = 0;
            }
        }
    }
}
