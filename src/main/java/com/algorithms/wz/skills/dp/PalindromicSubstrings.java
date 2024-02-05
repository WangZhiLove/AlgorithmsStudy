package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/palindromic-substrings/description/">647. 回文子串</a>
 * 给你一个字符串 s ，请你统计并返回这个字符串中 回文子串 的数目。
 * <p>
 * 回文字符串 是正着读和倒过来读一样的字符串。
 * <p>
 * 子字符串 是字符串中的由连续字符组成的一个序列。
 * <p>
 * 具有不同开始位置或结束位置的子串，即使是由相同的字符组成，也会被视作不同的子串。
 */
public class PalindromicSubstrings {

    /**
     * 在写的过程中思考，这道题目还是使用动态规划，关键是递推公式如何定义呢？
     *
     * @param s 字符串 s
     * @return 回文子串的数目
     */
    public int countSubstrings(String s) {
        // 声明 dp 数组，索引就是字符串的前 i 个元素，值就是回文子串的数目
        int[] dp = new int[s.length()];
        // 递推公式
        // if(s.charAt(i) == s.charAt(i - 1)) 左右指针进行扩展，遍历 + 1
        // 不相等，直接在前一位 + 1
        // 初始化
        dp[0] = 1;
        // 遍历
        for (int i = 1; i < s.length(); i++) {
            dp[i] = dp[i - 1] + 1;
            // 回文子串的两种情况，一种就是直接对称，比如说 abba
            if (s.charAt(i) == s.charAt(i - 1)) {
                int left = i - 1, right = i;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    dp[i] = dp[i] + 1;
                    left --;
                    right ++;
                }
            }
            // 另外一种是有个中间值进行对称，比如说 bab
            if (i < s.length() - 1 && s.charAt(i + 1) == s.charAt(i - 1)) {
                int left = i - 1, right = i + 1;
                while (left >= 0 && right < s.length() && s.charAt(left) == s.charAt(right)) {
                    dp[i] = dp[i] + 1;
                    left --;
                    right ++;
                }
            }
        }
        return dp[s.length() - 1];
    }

    public static void main(String[] args) {
        PalindromicSubstrings palindromicSubstrings = new PalindromicSubstrings();
        System.out.println(palindromicSubstrings.countSubstrings("abc"));
        System.out.println(palindromicSubstrings.countSubstrings("aaa"));
    }
}
