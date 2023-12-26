package com.algorithms.wz.data.structure.tree;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/invert-binary-tree/">226. 翻转二叉树</a>
 * 给你一棵二叉树的根节点 root ，翻转这棵二叉树，并返回其根节点。
 * @author wangzhi
 */
public class InvertBinaryTree {

    /**
     * 可以使用队列存储节点，原地替换，让我想起了双指针
     * @param root 根节点
     * @return 树
     */
    public TreeNode invertTree(TreeNode root) {
         TreeNode result = root;
         Queue<TreeNode> queue = new ArrayDeque<>();
         if (root != null) {
             queue.add(root);
         }
         while (!queue.isEmpty()) {
             TreeNode poll = queue.poll();
             if (poll.left != null) {
                 queue.add(poll.left);
             }
             if (poll.right != null) {
                 queue.add(poll.right);
             }
             TreeNode temp = poll.left;
             poll.left = poll.right;
             poll.right = temp;
         }
         return result;
    }


}
