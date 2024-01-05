package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combinations/description/">77. 组合</a>
 * 给定两个整数 n 和 k，返回范围 [1, n] 中所有可能的 k 个数的组合。
 * <p>
 * 你可以按 任何顺序 返回答案。
 */
public class Combinations {

    List<List<Integer>> result = new ArrayList<>();

    List<Integer> list = new ArrayList<>();

    /**
     * 组合，回溯算法
     *
     * @param n 范围，代表的是 1～n
     * @param k 集合的个数
     * @return 符合条件的所有集合
     */
    public List<List<Integer>> combine(int n, int k) {
        backtracking(n, k, 1);
        return result;
    }

    /**
     * 回溯
     *
     * @param n     范围，代表的是 1～n
     * @param k     集合的个数
     */
    private void backtracking(int n, int k, int index) {
        // 终止条件
        if (list.size() == k) {
            result.add(new ArrayList<>(list));
            return;
        }
        // for 循环 + 递归，这里考虑下剪枝，也就是不满足的情况都不需要考虑，结合 n 和 list 的元素，如果 list 现在的元素 + n 剩下的元素都达不到 k，则放弃循环
        for (int i = index; i <= n - (k - list.size()) + 1; i++) {
            list.add(i);
            backtracking(n, k, i + 1);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        Combinations combinations = new Combinations();
        List<List<Integer>> combine = combinations.combine(4, 2);
        for (int i = 0; i < combine.size(); i++) {
            System.out.println(combine.get(i));
        }
    }

}
