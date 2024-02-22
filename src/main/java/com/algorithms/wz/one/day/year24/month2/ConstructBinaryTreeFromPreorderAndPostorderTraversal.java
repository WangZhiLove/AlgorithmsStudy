package com.algorithms.wz.one.day.year24.month2;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode-cn.com/problems/construct-binary-tree-from-preorder-and-postorder-traversal/description/">889. 根据前序和后序遍历构造二叉树</a>
 * 给定两个整数数组，preorder 和 postorder ，其中 preorder 是一个具有 无重复 值的二叉树的前序遍历，postorder 是同一棵树的后序遍历，重构并返回二叉树。
 * <p>
 * 如果存在多个答案，您可以返回其中 任何 一个。
 */
public class ConstructBinaryTreeFromPreorderAndPostorderTraversal {

    /**
     * 这道题目倒是第一次做，根据中序以及前序或者后续的任意一个能确定唯一的树，但是如果是前序和后续，这个就不好确定。
     * 相同的方法来做一下
     *
     * @param preorder  前序
     * @param postorder 后续
     * @return 构造的树
     */
    public TreeNode constructFromPrePost(int[] preorder, int[] postorder) {
        return constructTree(preorder, postorder);
    }

    /**
     * 树的构造，对于一个节点来说，如果在前序中的下一个节点和后续中的前一个节点相同，那就是左节点或者右节点，
     * 如果不相同，那前序的下一个节点就是左节点，后续的前一个节点就是右节点，以这个思路递归，或许会有收获
     *
     * @param preorder  前序遍历
     * @param postorder 后续遍历
     * @return 构造的树
     */
    private TreeNode constructTree(int[] preorder, int[] postorder) {
        if (preorder.length == 0) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[0]);
        if (preorder.length == 1) {
            return root;
        }
        // index 表示节点的个数，主要的思路就是从后续遍历中确定当前节点的左节点有多少个，右节点右多少个，根据节点的个数截取数组
        int L = 0;
        for (int i = 0; i < preorder.length; i++) {
            if (postorder[i] == preorder[1]) {
                L = i + 1;
            }
        }
        // copy 的方法包含前节点，不包含后节点
        root.left = constructTree(Arrays.copyOfRange(preorder, 1, L + 1), Arrays.copyOfRange(postorder, 0, L));
        root.right = constructTree(Arrays.copyOfRange(preorder, L + 1, preorder.length),
            Arrays.copyOfRange(postorder, L, preorder.length - 1));
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndPostorderTraversal constructTree =
            new ConstructBinaryTreeFromPreorderAndPostorderTraversal();
        TreeNode treeNode =
            constructTree.constructFromPrePost(new int[] {1, 2, 4, 5, 3, 6, 7}, new int[] {4, 5, 2, 6, 7, 3, 1});
        System.out.println(treeNode.val);
    }

}
