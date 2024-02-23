package com.algorithms.wz.one.day.year24.month2;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/kth-largest-sum-in-a-binary-tree/description/">2583. 二叉树中的第 K 大层和</a>
 * 给你一棵二叉树的根节点 root 和一个正整数 k 。
 * <p>
 * 树中的 层和 是指 同一层 上节点值的总和。
 * <p>
 * 返回树中第 k 大的层和（不一定不同）。如果树少于 k 层，则返回 -1 。
 * <p>
 * 注意，如果两个节点与根节点的距离相同，则认为它们在同一层。
 */
public class KthLargestSumInABinaryTree {

    /**
     * 这道题目相对简单点，就是掌握层次遍历就可以，题目理解错了，第 k 大，也就是记录每一层的和，返回第k个最大，也就是排序排行k
     * 这道题目证明了 TreeSet 数据结构不如 List 直接排序，这也能理解，因为 TreeSet 每次添加的时候都要遍历，性能更差
     * @param root 根节点
     * @param k    k 层
     * @return k 大层的和
     */
    public long kthLargestLevelSum(TreeNode root, int k) {
        // 进行层次遍历
        List<Long> resultList = new ArrayList<>();
        LinkedList<TreeNode> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            int size = list.size();
            long sum = 0;
            for (int i = 0; i < size; i++) {
                TreeNode pop = list.pop();
                if (pop.left != null) {
                    list.add(pop.left);
                }
                if (pop.right != null) {
                    list.add(pop.right);
                }
                sum += pop.val;
            }
            resultList.add(sum);
        }
        if (resultList.size() < k) {
            return -1;
        }
        Collections.sort(resultList);
        return resultList.get(resultList.size() - k);
    }
}
