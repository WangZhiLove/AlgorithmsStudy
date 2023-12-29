package com.algorithms.wz.data.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/binary-tree-paths/">257. 二叉树的所有路径</a>
 * 给你一个二叉树的根节点 root ，按 任意顺序 ，返回所有从根节点到叶子节点的路径。
 * <p>
 * 叶子节点 是指没有子节点的节点。
 */
public class BinaryTreePaths {

    /**
     * 这道题目就是典型的深度优先遍历了
     *
     * @param root
     * @return
     */
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<>();
        dfs(root, "", result);
        return result;
    }

    private void dfs(TreeNode root, String str, List<String> result) {
        // root 不会有 null 的情况，所以这里直接拼接
        if (str.isEmpty()) {
            str += root.val;
        } else {
            str += "->" + root.val;
        }
        // 如果为叶子节点，直接结束
        if (root.left == null && root.right == null) {
            result.add(str);
        } else {
            if (root.left != null) {
                dfs(root.left, str, result);
            }
            if (root.right != null) {
                dfs(root.right, str, result);
            }
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        root.left = root2;
        root.right = root3;
        root2.left = root4;
        BinaryTreePaths binaryTreePaths = new BinaryTreePaths();
        List<String> strings = binaryTreePaths.binaryTreePaths(root);
        for (String string : strings) {
            System.out.println(string);
        }
    }

}
