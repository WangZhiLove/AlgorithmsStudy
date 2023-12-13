package com.algorithms.wz.data.structure.array;


/**
 * <a href="https://leetcode-cn.com/problems/squares-of-a-sorted-array/">977. 有序数组的平方</a>
 * 给你一个按 非递减顺序 排序的整数数组 nums，返回 每个数字的平方 组成的新数组，要求也按 非递减顺序 排序。
 *
 * @author wangzhi
 */
public class SquaresOfASortedArray {

    public static void main(String[] args) {
        int[] ints = sortedSquares(new int[] {-7,-3,2,3,11});
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 最简单的方法就是暴力，全部平方之后，然后重新排序
     * 双指针的方法进行交换，这个应该如何思考呢？就是从两端考虑，必然能取到最大值
     *
     * @param nums 数组
     * @return 平方后的数组
     */
    public static int[] sortedSquares(int[] nums) {
        int[] result = new int[nums.length];
        int resultIndex = nums.length - 1;
        int left = 0, right = nums.length - 1;
        while (left <= right) {
            if (nums[left] * nums[left] <= nums[right] * nums[right]) {
                result[resultIndex --] = nums[right] * nums[right];
                right --;
            } else {
                result[resultIndex --] = nums[left] * nums[left];
                left ++;
            }
        }
        return result;
    }


}
