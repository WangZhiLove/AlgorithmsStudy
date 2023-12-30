package com.algorithms.wz.data.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/path-sum-ii/description/">113.路径总和ii</a>
 * 给你二叉树的根节点`root`和一个整数目标和`targetSum`，找出所有**从根节点到叶子节点**路径总和等于给定目标和的路径。
 * <p>
 * **叶子节点**是指没有子节点的节点。
 */
public class PathSumii {

    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> pathSum(TreeNode root, int targetSum) {
        recursion(root, targetSum, 0, new ArrayList<>());
        return result;
    }

    private void recursion(TreeNode root, int targetSum, int mySum, List<Integer> list) {
        if (root == null) {
            return ;
        }
        list.add(root.val);
        mySum += root.val;
        if (root.left == null && root.right == null) {
            if (mySum == targetSum) {
                // copy 一份数据
                result.add(new ArrayList<>(list));
            }
            return;
        }
        if (root.left != null) {
            recursion(root.left, targetSum, mySum, list);
            list.remove(list.size() - 1);
        }
        if (root.right != null) {
            recursion(root.right, targetSum, mySum, list);
            list.remove(list.size() - 1);
        }
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(5);
        TreeNode root1 = new TreeNode(4);
        TreeNode root2 = new TreeNode(11);
        TreeNode root3 = new TreeNode(2);
        TreeNode root4 = new TreeNode(7);
        root.left = root1;
        root1.left = root2;
        root2.right = root3;
        root2.left = root4;
        PathSumii pathSum = new PathSumii();
        List<List<Integer>> lists = pathSum.pathSum(root, 22);
        for (int i = 0; i < lists.size(); i++) {
            System.out.println(lists.get(i));
        }
    }

}
