package com.algorithms.wz.data.structure.array;

/**
 * <a href="https://leetcode.cn/problems/diagonal-traverse/">498. 对角线遍历</a>
 * 给你一个大小为 m x n 的矩阵 mat ，请以对角线遍历的顺序，用一个数组返回这个矩阵中的所有元素。
 *
 * @author wangzhi
 */
public class DiagonalTraverse {

    public static void main(String[] args) {
        int[] diagonalOrder = findDiagonalOrder(new int[][] {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}});
        for (int i : diagonalOrder) {
            System.out.println(i);
        }
    }

    /**
     * 这道题目初次拿上没有思路，想找规律，结果发现并不好找，后来思考了一下和索引关联或许会是一个好的思路，好像不太行，看看题解吧，没有太多的思路
     * 还是找规律呀，挺直观的规律，但是我没有找到，我想找的是一个通用的解决方案，题解其实是从对角线的角度来考虑，对角线有其规律可言。所以针对于直接
     * 问题寻找答案，对角线的遍历要么从左下到右上，要么从右上到左下，前者是 i --,j++;后者是 i ++,j --，只要判断当前的对角线是哪一种，然后终止
     * 条件是什么就好
     *
     * @param mat 矩阵
     * @return 遍历后的数组
     */
    public static int[] findDiagonalOrder(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] result = new int[mat.length * mat[0].length];
        int index = 0;
        // 其中 i 表示第几条对角线
        for (int i = 0; i < m + n - 1; i++) {
            if (i % 2 == 0) {
                int x = i < m ? i : m - 1;
                int y = i < m ? 0 : i - m + 1;
                while (x >= 0 && y < n) {
                    result[index++] = mat[x][y];
                    x--;
                    y++;
                }
            } else {
                int x = i < n ? 0 : i - n + 1;
                int y = i < n ? i : n - 1;
                while (x < m && y >= 0) {
                    result[index++] = mat[x][y];
                    x++;
                    y--;
                }
            }
        }
        return result;
    }

}
