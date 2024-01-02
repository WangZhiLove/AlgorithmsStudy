package com.algorithms.wz.data.structure.tree;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/find-mode-in-binary-search-tree/description/">501.二叉搜索树中的众数</a>
 * 给你一个含重复值的二叉搜索树（BST）的根节点 root ，找出并返回 BST 中的所有 众数（即，出现频率最高的元素）。
 * <p>
 * 如果树中有不止一个众数，可以按 任意顺序 返回。
 * <p>
 * 假定 BST 满足如下定义：
 * <p>
 * 结点左子树中所含节点的值 小于等于 当前节点的值
 * 结点右子树中所含节点的值 大于等于 当前节点的值
 * 左子树和右子树都是二叉搜索树
 */
public class FindModeInBinarySearchTree {

    Map<Integer, Integer> map = new HashMap<>();

    /**
     * 遍历 + map 试试看
     *
     * @param root
     * @return
     */
    public int[] findMode(TreeNode root) {
        int maxNum = -1;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            map.put(poll.val, map.getOrDefault(poll.val, 0) + 1);
            maxNum = Math.max(maxNum, map.get(poll.val));
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            if (poll.right != null) {
                queue.offer(poll.right);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (Map.Entry<Integer, Integer> mapEntry : map.entrySet()) {
            if (mapEntry.getValue() == maxNum) {
                result.add(mapEntry.getKey());
            }
        }
        int[] resultArr = new int[result.size()];
        int index = 0;
        for (Integer num : result) {
            resultArr[index++] = num;
        }
        return resultArr;
    }

    List<Integer> answer = new ArrayList<>();
    int curMaxCount = 0;
    int curValue = Integer.MAX_VALUE;
    int curCount = 0;

    /**
     * 换个思路，用数组，可以清空数组呀，我怎么没想到呢，也是服了，感觉脑子生锈了，思维固化了
     *
     * @param root
     * @return
     */
    public int[] findMode2(TreeNode root) {
        dfs(root);
        int[] resultArr = new int[answer.size()];
        int index = 0;
        for (Integer num : answer) {
            resultArr[index++] = num;
        }
        return resultArr;
    }

    private void dfs(TreeNode root) {
        if (root == null) {
            return;
        }
        dfs(root.left);
        updateAnswer(root.val);
        dfs(root.right);
    }

    private void updateAnswer(int val) {
        if (val == curValue) {
            curCount++;
        } else {
            curCount = 1;
            curValue = val;
        }
        if (curCount == curMaxCount) {
            answer.add(curValue);
        }
        if (curCount > curMaxCount) {
            curMaxCount = curCount;
            answer.clear();
            answer.add(curValue);
        }
    }
}
