package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/palindrome-partitioning/description/">131.分割回文串</a>
 * 给你一个字符串 s，请你将 s 分割成一些子串，使每个子串都是 回文串 。返回 s 所有可能的分割方案。
 * <p>
 * 回文串 是正着读和反着读都一样的字符串。
 */
public class PalindromePartitioning {

    private int[][] flag;

    private List<List<String>> result = new ArrayList<>();

    private List<String> temp = new ArrayList<>();

    /**
     * 这个题目没有思路，甚至怎么切割都不知道，这里想一想树，其实就是一个 dfs 的过程，到每一个叶子节点的路径都是一个结果集，加上记忆化搜索，不需要重复计算
     * @param s 字符串
     * @return 切割所有的回文串
     */
    public List<List<String>> partition(String s) {
        flag = new int[s.length()][s.length()];
        backtracking(s, 0);
        return result;
    }

    private void backtracking(String s, int index) {
        // 遍历到最后一位，结束遍历
        if (index == s.length()) {
            result.add(new ArrayList<>(temp));
            return;
        }
        for (int i = index; i < s.length(); i++) {
            if (isPalindrome(s, index, i) == 1) {
                temp.add(s.substring(index, i + 1));
                backtracking(s, i + 1);
                temp.remove(temp.size() - 1);
            }
        }
    }

    private int isPalindrome(String s, int i, int j) {
        if (flag[i][j] != 0) {
            return flag[i][j];
        }
        if (i >= j) {
            flag[i][j] = 1;
        } else if (s.charAt(i) == s.charAt(j)){
            return isPalindrome(s, i + 1, j - 1);
        } else {
            flag[i][j] = -1;
        }
        return flag[i][j];
    }

}
