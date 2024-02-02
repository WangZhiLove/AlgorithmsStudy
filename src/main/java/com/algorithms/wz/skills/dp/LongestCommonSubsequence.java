package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/longest-common-subsequence/description/">1143.最长公共子序列</a>
 * 给定两个字符串 text1 和 text2，返回这两个字符串的最长 公共子序列 的长度。如果不存在 公共子序列 ，返回 0 。
 * <p>
 * 一个字符串的 子序列 是指这样一个新的字符串：它是由原字符串在不改变字符的相对顺序的情况下删除某些字符（也可以不删除任何字符）后组成的新字符串。
 * <p>
 * 例如，"ace" 是 "abcde" 的子序列，但 "aec" 不是 "abcde" 的子序列。
 * 两个字符串的 公共子序列 是这两个字符串所共同拥有的子序列。
 */
public class LongestCommonSubsequence {

    /**
     * 这道题目是求子序列，感觉是最长子数组以及最长递增子序列的一个和，这道题目没做出来的原因其实还是递推公式没有想清楚
     *
     * @param text1 字符串 1
     * @param text2 字符串 2
     * @return 所共同拥有的子序列
     */
    public int longestCommonSubsequence(String text1, String text2) {
        int result = 0;
        // 声明 dp 数组，这里同样是表示以 i-1 结尾的 text1 和 i-2 结尾的 text2 的最长递增子序列
        int[][] dp = new int[text1.length() + 1][text2.length() + 1];
        // 递推公式 if(text1.chatAt(i - 1) == text2.chatAt(j - 1)) dp[i][j] = dp[i - 1][j - 1] + 1;
        // 如果不相 等呢？
        // 全部初始化为 0
        // 遍历
        for (int i = 1; i <= text1.length(); i++) {
            for (int j = 1; j <= text2.length(); j++) {
                if (text1.charAt(i - 1) == text2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i][j - 1], dp[i - 1][j]);
                }
                result = Math.max(result, dp[i][j]);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        LongestCommonSubsequence longestCommonSubsequence = new LongestCommonSubsequence();
        System.out.println(longestCommonSubsequence.longestCommonSubsequence("bsbininm", "jmjkbkjkv"));
    }

}
