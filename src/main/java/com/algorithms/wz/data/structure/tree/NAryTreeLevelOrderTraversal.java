package com.algorithms.wz.data.structure.tree;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode-cn.com/problems/n-ary-tree-level-order-traversal/">429. N 叉树的层序遍历</a>
 * 给定一个 N 叉树，返回其节点值的层序遍历。（即从左到右，逐层遍历）。
 * <p>
 * 树的序列化输入是用层序遍历，每组子节点都由 null 值分隔（参见示例）。
 *
 * @author wangzhi
 */
public class NAryTreeLevelOrderTraversal {

    /**
     * 层序遍历，典型的就是使用队列
     *
     * @param root 根节点
     * @return 所有的节点
     */
    public List<List<Integer>> levelOrder(Node root) {
        List<List<Integer>> result = new ArrayList<>();
        Queue<Node> queue = new ArrayDeque<>();
        if (root != null) {
            queue.add(root);
        }
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                Node poll = queue.poll();
                list.add(poll.val);
                for (Node child : poll.children) {
                    queue.add(child);
                }
            }
            result.add(list);
        }

        return result;
    }

}
