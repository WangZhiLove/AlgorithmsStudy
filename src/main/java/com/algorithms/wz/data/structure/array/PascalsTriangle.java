package com.algorithms.wz.data.structure.array;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/pascals-triangle/">118. 杨辉三角</a>
 * <p>
 * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
 * <p>
 * 在「杨辉三角」中，每个数是它左上方和右上方的数的和。
 * </p>
 *
 * @author wangzhi
 */
public class PascalsTriangle {

    public static void main(String[] args) {
        List<List<Integer>> generate = generate(1);
        for (List<Integer> list : generate) {
            for (Integer integer : list) {
                System.out.print(integer + "  ");
            }
            System.out.println();
        }
    }

    /**
     * 给定一个非负整数 numRows，生成「杨辉三角」的前 numRows 行。
     * @param numRows 前几行
     * @return 生成的列表
     */
    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < numRows; i++) {
            List<Integer> rowList = new ArrayList<>();
            for (int j = 0; j <= i; j ++) {
                if (j == 0 || j == i) {
                    rowList.add(1);
                } else {
                    rowList.add(result.get(i - 1).get(j - 1) + result.get(i - 1).get(j));
                }
            }
            result.add(rowList);
        }
        return result;
    }
}
