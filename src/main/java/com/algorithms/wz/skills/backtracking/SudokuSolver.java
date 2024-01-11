package com.algorithms.wz.skills.backtracking;

/**
 * <a href="https://leetcode.cn/problems/sudoku-solver/description/">37. 解数独</a>
 * 编写一个程序，通过填充空格来解决数独问题。
 * <p>
 * 数独的解法需 遵循如下规则：
 * <p>
 * 数字 1-9 在每一行只能出现一次。
 * 数字 1-9 在每一列只能出现一次。
 * 数字 1-9 在每一个以粗实线分隔的 3x3 宫内只能出现一次。（请参考示例图）
 * 数独部分空格内已填入了数字，空白格用 '.' 表示。
 */
public class SudokuSolver {

    char[] numChar = new char[] {'1', '2', '3', '4', '5', '6', '7', '8', '9'};

    /**
     * 想想 N 皇后，这道题目类似，就是一个一个数字，但是我觉得这么写会超时，先写出来看看
     *
     * @param board 二维数组
     */
    public void solveSudoku(char[][] board) {
        backtracking(board);
        System.out.println(board);
    }

    private boolean backtracking(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    for (int k = 0; k < numChar.length; k++) {
                        if (vaild(board, i, j, numChar[k])) {
                            board[i][j] = numChar[k];
                            boolean backtracking = backtracking(board);
                            if (backtracking) {
                                return true;
                            } else {
                                board[i][j] = '.';
                            }
                        }
                    }
                    return false;
                }
            }
        }
        return true;
    }

    private boolean vaild(char[][] board, int row, int col, char num) {
        // 判断行
        for (int i = 0; i < board.length; i++) {
            if (board[row][i] == num) {
                return false;
            }
        }
        // 判断列
        for (int i = 0; i < board.length; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        // 判断所在九宫格
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        for (int i = startRow; i < startRow + 3; i++) {
            for (int j = startCol; j < startCol + 3; j++) {
                if (board[i][j] == num) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        SudokuSolver sudokuSolver = new SudokuSolver();
        char[][] target =
            new char[][] {{'5', '3', '.', '.', '7', '.', '.', '.', '.'}, {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'}, {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'}, {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '.'}, {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}};
        sudokuSolver.solveSudoku(target);
        System.out.println(target);

    }
}
