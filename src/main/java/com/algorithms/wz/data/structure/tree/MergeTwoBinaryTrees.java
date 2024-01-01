package com.algorithms.wz.data.structure.tree;

/**
 * <a href="https://leetcode.cn/problems/merge-two-binary-trees/description/">617.合并二叉树</a>
 * 给你两棵二叉树： root1 和 root2 。
 * <p>
 * 想象一下，当你将其中一棵覆盖到另一棵之上时，两棵树上的一些节点将会重叠（而另一些不会）。你需要将这两棵树合并成一棵新二叉树。合并的规则是：如果两个节点重叠，那么将这两个节点的值相加作为合并后节点的新值；否则，不为 null 的节点将直接作为新二叉树的节点。
 * <p>
 * 返回合并后的二叉树。
 * <p>
 * 注意: 合并过程必须从两个树的根节点开始。
 */
public class MergeTwoBinaryTrees {

    /**
     * 递归的思路来计算，就是找到看当前两个节点是否都为 null，如果都是 null，则返回 null，一个不是 null，就继续构造
     *
     * @param root1 树 1
     * @param root2 树 2
     * @return 新的树
     */
    public TreeNode mergeTrees(TreeNode root1, TreeNode root2) {
        if (root1 == null && root2 == null) {
            return null;
        }
        int curNodeValue = 0;
        if (root1 != null) {
            curNodeValue += root1.val;
        }
        if (root2 != null) {
            curNodeValue += root2.val;
        }
        TreeNode root = new TreeNode(curNodeValue);
        root.left = mergeTrees(root1 == null ? null : root1.left, root2 == null ? null : root2.left);
        root.right = mergeTrees(root1 == null ? null : root1.right, root2 == null ? null : root2.right);
        return root;
    }

    /**
     * 优化一下，减少递归次数
     *
     * @param root1
     * @param root2
     * @return
     */
    public TreeNode mergeTrees2(TreeNode root1, TreeNode root2) {
        if (root1 == null) {
            return root2;
        }
        if (root2 == null) {
            return root1;
        }
        TreeNode root = new TreeNode(root1.val + root2.val);
        root.left = mergeTrees(root1.left, root2.left);
        root.right = mergeTrees(root1.right, root2.right);
        return root;
    }
}
