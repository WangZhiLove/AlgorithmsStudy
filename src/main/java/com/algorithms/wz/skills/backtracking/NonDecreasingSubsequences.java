package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/non-decreasing-subsequences/description/">491. 非递减子序列</a>
 * 给你一个整数数组 nums ，找出并返回所有该数组中不同的递增子序列，递增子序列中 至少有两个元素 。你可以按 任意顺序 返回答案。
 * <p>
 * 数组中可能含有重复元素，如出现两个整数相等，也可以视作递增序列的一种特殊情况。
 */
public class NonDecreasingSubsequences {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> temp = new ArrayList<>();

    int curListMaxValue = Integer.MIN_VALUE;

    /**
     * 和之前的情况极度相似，就是加了一个判断，递增并且元素总数大于等于2，遇到一个问题就是如何剪枝，去掉重复的数组，这个其实最简单的就是使用 Set，那如果不用 Set 呢？
     * 因为 Set 的去重是底层判断，我想自己判断呢，这里使用了本层重复元素使用 Set 去重，很有意思
     *
     * @param nums 数组
     * @return 集合
     */
    public List<List<Integer>> findSubsequences(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }
        backtracking(nums, 0);
        return new ArrayList<>(result);
    }

    private void backtracking(int[] nums, int index) {
        if (temp.size() >= 2) {
            result.add(new ArrayList<>(temp));
        }
        HashSet<Integer> set = new HashSet<>();
        for (int i = index; i < nums.length; i++) {
            if (nums[i] < curListMaxValue) {
                continue;
            }
            if (set.contains(nums[i])) {
                continue;
            }
            set.add(nums[i]);
            temp.add(nums[i]);
            curListMaxValue = nums[i];
            backtracking(nums, i + 1);
            temp.remove(temp.size() - 1);
            curListMaxValue = temp.isEmpty() ? Integer.MIN_VALUE : temp.get(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        NonDecreasingSubsequences nonDecreasingSubsequences = new NonDecreasingSubsequences();
        List<List<Integer>> subsequences = nonDecreasingSubsequences.findSubsequences(new int[] {4, 6, 7, 7});
        subsequences.forEach(System.out::println);
    }
}
