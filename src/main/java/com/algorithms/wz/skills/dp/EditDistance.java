package com.algorithms.wz.skills.dp;

/**
 * <a href="https://leetcode.cn/problems/edit-distance/description/">72. 编辑距离</a>
 * 给你两个单词 word1 和 word2， 请返回将 word1 转换成 word2 所使用的最少操作数  。
 * <p>
 * 你可以对一个单词进行如下三种操作：
 * <p>
 * 插入一个字符
 * 删除一个字符
 * 替换一个字符
 */
public class EditDistance {

    /**
     * 动态规划肯定是二维数组来进行解决，那就列出动规五部曲，从 dp 数组考虑递推公式
     * @param word1 单词 1
     * @param word2 单词 2
     * @return 最少的操作数
     */
    public int minDistance(String word1, String word2) {
        // 声明 dp 数组，按照之前的逻辑，那么 dp[i][j] 的含义就是以 i - 1 为结尾的 word1，j - 1  为结尾的 word2，
        // 从 word1 变为 word2 的最少操作数
        int[][] dp = new int[word1.length() + 2][word2.length() + 1];
        // 递推公式
        // if(word1.charAt(i - 1) == word2.chatAt(j - 1)) dp[i][j] = dp[i - 1][j - 1]
        // else 这里就要分情况了，是插入、删除还是替换呢？这道题目的难点也是在这里，这里看看 carl 是怎么分析的吧，
        // 其实这里不要只操作 word1，我可以操作 word2，也可以同时操作，关键是取最小值
        // 初始化
        for (int i = 0; i < dp.length; i++) {
            dp[i][0] = i;
        }
        for (int i = 0; i < dp[0].length; i++) {
            dp[0][i] = i;
        }
        // 遍历
        for (int i = 1; i <= word1.length(); i++) {
            for (int j = 1; j <= word2.length(); j++) {
                if (word1.charAt(i - 1) == word2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1];
                } else {
                    // 分别是
                    // 在 word1 上增加和删除：dp[i - 1][j] + 1
                    // 在 word2 上增加和删除：dp[i][j - 1] + 1
                    // 在 word1 或者 word2 上进行替换：dp[i - 1][j - 1] + 1
                    dp[i][j] = Math.min(dp[i - 1][j] + 1, Math.min(dp[i][j - 1] + 1, dp[i - 1][j - 1] + 1));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

}
