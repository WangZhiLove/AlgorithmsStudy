package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum/description/">39. 组合总和</a>
 * 给你一个 无重复元素 的整数数组 candidates 和一个目标整数 target ，找出 candidates 中可以使数字和为目标数 target 的 所有 不同组合 ，并以列表形式返回。你可以按 任意顺序 返回这些组合。
 * <p>
 * candidates 中的 同一个 数字可以 无限制重复被选取 。如果至少一个数字的被选数量不同，则两种组合是不同的。
 * <p>
 * 对于给定的输入，保证和为 target 的不同组合数少于 150 个。
 */
public class CombinationSum {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> temp = new ArrayList<>();

    private int sum = 0;

    /**
     * 这个题目也是回溯，难点在于循环，之前都是每个元素只可以取一次，这个就不同了，可以取多次，那我可以排序，递归的时候也每次从索引 0 开始，直到和大于或等于 target，记得要剪枝
     *
     * @param candidates 给定数组
     * @param target     给定目标值
     * @return 所有的结果
     */
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking(candidates, target, 0);
        return result;
    }

    private void backtracking(int[] candidates, int target, int index) {
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            sum += candidates[i];
            // 小于就递归，注意，递归出来的时候要移除当前遍历的元素
            if (sum < target) {
                backtracking(candidates, target, i);
                sum -= candidates[i];
                temp.remove(temp.size() - 1);
            } else {
                if (sum == target) {
                    result.add(new ArrayList<>(temp));
                }
                sum -= candidates[i];
                temp.remove(temp.size() - 1);
                break;
            }
        }
    }

    private void backtracking2(int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < candidates.length; i++) {
            if (target - candidates[i] >= 0) {
                temp.add(candidates[i]);
                backtracking2(candidates, target - candidates[i], i);
                temp.remove(temp.size() - 1);
            } else {
                break;
            }
        }
    }

    public static void main(String[] args) {
        CombinationSum combinationSum = new CombinationSum();
        List<List<Integer>> lists = combinationSum.combinationSum(new int[] {2, 3, 6, 7}, 7);
        lists.forEach(System.out::println);
    }
}
