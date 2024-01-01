package com.algorithms.wz.data.structure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description/">105.从前序与中序遍历序列构造二叉树</a>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    int rootIndex = 0;

    Map<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * 思路和中序遍历和后续遍历一样
     *
     * @param preorder 前序
     * @param inorder  中序
     * @return 树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        int index = 0;
        for (int value : inorder) {
            inorderMap.put(value, index++);
        }
        return myBuildTree(preorder, 0, inorder.length - 1);
    }

    private TreeNode myBuildTree(int[] preorder, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        Integer index = inorderMap.get(root.val);
        rootIndex++;
        root.left = myBuildTree(preorder, leftIndex, index - 1);
        root.right = myBuildTree(preorder, index + 1, rightIndex);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal tree =
            new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode treeNode = tree.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
        System.out.println(treeNode);
    }
}
