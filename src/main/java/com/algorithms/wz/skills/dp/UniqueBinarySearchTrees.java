package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/unique-binary-search-trees/description/">96.不同的二叉搜索树</a>
 * 给你一个整数 n ，求恰由 n 个节点组成且节点值从 1 到 n 互不相同的 二叉搜索树 有多少种？返回满足题意的二叉搜索树的种数。
 */
public class UniqueBinarySearchTrees {

    /**
     * 这道题目没想出来，看了题解之后发现一个关键点，就是有多少种排列方式和序列内容无关，只和序列长度有关，比如说 4，5 也就两种，所以对于 n 来说
     * 就是 1 到 n 都作为根节点的不同二叉搜索树的组合，那对于具体的 n 如何计算呢？遍历 n，由 1 开始遍历到 n，默认 0 和 1作为根节点的值都为 1，那递推公式
     * 就是 dp[n] = dp[i - 1] * dp[n - i],其中 i 从 1 开始遍历到 n
     * @param n n 个节点
     * @return 不同的二叉搜索树的种类
     */
    public int numTrees(int n) {
        // 声明递推数组，其中索引就是节点的个数，值为节点个数的不同二叉搜索数
        int[] dp = new int[n + 1];
        // 找到递推公式，就是 dp[n] = dp[i - 1] * dp[n - i],其中 i 从 1 开始遍历到 n
        // 初始化 dp
        dp[0] = 1;
        dp[1] = 1;
        // 开始遍历
        for (int i = 2; i < dp.length; i++) {
            int curSpecies = 0;
            for (int j = 1; j <= i; j++) {
                curSpecies += dp[j - 1] * dp[i - j];
            }
            dp[i] = curSpecies;
        }
        return dp[n];
    }

}
