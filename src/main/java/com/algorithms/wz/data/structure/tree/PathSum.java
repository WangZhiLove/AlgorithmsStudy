package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode.cn/problems/path-sum/description/">112. 路径总和</a>
 * 给你二叉树的根节点 root 和一个表示目标和的整数 targetSum 。判断该树中是否存在 根节点到叶子节点 的路径，这条路径上所有节点值相加等于目标和 targetSum 。如果存在，返回 true ；否则，返回 false 。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class PathSum {

    /**
     * 递归深度遍历
     *
     * @param root      根节点
     * @param targetSum 目标值
     * @return 是否包含路径和等于 targetSum
     */
    public boolean hasPathSum(TreeNode root, int targetSum) {
        return recursion(root, targetSum, 0) == 1;
    }

    private int recursion(TreeNode root, int targetSum, int mySum) {
        if (root == null) {
            return -1;
        }
        mySum += root.val;
        if (root.left == null && root.right == null) {
            if (mySum == targetSum) {
                return 1;
            } else {
                return -1;
            }
        }
        return Math.max(recursion(root.left, targetSum, mySum), recursion(root.right, targetSum, mySum));
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(11);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root1.left = root2;
        root2.right = root3;
        root2.left = root4;
        PathSum pathSum = new PathSum();
        boolean b = pathSum.hasPathSum(root, 22);
        System.out.println(b);
    }

}
