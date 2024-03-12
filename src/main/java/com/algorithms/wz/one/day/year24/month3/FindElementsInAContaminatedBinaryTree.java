package com.algorithms.wz.one.day.year24.month3;

import com.algorithms.wz.data.structure.tree.TreeNode;

import java.util.HashSet;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/find-elements-in-a-contaminated-binary-tree/description/">1261. 在受污染的二叉树中查找元素</a>
 * 给出一个满足下述规则的二叉树：
 * <p>
 * root.val == 0
 * 如果 treeNode.val == x 且 treeNode.left != null，那么 treeNode.left.val == 2 * x + 1
 * 如果 treeNode.val == x 且 treeNode.right != null，那么 treeNode.right.val == 2 * x + 2
 * 现在这个二叉树受到「污染」，所有的 treeNode.val 都变成了 -1。
 * <p>
 * 请你先还原二叉树，然后实现 FindElements 类：
 * <p>
 * FindElements(TreeNode* root) 用受污染的二叉树初始化对象，你需要先把它还原。
 * bool find(int target) 判断目标值 target 是否存在于还原后的二叉树中并返回结果。
 */
public class FindElementsInAContaminatedBinaryTree {

}

class FindElements {

    private TreeNode myRoot;

    private Set<Integer> elements = new HashSet<>();

    public FindElements(TreeNode root) {
        myRoot = root;
        // 还原树，在还原的时候记录元素
        myRoot.val = 0;
        elements.add(0);
        recursionTree(myRoot);
    }

    private void recursionTree(TreeNode root) {
        if (root.left != null) {
            root.left.val = 2 * root.val + 1;
            elements.add(root.left.val);
            recursionTree(root.left);
        }
        if (root.right != null) {
            root.right.val = 2 * root.val + 2;
            elements.add(root.right.val);
            recursionTree(root.right);
        }
    }

    public boolean find(int target) {
        return elements.contains(target);
    }
}

