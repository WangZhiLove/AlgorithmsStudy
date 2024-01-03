package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode.cn/problems/convert-sorted-array-to-binary-search-tree/description/">108.将有序数组转换为二叉搜索树 </a>
 * 给你一个整数数组 nums ，其中元素已经按 升序 排列，请你将其转换为一棵 高度平衡 二叉搜索树。
 * <p>
 * 高度平衡 二叉树是一棵满足「每个节点的左右两个子树的高度差的绝对值不超过 1 」的二叉树。
 */
public class ConvertSortedArrayToBinarySearchTree {

    /**
     * 高度平衡二叉树，也就是一直要二分，那这道题目递归实现也是可以的，就是要加上左右边界
     *
     * @param nums 有序数组
     * @return 树
     */
    public TreeNode sortedArrayToBST(int[] nums) {
        return recursion(nums, 0, nums.length - 1);
    }

    private TreeNode recursion(int[] nums, int left, int right) {
        if (left > right) {
            return null;
        }
        int middle = (left + right) / 2;
        TreeNode root = new TreeNode(nums[middle]);
        root.left = recursion(nums, left, middle - 1);
        root.right = recursion(nums, middle + 1, right);
        return root;
    }

    public static void main(String[] args) {
        ConvertSortedArrayToBinarySearchTree convertSortedArrayToBinarySearchTree = new ConvertSortedArrayToBinarySearchTree();
        int[] nums = {1, 2, 3, 4, 5, 6, 7};
        TreeNode treeNode = convertSortedArrayToBinarySearchTree.sortedArrayToBST(nums);
        System.out.println(treeNode);
    }

}
