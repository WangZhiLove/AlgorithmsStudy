package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/subsets/description/">78.子集</a>
 * 给你一个整数数组 nums ，数组中的元素 互不相同 。返回该数组所有可能的子集（幂集）。
 * <p>
 * 解集 不能 包含重复的子集。你可以按 任意顺序 返回解集。
 */
public class Subsets {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> temp = new ArrayList<>();

    /**
     * 相似的题目，相对来说，判断更少
     *
     * @param nums 数组
     * @return 所有的子集
     */
    public List<List<Integer>> subsets(int[] nums) {
        result.add(new ArrayList<>());
        backtracking(nums, 0);
        return result;
    }

    private void backtracking(int[] nums, int index) {
        if (!temp.isEmpty()) {
            result.add(new ArrayList<>(temp));
        }
        for (int i = index; i < nums.length; i++) {
            temp.add(nums[i]);
            backtracking(nums, i + 1);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Subsets subsets = new Subsets();
        List<List<Integer>> subsets1 = subsets.subsets(new int[] {1, 2, 3});
        subsets1.forEach(System.out::println);
    }
}
