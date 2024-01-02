package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode.cn/problems/insert-into-a-binary-search-tree/description/">701.二叉搜索树中的插入操作</a>
 * 给定二叉搜索树（BST）的根节点 root 和要插入树中的值 value ，将值插入二叉搜索树。 返回插入后二叉搜索树的根节点。 输入数据 保证 ，新值和原始二叉搜索树中的任意节点值都不同。
 * <p>
 * 注意，可能存在多种有效的插入方式，只要树在插入后仍保持为二叉搜索树即可。 你可以返回 任意有效的结果 。
 */
public class InsertIntoABinarySearchTree {

    /**
     * 这道题目需要考虑的是什么插入 val，递归一直到根节点是最简单的，试试看
     * @param root 根节点
     * @param val 值
     * @return 树
     */
    public TreeNode insertIntoBST(TreeNode root, int val) {
        if (root == null) {
            return new TreeNode(val);
        }
        if (root.val > val) {
            root.left = insertIntoBST(root.left, val);
        } else {
            root.right = insertIntoBST(root.right, val);
        }
        return root;
    }

}
