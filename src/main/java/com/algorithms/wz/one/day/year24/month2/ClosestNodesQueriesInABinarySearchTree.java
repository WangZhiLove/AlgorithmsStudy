package com.algorithms.wz.one.day.year24.month2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/closest-nodes-queries-in-a-binary-search-tree/description/">2476. 二叉搜索树最近节点查询</a>
 * 给你一个 二叉搜索树 的根节点 root ，和一个由正整数组成、长度为 n 的数组 queries 。
 * <p>
 * 请你找出一个长度为 n 的 二维 答案数组 answer ，其中 answer[i] = [mini, maxi] ：
 * <p>
 * mini 是树中小于等于 queries[i] 的 最大值 。如果不存在这样的值，则使用 -1 代替。
 * maxi 是树中大于等于 queries[i] 的 最小值 。如果不存在这样的值，则使用 -1 代替。
 * 返回数组 answer 。
 */
public class ClosestNodesQueriesInABinarySearchTree {

    List<Integer> list = new ArrayList<>();

    /**
     * 这道题目可以暴力破解，也就是先遍历树，得到数组，然后双层循环找到 answer，但是和我猜测的相同，超时了
     * 题目中是二叉搜索树，那就要利用二叉搜索树的特点
     *
     * @param root    根节点
     * @param queries 数组
     * @return answer
     */
    public List<List<Integer>> closestNodes(TreeNode root, List<Integer> queries) {
        // 遍历得到树结果
        recursion(root);
        Collections.sort(list);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < queries.size(); i++) {
            List<Integer> temp = new ArrayList<>();
            for (int j = 0; j < list.size(); j++) {
                if (list.get(j).equals(queries.get(i))) {
                    temp.add(list.get(j));
                    temp.add(list.get(j));
                    result.add(temp);
                    break;
                } else if (list.get(j) > queries.get(i)) {
                    if (j == 0) {
                        temp.add(-1);
                    } else {
                        temp.add(list.get(j - 1));
                    }
                    temp.add(list.get(j));
                    result.add(temp);
                    break;
                }
                if (j == list.size() - 1) {
                    temp.add(list.get(j));
                    temp.add(-1);
                    result.add(temp);
                }
            }

        }
        return result;
    }

    private void recursion(TreeNode root) {
        if (root == null) {
            return;
        }
        list.add(root.val);
        recursion(root.left);
        recursion(root.right);
    }

    /**
     * 中序遍历 + 二分
     * @param root 根节点
     * @param queries 目标数组
     * @return 数组
     */
    public List<List<Integer>> closestNodes2(TreeNode root, List<Integer> queries) {
        List<Integer> dfsArray = new ArrayList<>();
        dfs(root, dfsArray);
        // 二分搜索
        List<List<Integer>> result = new ArrayList<>();
        for (Integer target : queries) {
            List<Integer> temp = new ArrayList<>();
            int index = binarySearch(dfsArray, target);
            int maxVal = -1, minVal = -1;
            if (index != dfsArray.size()) {
                maxVal = dfsArray.get(index);
                if (maxVal == target) {
                    temp.add(maxVal);
                    temp.add(maxVal);
                    result.add(temp);
                    continue;
                }
            }
            if (index > 0) {
                minVal = dfsArray.get(index - 1);
            }
            temp.add(minVal);
            temp.add(maxVal);
            result.add(temp);
        }
        return result;
    }

    private Integer binarySearch(List<Integer> dfsArray, Integer target) {
        int low = 0, high = dfsArray.size();
        while (low < high) {
            int middle = low + (high - low) / 2;
            if (dfsArray.get(middle) >= target) {
                high = middle;
            } else {
                low = middle - 1;
            }
        }
        return low;
    }

    private void dfs(TreeNode root, List<Integer> dfsArray) {
        if (root == null) {
            return;
        }
        dfs(root.left, dfsArray);
        dfsArray.add(root.val);
        dfs(root.right, dfsArray);
    }

}
