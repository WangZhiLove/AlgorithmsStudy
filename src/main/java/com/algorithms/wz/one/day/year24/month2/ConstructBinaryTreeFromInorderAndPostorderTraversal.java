package com.algorithms.wz.one.day.year24.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-inorder-and-postorder-traversal/description/">106. 从中序与后序遍历序列构造二叉树</a>
 * 给定两个整数数组 inorder 和 postorder ，其中 inorder 是二叉树的中序遍历， postorder 是同一棵树的后序遍历，请你构造并返回这颗 二叉树 。
 */
public class ConstructBinaryTreeFromInorderAndPostorderTraversal {

    // 根节点所在的位置
    int rootIndex;

    // 存放中序遍历的值和索引的关系
    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 有了前面一道题目做底子，这道题目就相对简单点，因为思维方式是相通的
     *
     * @param inorder   中序遍历的结果
     * @param postorder 后续遍历的结果
     * @return 构造的树
     */
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        rootIndex = postorder.length - 1;
        return constructTree(postorder, 0, postorder.length - 1);
    }

    /**
     * 构造树
     *
     * @param postorder 后序遍历
     * @param left      左边界
     * @param right     右边界
     * @return 构造的二叉树
     */
    private TreeNode constructTree(int[] postorder, int left, int right) {
        if (left > right || rootIndex < 0) {
            return null;
        }
        TreeNode root = new TreeNode(postorder[rootIndex]);
        rootIndex--;
        Integer index = map.get(root.val);
        root.right = constructTree(postorder, index + 1, right);
        root.left = constructTree(postorder, left, index - 1);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromInorderAndPostorderTraversal constructBinaryTree =
            new ConstructBinaryTreeFromInorderAndPostorderTraversal();
        TreeNode treeNode = constructBinaryTree.buildTree(new int[] {9, 3, 15, 20, 7}, new int[] {9, 15, 7, 20, 3});
        System.out.println(treeNode.val);
    }
}
