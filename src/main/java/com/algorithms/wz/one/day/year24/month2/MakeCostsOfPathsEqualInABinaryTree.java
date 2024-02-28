package com.algorithms.wz.one.day.year24.month2;

/**
 * <a href="https://leetcode.cn/problems/make-costs-of-paths-equal-in-a-binary-tree/description/">2673. 使二叉树所有路径值相等的最小代价</a>
 * 给你一个整数 n 表示一棵 满二叉树 里面节点的数目，节点编号从 1 到 n 。根节点编号为 1 ，树中每个非叶子节点 i 都有两个孩子，分别是左孩子 2 * i 和右孩子 2 * i + 1 。
 * <p>
 * 树中每个节点都有一个值，用下标从 0 开始、长度为 n 的整数数组 cost 表示，其中 cost[i] 是第 i + 1 个节点的值。每次操作，你可以将树中 任意 节点的值 增加 1 。你可以执行操作 任意 次。
 * <p>
 * 你的目标是让根到每一个 叶子结点 的路径值相等。请你返回 最少 需要执行增加操作多少次。
 * <p>
 * 注意：
 * <p>
 * 满二叉树 指的是一棵树，它满足树中除了叶子节点外每个节点都恰好有 2 个子节点，且所有叶子节点距离根节点距离相同。
 * 路径值 指的是路径上所有节点的值之和。
 */
public class MakeCostsOfPathsEqualInABinaryTree {

    /**
     * 这道题目我没有思路，感觉跟着大佬刷算法题，刷习惯后自己刷反而不会了，思维固化了，导致想什么都想不出来，看了题解发现其实并不是很难
     * 1. 谁说树一定要用树的形式，不能用数组的形式吗？
     * 2. 从根节点到叶子节点的路径值相等，那对于一个节点来说，保证到左右子树的路径值相等就可以，那就从叶子节点开始
     * 3. 数组的形式如何遍历呢？我们要的是每次比较两个叶子几点，而不是全部节点
     *
     * @param n    节点的个数
     * @param cost 路径
     * @return 最少需要执行增加操作多少次
     */
    public int minIncrements(int n, int[] cost) {
        int result = 0;
        for (int i = cost.length - 2; i > 0; i -= 2) {
            result += Math.abs(cost[i] - cost[i + 1]);
            // 找到叶子节点的根节点，将而这种的大的路径添加到根节点的路径中去，注意这里 i 也是索引，所以 i / 2 就是根节点的索引
            cost[i / 2] += Math.max(cost[i], cost[i + 1]);
        }
        return result;
    }
}
