package com.algorithms.wz.one.day.year24.month2;

/**
 * <a href="https://leetcode.cn/problems/range-sum-of-bst/description/">938. 二叉搜索树的范围和</a>
 * 给定二叉搜索树的根结点 root，返回值位于范围 [low, high] 之间的所有结点的值的和。
 */
public class RangeSumOfBst {

    int sum = 0;

    /**
     * 二叉搜索树，如果是二叉树，那这道题目没得说，遍历一遍，获取所有的结果就可以，但如果是二叉搜索树呢，那就减少了遍历次数，
     * 如果如果根节点大于 high，则不用判断右树，如果根节点小于 low，则不用判断左树
     * @param root 根节点
     * @param low 最小值
     * @param high 最大值
     * @return 二叉搜索树符合条件的所有值的和
     */
    public int rangeSumBST(TreeNode root, int low, int high) {
        recursionTree(root, low, high);
        return sum;
    }

    private void recursionTree(TreeNode root, int low, int high) {
        if (root == null) {
            return;
        }
        if (root.val > high) {
            recursionTree(root.left, low, high);
        }
        if (root.val < low) {
            recursionTree(root.right, low, high);
        }
        if (root.val >= low && root.val <= high) {
            sum += root.val;
            recursionTree(root.left, low, high);
            recursionTree(root.right, low, high);
        }
    }

}
