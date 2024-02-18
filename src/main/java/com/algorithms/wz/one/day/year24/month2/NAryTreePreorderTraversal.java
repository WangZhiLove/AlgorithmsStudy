package com.algorithms.wz.one.day.year24.month2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-preorder-traversal/description/">589. N 叉树的前序遍历</a>
 * 给定一个 n 叉树的根节点  root ，返回 其节点值的 前序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔。
 * <p>
 * 提示：
 * <p>
 * 节点总数在范围 [0, 104]内
 * 0 <= Node.val <= 104
 * n 叉树的高度小于或等于 1000
 */
public class NAryTreePreorderTraversal {

    /**
     * 两个点，一个是什么是前序遍历，前序遍历说的是根左右的一个遍历顺序；
     * 另一个是树的遍历一般如何做呢？树的遍历一般就是两种方法，要么递归，要么迭代
     *
     * @param root 根节点
     * @return N 叉树的前序遍历
     */
    public List<Integer> preorder(Node root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    /**
     * 递归获取前序遍历
     *
     * @param root   根节点
     * @param result 遍历的结果集
     */
    private void recursion(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        result.add(root.val);
        for (Node child : root.children) {
            recursion(child, result);
        }
    }

    /**
     * 上面用递归的方法实现，迭代如何做呢
     * @param root 根节点
     * @return 前序遍历
     */
    public List<Integer> preorder2(Node root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }
        // 使用双端链表
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node pop = list.pop();
            result.add(pop.val);
            for (int i = pop.children.size() - 1; i >= 0; i--) {
                list.addFirst(pop.children.get(i));
            }
        }
        return result;
    }

}

class Node {
    public int val;
    public List<Node> children;

    public Node() {
    }

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
