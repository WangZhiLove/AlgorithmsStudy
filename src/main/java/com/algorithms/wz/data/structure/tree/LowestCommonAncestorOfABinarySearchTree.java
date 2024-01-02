package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode-cn.com/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">235.二叉搜索树的最近公共祖先</a>
 * <p>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先
 * <p>
 * 二叉搜索树的特点是左子树的值都小于根节点，右子树的值都大于根节点
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 这道题目可以用二叉树的最近公共祖先来做，但是就应用不到二叉搜索树的特性，所以如果用二叉搜索树的特性，可以做到O(log n)的时间复杂度，一次寻找一半
     * 什么时候找到目标节点呢？判断依据就是 (p >= root && q <= root) || (p <= root && q >= root) || root.val == p.val || root.val == q.val
     * @param root 根节点
     * @param p  目标 p
     * @param q  目标 q
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val > p.val && root.val < q.val) {
            return root;
        }
        if (root.val < p.val && root.val > q.val) {
            return root;
        }
        if (root.val == p.val || root.val == q. val) {
            return root;
        }
        if (root.val < p.val && root.val < q.val) {
            return lowestCommonAncestor(root.right, p, q);
        } else {
            return lowestCommonAncestor(root.left, p, q);
        }
    }
}
