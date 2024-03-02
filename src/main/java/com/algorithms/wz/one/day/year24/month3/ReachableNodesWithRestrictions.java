package com.algorithms.wz.one.day.year24.month3;

import java.util.*;

/**
 * <a href="https://leetcode.cn/problems/reachable-nodes-with-restrictions/description/">2368.受限条件下可到达节点的数目</a>
 * 现有一棵由 n 个节点组成的无向树，节点编号从 0 到 n - 1 ，共有 n - 1 条边。
 * <p>
 * 给你一个二维整数数组 edges ，长度为 n - 1 ，其中 edges[i] = [ai, bi] 表示树中节点 ai 和 bi 之间存在一条边。另给你一个整数数组 restricted 表示 受限 节点。
 * <p>
 * 在不访问受限节点的前提下，返回你可以从节点 0 到达的 最多 节点数目。
 * <p>
 * 注意，节点 0 不 会标记为受限节点。
 */
public class ReachableNodesWithRestrictions {

    /**
     * 这道题目我脑海中的想法是暴力破解，果然和我猜想的一样，因为数据量庞大，所以超时了，想到 dfs，其实我的这个思路是 bfs 的思路
     *
     * @param n          节点的个数
     * @param edges      无向边
     * @param restricted 受限节点
     * @return 从节点 0 可到达的最多节点数目
     */
    public int reachableNodes(int n, int[][] edges, int[] restricted) {
        // 存储最后的结果
        int result = 1;
        // 存储遍历的节点
        LinkedList<Integer> queue = new LinkedList<>();
        queue.add(0);
        // 声明一个数组表示已经遍历过的节点
        int[] visited = new int[n];
        // 开始遍历
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Integer poll = queue.poll();
                for (int j = 0; j < edges.length; j++) {
                    // 之前遍历过，直接跳过遍历
                    if (visited[j] == 1) {
                        continue;
                    }
                    int first = edges[j][0];
                    int second = edges[j][1];
                    // 判断是否存在受限节点，存在，直接跳过
                    if (restrictNum(first, restricted) || restrictNum(second, restricted)) {
                        visited[j] = 1;
                        continue;
                    }
                    // 没访问过并且不存在受限节点
                    if (first == poll || second == poll) {
                        result++;
                        if (first == poll) {
                            queue.add(second);
                        } else {
                            queue.add(first);
                        }
                        visited[j] = 1;
                    }
                }
            }
        }
        return result;
    }

    private boolean restrictNum(int first, int[] restricted) {
        for (int value : restricted) {
            if (first == value) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        ReachableNodesWithRestrictions reachableNodesWithRestrictions = new ReachableNodesWithRestrictions();
        int i = reachableNodesWithRestrictions.reachableNodes2(7,
            new int[][] {{0, 1}, {1, 2}, {3, 1}, {4, 0}, {0, 5}, {5, 6}}, new int[] {4, 5});
        System.out.println(i);
    }

    boolean[] isRestricted;

    int cnt = 0;

    /**
     * 是不是可以使用 dfs，也超出时间限制
     * @param n          节点的个数
     * @param edges      无向边
     * @param restricted 受限节点
     * @return 从节点 0 可到达的最多节点数目
     */
    public int reachableNodes2(int n, int[][] edges, int[] restricted) {
        isRestricted = new boolean[n];
        for (int i : restricted) {
            isRestricted[i] = true;
        }
        boolean[] visited = new boolean[n];
        visited[0] = true;
        dfs(0, visited, edges);
        return cnt;
    }

    private void dfs(int curNode, boolean[] visited, int[][] edges) {
        cnt ++;
        for (int[] edge : edges) {
            if (edge[0] == curNode) {
                if (!visited[edge[1]] && !isRestricted[edge[1]]) {
                    visited[edge[1]] = true;
                    dfs(edge[1], visited, edges);
                }
            }
            if (edge[1] == curNode) {
                if (!visited[edge[0]] && !isRestricted[edge[0]]) {
                    visited[edge[0]] = true;
                    dfs(edge[0], visited, edges);
                }
            }
        }
    }

    public int reachableNodes3(int n, int[][] edges, int[] restricted) {
        boolean[] isrestricted = new boolean[n];
        for (int x : restricted) {
            isrestricted[x] = true;
        }
        // 这个操作很关键，就是看每一个节点可以到哪几个节点
        List<Integer>[] g = new List[n];
        for (int i = 0; i < n; i++) {
            g[i] = new ArrayList<Integer>();
        }
        for (int[] v : edges) {
            g[v[0]].add(v[1]);
            g[v[1]].add(v[0]);
        }
        dfs(0, -1, isrestricted, g);
        return cnt;
    }

    public void dfs(int x, int f, boolean[] isrestricted, List<Integer>[] g) {
        cnt++;
        for (int y : g[x]) {
            if (y != f && !isrestricted[y]) {
                dfs(y, x, isrestricted, g);
            }
        }
    }
}

