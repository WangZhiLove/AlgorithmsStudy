package com.algorithms.wz.data.structure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/maximum-binary-tree/description/">654.最大二叉树</a>
 * 给定一个不重复的整数数组 nums 。 最大二叉树 可以用下面的算法从 nums 递归地构建:
 * <p>
 * 创建一个根节点，其值为 nums 中的最大值。
 * 递归地在最大值 左边 的 子数组前缀上 构建左子树。
 * 递归地在最大值 右边 的 子数组后缀上 构建右子树。
 * 返回 nums 构建的 最大二叉树 。
 */
public class MaximumBinaryTree {


    /**
     * 这道题目和之前构造树有点想似，找准边界构造就可以
     *
     * @param nums
     * @return
     */
    public TreeNode constructMaximumBinaryTree(int[] nums) {
        return constructBinaryTree(nums, 0, nums.length - 1);
    }

    private TreeNode constructBinaryTree(int[] nums, int left, int right) {
        if (left > right || left < 0 || right > nums.length - 1) {
            return null;
        }
        int maxValueIndex = getMaxValueIndex(nums, left, right);
        TreeNode root = new TreeNode(nums[maxValueIndex]);
        root.left = constructBinaryTree(nums, left, maxValueIndex - 1);
        root.right = constructBinaryTree(nums, maxValueIndex + 1, right);
        return root;
    }

    private int getMaxValueIndex(int[] nums, int left, int right) {
        int maxValue = Integer.MIN_VALUE;
        int maxValueIndex = 0;
        for (int i = left; i <= right; i++) {
            if (nums[i] > maxValue) {
                maxValue = nums[i];
                maxValueIndex = i;
            }
        }
        return maxValueIndex;
    }

    public static void main(String[] args) {
        MaximumBinaryTree maximumBinaryTree = new MaximumBinaryTree();
        TreeNode treeNode = maximumBinaryTree.constructMaximumBinaryTree(new int[] {3, 2, 1, 6, 0, 5});
        System.out.println(treeNode);
    }
}
