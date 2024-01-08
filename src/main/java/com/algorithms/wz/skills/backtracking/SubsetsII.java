package com.algorithms.wz.skills.backtracking;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/subsets-ii/description/">90.子集II  </a>
 * 给你一个整数数组 nums ，其中可能包含重复元素，请你返回该数组所有可能的子集（幂集）。
 *
 * 解集 不能 包含重复的子集。返回的解集中，子集可以按 任意顺序 排列。
 */
public class SubsetsII {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> temp = new ArrayList<>();


    /**
     * 和子集一类似，避免重复就可以
     * @param nums
     * @return
     */
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        result.add(new ArrayList<>());
        backtracking(nums, 0);
        return new ArrayList<>(result);
    }


    private void backtracking(int[] nums, int index) {
        if (!temp.isEmpty()) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = index; i < nums.length; i++) {
            // 剪枝，当在循环中，当前元素与前一个元素相同的时候，直接跳过，还要注意 i != index，这个主要考虑第一次循环的时候一定是要添加的，这个剪枝针对于是 for 循环，而不是递归
            if (i > 0 && nums[i] == nums[i - 1] && i != index) {
                continue;
            }
            temp.add(nums[i]);
            backtracking(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        SubsetsII subsetsII = new SubsetsII();
        List<List<Integer>> lists = subsetsII.subsetsWithDup(new int[] {1, 2, 2, 2, 2});
        lists.forEach(System.out::println);
    }

}
