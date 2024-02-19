package com.algorithms.wz.one.day.year24.month2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * <a href="https://leetcode.cn/problems/n-ary-tree-postorder-traversal/description/">590. N 叉树的后序遍历</a>
 * 给定一个 n 叉树的根节点 root ，返回 其节点值的 后序遍历 。
 * <p>
 * n 叉树 在输入中按层序遍历进行序列化表示，每组子节点由空值 null 分隔（请参见示例）。
 */
public class NAryTreePostorderTraversal {

    /**
     * 昨天是前序遍历，今天就变成后序遍历了，其实树的题目我是挺喜欢做的，还是老样子，分解
     * 1. 后续遍历是什么，左-右-根的遍历顺序
     * 2. 树的遍历方法呢？递归和迭代
     * @param root 根节点
     * @return 后续遍历的集合
     */
    public List<Integer> postorder(Node root) {
        List<Integer> result = new ArrayList<>();
        recursion(root, result);
        return result;
    }

    private void recursion(Node root, List<Integer> result) {
        if (root == null) {
            return;
        }
        for (Node child : root.children) {
            recursion(child, result);
        }
        result.add(root.val);
    }

    /**
     * 迭代，迭代的思路是什么呢？这里的迭代我的思路就比较乱了，我现在的想法就是倒序，或者说就是在保存到结果集的时候一直插入到前面，
     * 迭代的代码并不复杂，复杂的是想在脑海中把这个过程给模拟出来，一旦这么做了，那就非常难了，我的思考就是用合适的数据结构，树的迭代一般就用的
     * 队列或者双端队列/链表
     * @param root 根节点
     * @return N 叉树的后续遍历
     */
    public List<Integer> postorder2(Node root) {
        LinkedList<Integer> result = new LinkedList<>();
        if (root == null) {
            return result;
        }
        LinkedList<Node> list = new LinkedList<>();
        list.add(root);
        while (!list.isEmpty()) {
            Node pop = list.pop();
            result.addFirst(pop.val);
            for (Node child : pop.children) {
                list.addFirst(child);
            }
        }
        return result;
    }

}

