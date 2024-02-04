package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/is-subsequence/description/">392.判断子序列</a>
 * 给定字符串 s 和 t ，判断 s 是否为 t 的子序列。
 * <p>
 * 字符串的一个子序列是原始字符串删除一些（也可以不删除）字符而不改变剩余字符相对位置形成的新字符串。（例如，"ace"是"abcde"的一个子序列，而"aec"不是）。
 * <p>
 * 进阶：
 * <p>
 * 如果有大量输入的 S，称作 S1, S2, ... , Sk 其中 k >= 10亿，你需要依次检查它们是否为 T 的子序列。在这种情况下，你会怎样改变代码？
 */
public class IsSubsequence {

    /**
     * 判断 s 是否为 t 的子序列，这道题目可以使用双指针来实现
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 是，返回 true；否返回 false
     */
    public boolean isSubsequence(String s, String t) {
        int sIndex = 0;
        int tIndex = 0;
        while (sIndex < s.length() && tIndex < t.length()) {
            if (s.charAt(sIndex) == t.charAt(tIndex)) {
                sIndex ++;
            }
            tIndex ++;
        }
        return sIndex == s.length();
    }

    /**
     * 如果使用动态规划呢？动态规划五部曲，这个和之前做过的最大公共子序和、最长公共子序列类似
     * @param s 字符串 s
     * @param t 字符串 t
     * @return 是，返回 true；否返回 false
     */
    public boolean isSubsequence1(String s, String t) {
        // 声明 dp，二维 dp，i - 1 表示 s 的索引，j - 1 表示 t 的索引，值表示最长的公共子序
        int[][] dp = new int[s.length() + 1][t.length() + 1];
        // 递推公式 if 相等 dp[i][j] = dp[i - 1][j - 1] + 1 else 上一个或者前一个最大值
        // 初始化，非法直接初始化为 0
        // 遍历
        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= t.length(); j++) {
                if (s.charAt(i - 1) == t.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[s.length()][t.length()] == s.length();
    }

}
