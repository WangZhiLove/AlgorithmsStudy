package com.algorithms.wz.data.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/count-complete-tree-nodes/">222. 完全二叉树的节点个数</a>
 * 给你一棵 完全二叉树 的根节点 root ，求出该树的节点个数。
 * <p>
 * 完全二叉树 的定义如下：
 * <p>
 * <ul>
 * <li>在完全二叉树中，除了最底层节点可能没填满外，其余每层节点数都达到最大值，并且最下面一层的节点都集中在该层最左边的若干
 * 位置。若最底层为第 h 层，则该层包含 1~ 2<sup>h</sup> 个节点。</li>
 * <li>满二叉树：除了叶子节点外，每个节点都有左右两个子节点的二叉树。</li>
 * </ul>
 * <p>
 * 提示：
 * <ul>
 * <li>树中节点的数目范围是[0, 5 * 10<sup>4</sup>]</li>
 * <li>0 <= Node.val <= 5 * 10<sup>4</sup></li>
 * <li>题目数据保证输入的树是 完全二叉树</li>
 * </ul>
 * <p>
 * 进阶：遍历树来统计节点是一种时间复杂度为 O(n) 的简单解决方案。你可以设计一个更快的算法吗？
 */
public class CountCompleteTreeNodes {

    /**
     * 简单的思路就是遍历一遍树，求出节点个数
     * @param root
     * @return
     */
    public int countNodes(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        recursion(root, list);
        return list.size();
    }

    private void recursion(TreeNode root, List<Integer> list) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        recursion(root.left, list);
        recursion(root.right, list);
    }

}
