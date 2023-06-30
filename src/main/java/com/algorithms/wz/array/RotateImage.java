package com.algorithms.wz.array;

import java.util.Arrays;

/**
 * <a href="https://leetcode.cn/problems/rotate-image/">48. 旋转图像</a>
 *
 * @author wangzhi
 */
public class RotateImage {

    public static void main(String[] args) {
        int[][] arr = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        int[][] rotate = rotate(arr);
        for (int[] ints : rotate) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }

    /**
     * 这倒题目如果可以借助另外一个矩阵，那就方便多了，就是行列互换就好，0 行变最后一列，1 行变倒数第二列，但是要求原地旋转，那就需要想一下了
     * 花费了大半个小时，总算找到规律了，用索引来总结下面的规律：
     * (i,j) -> (j, length - 1 - i) -> (length - 1 - i, length - 1 - j) -> (length - 1 - j, i) -> (i,j)
     *
     * 官方题解的规律更简单一点，对于 (i,j) 的元素，旋转后的新位置是 (j, n - row - 1), 不过竟然用了辅助矩阵，这与题目要求不符，不用考虑
     *
     * 官方还有另外一个解题思路，就是先水平翻转，再主对角线反转，这也是一个思路
     *
     * @param matrix 矩阵
     */
    public static int[][] rotate(int[][] matrix) {
        if (matrix.length == 0 || matrix.length == 1) {
            return matrix;
        }
        int lenIndex = matrix.length - 1;
        // 标识位，防止重复旋转
        int[][] flag = new int[matrix.length][matrix[0].length];
        for (int[] flagArr : flag) {
            Arrays.fill(flagArr, 0);
        }
        // 遍历，进行原地旋转
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (flag[i][j] == 1) {
                    continue;
                }
                // 使用规律进行旋转，本质其实就是元素交换，只不过是四个元素交换
                /*int value = matrix[j][lenIndex - i];
                int temp = matrix[lenIndex - i][lenIndex - j];
                int temp1 = matrix[lenIndex - j][i];
                matrix[j][lenIndex - i] = matrix[i][j];
                matrix[lenIndex - i][lenIndex - j] = value;
                matrix[lenIndex - j][i] = temp;
                matrix[i][j] = temp1;*/
                int value = matrix[i][j];
                matrix[i][j] = matrix[lenIndex - j][i];
                matrix[lenIndex - j][i] = matrix[lenIndex - i][lenIndex - j];
                matrix[lenIndex - i][lenIndex - j] =matrix[j][lenIndex - i];
                matrix[j][lenIndex - i] = value;
                // 重置标志为
                flag[i][j] = 1;
                flag[j][lenIndex - i] = 1;
                flag[lenIndex - i][lenIndex - j] = 1;
                flag[lenIndex - j][i] = 1;
            }
        }
        return matrix;
    }


}
