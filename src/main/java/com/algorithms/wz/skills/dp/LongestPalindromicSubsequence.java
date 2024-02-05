package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/longest-palindromic-subsequence/description/">516.最长回文子序列</a>
 * 给你一个字符串 s ，找出其中最长的回文子序列，并返回该序列的长度。
 * <p>
 * 子序列定义为：不改变剩余字符顺序的情况下，删除某些字符或者不删除任何字符形成的一个序列。
 */
public class LongestPalindromicSubsequence {

    /**
     * 这道题目可以用回溯的的方法实现，枚举出所有的情况，但是耗时比较严重，所以该想想有没有其它的方法了
     *
     * @param s 字符串 s
     * @return 最长的回文子序列
     */
    public int longestPalindromeSubseq(String s) {
        // 还是用二维数组来解决吧，一维数组可以解决，但是就是麻烦，二维数据表示什么呢，表示在 s 中索引 i 到 j 之间的最长会为子序列
        int[][] dp = new int[s.length()][s.length()];
        // 递推公式
        // if(s.chatAt(i) == s.charAt(j)) dp[i][j] == dp[i + 1][j - 1] + 2;
        // else dp[i][j] = Math.max(dp[i][j - 1], dp[i + 1][j])
        // 初始化，因为单个字符本身是回文子串，所以 当 i== j 的时候 dp[i][j] = 1
        for (int i = 0; i < s.length(); i++) {
            dp[i][i] = 1;
        }
        // 遍历顺序是怎样的呢？可以看到递推公式中使用了 i + 1 以及 j - 1，所以对于行来说，要倒序，对于列来说，要正序
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i + 1; j < s.length(); j++) {
                if (s.charAt(i) == s.charAt(j)) {
                    dp[i][j] = dp[i + 1][j - 1] + 2;
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[0][s.length() - 1];
    }

    public static void main(String[] args) {
        LongestPalindromicSubsequence longestPalindromicSubsequence = new LongestPalindromicSubsequence();
        System.out.println(longestPalindromicSubsequence.longestPalindromeSubseq("aaaa"));
        System.out.println(longestPalindromicSubsequence.longestPalindromeSubseq("aaa"));
    }
}
