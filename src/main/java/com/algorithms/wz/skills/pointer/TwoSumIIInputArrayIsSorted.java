package com.algorithms.wz.skills.pointer;

/**
 * <a href="https://leetcode-cn.com/problems/two-sum-ii-input-array-is-sorted/">167. 两数之和 II - 输入有序数组</a>
 * <p>
 *     给定一个已按照 升序排列 的整数数组 numbers, 请你从数组中找出两个数满足相加之和等于目标数 target。如果设这两个数分别是 numbers[index1] 和 numbers[index2] ，则 1 <= index1 < index2 <= numbers.length 。
 *
 * 以长度为 2 的整数数组 [index1, index2] 的形式返回这两个整数的下标 index1 和 index2。
 *
 * 你可以假设每个输入 只对应唯一的答案 ，而且你 不可以 重复使用相同的元素。
 *
 * 你所设计的解决方案必须只使用常量级的额外空间。
 *
 * @author wangzhi
 */
public class TwoSumIIInputArrayIsSorted {

    public static void main(String[] args) {
        int[] ints = twoSum(new int[] {2, 7, 11, 15}, 9);
        for (int anInt : ints) {
            System.out.println(anInt);
        }
    }

    /**
     * 这道题目需要双指针的解法了，左右指针试试看看
     * @param numbers 数组
     * @param target  目标值
     * @return 下标
     */
    public static int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                break;
            } else if (sum > target) {
                right --;
            } else {
                left ++;
            }
        }
        return new int[]{left + 1, right + 1};
    }
}
