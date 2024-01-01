package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode.cn/problems/search-in-a-binary-search-tree/description/">700.二叉搜索树中的搜索</a>
 * 给定二叉搜索树（BST）的根节点 root 和一个整数值 val。
 * <p>
 * 你需要在 BST 中找到节点值等于 val 的节点。 返回以该节点为根的子树。 如果节点不存在，则返回 null 。
 */
public class SearchInABinarySearchTree {

    /**
     * 搜索树的顺序遍历，其实这个就是考验是否知道二叉搜索树的概念
     *
     * @param root 根节点
     * @param val  目标值
     * @return 返回根节点
     */
    public TreeNode searchBST(TreeNode root, int val) {
        if (root == null) {
            return null;
        }
        if (root.val == val) {
            return root;
        }
        if (root.val > val) {
            return searchBST(root.left, val);
        }
        return searchBST(root.right, val);
    }

}
