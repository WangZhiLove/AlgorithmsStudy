package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/distinct-subsequences/description/">115.不同的子序列</a>
 * 给你两个字符串 s 和 t ，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10^9 + 7 取模。
 */
public class DistinctSubsequences {

    /**
     * 一道简单题后就是困难题目，这个跨度有点大，统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10^9 + 7 取模。
     * 感觉这道题目可以用回溯，但是肯定会超时，那使用动态规划如何做呢，肯定也是动态规划五步曲，先按照思路往下写，写的过程中万一想明白了呢
     * 这道题目我没想出来的点在于不同的起点问题，如果说判断存不存在比较容易，但是判断出出现的个数，这个我就没有思路了，感觉情况比较多
     * 固定一点？找其它的情况吗？有多少种删除元素的方式？这道题目不好想呀
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 统计并返回在 s 的 子序列 中 t 出现的个数，结果需要对 10^9 + 7 取模。
     */
    public int numDistinct(String s, String t) {
        // 声明 dp 数组，描述就是以 i-1 为结尾的 s 和以 j-1 为结尾的 t 中，有多少种的不同的方法
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 递推公式，这个比较难得
        // if(s.charAt(i) == t.charAt(j)) dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
        // 这个从删除元素的考虑就是我使用 i 元素和不使用 i 元素的方法之和
        // 那如果是不相等呢？那其实就不管了，dp[i][j] = dp[i - 1][j]
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = 1;
        }
        // 遍历
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + dp[i - 1][j];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[s.length()][t.length()];
    }
}
