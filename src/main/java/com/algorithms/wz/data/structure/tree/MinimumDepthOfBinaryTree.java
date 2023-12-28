package com.algorithms.wz.data.structure.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/minimum-depth-of-binary-tree/">111. 二叉树的最小深度</a>
 * <p>
 * 给定一个二叉树，找出其最小深度。
 * 最小深度是从根节点到最近叶子节点的最短路径上的节点数量。
 * 说明：叶子节点是指没有子节点的节点。
 */
public class MinimumDepthOfBinaryTree {

    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        return recursionMinDepth(root.left, root.right, 0);
    }

    private int recursionMinDepth(TreeNode left, TreeNode right, int depth) {
        if (left == null && right == null) {
            return depth + 1;
        }
        if (left != null && right != null) {
            return Math.min(recursionMinDepth(left.left, left.right, depth + 1), recursionMinDepth(right.left, right.right, depth + 1));
        }
        if (left != null) {
            return recursionMinDepth(left.left, left.right, depth + 1);
        }
        return recursionMinDepth(right.left, right.right, depth + 1);
    }

    /**
     * 循环的写法就是层序遍历，记录层就足够了，直到有一个节点的左右字节点都为空，这时候层就是最小深度
     * @param root
     * @return
     */
    public int minDepth2(TreeNode root) {
        if (root == null) {
            return 0;
        }
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int minDepth = 0;
        while (!queue.isEmpty()) {
            minDepth ++;
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                if (poll.left == null && poll.right == null) {
                    return minDepth;
                }
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
        }
        return minDepth;
    }
}
