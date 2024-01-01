package com.algorithms.wz.data.structure.tree;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/">106. 从中序与后序遍历序列构造二叉树</a>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    /**
     * 表示根节点的位置，也就是倒序遍历后续遍历的索引
     */
    int rootIndex;

    /**
     * 中序遍历的 Map，用于确定边界
     */
    Map<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * 先了解什么是中序遍历，什么是后序遍历。
     * 思路是由中序遍历可以确定左子树和右子树的边界，因为后续遍历是左右根，因此可以从后续遍历中找根节点，意味着先要确定右子树
     * 对于 后序遍历 来说，最后一个元素是根节点，根节点的前一个元素要么是左节点，要么是右节点
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        rootIndex = postorder.length - 1;
        int index = 0;
        for (int value : inorder) {
            inorderMap.put(value, index++);
        }
        return myBuildTree(postorder, 0, postorder.length - 1);
    }

    /**
     * 递归找树，就是忽略了一点，考虑左右子树的边界，这个如果出了边界，则直接返回 null
     *
     * @param postorder  后序
     * @param leftIndex  当前根节点左边界
     * @param rightIndex 当前根节点右边界
     * @return
     */
    private TreeNode myBuildTree(int[] postorder, int leftIndex, int rightIndex) {
        if (leftIndex > rightIndex) {
            return null;
        }
        // 确定根节点
        TreeNode root = new TreeNode();
        root.val = postorder[rootIndex];
        rootIndex--;
        // 确定边界
        Integer index = inorderMap.get(root.val);
        root.right = myBuildTree(postorder, index + 1, rightIndex);
        root.left = myBuildTree(postorder, leftIndex, index - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal tree =
            new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode treeNode = tree.buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
        System.out.println(treeNode);
    }
}
