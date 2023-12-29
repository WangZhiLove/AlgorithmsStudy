package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode-cn.com/problems/sum-of-left-leaves/">404. 左叶子之和</a>
 * 给定二叉树的根节点 root ，返回所有左叶子之和。
 */
public class SumOfLeftLeaves {

    /**
     * 这道题目广度和深度都行，只遍历左节点就可以，我想递归应该简单，那就用递归
     * @param root 根节点
     * @return
     */
    public int sumOfLeftLeaves(TreeNode root) {
        return recursion(root, 1, 0);
    }

    private int recursion(TreeNode root, int leftOrRight, int sum) {
        if (root == null) {
            return leftOrRight == 0 ? sum : 0;
        }
        if (leftOrRight == 0 && root.left == null && root.right == null) {
            sum += root.val;
        }
        int leftSum = recursion(root.left, 0, sum);
        int rightSum = recursion(root.right, 1, sum);
        return leftSum + rightSum;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        root2.right = root5;
        SumOfLeftLeaves sumOfLeftLeaves = new SumOfLeftLeaves();
        int i = sumOfLeftLeaves.sumOfLeftLeaves(root);
        System.out.println(i);
    }
}
