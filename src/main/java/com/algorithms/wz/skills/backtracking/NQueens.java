package com.algorithms.wz.skills.backtracking;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-queens/description/">51. N皇后</a>
 * 按照国际象棋的规则，皇后可以攻击与之处在同一行或同一列或同一斜线上的棋子。
 * <p>
 * n 皇后问题 研究的是如何将 n 个皇后放置在 n×n 的棋盘上，并且使皇后彼此之间不能相互攻击。
 * <p>
 * 给你一个整数 n ，返回所有不同的 n 皇后问题 的解决方案。
 * <p>
 * 每一种解法包含一个不同的 n 皇后问题 的棋子放置方案，该方案中 'Q' 和 '.' 分别代表了皇后和空位。
 */
public class NQueens {

    List<List<String>> result = new ArrayList<>();

    /**
     * N 皇后，直到用回溯，但是还是不会
     *
     * @param n 棋盘、皇后的个数
     * @return 符合条件的结果
     */
    public List<List<String>> solveNQueens(int n) {
        char[][] tempCharArr = new char[n][n];
        for (char[] chars : tempCharArr) {
            Arrays.fill(chars, '.');
        }
        backtracking(n, 0, tempCharArr);
        return result;
    }

    /**
     * 回溯方法
     *
     * @param n           N 个皇后
     * @param row         第几行
     * @param tempCharArr 皇后棋盘
     */
    private void backtracking(int n, int row, char[][] tempCharArr) {
        if (row == n) {
            result.add(array2List(tempCharArr));
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isValid(row, col, n, tempCharArr)) {
                tempCharArr[row][col] = 'Q';
                backtracking(n, row + 1, tempCharArr);
                tempCharArr[row][col] = '.';
            }
        }
    }

    private boolean isValid(int row, int col, int n, char[][] tempCharArr) {
        // 检查列
        for (int i = 0; i < row; i++) {
            if (tempCharArr[i][col] == 'Q') {
                return false;
            }
        }
        // 检查 45
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (tempCharArr[i][j] == 'Q') {
                return false;
            }
        }
        // 检查 135
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (tempCharArr[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }

    private List<String> array2List(char[][] tempCharArr) {
        List<String> list = new ArrayList<>();
        for (char[] chars : tempCharArr) {
            list.add(String.copyValueOf(chars));
        }
        return list;
    }

}
