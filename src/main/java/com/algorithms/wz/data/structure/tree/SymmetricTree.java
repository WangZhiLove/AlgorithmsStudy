package com.algorithms.wz.data.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/symmetric-tree/">101. 对称二叉树</a>
 * 给你一个二叉树的根节点 root ， 检查它是否轴对称。
 *
 * @author wangzhi
 */
public class SymmetricTree {

    /**
     * 双指针 + 递归
     *
     * @param root 根节点
     * @return 是否对称
     */
    public boolean isSymmetric(TreeNode root) {
        return traversal(root, root);
    }

    private boolean traversal(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        return left.val == right.val && traversal(left.left, right.right) && traversal(left.right, right.left);
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root1 = new TreeNode(2);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(2);
        root.left = root1;
        root.right = root2;
        root1.left = root3;
        root1.right = null;
        root2.left = root4;
        SymmetricTree symmetricTree = new SymmetricTree();
        System.out.println(symmetricTree.isSymmetric2(root));
    }

    /**
     * 队列试试，一次要出两个节点，相同的代码，使用 LinkedList 无错，使用 ArrayDeque 就会出错，这个是因为 ArrayDeque 不支持 null。
     *
     * @param root
     * @return
     */
    public boolean isSymmetric2(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode left = queue.poll();
            TreeNode right = queue.poll();
            if (left == null && right == null) {
                continue;
            }
            if ((left == null || right == null) || left.val != right.val) {
                return false;
            }
            queue.offer(left.left);
            queue.offer(right.right);

            queue.offer(left.right);
            queue.offer(right.left);
        }
        return true;
    }

}
