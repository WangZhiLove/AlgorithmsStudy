package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode.cn/problems/trim-a-binary-search-tree/description/">669. 修剪二叉搜索树</a>
 * 给你二叉搜索树的根节点 root ，同时给定最小边界low 和最大边界 high。通过修剪二叉搜索树，使得所有节点的值在[low, high]中。修剪树 不应该 改变保留在树中的元素的相对结构 (即，如果没有被移除，原有的父代子代关系都应当保留)。 可以证明，存在 唯一的答案 。
 * <p>
 * 所以结果应当返回修剪好的二叉搜索树的新的根节点。注意，根节点可能会根据给定的边界发生改变。
 */
public class TrimABinarySearchTree {

    /**
     * 判断当前节点是否符合边界，有三种情况：
     * 1. 符合，啥也不做，判断当前节点的左节点和右节点
     * 2. 小于最小值，判断当前节点的右树
     * 3. 大于最大值，判断当前节点的左树
     *
     * @param root 根节点
     * @param low  节点最小值
     * @param high 节点最大值
     * @return 树的根节点
     */
    public TreeNode trimBST(TreeNode root, int low, int high) {
        if (root == null) {
            return null;
        }
        if (root.val >= low && root.val <= high) {
            root.left = trimBST(root.left, low, high);
            root.right = trimBST(root.right, low, high);
        }
        if (root.val < low) {
            return trimBST(root.right, low, high);
        }
        if (root.val > high) {
            return trimBST(root.left, low, high);
        }
        return root;
    }

}
