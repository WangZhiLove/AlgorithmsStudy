package com.algorithms.wz.data.structure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/zero-matrix-lcci/">面试题 01.08. 零矩阵</a>
 * <p>
 * 编写一种算法，若M × N矩阵中某个元素为0，则将其所在的行与列清零。
 * </p>
 *
 * @author wangzhi
 */
public class ZeroMatrixLcci {

    public static void main(String[] args) {

    }

    /**
     * 这道题目我的想法非常简单，就是两次遍历，一次遍历寻找到所有 0 的元素位置，第二次遍历置为 0
     * 上面的解题思路没有问题，并且可以完美解决问题，那有没有更好的方式呢？比如说原地更新？递归思路试一试
     * @param matrix M × N矩阵
     */
    public void setZeroes(int[][] matrix) {
        if (matrix.length == 0) {
            return;
        }
        // 存放行为 0 的索引
        List<Integer> rows = new ArrayList<>();
        // 存放列为 0 的索引
        List<Integer> cols = new ArrayList<>();
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    rows.add(i);
                    cols.add(j);
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (rows.contains(i) || cols.contains(j)) {
                    matrix[i][j] = 0;
                }
            }
        }
    }

    /**
     * 标记数组的思路想一想
     * @param matrix M × N矩阵
     */
    public void setZeroes2(int[][] matrix) {

    }

}
