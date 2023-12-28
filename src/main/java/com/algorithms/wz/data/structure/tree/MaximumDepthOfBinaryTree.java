package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-binary-tree/">104. 二叉树的最大深度</a>
 * 给定一个二叉树 root ，返回其最大深度。
 * <p>
 * 二叉树的 最大深度 是指从根节点到最远叶子节点的最长路径上的节点数。
 */
public class MaximumDepthOfBinaryTree {

    public int maxDepth(TreeNode root) {
        return recursionMaxDepth(root, 0);
    }

    private int recursionMaxDepth(TreeNode root, int depth) {
        if (root == null) {
            return depth;
        }
        return Math.max(recursionMaxDepth(root.left, depth + 1), recursionMaxDepth(root.right, depth + 1));
    }
}
