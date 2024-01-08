package com.algorithms.wz.skills.backtracking;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-ii/description/">40.组合总和II</a>
 * 给定一个候选人编号的集合 candidates 和一个目标数 target ，找出 candidates 中所有可以使数字和为 target 的组合。
 * <p>
 * candidates 中的每个数字在每个组合中只能使用 一次 。
 * <p>
 * 注意：解集不能包含重复的组合。
 */
public class CombinationSumII {

    private Set<List<Integer>> result = new HashSet<>();

    private List<Integer> temp = new ArrayList<>();

    private int sum = 0;

    /**
     * 和组合总和不同的的是，给定的数组中有重复元素，结果中不能包含重复元素，按照我的思路，先排序，集合使用 Set 去重，下面这种算法超时，我觉得是剪枝的问题
     *
     * @param candidates 给定数组
     * @param target     目标和
     * @return 结果集
     */
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        backtracking2(candidates, target, 0);
        return new ArrayList<>(result);
    }

    private void backtracking(int[] candidates, int target, int index) {
        if (target == 0) {
            result.add(new ArrayList<>(temp));
        } else {
            for (int i = index; i < candidates.length; i++) {
                if (target - candidates[i] >= 0) {
                    temp.add(candidates[i]);
                    backtracking(candidates, target - candidates[i], i + 1);
                    temp.remove(temp.size() - 1);
                }
            }
        }
    }

    private void backtracking2(int[] candidates, int target, int index) {
        for (int i = index; i < candidates.length; i++) {
            temp.add(candidates[i]);
            sum += candidates[i];
            if (sum < target) {
                backtracking2(candidates, target, i + 1);
                sum -= candidates[i];
                temp.remove(temp.size() - 1);
                // 重复数据减枝
                while (i < candidates.length - 1 && candidates[i] == candidates[i + 1]) {
                    i ++;
                }
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

    public static void main(String[] args) {
        CombinationSumII combinationSumII = new CombinationSumII();
        List<List<Integer>> lists = combinationSumII.combinationSum2(
            new int[] {1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1}, 30);
        lists.forEach(System.out::println);
    }

}
