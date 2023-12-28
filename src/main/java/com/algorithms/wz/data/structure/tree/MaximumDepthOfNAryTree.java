package com.algorithms.wz.data.structure.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * <a href="https://leetcode-cn.com/problems/maximum-depth-of-n-ary-tree/">559. N 叉树的最大深度</a>
 * 给定一个 N 叉树，找到其最大深度。
 * <p>
 * 最大深度是指从根节点到最远叶子节点的最长路径上的节点总数。
 */
public class MaximumDepthOfNAryTree {

    public int maxDepth(Node root) {
        return recursionMaxDepth(root, 0);
    }

    private int recursionMaxDepth(Node root, int depth) {
        if (root == null) {
            return depth;
        }
        List<Node> children = root.children;
        int max = depth;
        for (Node child : children) {
            max = Math.max(recursionMaxDepth(child, depth + 1), max);
        }
        return children.isEmpty() ? max + 1 : max;
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node root2 = new Node(1);
        Node root3 = new Node(1);
        Node root4 = new Node(1);
        List<Node> child = new ArrayList<>();
        child.add(root2);
        child.add(root3);
        child.add(root4);
        root.children = child;
        Node root5 = new Node(5);
        List<Node> child1 = new ArrayList<>();
        child1.add(root5);
        root2.children = child1;
        MaximumDepthOfNAryTree maximumDepthOfNAryTree = new MaximumDepthOfNAryTree();
        System.out.println(maximumDepthOfNAryTree.maxDepth(root));
    }
}
