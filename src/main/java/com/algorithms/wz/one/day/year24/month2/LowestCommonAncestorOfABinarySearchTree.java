package com.algorithms.wz.one.day.year24.month2;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-search-tree/description/">235. 二叉搜索树的最近公共祖先</a>
 * 给定一个二叉搜索树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个结点 p、q，最近公共祖先表示为一个结点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestorOfABinarySearchTree {

    /**
     * 最近公公祖先
     * @param root 根节点
     * @param p    目标节点1
     * @param q    目标节点2
     * @return 最近的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        TreeNode small = p.val >= q.val ? q : p;
        TreeNode big = p.val >= q.val ? p : q;
        return myLowestCommonAncestor(root, small, big);
    }

    private TreeNode myLowestCommonAncestor(TreeNode root, TreeNode small, TreeNode big) {
        if (small.val <= root.val && big.val >= root.val) {
            return root;
        }
        if (small.val == root.val || big.val == root.val) {
            return root;
        }
        if (big.val < root.val) {
            return myLowestCommonAncestor(root.left, small, big);
        } else {
            return myLowestCommonAncestor(root.right, small, big);
        }
    }
}
