package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode-cn.com/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 * 给定一个二叉树，判断它是否是高度平衡的二叉树。
 * <p>
 * 本题中，一棵高度平衡二叉树定义为：
 * <p>
 * 一个二叉树每个节点 的左右两个子树的高度差的绝对值不超过 1 。
 */
public class BalancedBinaryTree {

    /**
     * 这道题我的思路是求出最小深度和最大深度，然后比较两者的差值，如果大于1，则不是平衡二叉树
     * 思路出现了问题，这道题是每个节点 的左右两个子树的高度差的绝对值不超过 1，好吧，这道题没有思路，看了题解在做
     * 理解什么是高度，什么是深度？
     * 高度说的是节点到叶子节点的最长路径；深度说的是节点到根节点的路径和
     *
     * @param root 根节点
     * @return 是否是平衡二叉树
     */
    public boolean isBalanced(TreeNode root) {
        if (root == null) {
            return true;
        } else {
            return Math.abs(height(root.left) - height(root.right)) <= 1 && isBalanced(root.left) && isBalanced(
                root.right);
        }
    }

    private int height(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        } else {
            return Math.max(height(treeNode.left), height(treeNode.right)) + 1;
        }
    }

    public boolean isBalanced2(TreeNode root) {
        return height2(root) >= 0;
    }

    private int height2(TreeNode treeNode) {
        if (treeNode == null) {
            return 0;
        }
        int leftHeight = height2(treeNode.left);
        int rightHeight = height2(treeNode.right);
        if (leftHeight == -1 || rightHeight == -1 || Math.abs(leftHeight - rightHeight) > 1) {
            return -1;
        }
        return Math.max(leftHeight, rightHeight) + 1;
    }

}
