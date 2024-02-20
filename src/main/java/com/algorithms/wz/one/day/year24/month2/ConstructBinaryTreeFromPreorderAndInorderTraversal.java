package com.algorithms.wz.one.day.year24.month2;

import java.util.HashMap;
import java.util.Map;

/**
 * <a href="https://leetcode.cn/problems/construct-binary-tree-from-preorder-and-inorder-traversal/description">105. 从前序与中序遍历序列构造二叉树</a>
 * 给定两个整数数组 preorder 和 inorder ，其中 preorder 是二叉树的先序遍历， inorder 是同一棵树的中序遍历，请构造二叉树并返回其根节点。
 */
public class ConstructBinaryTreeFromPreorderAndInorderTraversal {

    // 确定当前遍历根点的位置，其实也就是遍历了一遍前序数组
    int rootIndex = 0;

    Map<Integer, Integer> inorderMap = new HashMap<>();

    /**
     * 考虑一下。这道题目算下来做了三四遍了吧，乍一看还是思路不明确，那就分析一下吧
     * 先序：根左右
     * 中序：左根右
     * 递归来实现，考虑清楚一个节点如何构造，其余的节点按照相同的方法进行构造就可以，没想出来，还是看下题解吧，就是把中序遍历分成两半来计算
     * 这次没做出来的原因算是代码的问题，知道如何做，但是写不出来，将 rootIndex 提取到方法之外，这个点睛之笔，另外就是每次在一半中寻找，合理
     * 利用中序遍历，好
     * @param preorder 先序遍历
     * @param inorder  中序遍历
     * @return 构造出来的树
     */
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        // 这里要快速找到先序遍历中出现的元素在中序遍历中出现的位置，以便确定是左节点还是右节点
        for (int i = 0; i < inorder.length; i++) {
            inorderMap.put(inorder[i], i);
        }
        // 递归构造树
        return recursion(preorder, 0, preorder.length - 1);
    }

    /**
     * 递归构造树
     *
     * @param preorder 先序
     * @param left     左边界
     * @param right    右边界
     * @return 构造的树
     */
    private TreeNode recursion(int[] preorder, int left, int right) {
        if (left > right) {
            return null;
        }
        TreeNode root = new TreeNode(preorder[rootIndex]);
        rootIndex++;
        // 确定边界
        Integer index = inorderMap.get(root.val);
        root.left = recursion(preorder, left, index - 1);
        root.right = recursion(preorder, index + 1, right);
        return root;
    }

    public static void main(String[] args) {
        ConstructBinaryTreeFromPreorderAndInorderTraversal constructTree =
            new ConstructBinaryTreeFromPreorderAndInorderTraversal();
        TreeNode treeNode = constructTree.buildTree(new int[] {3, 9, 20, 15, 7}, new int[] {9, 3, 15, 20, 7});
        System.out.println(treeNode.val);
    }
}

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}
