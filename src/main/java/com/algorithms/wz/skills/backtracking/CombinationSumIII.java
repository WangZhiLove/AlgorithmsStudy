package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/combination-sum-iii/description/">216.组合总和III</a>
 * 找出所有相加之和为 n 的 k 个数的组合，且满足下列条件：
 * <p>
 * 只使用数字1到9
 * 每个数字 最多使用一次
 * 返回 所有可能的有效组合的列表 。该列表不能包含相同的组合两次，组合可以以任何顺序返回。
 */
public class CombinationSumIII {

    private List<List<Integer>> result = new ArrayList<>();

    private List<Integer> temp = new ArrayList<>();

    private int sum = 0;

    /**
     * 回溯法，代码模板套上去看看
     * @param k  集合中元素的个数
     * @param n  元素之和
     * @return 集合
     */
    public List<List<Integer>> combinationSum3(int k, int n) {
        backtracking(k, n, 1);
        return result;
    }

    private void backtracking(int k, int n, int index) {
        // 终止条件
        if (temp.size() == k) {
            // 添加结果到结果集
            if (sum == n) {
                result.add(new ArrayList<>(temp));
            }
            return;
        }
        // 循环
        for (int i = index; i < 10 - (k - temp.size()) + 1; i++) {
            temp.add(i);
            sum += i;
            // 递归
            backtracking(k, n, i + 1);
            sum -= i;
            temp.remove(temp.size() - 1);
        }
    }

}
