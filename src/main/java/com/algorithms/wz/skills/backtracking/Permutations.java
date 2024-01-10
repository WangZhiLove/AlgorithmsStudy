package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/permutations/description/">46.全排列</a>
 * 给定一个不含重复数字的数组 nums ，返回其 所有可能的全排列 。你可以 按任意顺序 返回答案。
 */
public class Permutations {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> temp = new ArrayList<>();

    /**
     * 这个题目就是枚举所有的情况，也是用回溯，就是遇到重复元素的时候要跳过，什么时候加入结果集呢？当元素的个数等于 nums 的长度，就加入
     * @param nums 数组
     * @return 所有的排列
     */
    public List<List<Integer>> permute(int[] nums) {
        backtracking(nums);
        return result;
    }

    private void backtracking(int[] nums) {
        if (temp.size() == nums.length) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = 0; i < nums.length; i++) {
            if (temp.contains(nums[i])) {
                continue;
            }
            temp.add(nums[i]);
            backtracking(nums);
            temp.remove(temp.size() - 1);
        }
    }

    public static void main(String[] args) {
        Permutations permutations = new Permutations();
        List<List<Integer>> permute = permutations.permute(new int[] {1, 2, 3});
        permute.forEach(System.out::println);
    }
}
