package com.algorithms.wz.data.structure.tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * <a href="https://leetcode.cn/problems/find-bottom-left-tree-value/description/">513.找树左下角的值</a>
 * 给定一个二叉树的 根节点 root，请找出该二叉树的 最底层 最左边 节点的值。
 * <p>
 * 假设二叉树中至少有一个节点。
 */
public class FindBottomLeftTreeValue {

    /**
     * 我的想法是层次遍历，只放左节点，看错题目了，其实就是层次遍历，找到最后一层的第一个元素，无关左节点还是右节点
     *
     * @param root 根节点
     * @return 最底层的左节点
     */
    public int findBottomLeftValue(TreeNode root) {
        List<List<Integer>> resultList = new ArrayList<>();
        // 这里用数据，索引 0 处的值为 0 和 1，,0
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> temp = new ArrayList<>();
            for (int i = 0; i < size; i++) {
                TreeNode poll = queue.poll();
                temp.add(poll.val);
                if (poll.left != null) {
                    queue.offer(poll.left);
                }
                if (poll.right != null) {
                    queue.offer(poll.right);
                }
            }
            resultList.add(temp);
        }
        for (int i = resultList.size() - 1; i >= 0; i--) {
            if (resultList.get(i).isEmpty()) {
                continue;
            }
            return resultList.get(i).get(0);
        }
        return 0;
    }

    public int findBottomLeftValue2(TreeNode root) {
        int result = 0;
        // 这里用数据，索引 0 处的值为 0 和 1，,0
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode poll = queue.poll();
            if (poll.right != null) {
                queue.offer(poll.right);
            }
            if (poll.left != null) {
                queue.offer(poll.left);
            }
            result = poll.val;
        }
        return result;
    }

}

class TempNode {
    private int leftOrRight;

    private TreeNode treeNode;

    public int getLeftOrRight() {
        return leftOrRight;
    }

    public void setLeftOrRight(int leftOrRight) {
        this.leftOrRight = leftOrRight;
    }

    public TreeNode getTreeNode() {
        return treeNode;
    }

    public void setTreeNode(TreeNode treeNode) {
        this.treeNode = treeNode;
    }

    public TempNode(int leftOrRight, TreeNode treeNode) {
        this.leftOrRight = leftOrRight;
        this.treeNode = treeNode;
    }
}
