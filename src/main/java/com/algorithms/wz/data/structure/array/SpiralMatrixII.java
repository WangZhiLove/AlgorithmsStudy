package com.algorithms.wz.data.structure.array;


/**
 * <a href="https://leetcode.cn/problems/spiral-matrix-ii/description/">59. 螺旋矩阵 II</a>
 * 给你一个正整数 n ，生成一个包含 1 到 n2 所有元素，且元素按顺时针顺序螺旋排列的 n x n 正方形矩阵 matrix 。
 */
public class SpiralMatrixII {

    public static void main(String[] args) {
        generateMatrix2(3);
    }

    /**
     * 遇到边界或者访问过的元素，就顺时针转动，关键是代码怎么写，如何确定边界很关键。
     * 这里声明了一个二维数组确定下一个位置，声明一个变量用来确定方向，为什么要确定下一个位置，因为要根据下一个位置来确定是不是要转向，
     * 也就是下一个位置如果处于边界或者已经访问过，则顺时针转向
     *
     * @param n 二维数组的长度
     * @return 二维数组
     */
    public static int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        // 四个方向，分别代表了右、下、左、上
        int[][] direct = new int[][] {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
        // 代表了方向，因为是四个方向，所以和 4 取余
        int steering = 0;
        // 初始化行、列
        int num = 1, row = 0, col = 0;
        while (num <= n * n) {
            result[row][col] = num;
            num++;
            // 确定下一个位置，并不是真实的下一个位置，而是根据当下的情况确定下一个位置，用于判断是否是边界或者是否已经访问过
            int nextRow = row + direct[steering][0], nextCol = col + direct[steering][1];
            // 如果是边界或者已经访问过， 则顺时针旋转到下一个方向
            if (nextRow < 0 || nextRow >= n || nextCol < 0 || nextCol >= n || result[nextRow][nextCol] != 0) {
                steering = (++steering) % 4;
            }
            // 确定真实的下一个位置
            row = row + direct[steering][0];
            col = col + direct[steering][1];
        }
        return result;
    }

    /**
     * 按层遍历，确定每一层的四个角，并且每一层都是先从左上到右上，从右上到右下，从右下到左下，从左下到左上，形成循环
     *
     * @param n 二维数组的长度
     * @return 二维数组
     */
    public static int[][] generateMatrix2(int n) {
        int[][] result = new int[n][n];
        int num = 1;
        int left = 0, right = n - 1, top = 0, bottom = n - 1;
        while (left <= right && top <= bottom) {
            for (int col = left; col <= right; col++) {
                result[left][col] = num;
                num++;
            }
            for (int row = top + 1; row <= bottom; row++) {
                result[row][right] = num;
                num++;
            }
            for (int col = right - 1; col >= left; col --) {
                result[bottom][col] = num;
                num++;
            }
            for (int row = bottom - 1; row > top; row --) {
                result[row][left] = num;
                num++;
            }
            left ++;
            right --;
            top ++;
            bottom --;
        }
        return result;
    }
}
