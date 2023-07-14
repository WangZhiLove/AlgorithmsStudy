package com.algorithms.wz.skills.pointer;

import java.util.Arrays;

/**
 * <a href="https://leetcode-cn.com/problems/array-partition-i/">561. 数组拆分 I</a>
 * <p>
 * 给定长度为 2n 的整数数组 nums ，你的任务是将这些数分成 n 对, 例如 (a1, b1), (a2, b2), ..., (an, bn) ，
 * 使得从 1 到 n 的 min(ai, bi) 总和最大。 返回该 最大总和 。
 * <p>
 * @author wangzhi
 */
public class ArrayPartition {

    public static void main(String[] args) {
        System.out.println(arrayPairSum(new int[]{1,2,3,4}));
        System.out.println(arrayPairSum(new int[]{6,2,6,5,1,2}));
    }

    /**
     * 这道题目我个人的看法就是排序，然后取数就可以，试试看，因为两两组合要加最小的那个，所以我排序之后获取就可以
     * 确实可以这样解，但是这道题目和双指针有什么关系呢？
     * @param nums 数组
     * @return 最大总和
     */
    public static int arrayPairSum(int[] nums) {
        Arrays.sort(nums);
        int sum = 0;
        for (int i = 0; i < nums.length; i+=2) {
            sum += nums[i];
        }
        return sum;
    }
}
