package com.algorithms.wz.data.structure.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/pascals-triangle-ii/">119. 杨辉三角 II</a>
 * <p>
 * 给定一个非负索引 rowIndex，返回「杨辉三角」的第 rowIndex 行。
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * </p>
 *
 * @author wangzhi
 */
public class PascalsTriangleII {

    public static void main(String[] args) {
        List<Integer> row = getRow(4);
        for (Integer integer : row) {
            System.out.print(integer + " ");
        }
    }

    /**
     * 相对于杨辉三角 1 来说就是算第 n 行，可以在其基础上做，但是时间复杂度比较高，但是有什么更简单的方法吗？可以用递归的方法实现吗？试试看
     *
     * @param rowIndex 第 n 行
     * @return 第 n 行的数据
     */
    public static List<Integer> getRow(int rowIndex) {
        int len = rowIndex + 1;
        List<Integer> result = new ArrayList<>(rowIndex + 1);
        int[][] arr = new int[rowIndex + 1][rowIndex + 1];
        for (int[] ins : arr) {
            Arrays.fill(ins, -1);
        }
        for (int i = 0; i < len / 2; i++) {
            result.add(getArrIndex(rowIndex, i, arr));
        }
        // 奇数
        if (len % 2 == 1) {
            result.add(getArrIndex(rowIndex, len / 2, arr));
            for (int i = len / 2 + 1; i < len; i++) {
                result.add(result.get(len - i - 1));
            }
        } else {
            // 偶数
            for (int i = len / 2; i < len; i++) {
                result.add(result.get(len - i - 1));
            }
        }
        return result;
    }

    /**
     * 获取数组元素
     *
     * @param row 行
     * @param col 列
     * @param arr 数组
     * @return 元素
     */
    private static Integer getArrIndex(int row, int col, int[][] arr) {
        // 缓存的数据
        if (arr[row][col] != -1) {
            return arr[row][col];
        }
        // 边界
        if (col == 0 || col == row) {
            arr[row][col] = 1;
            return 1;
        }
        // 计算
        arr[row][col] = getArrIndex(row - 1, col - 1, arr) + getArrIndex(row - 1, col, arr);
        return arr[row][col];
    }

}
