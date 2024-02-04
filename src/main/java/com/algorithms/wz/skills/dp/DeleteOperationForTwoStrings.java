package com.algorithms.wz.skills.dp;


/**
 * <a href="https://leetcode.cn/problems/delete-operation-for-two-strings/description/">583. 两个字符串的删除操作</a>
 * 给定两个单词 word1 和 word2 ，返回使得 word1 和  word2 相同所需的最小步数。
 * <p>
 * 每步 可以删除任意一个字符串中的一个字符。
 */
public class DeleteOperationForTwoStrings {

    /**
     * 这道题目我可以转化为两个单词从头到尾两个单词有多少个单词不相同，这个题目也得用动态规划来实现了，双指针不太能实现
     * @param word1 单词 1
     * @param word2 单词 2
     * @return 返回使得 word1 和  word2 相同所需的最小步数
     */
    public int minDistance(String word1, String word2) {
        // 声明 dp 数组，表述的是以 i-1 为结尾的 word1，j-1 为结尾的 word2，变成相通所需要的最小步数
        int[][] dp = new int[word1.length() + 1][word2.length() + 1];
        // 递推公式
        // if(word1[i] == word2[j]) dp[i][j] = dp[i - 1][j - 1]
        // else dp[i][j] = Math.min(dp[i][j - 1], dp[i - 1][j]) + 1
        // 初始化，初始化 0 行和 0 列
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
                    // 列出所有情况
                    // 删除 word2：dp[i][j - 1] + 1
                    // 删除 word1：dp[i - 1][j] + 1
                    // 两个元素都删除：dp[i - 1][j - 1] + 2
                    dp[i][j] = Math.min(dp[i][j - 1] + 1, Math.min(dp[i - 1][j] + 1, dp[i - 1][j - 1] + 2));
                }
            }
        }
        return dp[word1.length()][word2.length()];
    }

    public static void main(String[] args) {
        DeleteOperationForTwoStrings deleteOperationForTwoStrings = new DeleteOperationForTwoStrings();
        System.out.println(deleteOperationForTwoStrings.minDistance("hello", "hello"));
        System.out.println(deleteOperationForTwoStrings.minDistance("eat", "sea"));
        System.out.println(deleteOperationForTwoStrings.minDistance("leetcode", "etco"));
    }
}
