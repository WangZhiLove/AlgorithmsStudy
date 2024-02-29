package com.algorithms.wz.one.day.year24.month2;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * <a href="https://leetcode.cn/problems/count-number-of-possible-root-nodes/description/">2581. 统计可能的树根数目</a>
 * Alice 有一棵 n 个节点的树，节点编号为 0 到 n - 1 。树用一个长度为 n - 1 的二维整数数组 edges 表示，其中 edges[i] = [ai, bi] ，表示树中节点 ai 和 bi 之间有一条边。
 * <p>
 * Alice 想要 Bob 找到这棵树的根。她允许 Bob 对这棵树进行若干次 猜测 。每一次猜测，Bob 做如下事情：
 * <p>
 * 选择两个 不相等 的整数 u 和 v ，且树中必须存在边 [u, v] 。
 * Bob 猜测树中 u 是 v 的 父节点 。
 * Bob 的猜测用二维整数数组 guesses 表示，其中 guesses[j] = [uj, vj] 表示 Bob 猜 uj 是 vj 的父节点。
 * <p>
 * Alice 非常懒，她不想逐个回答 Bob 的猜测，只告诉 Bob 这些猜测里面 至少 有 k 个猜测的结果为 true 。
 * <p>
 * 给你二维整数数组 edges ，Bob 的所有猜测和整数 k ，请你返回可能成为树根的 节点数目 。如果没有这样的树，则返回 0。
 */
public class CountNumberOfPossibleRootNodes {

    /**
     * 思维真的被固化了，如何能解脱出来呢？这道题目没有思路，如果是暴力破解呢？其实就是得到所有的节点，然后判断每一个节点是否为根节点，这个方法
     * 超时的概率很大。
     * 看了题解发现使用动态规划，这道题目为什么能想到动态规划呢？搞不明白，知道是动态规划了，那就是动规五部曲
     *
     * @param edges 边
     * @param guesses 节点间的关系
     * @param k 节点间的关系中 k 个正确
     * @return 可能为树根的节点个数
     */
    int cnt = 0, res = 0;
    int k;
    List<Integer>[] g;
    Set<Long> set;

    public int rootCount(int[][] edges, int[][] guesses, int k) {
        this.k = k;
        int n = edges.length + 1;
        g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }
        set = new HashSet<Long>();
        for (int[] v : edges) {
            g[v[0]].add(v[1]);
            g[v[1]].add(v[0]);
        }
        for (int[] v : guesses) {
            set.add(h(v[0], v[1]));
        }

        dfs(0, -1);
        redfs(0, -1, cnt);
        return res;
    }

    public long h(int x, int y) {
        return (long)x << 20 | y;
    }

    public void dfs(int x, int fat) {
        for (int y : g[x]) {
            if (y == fat) {
                continue;
            }
            cnt += set.contains(h(x, y)) ? 1 : 0;
            dfs(y, x);
        }
    }

    public void redfs(int x, int fat, int cnt) {
        if (cnt >= k) {
            res++;
        }
        for (int y : g[x]) {
            if (y == fat) {
                continue;
            }
            redfs(y, x, cnt - (set.contains(h(x, y)) ? 1 : 0) + (set.contains(h(y, x)) ? 1 : 0));
        }
    }
}
