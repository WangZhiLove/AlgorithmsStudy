package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode.cn/problems/lowest-common-ancestor-of-a-binary-tree/description/">236. 二叉树的最近公共祖先</a>
 * 给定一个二叉树, 找到该树中两个指定节点的最近公共祖先。
 * <p>
 * 百度百科中最近公共祖先的定义为：“对于有根树 T 的两个节点 p、q，最近公共祖先表示为一个节点 x，满足 x 是 p、q 的祖先且 x 的深度尽可能大（一个节点也可以是它自己的祖先）。”
 */
public class LowestCommonAncestorOfABinaryTree {

    /**
     * 递归的思路应该简单，判断 p，q 是否分别存在于当前节点左树和右树，如果存在，那说明当前节点就是最近共同祖先
     * 没想出来，但是我有一个思路，就是判断 p，q 是否同时在一个树的左右两侧，如果在，那就是当前节点，如果不在，那就看看是在左还是右，遍历对应的子树，确实做出来，就是复杂度有点高
     *
     * @param root 根节点
     * @param p    目标 p
     * @param q    目标 q
     * @return 最近的公共祖先
     */
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if (root.val == p.val || root.val == q.val) {
            return root;
        }
        boolean left = nodeIsTree(root.left, p) && nodeIsTree(root.left, q);
        boolean right = nodeIsTree(root.right, p) && nodeIsTree(root.right, q);
        if (left) {
            return lowestCommonAncestor(root.left, p, q);
        } else if (right) {
            return lowestCommonAncestor(root.right, p, q);
        }
        return root;
    }

    private boolean nodeIsTree(TreeNode root, TreeNode p) {
        if (root == null) {
            return false;
        }
        if (root.val == p.val) {
            return true;
        }
        return nodeIsTree(root.left, p) || nodeIsTree(root.right, p);
    }

    public static void main(String[] args) {
        LowestCommonAncestorOfABinaryTree lowestCommonAncestorOfABinaryTree = new LowestCommonAncestorOfABinaryTree();
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(3);
        root.left = root1;
        root.right = root2;
        System.out.println(lowestCommonAncestorOfABinaryTree.lowestCommonAncestor(root, root2, root1).val);
    }

    private TreeNode answer = null;

    /**
     * dfs，我想到用 dfs 了，但是卡在了如何判断当前节点是否为最近公共祖先，判断的公式是
     * node_left_p && node_right_q || ((node_p || node_q) && (node_left_p || node_right_q))
     *
     * @param root 根节点
     * @param p    目标 p
     * @param q    目标 q
     * @return 最近公共祖先
     */
    public TreeNode lowestCommonAncestor2(TreeNode root, TreeNode p, TreeNode q) {
        dfs(root, p, q);
        return answer;
    }

    private boolean dfs(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null) {
            return false;
        }
        boolean curNode = root.val == p.val || root.val == q.val;
        boolean nodeLeft = dfs(root.left, p, q);
        boolean nodeRight = dfs(root.right, p, q);
        if ((nodeLeft && nodeRight) || (curNode && nodeLeft) || (curNode && nodeRight)) {
            answer = root;
        }
        // 这一步也很关键
        return nodeLeft || nodeRight || curNode;
    }

}
