package com.algorithms.wz.data.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/convert-bst-to-greater-tree/description/">538.把二叉搜索树转换为累加树 </a>
 * 给出二叉 搜索 树的根节点，该树的节点值各不相同，请你将其转换为累加树（Greater Sum Tree），使每个节点 node 的新值等于原树中大于或等于 node.val 的值之和。
 * <p>
 * 提醒一下，二叉搜索树满足下列约束条件：
 * <p>
 * 节点的左子树仅包含键 小于 节点键的节点。
 * 节点的右子树仅包含键 大于 节点键的节点。
 * 左右子树也必须是二叉搜索树。
 */
public class ConvertBstToGreaterTree {

    /**
     * 可以用循环中序遍历，然后倒序累加就可以
     * @param root  根节点
     * @return 累加树
     */
    public TreeNode convertBST(TreeNode root) {
        List<TreeNode> list = new ArrayList<>();
        recursion(root, list);
        for (int i = list.size() - 2; i >= 0; i--) {
            list.get(i).val = list.get(i).val + list.get(i + 1).val;
        }
        return list.get(0);
    }

    private void recursion(TreeNode root, List<TreeNode> list) {
        if (root == null) {
            return;
        }
        recursion(root.left, list);
        list.add(root);
        recursion(root.right, list);
    }

    /**
     * 可以一次递归解决，右根左遍历，声明一个全局变量，记录累加值
     * @param root 根节点
     * @return 累加树
     */
    public TreeNode convertBST2(TreeNode root) {
        recursion2(root);
        return root;
    }

    private int sumTree = 0;
    private void recursion2(TreeNode root) {
        if (root == null) {
            return;
        }
        recursion2(root.right);
        root.val = root.val + sumTree;
        sumTree = root.val;
        recursion2(root.left);
    }

    public static void main(String[] args) {
        TreeNode root0 = new TreeNode(0);
        TreeNode root1 = new TreeNode(1);
        TreeNode root2 = new TreeNode(2);
        TreeNode root3 = new TreeNode(3);
        TreeNode root4 = new TreeNode(4);
        TreeNode root5 = new TreeNode(5);
        TreeNode root6 = new TreeNode(6);
        TreeNode root7 = new TreeNode(7);
        TreeNode root8 = new TreeNode(8);
        root4.left = root1;
        root4.right = root6;
        root1.left = root0;
        root1.right = root2;
        root2.right = root3;
        root6.left = root5;
        root6.right = root7;
        root7.right = root8;
        new ConvertBstToGreaterTree().convertBST2(root4);
        System.out.println(root4.val);
    }

}
